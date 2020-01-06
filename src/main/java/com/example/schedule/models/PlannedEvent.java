package com.example.schedule.models;

import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalTime;

@Entity
public class PlannedEvent {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @NotNull(message = "Workshop is required")
   private String workshop;

   @NotNull(message = "Speaker is required")
   private String speaker;

   @NotNull(message = "Start time is required")
   private LocalTime startTime;

   @NotNull(message = "End time is required")
   private LocalTime endTime;

   public PlannedEvent(String workshop, String speaker, LocalTime startTime, LocalTime endTime, Integer id) {
      this.workshop = workshop;
      this.speaker = speaker;
      this.startTime = startTime;
      this.endTime = endTime;
      this.id = id;
   }

   public PlannedEvent(String workshop, LocalTime startTime, LocalTime endTime, String speaker) {
      this.workshop = workshop;
      this.speaker = speaker;
      this.startTime = startTime;
      this.endTime = endTime;
   }
   /*
      public Speaker(@NotNull(message = "Debes especificar el código") @Size(min = 1, max = 50, message = "El código debe medir entre 1 y 50") String codigo) {
         this.codigo = codigo;
      }
   */
   public PlannedEvent() {
   }

   public String getWorkshop() {
      return workshop;
   }

   public void setWorkshop(String workshop) {
      this.workshop = workshop;
   }

   public String getSpeaker() {
      return speaker;
   }

   public void setSpeaker(String speaker) {
      this.speaker = speaker;
   }

   public LocalTime getStartTime() {
      return startTime;
   }

   public void setStartTime(LocalTime startTime) {
      this.startTime = startTime;
   }

   public LocalTime getEndTime() {
      return endTime;
   }

   public void setEndTime(LocalTime endTime) {
      this.endTime = endTime;
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }
}
