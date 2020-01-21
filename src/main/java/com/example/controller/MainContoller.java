package com.example.controller;


import com.example.model.Order;
import com.example.model.OrderSparePart;
import com.example.model.User;
import com.example.model.Vehicle;
import com.example.repository.OrderRepository;
import com.example.repository.UserRepository;
import com.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    public int login(@RequestParam("email") String email, @RequestParam("password") String password) {
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
     public User userDetails(@PathVariable("id") int id) {
         LOGGER = Logger.getLogger(MainContoller.class.getName());
         LOGGER.log(Level.INFO, "Пользователь получен");
        return userRepository.findById(id).get();
    }
    @GetMapping("/userDetailsName/{name}")
    public User userDetails(@PathVariable("name") String username) {
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "Пользователь получен");
        return userRepository.findByUsername(username);
    }

    @GetMapping(path = "/vehicleList")
    public List<Vehicle> getAllVehicle() {
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "Список автомобилей получен");
        return vehicleService.getVehicleList();
    }
    @GetMapping(path = "/orderList")
    public List<Order> getAllOrder(){
        return orderService.getOrderList();
    }

    @PostMapping(path = "/createVehicle")
    public void createVehicle(@RequestBody Vehicle vehicle){
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "Автомобиль добавлен");
        if (vehicle != null)
        vehicleService.save(vehicle);
    }
    @PostMapping("/createOrder")
    public void createOrder(@RequestBody Order order){
        if(order != null){
            orderService.save(order);
        }
    }
}
