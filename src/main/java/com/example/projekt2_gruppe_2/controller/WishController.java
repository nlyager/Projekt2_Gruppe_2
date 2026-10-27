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

    @GetMapping("/my-wishlist")
    public String myWishlist(@RequestParam(required = false) Integer listID,
                             HttpSession session, Model model) {
        Integer userID = (Integer) session.getAttribute("userID");
        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        if (listID == null) {
            model.addAttribute("wishLists", wishListRepo.getWishLists(userID));
            return "my-wishlists";
        }

        WishList current = null;
        for (WishList list : wishListRepo.getWishLists(userID)) {
            if (list.getListID() == listID) {
                current = list;
            }
        }
        if (current == null) {
            return "redirect:/my-wishlist";
        }

        model.addAttribute("listTitle", current.getTitle());
        model.addAttribute("wishes", wishRepo.getWishes(listID));
        model.addAttribute("categories", wishRepo.getWishCategories());
        return "my-wishlist";
    }
}