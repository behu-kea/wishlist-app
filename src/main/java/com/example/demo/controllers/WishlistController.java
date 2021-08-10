package com.example.demo.controllers;

import com.example.demo.services.WishlistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/wishlists")
public class WishlistController {
    private final WishlistService wishlistService = new WishlistService();

    @GetMapping("/all")
    public String wishlistOverview(Model model) {
        model.addAttribute("allWishlists", wishlistService.getAllWishlists());
        return "/wishlist-overview.html";
    }

    @PostMapping("/new-wishlist")
    public String addWishlistPostRequest(@RequestParam String title) {
        wishlistService.createWishlist(title);
        return "redirect:/wishlists/all";
    }
}
