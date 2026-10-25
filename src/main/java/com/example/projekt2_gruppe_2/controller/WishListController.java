package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.WishList;
import com.example.projekt2_gruppe_2.repository.WishListRepo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class WishListController {
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
}
