package com.wipro.oop;

public class BankTest {
    public static void main(String[] args) {
        HDFC hdfcAccount = new HDFC("HDFC123");
        Citi citiAccount = new Citi("CITI123");

        hdfcAccount.deposit(3000, "HDFC123");
        System.out.println("HDFC Balance:" + hdfcAccount.getBalance("HDFC123"));

        citiAccount.deposit(5000, "CITI123");
        System.out.println("Citi Balance:" + citiAccount.getBalance("CITI123"));
    }
}
