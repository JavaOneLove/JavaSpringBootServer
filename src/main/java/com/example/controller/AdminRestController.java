package com.example.controller;


import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize(value = "hasAuthority('ROLE_ADMIN')")
public class AdminRestController {

    private UserService userService;
    private Logger LOGGER;

    @Autowired
    public AdminRestController(UserService userService){
        this.userService = userService;
    }
    @GetMapping(path = "/userList")
    public List<User> getUserList() {
        List<User> usersList = userService.getUserList();
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userList : Список пользователей получен");
        return usersList;
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
}
