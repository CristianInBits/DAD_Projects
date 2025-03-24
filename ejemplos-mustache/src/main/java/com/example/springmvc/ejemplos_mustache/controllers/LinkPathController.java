package com.example.springmvc.ejemplos_mustache.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LinkPathController {
    
    @GetMapping("/link-path/{nenlace}")
    public String showLink(Model model, @PathVariable int nenlace){
        
        model.addAttribute("nenlace", nenlace);

        return "links/show_link_path";
    }
}
