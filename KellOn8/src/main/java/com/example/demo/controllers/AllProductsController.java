package com.example.demo.controllers;

import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AllProductsController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
    public String loadAll(Model model) {
        model.addAttribute("product", productRepository.findAll());
        model.addAttribute("uniqueProductCount", productRepository.countOfUniqueProducts());
        model.addAttribute("productCount", productRepository.countOfAllProducts());
        return "allProducts";
    }

    @RequestMapping("/allProducts/delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("message",
                "Product has been deleted!");
        return "redirect:/allProducts";
    }

    @RequestMapping(value = "/allProducts/edit/{id}", method = RequestMethod.GET)
    public String editProduct(@PathVariable Long id, Model model){
        model.addAttribute("product", productRepository.findById(id));

        productRepository.deleteById(id);
        return "/addProducts";
    }
}
