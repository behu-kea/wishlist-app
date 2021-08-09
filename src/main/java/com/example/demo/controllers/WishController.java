package com.example.demo.controllers;

import com.example.demo.services.WishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WishController {
    private WishService wishService;

    @PostMapping("/wish/add")
    public String addWishPostRequest() {
//      wishService.createWish();
        return "redirect:/";
    }
}
