package com.zoggy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Zoggy"); // Add an attribute to be used in the template
        return "home"; // Return the name of the Thymeleaf template without the .html extension
    }
}
