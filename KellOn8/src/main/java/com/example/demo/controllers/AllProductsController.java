package com.example.demo.controllers;

import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AllProductsController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
    public String loadAll(Model model) {
            model.addAttribute("product", productRepository.findAll());
            return "allProducts";
    }
}
