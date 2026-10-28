package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.repository.WishListRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SharedWishlistController {

    @Autowired
    private WishListRepo wishListRepo;

    @GetMapping("/shared-wishlists")
    public String sharedWishlists(HttpSession session, Model model) {
        Integer userId = (Integer) session.getAttribute("userID");
        if (userId == null) {
            return "redirect:/?loginError=true";
        }

        model.addAttribute("wishLists", wishListRepo.getWishListsSharedWith(userId));
        return "shared-wishlists";
    }
}
