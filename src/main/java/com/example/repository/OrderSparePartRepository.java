package com.example.repository;

import com.example.model.OrderSparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderSparePartRepository extends JpaRepository<OrderSparePart,Integer> {
}
