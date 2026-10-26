package com.example.projekt2_gruppe_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getindex() {
        System.out.println("getindex()");
        return "index";
    }

    @GetMapping("/find-wishlist")
    public String getfindwishlist() {
        System.out.println("getfindwishlist()");
        return "find-wishlist";
    }

    @GetMapping("/contact")
    public String getcontact() {
        System.out.println("getcontact");
        return "contact";
    }

    @GetMapping("/about-us")
    public String getaboutus() {
        System.out.println("getaboutus");
        return "about-us";
    }

}