package com.example.controller;

import com.example.model.Order;
import com.example.model.Role;
import com.example.model.User;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class RegistrationController {

    private static Logger LOGGER;

    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserService userService;

    @PostMapping("/registration")
    public void registration(@RequestBody User user){
        User UserFromDB = userRepository.findByUsername(user.getUsername());
        if(UserFromDB == null){
            LOGGER = Logger.getLogger(RegistrationController.class.getName());
            LOGGER.log(Level.INFO,"Метод отработал");
            user.setRoles(Collections.singleton(Role.USER));
            userRepository.save(user);
        }
    }
    @PostMapping
    public void createOrder(@RequestBody Order order){
        if(order != null){
            orderRepository.save(order);
        }
    }
    @DeleteMapping
    public void deleteUser(@PathVariable("id") int id){
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }
    @PostMapping
    public void updateUser(@RequestBody User user){
        if (user != null){
            String usr = user.getUsername();
            String eml = user.getEmail();
            String pas = user.getPassword();
            userService.updateProfile(user,pas,eml,usr);
        }
    }
}
