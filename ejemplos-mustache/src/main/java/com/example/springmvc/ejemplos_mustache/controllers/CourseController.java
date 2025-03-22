package com.example.springmvc.ejemplos_mustache.controllers;

import com.example.springmvc.ejemplos_mustache.models.Course;

import java.util.List;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class CourseController {

    @GetMapping("/courses")
    public String showCourses(Model model) {
        List<Course> courses = Arrays.asList(
            new Course("Java Básico", "Aprende los fundamentos de Java."),
            new Course("Spring Boot", "Construye aplicaciones modernas con Spring Boot."),
            new Course("Bases de Datos", "Domina SQL y diseño de bases de datos.")
        );

        model.addAttribute("courses", courses);
        return "courses/courses_template";
    }
}
