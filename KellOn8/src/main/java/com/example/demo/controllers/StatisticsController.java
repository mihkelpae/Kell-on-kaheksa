package com.example.demo.controllers;

import com.example.demo.repositories.BrowserRepository;
import com.example.demo.repositories.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class StatisticsController {

    @Autowired
    BrowserRepository browserRepository;
    @Autowired
    OSRepository osRepository;

    @RequestMapping(value="/statistics", method = RequestMethod.GET)
    public String home(Model model){
        model.addAttribute("topBrowser", browserRepository.findBrowsers());
        model.addAttribute("topOS", osRepository.findOpSys());
        return "statistics";
    }
}
