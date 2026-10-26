package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.WishCategories;
import com.example.projekt2_gruppe_2.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class WishCategoriesController {
    @Autowired
    WishRepo wishRepo;

    @GetMapping("/shop")
    public String getShop(Model model) {
        System.out.println("getshop");

        ArrayList<WishCategories> wishCategories = wishRepo.getWishCategories();
        model.addAttribute("wishCategories", wishCategories);

        return "shop";
    }

}
