package com.example.schedule.repositories;

import com.example.schedule.models.Speaker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpeakersRepository extends CrudRepository<Speaker, Integer> {

   Speaker findFirstById(Integer id);

}