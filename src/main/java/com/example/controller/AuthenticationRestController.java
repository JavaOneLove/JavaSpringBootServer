package com.example.controller;

import com.example.dto.AuthenticationRequestDto;
import com.example.model.User;
import com.example.security.jwt.JwtTokenProvider;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private static Logger LOGGER;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<Object,Object>> login(@RequestBody AuthenticationRequestDto requestDto,HttpServletResponse res) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUsername(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles(),res);

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            LOGGER = Logger.getLogger(AuthenticationRestController.class.getName());
            LOGGER.log(Level.INFO,"User {" + username + "} is authenticated");
            return ok(response);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
    @PostMapping("v2/login")
    public String loginV2(AuthenticationRequestDto requestDto, HttpServletResponse res, HttpServletRequest req){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));
        User user = userService.findByUsername(requestDto.getUsername());
        ModelAndView view = new ModelAndView();
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + requestDto.getUsername() + " not found");
        }
        String token = jwtTokenProvider.createToken(requestDto.getUsername(), user.getRoles(),res);
        req.getSession();
        String c = req.getHeader("Authorization");
        LOGGER = Logger.getLogger(AuthenticationRestController.class.getName());
        LOGGER.log(Level.INFO,"User {" + requestDto.getUsername() + "} is authenticatedV2");
        if (user.getRoles().get(0).getName().equals("ROLE_ADMIN")){
            view.setViewName("redirect:/api/admin/profile");
        }else if(user.getRoles().get(0).getName().equals("ROLE_MANAGER")){
            view.setViewName("redirect:/api/manager/orderList");
        }else view = null;
        return c;
    }
}
