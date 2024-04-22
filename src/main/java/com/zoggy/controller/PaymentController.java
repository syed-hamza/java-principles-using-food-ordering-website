package com.zoggy.controller;

import com.zoggy.request.AddPayRequest;
import com.zoggy.response.PayResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
@Controller
public class PaymentController {
//    @GetMapping("/payment")
//    public String payment(Model model) {
//        return "payment"; // Return the name of the Thymeleaf template without the .html extension
//    }

    @PostMapping("/create-payment-intent")
    public PayResponse createPaymentIntent(@RequestBody AddPayRequest request)
            throws StripeException {
        PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                .setAmount(request.getAmount() * 100L)
                .putMetadata("itemName", request.getItemName())
                .setCurrency("usd")
                .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                                .setEnabled(true)
                                .build()
                )
                .build();
        PaymentIntent intent = PaymentIntent.create(params);

        return new PayResponse(intent.getId(), intent.getClientSecret());
    }
}
