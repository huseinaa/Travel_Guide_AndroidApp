package com.example.myapp;

public class TravelDestination {
    private int imageUrl;
    private String title;
    private double price;
    private String description;

    public TravelDestination(int imageUrl, String title, double price, String description) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResource() {
        return imageUrl;
    }

    public void setImageResource(int imageResource) {
        this.imageUrl = imageResource;
    }
}

