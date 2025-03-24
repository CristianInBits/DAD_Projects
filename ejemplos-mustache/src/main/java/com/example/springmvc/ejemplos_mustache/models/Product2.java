package com.example.springmvc.ejemplos_mustache.models;

public class Product2 {

    private String name;
    private String description;
    private double price;

    public Product2() {
    }

    public Product2(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
