package com.example.controller;


import com.example.model.Order;
import com.example.model.User;
import com.example.model.Vehicle;
import com.example.service.OrderService;
import com.example.service.UserService;
import com.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

    private final UserService userService;
    private final VehicleService vehicleService;
    private final OrderService orderService;

    private static Logger LOGGER;

    @Autowired
    public UserRestController(UserService userService, VehicleService vehicleService,OrderService orderService){
        this.userService = userService;
        this.vehicleService = vehicleService;
        this.orderService = orderService;
    }

    @PostMapping(path = "/createVehicle")
    public void createVehicle(@AuthenticationPrincipal Principal principal, @RequestBody Vehicle vehicle){

        if (vehicle != null && principal != null)
            vehicle.setPrimaryUser(userService.findByUsername(principal.getName()));
            vehicleService.save(vehicle);
        LOGGER = Logger.getLogger(UserRestController.class.getName());
        LOGGER.log(Level.INFO, "UserController : /createVehicle : Автомобиль добавлен");
    }
    @GetMapping(path = "/getUserVehicle")
    public ResponseEntity<List<Vehicle>> getUserVehicle(@AuthenticationPrincipal Principal principal){
        String name = principal.getName();
        if(name != null){
           User user = userService.findByUsername(name);
            LOGGER = Logger.getLogger(UserRestController.class.getName());
            LOGGER.log(Level.INFO, "UserController : /getUserVehicle : Автомобили получены");
          return new ResponseEntity<>(vehicleService.getVehicleByUserId(user.getId()),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createOrder")
    public void createOrder(@AuthenticationPrincipal Principal principal,@RequestBody Order order){
        if(order != null && principal != null){
            order.setPrimaryUser(userService.findByUsername(principal.getName()));
            orderService.save(order);
            LOGGER = Logger.getLogger(UserRestController.class.getName());
            LOGGER.log(Level.INFO, "UserController : /createOrder : Заказ добавлен");
        }
    }
    @PostMapping("updateOrder")
    public void updateOrder(@RequestBody Order order){
        if (order != null){
            orderService.save(order);
        }
    }
    @GetMapping("/userDetailsName")
    public ResponseEntity<User> userDetails(@AuthenticationPrincipal Principal principal) {
        LOGGER = Logger.getLogger(UserRestController.class.getName());
        LOGGER.log(Level.INFO, "UserController : /userDetailsName : Пользователь получен");
        if (userService.findByUsername(principal.getName()) != null)
            return new ResponseEntity<>(userService.findByUsername(principal.getName()),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/updateUser")
    public void updateUserProfile(@AuthenticationPrincipal Principal principal,@RequestBody User user){
            if (user != null) {
                User userChange = userService.findByUsername(principal.getName());
                String usr = user.getUsername();
                String eml = user.getEmail();
                String pas = user.getPassword();
                userService.updateProfile(userChange, pas, eml, usr);
            }
    }
    @GetMapping("/getUserOrders")
    public ResponseEntity<List<Order>> getUserOrders(@AuthenticationPrincipal Principal principal){
        String name = principal.getName();
        if(name != null){
            User user = userService.findByUsername(name);
            LOGGER = Logger.getLogger(UserRestController.class.getName());
            LOGGER.log(Level.INFO, "UserController : /getUserOrders : Заказы получены");
            return new ResponseEntity<>(orderService.getOrdersByUserId(user.getId()),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
