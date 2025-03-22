package com.example.springmvc.ejemplos_mustache.models;

public class Product {

    private String name;
    private double price;
    private String image;

    public Product(String name, double price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
