package com.example.springmvc.ejemplos_mustache.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.example.springmvc.ejemplos_mustache.models.Order;

@Controller
public class OrderController {
    
    @GetMapping("/orders")
    public String showOrders(Model model){
        
        List<Order> orders = Arrays.asList(
            new Order("Carlos López", 250.75),
            new Order("Marta Ruiz", 500.00),
            new Order("Sergio Díaz", 130.40)
        );

        model.addAttribute("orders", orders);

        return "orders/orders_template";
    }
}
