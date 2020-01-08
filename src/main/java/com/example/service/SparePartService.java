package com.example.service;

import com.example.model.SparePart;
import com.example.repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SparePartService {
    @Autowired
    SparePartRepository sparePartRepository;

    public List<SparePart> getVehicleList(){
        List<SparePart> list = new ArrayList<>();
        sparePartRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
