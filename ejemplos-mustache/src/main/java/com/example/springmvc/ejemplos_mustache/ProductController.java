package com.example.springmvc.ejemplos_mustache;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    // Queremos mostrar una tabla con datos de productos
    @GetMapping("/products")
    public String showProducts(Model model) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.99),
                new Product("Smartphone", 899.49),
                new Product("Tablet", 499.99));
        model.addAttribute("products", products);
        return "products_templates";
    }

    // Si no hay productos en la lista, se debe mostrar un mensaje indicando que no
    // hay elementos.
    @GetMapping("/empty_products")
    public String emptyProducts(Model model) {

        List<Product> products = Arrays.asList(); // Lista vacía
        model.addAttribute("products", products);
        return "empty_products_template";
    }

}