package com.wipro.oop;

public class TestPayment {
    public static void main(String[] args) { 
        PaymentMethod1 payment1 = new PhonePay();
        payment1.pay(500.0);
//        PaymentMethod1 payment2 = new PhonePay();
//        payment2.pay(1000.0);
    }
}
