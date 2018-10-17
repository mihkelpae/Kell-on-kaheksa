package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddProductsController {

    @Autowired
    ProductRepository productRepository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/addProducts", method = RequestMethod.GET)
    public String setupForm(Model model) {
        model.addAttribute("product", new Product());
        return "addProducts";
    }

    @RequestMapping(value="/addProducts", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        productRepository.save(product);
        return "productAdded";
    }

}