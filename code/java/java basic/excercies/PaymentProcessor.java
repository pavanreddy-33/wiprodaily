package wiproPracticeDay1;

public class PaymentProcessor {
    private Payment paymentMethod;

    public PaymentProcessor(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double amount) {
        paymentMethod.pay(amount);
    }
}
