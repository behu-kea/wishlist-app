package com.example.demo.models;

public class Wish {
    private String title;
    private String link;
    private double price;
    private String wishDescription;

    public Wish(String title, String link, double price, String wishDescription) {
        this.title = title;
        this.link = link;
        this.price = price;
        this.wishDescription = wishDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWishDescription() {
        return wishDescription;
    }

    public void setWishDescription(String wishDescription) {
        this.wishDescription = wishDescription;
    }

    @Override
    public String toString() {
        return "Wish{" +
                ", text='" + title + '\'' +
                ", link='" + link + '\'' +
                ", price=" + price +
                ", description='" + wishDescription + '\'' +
                '}';
    }
}
