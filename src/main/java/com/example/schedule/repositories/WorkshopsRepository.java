package com.example.schedule.repositories;

import com.example.schedule.models.Workshop;
import org.springframework.data.repository.CrudRepository;

public interface WorkshopsRepository extends CrudRepository<Workshop, Integer> {

   Workshop findFirstById(Integer id);
}