package com.example.controller;

import com.example.model.Order;
import com.example.model.OrderSparePart;
import com.example.service.OrderService;
import com.example.service.OrderSparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "api/manager")
@PreAuthorize(value = "hasAuthority('ROLE_MANGER')")
public class ManagerRestController {

    private OrderSparePartService orderSparePartService;
    private OrderService orderService;
    private Logger LOGGER;

    @Autowired
    private ManagerRestController(OrderService orderService,OrderSparePartService orderSparePartService){
        this.orderService = orderService;
        this.orderSparePartService = orderSparePartService;
    }

    @GetMapping(path = "/orderList")
    public List<Order> getAllOrder(){
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO, "ManagerController : /orderList : Список заказов получен");
        return orderService.getOrderList();
    }
    @PostMapping("updateOrder")
    public void updateOrder(@RequestBody Order order){
        if (order != null){
            orderService.save(order);
        }
    }

}
