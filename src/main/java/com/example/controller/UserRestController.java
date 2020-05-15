package com.example.controller;


import com.example.model.Order;
import com.example.model.Vehicle;
import com.example.service.OrderService;
import com.example.service.UserService;
import com.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

    private UserService userService;
    private VehicleService vehicleService;
    private OrderService orderService;

    private static Logger LOGGER;

    @Autowired
    public UserRestController(UserService userService, VehicleService vehicleService,OrderService orderService){
        this.userService = userService;
        this.vehicleService = vehicleService;
        this.orderService = orderService;
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
    @PostMapping("updateOrder")
    public void updateOrder(@RequestBody Order order){
        if (order != null){
            orderService.save(order);
        }
    }
}
