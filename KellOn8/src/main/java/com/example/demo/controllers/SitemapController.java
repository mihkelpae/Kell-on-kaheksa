package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SitemapController {

    @RequestMapping(value = "/sitemap", method = RequestMethod.GET)
    public String index(Model model) {
        return "sitemap";
    }
}