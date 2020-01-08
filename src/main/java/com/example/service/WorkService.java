package com.example.service;

import com.example.model.Work;
import com.example.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkService {
    @Autowired
    WorkRepository workRepository;

    public List<Work> getWorkList(){
        List<Work> list = new ArrayList<>();
        workRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
