package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.WishList;
import com.example.projekt2_gruppe_2.repository.WishListRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class FindWishListController {
    @Autowired
    WishListRepo wishListRepo;


    @GetMapping("/findWishList")
    public String findWishList(
            @RequestParam("email") String email,
            Model model) {

        ArrayList<WishList> wishListList =
                wishListRepo.getWishListsByEmail(email);

        model.addAttribute("wishListList", wishListList);
        model.addAttribute("searchedEmail", email);

        return "find-wishlist";
    }

    @GetMapping("/find-wishlist")
    public String getfindwishlist(HttpSession session) {

        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            System.out.println("getfindwishlist()");
            System.out.println("userID is null");
            return "redirect:/";
        }

        System.out.println("getfindwishlist()");
        System.out.println("userID: " + userID);
        return "find-wishlist";
    }
}
