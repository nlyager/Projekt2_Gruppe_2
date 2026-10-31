package com.example.projekt2_gruppe_2.controller;

import com.example.projekt2_gruppe_2.model.User;
import com.example.projekt2_gruppe_2.repository.UserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        // Check whether a user exists with these credentials
        Integer userID = userRepo.getUserIDByEmailAndPassword(email, password);

        // If the credentials are incorrect
        if (userID == null) {
            return "redirect:/?loginError=true";
        }

        // Save the logged-in user's ID in the session
        session.setAttribute("userID", userID);

        return "redirect:/";
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate();

        return "redirect:/";
    }


    @PostMapping("/register")
    public String register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        if (userRepo.getUserByEmail(email) != null) {
            return "redirect:/?registerError=true";
        }

        User user = new User(name, email, password);

        int userID = userRepo.createUser(user);

        if (userID > 0) {

            session.setAttribute("userID", userID);
            return "redirect:/";

        }

        return "redirect:/?registerError=true";
    }

}
