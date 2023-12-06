package com.example.casestudymd3.model;

import java.util.Date;

public class Game {
    private int id;
    private String title;
    private int price;
    private String description;
    private String genre;
    private String rating;
    private int totalDownload;
    private String developer;
    private String releaseDate;
    private boolean purchased;

    public Game(String title, int price, String description, String genre, String rating, int totalDownload, String developer, String releaseDate, boolean purchased) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.totalDownload = totalDownload;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.purchased = purchased;
    }

    public Game(int id, String title, int price, String description, String genre, String rating, int totalDownload, String developer, String releaseDate, boolean purchased) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.totalDownload = totalDownload;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.purchased = purchased;
    }

    public Game(String title, int price, String description, String genre, String rating, String developer, String releaseDate) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.genre = genre;
        this.rating = rating;
        this.developer = developer;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(int totalDownload) {
        this.totalDownload = totalDownload;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
}
