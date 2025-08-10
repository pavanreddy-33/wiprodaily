package com.wipro.oop;

public class Citi implements BankOps {
    private String accNumber;
    private double balance;

    public Citi(String accNumber) {
        this.accNumber = accNumber;
        this.balance = 0.0;
    }

    @Override
    public void deposit(double amount, String accNumber) {
        if (this.accNumber.equals(accNumber)) {
            double cashback = amount * 0.005;
            System.out.println("Citi: Deposited " + amount + " to account " + accNumber);
        } else {
            System.out.println("Invalid account number.");
        }
    }

    @Override
    public double getBalance(String accNumber) {
        if (this.accNumber.equals(accNumber)) {
            return balance;
        } else {
            System.out.println("Invalid account number.");
            return -1;
        }
    }
}
