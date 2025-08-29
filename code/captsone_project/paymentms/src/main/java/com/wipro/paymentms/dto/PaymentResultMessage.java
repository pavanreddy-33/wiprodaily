package com.wipro.paymentms.dto;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResultMessage {
	private String bookingId;
	private String status;
	private String reason;
}
