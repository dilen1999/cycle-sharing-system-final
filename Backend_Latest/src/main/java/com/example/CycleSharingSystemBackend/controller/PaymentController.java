package com.example.CycleSharingSystemBackend.controller;

import com.example.CycleSharingSystemBackend.dto.PaymentRequest;
import com.example.CycleSharingSystemBackend.dto.CreatePaymentResponse;
import com.example.CycleSharingSystemBackend.service.StripePaymentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin("http://localhost:3000")
public class PaymentController {

    private final StripePaymentService paymentService;

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody PaymentRequest paymentRequest) {
            return paymentService.createPaymentIntent(paymentRequest);
    }
}

