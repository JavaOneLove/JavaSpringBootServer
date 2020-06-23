package com.example.controller;

import com.example.model.Order;
import com.example.model.SparePart;
import com.example.model.User;
import com.example.service.OrderService;
import com.example.service.SparePartService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "api/manager")
//@PreAuthorize(value = "hasAuthority('ROLE_MANAGER')")
public class ManagerRestController {

    private UserService userService;
    private SparePartService sparePartService;
    private OrderService orderService;
    private Logger LOGGER;

    @Autowired
    private ManagerRestController(OrderService orderService,
                                  SparePartService sparePartService,
                                  UserService userService){
        this.userService = userService;
        this.orderService = orderService;
        this.sparePartService = sparePartService;
    }

    @GetMapping(path = "/orderList")
    public ModelAndView getAllOrder(){
        ModelAndView model = new ModelAndView();
        model.setViewName("orderList");
        model.addObject("orders",orderService.getOrderList());
        LOGGER = Logger.getLogger(ManagerRestController.class.getName());
        LOGGER.log(Level.INFO, "ManagerController : /orderList : Список заказов получен");
        return model;
    }
    @PostMapping("updateOrder")
    public void updateOrder(@RequestBody Order order){
        if (order != null){
            orderService.save(order);
        }
    }
    @GetMapping("/profile")
    public ModelAndView profile(@AuthenticationPrincipal Principal principal){
        ModelAndView model = new ModelAndView();
        model.addObject(userService.findByUsername("manager"));// principal.getName()
        model.setViewName("managerProfile");
        model.addObject("users",userService.getUserList());
        return model;
    }
    @GetMapping("orderDetails/{id}")
    public ModelAndView orderDetails(@PathVariable int id){
        List<String> status = new ArrayList<>();
        status.add("Принять");
        status.add("Завершить");
        status.add("Отклонить");
        ModelAndView model = new ModelAndView();
        model.addObject("status",status);
        model.addObject(orderService.getOrderById(id));
        model.setViewName("getOrderDetails");
        return model;
    }

    @PostMapping("ValidateOrder")
    public ModelAndView validate(@RequestParam("orderId") Order order,
                         @RequestParam(value = "Принять", required = false) String Accept,
                         @RequestParam(value = "Завершить", required = false) String Complete,
                         @RequestParam(value = "Отклонить", required = false) String Reject){
        String status = null;
        if (Accept != null && Accept.equals("on"))
            status = "Принять";
        if (Complete != null && Complete.equals("on"))
            status = "Завершить";
        if (Reject != null && Reject.equals("on"))
            status = "Отклонить";
        order.setStatus(status);
        orderService.save(order);
        LOGGER = Logger.getLogger(ManagerRestController.class.getName());
        LOGGER.log(Level.INFO, "ManagerController : /ValidateOrder : Заказ обработан " + status);
        return new ModelAndView("redirect:/api/manager/profile");
    }

    @GetMapping("SparePartList")
    public ModelAndView SparePartList(){
        ModelAndView model = new ModelAndView();
        model.addObject("SparePartList",sparePartService.getSparePartList());
        model.setViewName("SparePartList");
        return model;
    }
    @PostMapping("/updateUser")
    public void updateUserProfile(@AuthenticationPrincipal Principal principal, User user){
        if (user != null) {
            User userChange = userService.findByUsername(principal.getName());
            String usr = user.getUsername();
            String eml = user.getEmail();
            String pas = user.getPassword();
            userService.updateProfile(userChange, pas, eml, usr);
            LOGGER = Logger.getLogger(AdminRestController.class.getName());
            LOGGER.log(Level.INFO, "AdminController: /updateUser :Пользователь изменен");
        }
    }
    @GetMapping("addSparePart")
    public ModelAndView addSparePart(){
        ModelAndView model = new ModelAndView();
        model.setViewName("AddSparePart");
        return model;
    }

    @PostMapping("addSparePart")
    public ModelAndView addSparePart(@RequestParam("name") String name,
                             @RequestParam("mark") String mark,
                             @RequestParam("model") String model,
                             @RequestParam("value") int value){
        SparePart sparePart = new SparePart(name,mark,model,value);
        LOGGER = Logger.getLogger(AdminRestController.class.getName());
        LOGGER.log(Level.INFO, "AdminController: /addSparePart :Запчасть добавлена ");
        sparePartService.save(sparePart);
        return new ModelAndView("redirect:/api/manager/SparePartList");
    }
}
