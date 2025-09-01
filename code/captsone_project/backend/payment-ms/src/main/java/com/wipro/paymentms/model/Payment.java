package com.wipro.paymentms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bookingId;
    private double amount;
    private String paymentMethod;  // e.g., "credit_card"
    private String status;  // successful, failed

    // Card details for simulation/validation
    private String cardNumber;  // e.g., 16 digits
    private String cardHolderName;
    private String expiryDate;  // MM/YYYY, validate > current date
    private String cvv;
}