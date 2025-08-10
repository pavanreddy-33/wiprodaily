package wiproPracticeDay1;

public class GooglePay implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Google Pay.");
    }
}