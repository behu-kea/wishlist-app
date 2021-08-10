package com.example.demo;

import com.example.demo.models.Wish;
import com.example.demo.models.Wishlist;
import com.example.demo.repositories.WishRepository;
import com.example.demo.repositories.WishlistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//      Insert some stuff in the database
//      insertData();
    }
    public static void insertData(){
        WishlistRepository wishlistRepo = new WishlistRepository();
        WishRepository wishRepo = new WishRepository();

        Wishlist wl1 = new Wishlist("Fødselsdag");
        Wishlist wl2 = new Wishlist("Jul");

        wishlistRepo.createWishlist(wl1.getTitle());
        wishlistRepo.createWishlist(wl2.getTitle());

        Wish w1 = new Wish("Hund","www.google.com",10,"Dog");
        Wish w2 = new Wish("Nalgene Flaske","www.fjallraven.com",10,"ægte");
        Wish w3 = new Wish("iphone","www.apple.com",10,"steve");
        Wish w4 = new Wish("kanye west cd","www.donda.com",10,"steve");
        Wish w5 = new Wish("jakke","www.fjallraven.com",10,"jakke");
        Wish w6 = new Wish("dvd","www.dvd.com",10,"100 p");

        wishRepo.createWish(w1,1);
        wishRepo.createWish(w2,1);
        wishRepo.createWish(w3,1);
        wishRepo.createWish(w4,1);
        wishRepo.createWish(w5,1);
        wishRepo.createWish(w6,2);
    }
}
