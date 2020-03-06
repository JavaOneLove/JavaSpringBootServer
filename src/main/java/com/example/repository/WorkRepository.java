package com.example.repository;

import com.example.model.Work;
import org.springframework.data.repository.CrudRepository;

public interface WorkRepository extends CrudRepository<Work,Integer> {
}
