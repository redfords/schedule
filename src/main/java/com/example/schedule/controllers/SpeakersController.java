package com.example.schedule.controllers;

import com.example.schedule.models.Speaker;
import com.example.schedule.repositories.SpeakersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/speakers")
public class SpeakersController {
   @Autowired
   private SpeakersRepository speakersRepository;

   @GetMapping(value = "/add")
   public String addSpeaker(Model model) {
      model.addAttribute("speaker", new Speaker());
      return "speakers/add_speaker";
   }

   @GetMapping(value = "/show")
   public String showSpeakers(Model model) {
      model.addAttribute("speakers", speakersRepository.findAll());
      return "speakers/see_speakers";
   }

   @PostMapping(value = "/delete")
   public String deleteSpeaker(@ModelAttribute Speaker speaker, RedirectAttributes redirectAttrs) {
      redirectAttrs
         .addFlashAttribute("mensaje", "The speaker has been deleted")
         .addFlashAttribute("clase", "warning");
      speakersRepository.deleteById(speaker.getId());
      return "redirect:/speakers/show";
   }

   @PostMapping(value = "/edit/{id}")
   public String editSpeaker(@ModelAttribute @Valid Speaker speaker, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         if (speaker.getId() != null) {
            return "speakers/edit_speaker";
         }
         return "redirect:/speakers/show";
      }

      speakersRepository.save(speaker);
      redirectAttrs
         .addFlashAttribute("mensaje", "The speaker has been modified")
         .addFlashAttribute("clase", "success");
      return "redirect:/speakers/show";
   }

   @GetMapping(value = "/edit/{id}")
   public String showEditForm(@PathVariable int id, Model model) {
      model.addAttribute("speaker", speakersRepository.findById(id).orElse(null));
      return "speakers/edit_speaker";
   }

   @PostMapping(value = "/add")
   public String saveSpeaker(@ModelAttribute @Valid Speaker speaker, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
      if (bindingResult.hasErrors()) {
         return "speakers/add_speaker";
      }

      speakersRepository.save(speaker);
      redirectAttrs
         .addFlashAttribute("mensaje", "The speaker has been added")
         .addFlashAttribute("clase", "success");
      return "redirect:/speakers/show";
   }
}
