package com.example.demo.models;

import java.util.ArrayList;

public class Wishlist {
    private int id;
    private String title;
    private ArrayList<Wish> wishes;

    public Wishlist(String title) {
        this.title = title;
    }

    public Wishlist(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(ArrayList<Wish> wishes) {
        this.wishes = wishes;
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "title='" + title + '\'' +
                '}';
    }
}
