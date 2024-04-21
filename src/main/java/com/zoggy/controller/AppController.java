package com.zoggy.controller;

import com.zoggy.request.AddPayRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Value("${stripe.api.publicKey}")
    private String publicKey;

    @GetMapping("/cart-payment")
    public String home(Model model){
        model.addAttribute("request", new AddPayRequest());
        return "payment";
    }

    @PostMapping("/payment")
    public String showCard(@ModelAttribute @Valid AddPayRequest request,
                           BindingResult bindingResult,
                           Model model){
        if (bindingResult.hasErrors()){
            return "payment";
        }
        model.addAttribute("publicKey",publicKey);
        model.addAttribute("amount",request.getAmount());
        model.addAttribute("email",request.getEmail());
        model.addAttribute("itemName",request.getItemName());

        return "checkout";
    }
}
