package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.Wish;
import com.example.projekt2_gruppe_2.model.WishCategories;
import com.example.projekt2_gruppe_2.model.WishList;
import com.example.projekt2_gruppe_2.repository.WishListRepo;
import com.example.projekt2_gruppe_2.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class WishController {

    @Autowired
    WishRepo wishRepo;

    @Autowired
    WishListRepo wishListRepo;

    @GetMapping("/my-wishlist")
    public String myWishlist(Model model) {
        System.out.println("myWishlist()");

        int userId = 1;

        ArrayList<WishList> wishLists = wishListRepo.getWishLists(userId);
        int listId = wishLists.get(0).getListID();

        ArrayList<Wish> wishes = wishRepo.getWishes(listId);
        model.addAttribute("wishes", wishes);

        ArrayList<WishCategories> wishCategories = wishRepo.getWishCategories();
        model.addAttribute("categories", wishCategories);

        return "my-wishlist";
    }
}