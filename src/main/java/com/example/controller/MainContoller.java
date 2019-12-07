package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
public class MainContoller {

    static Logger LOGGER;
    @Autowired
    private UserService userService;

    @GetMapping
    public String test(){
    return "test";
    }
    @PostMapping("/login")
    public void ptest(){
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO,"Метод отработал");
    }

    @GetMapping("/userList")
    public List<User> getUserList(){
        List<User> usersList = userService.getUserList();
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO,"Список пользователей получен");
        return usersList;
    }
}
