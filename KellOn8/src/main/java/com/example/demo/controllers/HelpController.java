package com.example.demo.controllers;

import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class HelpController {

    @Autowired
    UserService userService;

    @Autowired
    ReviewRepository reviewRepository;

    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("review", new Review());
        return "help";
    }


    @RequestMapping(value = "/replySaved", method = RequestMethod.POST)
    public String saveReview(@RequestParam("reply")String reply,
                             Principal principal,
                             RedirectAttributes redirectAttributes) {

        if (principal != null) {
            User test = userService.getUser(principal);
            String name = test.getFirstName();
            reviewRepository.addReview(reply, name);
        }
        else{
            reviewRepository.addReview(reply, "Unknown");
        }
        redirectAttributes.addFlashAttribute("reviewAdded", "" +
                "Review has been added.");
        return "redirect:/help";
    }
}