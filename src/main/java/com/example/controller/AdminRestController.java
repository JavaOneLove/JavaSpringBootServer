package com.example.controller;


import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminRestController {

    private UserRepository userRepository;
    private UserService userService;
    private Logger LOGGER;

    @Autowired
    public AdminRestController(UserService userService, UserRepository userRepository){
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping(path = "/userList")
    public List<User> getUserList() {
        List<User> usersList = userService.getUserList();
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userList : Список пользователей получен");
        return usersList;
    }

    @GetMapping("/userDetails/{id}")
    public User userDetails(@PathVariable("id") Long id) {
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userDetails/{id} :Пользователь получен");
        return userRepository.findById(id).get();
    }

    @GetMapping("/userDetailsName/{name}")
    public User userDetails(@PathVariable("name") String username) {
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /userDetailsName/{name} :Пользователь получен");
        return userRepository.findByUsername(username);
    }
    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody User user){
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
