package com.example.schedule.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Speaker {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Name is required")
   @Size(min = 1, max = 20, message = "Name must be between 1 and 20 characters")
   private String name;

   @NotNull(message = "Title is required")
   @Size(min = 1, max = 20, message = "Title must be between 1 and 20 characters")
   private String title;

   @NotNull(message = "Company is required")
   @Size(min = 1, max = 20, message = "Company must be between 1 and 20 characters")
   private String company;

   @NotNull(message = "Bio is required")
   @Size(min = 1, max = 100, message = "Bio must be between 1 and 100 characters")
   private String bio;

   public Speaker(String name, String title, String company, String bio, Integer id) {
      this.name = name;
      this.title = title;
      this.company = company;
      this.bio = bio;
      this.id = id;
   }

   public Speaker(String name, String title, String company, String bio) {
      this.name = name;
      this.title = title;
      this.company = company;
      this.bio = bio;
   }

   public Speaker(String name) {
      this.name = name;
   }
/*
   public Speaker(@NotNull(message = "Debes especificar el código") @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50") String codigo) {
      this.codigo = codigo;
   }
*/
   public Speaker() {
   }

   public String getCompany() {
      return company;
   }

   public void setCompany(String company) {
      this.company = company;
   }

   public String getBio() {
      return bio;
   }

   public void setBio(String bio) {
      this.bio = bio;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
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
