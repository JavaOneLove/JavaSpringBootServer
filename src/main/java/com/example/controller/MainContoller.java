package com.example.controller;


import com.example.model.OrderSparePart;
import com.example.model.User;
import com.example.model.Vehicle;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
public class MainContoller {

    private static Logger LOGGER;
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    WorkService workService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderSparePartService orderSparePartService;


    @GetMapping
    public String test() {
        return "test";
    }

    @PostMapping("/login")
    public int login(@RequestParam String email,@RequestParam String password) {
        int id = 0;
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, email);
        if (email != null && password != null) {
            User user = userRepository.findByUsername(email);
            LOGGER = Logger.getLogger(MainContoller.class.getName());
            LOGGER.log(Level.INFO, user.getEmail());
            if (user.getPassword().equals(password)) {
                LOGGER = Logger.getLogger(MainContoller.class.getName());
                LOGGER.log(Level.INFO, "2");
                id = user.getId();
            }
        }
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "Залогинился");
        return id;
    }

    @GetMapping(path = "/userList")
    public List<User> getUserList() {
        List<User> usersList = userService.getUserList();
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "Список пользователей получен");
        return usersList;
    }

    @GetMapping("/userDetails/{id}")
    public User userDetails(@PathVariable int id) {
        return userRepository.findById(id).get();
    }

    @GetMapping(path = "/vehicleList")
    public List<Vehicle> getAllVehicle() {
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "Список автомобилей получен");
        return vehicleService.getVehicleList();
    }
}
