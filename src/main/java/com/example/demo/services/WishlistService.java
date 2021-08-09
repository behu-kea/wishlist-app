package com.example.demo.services;

import com.example.demo.models.Wishlist;
import com.example.demo.repositories.WishRepository;
import com.example.demo.repositories.WishlistRepository;

import java.util.ArrayList;

public class WishlistService {
    private final WishlistRepository wishlistRepository = new WishlistRepository();
    private final WishRepository wishRepository = new WishRepository();

    public void createWishlist(String title) {
        wishlistRepository.createWishlist(title);
    }

    public ArrayList<Wishlist> getAllWishlists(){
        return wishlistRepository.getAllWishLists();
    }

    public Wishlist getWishlist(int id) {
        Wishlist wishlist = wishlistRepository.getSingleWishlistById(id);
        wishlist.setWishes(wishRepository.getAllWishes(id));
        return wishlist;
    }
}
