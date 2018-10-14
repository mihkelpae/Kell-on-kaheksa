package com.example.demo.controllers;

import com.example.demo.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddProductsController {



    @RequestMapping(value="/addProducts", method = RequestMethod.GET)
    public String setupForm(Model model) {
        Product prod = new Product();
        model.addAttribute("Product", prod);
        return "addProducts";
    }



}