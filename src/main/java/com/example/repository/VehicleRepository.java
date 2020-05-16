package com.example.repository;

import com.example.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {
    List<Vehicle> findVehicleByPrimaryUserId(Long id);
}
