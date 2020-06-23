package com.example.service;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public Order getOrderById(int id){
        return orderRepository.getOrderById(id);
    }

    public List<Order> getOrderList(){
        List<Order> list = new ArrayList<>();
        orderRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public void save(Order order){
        orderRepository.save(order);
    }

    public List<Order> getOrdersByUserId(Long id){
        return orderRepository.findOrdersByPrimaryUserId(id);
    }
}
