package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("text", "Hello world from index ...");
        return "index";
    }
    @GetMapping("/book")
    public String home() {
        return "book";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/book/{id}")
    public String getBookById(Model model, @PathVariable("id") Long id) {
        model.addAttribute("bookId", id);
        return "book";
    }

}
