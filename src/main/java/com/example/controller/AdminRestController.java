package com.example.controller;


import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/admin")
//@PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
public class AdminRestController {

    private UserService userService;
    private Logger LOGGER;

    @Autowired
    public AdminRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/userList")
    public ModelAndView getUserList() {
        ModelAndView model = new ModelAndView();
        List<User> usersList = userService.getUserList();
        model.addObject(usersList);
        model.setViewName("getUserList");
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userList : Список пользователей получен");
        return model;
    }

    @GetMapping("/userDetails/{id}")
    public User userDetails(@PathVariable("id") Long id) {
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userDetails/{id} :Пользователь получен");
        return userService.findById(id);
    }

    @GetMapping("/userDetailsName/{name}")
    public User userDetails(@PathVariable("name") String username) {
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userDetailsName/{name} :Пользователь получен");
        return userService.findByUsername(username);
    }
    @PostMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") Long id){
            userService.delete(id);
    }

    @GetMapping("/profile")
    public ModelAndView profile(){
        return new ModelAndView("AdminProfile");
    }
}
