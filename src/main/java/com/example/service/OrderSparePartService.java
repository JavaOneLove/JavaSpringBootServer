package com.example.service;

import com.example.model.OrderSparePart;
import com.example.repository.OrderSparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderSparePartService {
    @Autowired
    OrderSparePartRepository orderSparePartRepository;

    public List<OrderSparePart> getVehicleList(){
        List<OrderSparePart> list = new ArrayList<>();
        orderSparePartRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
