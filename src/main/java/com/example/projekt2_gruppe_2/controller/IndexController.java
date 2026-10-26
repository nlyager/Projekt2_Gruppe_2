package com.example.projekt2_gruppe_2.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getindex() {
        System.out.println("getindex()");
        return "index";
    }

    @GetMapping("/find-wishlist")
    public String getfindwishlist(HttpSession httpSession) {

        Integer userID = (Integer) httpSession.getAttribute("userID");

        if (userID == null) {
            System.out.println("getfindwishlist()");
            System.out.println("userID is null");
            return "redirect:/";
        }

        System.out.println("getfindwishlist()");
        System.out.println("userID: " + userID);
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