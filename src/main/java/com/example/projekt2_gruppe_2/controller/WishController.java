package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.WishList;
import com.example.projekt2_gruppe_2.repository.WishListRepo;
import com.example.projekt2_gruppe_2.repository.WishRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("userID", userID);

        model.addAttribute("isOwner", isOwner);

        return "show-wishlist";
    }

    @PostMapping("/reserve-wish")
    public String reserveWish(@RequestParam int wishID, @RequestParam int listID,
                              HttpSession session) {

        Integer userID = (Integer) session.getAttribute("userID");
        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        WishList list = wishListRepo.getWishListByID(listID);
        if (list != null && list.getUserID() != userID) {
            wishRepo.reserveWish(wishID, listID, userID);
        }
        return "redirect:/wishlist?listID=" + listID;
    }

    @PostMapping("/unreserve-wish")
    public String unreserveWish(@RequestParam int wishID, @RequestParam int listID,
                                HttpSession session) {

        Integer userID = (Integer) session.getAttribute("userID");
        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        wishRepo.unreserveWish(wishID, listID, userID);
        return "redirect:/wishlist?listID=" + listID;
    }

    @PostMapping("/delete-wish")
    public String deleteWish(@RequestParam int wishID, @RequestParam int listID,
                             HttpSession session) {
        Integer userID = (Integer) session.getAttribute("userID");
        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        WishList list = wishListRepo.getWishListByID(listID);
        if (list != null && list.getUserID() == userID) {
            wishRepo.deleteWish(wishID, listID);
        }
        return "redirect:/wishlist?listID=" + listID;
    }

    @GetMapping("/addwish")
    public String showAddWish(@RequestParam Integer listID, Model model) {

        model.addAttribute("categories", wishRepo.getWishCategories());
        model.addAttribute("listID", listID);

        return "addWish";

    }

    @PostMapping("/addwish")
    public String addWish(
            @RequestParam Integer listID,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Integer price,
            @RequestParam(required = false) String link,
            @RequestParam Integer categoryID) {

        wishRepo.addWish(
                listID,
                title,
                description,
                price,
                link,
                categoryID
        );

        return "redirect:/wishlist?listID=" + listID;
    }
}