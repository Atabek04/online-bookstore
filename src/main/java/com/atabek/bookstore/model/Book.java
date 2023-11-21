package com.atabek.bookstore.model;

public class Book {
    private String title;
    private String author;
    private double price;
    private String imageUrl;
    private int id;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book(String title, String author, double price, String imageUrl) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Book(String title, String author, double price, String imageUrl, int id) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public Book() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
