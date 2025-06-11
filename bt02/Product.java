package com.example.bt02;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int imageResource;

    public Product(int id, String name, int quantity, double price, int imageResource) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imageResource = imageResource;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }

    // Setter methods
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
