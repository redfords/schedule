package com.example.schedule.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Workshop {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Name is required")
   @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
   private String name;

   @NotNull(message = "Description is required")
   @Size(min = 1, max = 200, message = "Description must be between 1 and 200 characters")
   private String description;

   public Workshop(String name, String description, Integer id) {
      this.name = name;
      this.description = description;
      this.id = id;
   }

   public Workshop(String name, String description) {
      this.name = name;
      this.description = description;
   }

   public Workshop() {
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}
