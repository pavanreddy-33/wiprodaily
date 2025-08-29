package com.wipro.bookingms.dto;

import lombok.Data;

@Data
public class PaymentResultMessage {
	private String bookingId;
	private String status; 
	private String reason;
}
