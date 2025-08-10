package wiproPracticeDay1;

public class Test {
    public static void main(String[] args) {
        Payment googlePay = new GooglePay();
        PaymentProcessor processor1 = new PaymentProcessor(googlePay);
        processor1.makePayment(500.0);
        Payment phonePe = new PhonePe();
        PaymentProcessor processor2 = new PaymentProcessor(phonePe);
        processor2.makePayment(250.0);
        Payment paytm = new Paytm();
        PaymentProcessor processor3 = new PaymentProcessor(paytm);
        processor3.makePayment(1000.0);
    }
}
