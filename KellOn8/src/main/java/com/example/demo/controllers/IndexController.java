package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("text", "Hello world from index ...");
        return "index";
    }
    @GetMapping("/products/kategooria1")
    public String home() {
        return "products/kategooria1";
    }

    @GetMapping("about")
    public String about() {
        return "about";
    }

    @GetMapping("help")
    public String help() {
        return "help";
    }

    @GetMapping("profile")
    public String profile() {
        return "profile";
    }

    @RequestMapping("/book/{id}")
    public String getBookById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("bookId", id);
        return "products";
    }

}
