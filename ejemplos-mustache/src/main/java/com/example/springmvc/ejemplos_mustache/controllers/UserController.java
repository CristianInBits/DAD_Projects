package com.example.springmvc.ejemplos_mustache.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springmvc.ejemplos_mustache.models.User;

@Controller
public class UserController {

    @GetMapping("/user")
    public String showUseString(Model model) {

        User userWithPhoto = new User("Peter Griffin", "peter.jpg", false);
        User userWithoutPhoto = new User("Peter Griffin", "default-profile.jpg", false);

        model.addAttribute("user", userWithPhoto);
        return "users/user_template";
    }

    @GetMapping("/date")
    public String showUserWithDate(Model model) {
        LocalDate createdDate = LocalDate.now();
        String formattedDate = createdDate.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
        model.addAttribute("createdDate", formattedDate);
        return "users/date_template";
    }

    @GetMapping("/user-status")
    public String showUserStatus(Model model){
        User user = new User("Lucía García", null, true); // Cambia a true para probar el caso activo
        model.addAttribute("user", user);
        return "users/user_status_template";
    }

}
