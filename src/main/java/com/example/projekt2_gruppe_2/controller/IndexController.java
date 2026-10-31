package com.example.projekt2_gruppe_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getindex() {
        System.out.println("getindex()");
        return "index";
    }

    @GetMapping("/contact")
    public String getcontact() {
        System.out.println("getcontact");
        return "contact";
    }

    @GetMapping("/about-us")
    public String getaboutus() {
        System.out.println("getaboutus");
        return "about-us";
    }

    @PostMapping("/contact-sent")
    public String getcontactsend() {
        System.out.println("getcontactsend");
        return "redirect:/contact?sent=true";
    }

}