package com.example.springmvc.ejemplos_mustache.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdvertisementController {

    @PostMapping("/create-advertisment")
    public String createAd(
        @RequestParam String userName,
        @RequestParam String subject,
        @RequestParam String message,
        Model model
    ) {
        model.addAttribute("userName", userName);
        model.addAttribute("subject", subject);
        model.addAttribute("message", message);
        return "advertisments/show_ad";
    }
}
