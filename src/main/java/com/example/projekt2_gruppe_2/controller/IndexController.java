package com.example.projekt2_gruppe_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getindex() {
        System.out.println("getindex()");
        return "index";
    }
}
