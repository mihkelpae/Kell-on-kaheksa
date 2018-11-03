package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "profile";
    }

    @RequestMapping(value="/saveProfileAddress", method = RequestMethod.POST)
    public String saveAddress(@RequestParam("address")String address,
                              Principal principal) {
        User test = userService.getUser(principal);
        String email = test.getEmail();
        userRepository.updateAddress(address, email);
        return "profile";
    }
}