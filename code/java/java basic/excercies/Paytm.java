package wiproPracticeDay1;

public class Paytm implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Paytm.");
    }
}