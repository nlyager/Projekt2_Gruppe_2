package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.WishList;
import com.example.projekt2_gruppe_2.repository.WishListRepo;
import com.example.projekt2_gruppe_2.repository.WishRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WishController {

    @Autowired
    WishRepo wishRepo;

    @Autowired
    WishListRepo wishListRepo;

    @GetMapping("/wishlist")
    public String showWishList(
            @RequestParam Integer listID,
            HttpSession session,
            Model model) {

        Integer userID = (Integer) session.getAttribute("userID");

        WishList current = wishListRepo.getWishListByID(listID);

        if (current == null) {
            return "redirect:/";
        }

        boolean isOwner = userID != null && current.getUserID() == userID;

        model.addAttribute("wishList", current);
        model.addAttribute("wishes", wishRepo.getWishes(listID));
        model.addAttribute("categories", wishRepo.getWishCategories());

        model.addAttribute("isOwner", isOwner);

        return "show-wishlist";
    }
}