package com.example.repository;

import com.example.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SparePartRepository extends JpaRepository<SparePart,Integer> {
}
