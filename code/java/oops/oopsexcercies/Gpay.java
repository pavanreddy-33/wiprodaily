package com.wipro.oop;

public class Gpay implements PaymentMethod1 {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Gpay.");
    }
}

