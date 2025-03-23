package com.example.springmvc.ejemplos_mustache.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultModelAttributes {
    
    @ModelAttribute("loggedUser")
    public String loggedUser(){
        return "Juan Pérez";
    }
}
