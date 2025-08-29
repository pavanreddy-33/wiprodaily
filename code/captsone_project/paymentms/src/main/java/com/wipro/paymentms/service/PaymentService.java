package com.wipro.paymentms.service;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.paymentms.dto.PaymentRequestMessage;
import com.wipro.paymentms.dto.PaymentResultMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	private final KafkaTemplate<String, Object> kafkaTemplate;
	  private final String resultTopic = "T2";

	  public PaymentResultMessage processSync(PaymentRequestMessage req) {
	    boolean valid = validate(req.getCardNumber(), req.getExpiry());
	    String status = valid ? "SUCCESS" : "FAILED";
	    String reason = valid ? "OK" : "Invalid card or expiry";
	    return new PaymentResultMessage(req.getBookingId(), status, reason);
	  }

	  @KafkaListener(topics = "T1", groupId = "payment-group", containerFactory = "kafkaListenerContainerFactory")
	  public void onPaymentRequest(PaymentRequestMessage req) {
	    PaymentResultMessage result = processSync(req);
	    kafkaTemplate.send(resultTopic, req.getBookingId(), result);
	  }

	  private boolean validate(String card, String expiry) {
	    if (card == null || card.length() != 16) return false;
	    try {
	      DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yyyy");
	      YearMonth ym = YearMonth.parse(expiry, fmt);
	      return ym.atEndOfMonth().isAfter(java.time.LocalDate.now());
	    } catch (Exception e) {
	      return false;
	    }
	  }
}
