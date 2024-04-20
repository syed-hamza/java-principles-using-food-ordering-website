package com.zoggy.service;

import com.stripe.exception.StripeException;
import com.zoggy.model.Order;
import com.zoggy.response.PaymentResponse;


public interface PaymentService {
    public PaymentResponse createPaymentLink(Order order) throws StripeException;
}
