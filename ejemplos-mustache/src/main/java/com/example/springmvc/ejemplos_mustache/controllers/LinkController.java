package com.example.springmvc.ejemplos_mustache.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkController {
    
    @GetMapping("/link")
    public String showLink(Model model, @RequestParam int nenlace){

        model.addAttribute("nenlace",nenlace);
        
        return "links/show_link";
    }

}
