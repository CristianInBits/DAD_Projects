package com.example.springmvc.ejemplos_mustache.controllers;

import com.example.springmvc.ejemplos_mustache.models.Ad;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdController {

    @PostMapping("/save-ad")
    public String saveAd(Model model, Ad ad) {

        model.addAttribute("ad", ad);

        return "ads/show_ad"; // plantilla que vamos a cambiar también a inglés
    }
}