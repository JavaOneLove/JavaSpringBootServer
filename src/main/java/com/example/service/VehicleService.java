package com.example.service;

import com.example.model.Vehicle;
import com.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<Vehicle> getVehicleList(){
        List<Vehicle> list = new ArrayList<>();
        vehicleRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
    public void save(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
}
