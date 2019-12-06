package com.example.controller;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RegistrationController {

    static Logger LOGGER;

    @Autowired
    UserRepository userRepository;
    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }
    @PostMapping("/registration")
    public void addNewUser(@RequestBody User user){
        User UserFromDB = userRepository.findByUsername(user.getUsername());
        if(UserFromDB == null){
            LOGGER = Logger.getLogger(RegistrationController.class.getName());
            LOGGER.log(Level.INFO,"Метод отработал");
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
        }
    }
}
