package com.example.bt02;

import java.io.Serializable;

public class ProductRecycle implements Serializable {
    private String mName;
    private double price;
    private int quantity;
    private int imageResource; // Add this field for the image resource

    public String getmName() {
        return mName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name){
        this.mName = name;
    }

    // Add a constructor to initialize the image resource
    public ProductRecycle(String mName, int quantity, double price, int imageResource) {
        this.mName = mName;
        this.quantity = quantity;
        this.price = price;
        this.imageResource = imageResource;
    }

    public String getName() {
        return this.mName;
    }
}
