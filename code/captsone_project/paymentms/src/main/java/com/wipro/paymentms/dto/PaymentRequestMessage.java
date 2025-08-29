package com.wipro.paymentms.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestMessage {
	private String bookingId;
	private double amount;
	private String paymentMode;
	private String cardNumber;
	private String expiry;
}
