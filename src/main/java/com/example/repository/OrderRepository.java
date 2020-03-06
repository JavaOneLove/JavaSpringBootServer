package com.example.repository;

import com.example.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
   void getAllOrderById(int id);
}
