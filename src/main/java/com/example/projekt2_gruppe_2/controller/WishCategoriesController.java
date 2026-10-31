package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.WishCategories;
import com.example.projekt2_gruppe_2.repository.WishRepo;
import jakarta.servlet.http.HttpSession;
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
    public String getShop(Model model, HttpSession session) {
        System.out.println("getshop()");

        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            System.out.println("getfindwishlist()");
            System.out.println("userID is null");
            return "redirect:/?notLoggedIn=true";
        }
        System.out.println("UserID : " + userID);

        ArrayList<WishCategories> wishCategories = wishRepo.getWishCategories();
        model.addAttribute("wishCategories", wishCategories);

        return "shop";
    }

}
