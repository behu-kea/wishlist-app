package com.example.demo.services;

import com.example.demo.models.Wish;
import com.example.demo.repositories.WishRepository;

public class WishService {
    private final WishRepository wishRepository = new WishRepository();

    public void createWish(Wish wishFromUser, int wishlist) {
        wishRepository.createWish(wishFromUser, wishlist);
    }
}

