package com.example.springmvc.ejemplos_mustache.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springmvc.ejemplos_mustache.models.Product2;

@Controller
public class Product2Controller {
    
    private List<Product2> products = new ArrayList<>();
    private long nextId = 1;

    @GetMapping("/home2")
    public String showProducts(Model model){
        model.addAttribute("products",products);
        return "products2/main";
    }

    @PostMapping("/products/save-product")
    public String saveProduct(Model model, Product2 product){
        products.add(product);
        model.addAttribute("product", product);
        return "product_saved";
    }

    @GetMapping("/products/{id}/delete")
    public String deleteProduct(Model model, @PathVariable String name){
        products.removeIf(p -> p.getName()==name);
        model.addAttribute("name", name);
    }
}
