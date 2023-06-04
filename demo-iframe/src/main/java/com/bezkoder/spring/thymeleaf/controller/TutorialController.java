package com.bezkoder.spring.thymeleaf.controller;

import com.bezkoder.spring.thymeleaf.entity.Tutorial;
import com.bezkoder.spring.thymeleaf.entity.User;
import com.bezkoder.spring.thymeleaf.repository.TutorialRepository;
import com.bezkoder.spring.thymeleaf.repository.UserRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TutorialController {

  private final TutorialRepository tutorialRepository;
  private final UserRepository userRepository;

  public TutorialController(TutorialRepository tutorialRepository, UserRepository userRepository) {
    this.tutorialRepository = tutorialRepository;
    this.userRepository = userRepository;
  }

  @GetMapping("/tutorials")
  public String getAll(Model model, @Param("keyword") String keyword, @RequestParam("user") String username) {
    try {
      List<Tutorial> tutorials = new ArrayList<>();
      User user = userRepository.findByUsername(username);
      if(user == null){
        model.addAttribute("tutorials", tutorials);

        return "tutorials";
      }

      if (keyword == null) {
        tutorials.addAll(tutorialRepository.findByUserId(user.getId()));
      } else {
        tutorials.addAll(tutorialRepository.findByTitleContainingIgnoreCaseAndUserId(keyword, user.getId()));
        model.addAttribute("keyword", keyword);
      }

      model.addAttribute("tutorials", tutorials);
      model.addAttribute("user", user);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "tutorials";
  }
}
