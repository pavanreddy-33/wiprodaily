package com.wipro.paymentms.controller;

import com.wipro.paymentms.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment/test")
public class TestPaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/simulate")
    public ResponseEntity<String> simulatePayment(@RequestBody String message) {
        // Simulate Kafka message (e.g., "Booking ID: 1, Amount: 5651.0, ...")
        paymentService.processPayment(message);
        return ResponseEntity.ok("Payment simulation triggered. Check DB and T2.");
    }
}