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
@RequestMapping("/home")
public class MainContoller {

    static Logger LOGGER;
    @Autowired
    private UserService userService;
    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String test(){
    return "test";
    }
    @PostMapping("/login")
    public boolean login(@RequestBody String email, String password){
        boolean check = false;
        if (!email.isEmpty() && !password.isEmpty()){
           User user = userRepository.findByUsername(email);
           if (user.getPassword().equals(password)){
              check = true;
           }
        }
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO,"Залогинился");
        return check;
    }

    @GetMapping("/userList")
    public List<User> getUserList(){
        List<User> usersList = userService.getUserList();
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO,"Список пользователей получен");
        return usersList;
    }
}
