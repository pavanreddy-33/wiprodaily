interface PaymentService {
    void pay(double amount);
}

class GooglePay implements PaymentService {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using GooglePay");
    }
}

class PhonePay implements PaymentService {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PhonePay");
    }
}

class Paytm implements PaymentService {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Paytm");
    }
}

class PaymentProcessor {
    private PaymentService paymentService;
    public PaymentProcessor(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    public void process(double amount) {
        paymentService.pay(amount);
    }
}

public class Exercise6 {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor(new GooglePay());
        processor.process(500.0);
    }
}