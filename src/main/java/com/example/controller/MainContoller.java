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
    UserRepository userRepository;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    WorkService workService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderSparePartService orderSparePartService;



    @GetMapping(path = "/vehicleList")
    public List<Vehicle> getAllVehicle() {
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "Список автомобилей получен");
        return vehicleService.getVehicleList();
    }

}
