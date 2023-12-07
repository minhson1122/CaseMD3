package com.example.casestudymd3.model;

public class Cart {
    private String username;
    private String name;
    private String title;
    private int price;

    public Cart() {
    }

    public Cart(String username, String name, String title, int price) {
        this.username = username;
        this.name = name;
        this.title = title;
        this.price = price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
