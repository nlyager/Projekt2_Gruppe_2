package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.repository.WishListRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyWishListController {

    @Autowired
    WishListRepo wishListRepo;

    @GetMapping("/my-wishlists")
    public String myWishLists(HttpSession session, Model model) {

        Integer userID = (Integer) session.getAttribute("userID");

        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        model.addAttribute("wishLists", wishListRepo.getWishLists(userID));

        model.addAttribute("createError", false);

        return "my-wishlists";
    }

    @PostMapping("/add-wishlist")
    public String addWishlist(@RequestParam String title,
                              @RequestParam String description,
                              HttpSession session) {
        Integer userID = (Integer) session.getAttribute("userID");
        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        String trimmedTitle = title.trim();
        String trimmedDescription = description.trim();
        if (trimmedTitle.isEmpty() || trimmedDescription.isEmpty()
                || trimmedTitle.length() > 45 || trimmedDescription.length() > 200) {
            return "redirect:/my-wishlists?createError=true";
        }

        wishListRepo.addWishList(userID, trimmedTitle, trimmedDescription);
        return "redirect:/my-wishlists";
    }

    @PostMapping("/delete-wishlist")
    public String deleteWishlist(@RequestParam int listID, HttpSession session) {
        Integer userID = (Integer) session.getAttribute("userID");
        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        wishListRepo.deleteWishList(userID, listID);
        return "redirect:/my-wishlists";
    }
}
