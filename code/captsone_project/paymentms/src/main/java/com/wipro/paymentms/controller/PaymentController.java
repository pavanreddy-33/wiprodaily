package com.wipro.paymentms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.paymentms.dto.PaymentRequestMessage;
import com.wipro.paymentms.dto.PaymentResultMessage;
import com.wipro.paymentms.service.PaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	@PostMapping("/process")
	  public ResponseEntity<PaymentResultMessage> process(@RequestBody PaymentRequestMessage req){
	    return ResponseEntity.ok(service.processSync(req));
	  }
}
