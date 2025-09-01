package com.wipro.paymentms.service;

import com.wipro.paymentms.model.Payment;
import com.wipro.paymentms.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    public void testProcessPaymentValid() {
        String message = "Booking ID: 1, Amount: 5651.0, Method: credit_card, CardNumber: 1234567890123456, CardHolderName: John Doe, ExpiryDate: 12/2025, CVV: 123";
        when(paymentRepository.save(any(Payment.class))).thenReturn(new Payment());

        paymentService.processPayment(message);

        verify(paymentRepository).save(any(Payment.class));
        verify(kafkaTemplate).send("T2", "Booking ID: 1, Status: successful");
    }

    @Test
    public void testProcessPaymentInvalid() {
        String message = "Booking ID: 2, Amount: 4550.0, Method: credit_card, CardNumber: 1234, CardHolderName: Jane Doe, ExpiryDate: 01/2020, CVV: 456";
        when(paymentRepository.save(any(Payment.class))).thenReturn(new Payment());

        paymentService.processPayment(message);

        verify(paymentRepository).save(any(Payment.class));
        verify(kafkaTemplate).send("T2", "Booking ID: 2, Status: failed");
    }
}