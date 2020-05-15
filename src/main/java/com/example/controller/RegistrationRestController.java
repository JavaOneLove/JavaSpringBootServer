package com.example.controller;


import com.example.dto.GuestDto;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/reg/")
public class RegistrationRestController {

    private UserService userService;

    @Autowired
    public RegistrationRestController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("registration")
    public ResponseEntity registration(@RequestBody GuestDto guestDto) {
        User newUser = userService.register(guestDto);
        if (newUser != null) {
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }
        throw new BadCredentialsException("Invalid username or password");
    }

}