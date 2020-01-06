package com.example.schedule.repositories;

import com.example.schedule.models.PlannedEvent;
import org.springframework.data.repository.CrudRepository;

public interface PlannedEventsRepository extends CrudRepository<PlannedEvent, Integer> {

   PlannedEvent findFirstById(Integer id);
}