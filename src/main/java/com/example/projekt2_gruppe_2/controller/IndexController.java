package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.Wish;
import com.example.projekt2_gruppe_2.model.WishCategories;
import com.example.projekt2_gruppe_2.repository.WishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getindex() {
        System.out.println("getindex()");
        return "index";
    }

    @GetMapping("/find-wishlist")
    public String getfindwishlist() {
        System.out.println("getfindwishlist()");
        return "find-wishlist";
    }

    @GetMapping("/my-wishlist")
    public String myWishlist(Model model) {
        System.out.println("myWishlist()");

        Map<Integer, WishCategories> categories = Map.of(
                1, new WishCategories(1, "Vehicles", "toyota.jpeg"),
                2, new WishCategories(2, "Books", "stormlight.jpeg"),
                3, new WishCategories(3, "Electronics", "gamerpc.jpeg"),
                4, new WishCategories(4, "Clothing", "jacket.jpeg"),
                5, new WishCategories(1, "Vehicles", "toyota.jpeg"),
                6, new WishCategories(2, "Books", "stormlight.jpeg"),
                7, new WishCategories(3, "Electronics", "gamerpc.jpeg"),
                8, new WishCategories(4, "Clothing", "jacket.jpeg")
        );

        List<Wish> wishes = List.of(
                new Wish(1, "Car", "Toyota Corolla 1996", 14999, 0, 1, 1),
                new Wish(2, "Book", "The Stormlight Archive", 199, 0, 1, 2),
                new Wish(3, "Computer", "Gamer computer", 8999, 0, 1, 3),
                new Wish(4, "Jacket", "Jacket, Waterproof", 449, 0, 1, 4),
                new Wish(5, "Car", "Toyota Corolla 1996", 14999, 0, 1, 1),
                new Wish(6, "Book", "The Stormlight Archive", 199, 0, 1, 2),
                new Wish(7, "Computer", "Gamer computer", 8999, 0, 1, 3),
                new Wish(8, "Jacket", "Jacket, Waterproof", 449, 0, 1, 4)
        );

        model.addAttribute("wishes", wishes);
        model.addAttribute("categories", categories);
        return "my-wishlist";
    }
}