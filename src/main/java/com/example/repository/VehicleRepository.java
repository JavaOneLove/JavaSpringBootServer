package com.example.repository;

import com.example.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {
}
