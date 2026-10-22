package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.Wish;
import com.example.projekt2_gruppe_2.model.WishCategories;
import com.example.projekt2_gruppe_2.model.WishList;
import com.example.projekt2_gruppe_2.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class WishController {

    @Autowired
    WishRepo wishRepo;

//    @GetMapping("/my-wishlist")
//    public String myWishlist(
//            @RequestParam("userID") int userID,
//            Model model) {
//        System.out.println("myWishlist()");
//
//        ArrayList<WishCategories> wishCategories = wishRepo.getWishCategories();
//        model.addAttribute("wishCategories", wishCategories);
//
//        ArrayList<WishList> wishLists = wishRepo.getWishLists(userID);
//        model.addAttribute("wishLists", wishLists);
//        return "my-wishlist";
//    }
}
