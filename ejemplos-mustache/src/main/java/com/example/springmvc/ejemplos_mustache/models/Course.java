package com.example.springmvc.ejemplos_mustache.models;

public class Course {
    
    private String title;
    private String description;

    public Course(String title, String description){
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}