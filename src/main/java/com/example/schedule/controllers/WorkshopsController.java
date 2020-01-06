package com.example.schedule.controllers;

import com.example.schedule.models.Workshop;
import com.example.schedule.repositories.WorkshopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/workshops")
public class WorkshopsController {
   @Autowired
   private WorkshopsRepository workshopsRepository;

   @GetMapping(value = "/add")
   public String addWorkshop(Model model) {
      model.addAttribute("workshop", new Workshop());
      return "workshops/add_workshop";
   }

   @GetMapping(value = "/show")
   public String showWorkshops(Model model) {
      model.addAttribute("workshops", workshopsRepository.findAll());
      return "workshops/see_workshops";
   }

   @PostMapping(value = "/delete")
   public String deleteWorkshop(@ModelAttribute Workshop workshop, RedirectAttributes redirectAttrs) {
      redirectAttrs
         .addFlashAttribute("mensaje", "The workshop has been deleted")
         .addFlashAttribute("clase", "warning");
      workshopsRepository.deleteById(workshop.getId());
      return "redirect:/workshops/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editWorkshops(@ModelAttribute @Valid Workshop workshop, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (workshop.getId() != null) {
            return "workshops/edit_workshop";
         }
         return "redirect:/workshops/show";
      }

      workshopsRepository.save(workshop);
      redirectAttrs
         .addFlashAttribute("mensaje", "The workshop has been modified")
         .addFlashAttribute("clase", "success");
      return "redirect:/workshops/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("workshop", workshopsRepository.findById(id).orElse(null));
      return "workshops/edit_workshop";
   }

   @PostMapping(value = "/add")
   public String saveWorkshop(@ModelAttribute @Valid Workshop workshop, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "workshops/add_workshop";
      }

      workshopsRepository.save(workshop);
      redirectAttrs
         .addFlashAttribute("mensaje", "The workshop has been added")
         .addFlashAttribute("clase", "success");
      return "redirect:/workshops/show";
   }
}
