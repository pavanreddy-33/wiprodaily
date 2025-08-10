package wiproPracticeDay1;

public class PhonePe implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PhonePe.");
    }
}
