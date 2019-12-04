package com.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/home")
public class MainContoller {

    static Logger LOGGER;

    @GetMapping
    public String test(){
    return "test";
    }
    @PostMapping("/login")
    public void ptest(){
        LOGGER = Logger.getLogger(MainContoller.class.getName());
        LOGGER.log(Level.INFO,"Метод отработал");
    }
}
