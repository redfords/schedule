package com.example.schedule.controllers;

import com.example.schedule.models.PlannedEvent;
import com.example.schedule.repositories.PlannedEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/plannedEvents")
public class PlannedEventsController {
   @Autowired
   private PlannedEventsRepository plannedEventsRepository;

   @GetMapping(value = "/add")
   public String addPlannedEvent(Model model) {
      model.addAttribute("plannedEvent", new PlannedEvent());
      return "plannedEvents/add_plannedEvent";
   }

   @GetMapping(value = "/show")
   public String showPlannedEvents(Model model) {
      model.addAttribute("plannedEvents", plannedEventsRepository.findAll());
      return "plannedEvents/see_plannedEvents";
   }

   @PostMapping(value = "/delete")
   public String deletePlannedEvent(@ModelAttribute PlannedEvent plannedEvent, RedirectAttributes redirectAttrs) {
      redirectAttrs
         .addFlashAttribute("mensaje", "The event has been deleted")
         .addFlashAttribute("clase", "warning");
      plannedEventsRepository.deleteById(plannedEvent.getId());
      return "redirect:/plannedEvents/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editPlannedEvents(@ModelAttribute @Valid PlannedEvent plannedEvent, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (plannedEvent.getId() != null) {
            return "plannedEvents/edit_plannedEvent";
         }
         return "redirect:/plannedEvents/show";
      }

      plannedEventsRepository.save(plannedEvent);
      redirectAttrs
         .addFlashAttribute("mensaje", "The event has been modified")
         .addFlashAttribute("clase", "success");
      return "redirect:/plannedEvents/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("plannedEvent", plannedEventsRepository.findById(id).orElse(null));
      return "plannedEvents/edit_plannedEvent";
   }

   @PostMapping(value = "/add")
   public String savePlannedEvent(@ModelAttribute @Valid PlannedEvent plannedEvent, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "plannedEvents/add_plannedEvent";
      }

      plannedEventsRepository.save(plannedEvent);
      redirectAttrs
         .addFlashAttribute("mensaje", "The event has been added")
         .addFlashAttribute("clase", "success");
      return "redirect:/plannedEvents/show";
   }
}
