package Labs.oopChallenge;


enum PaymentMethod {
    CREDITCARD,
    DEBITCARD,
    PAYPAL
}


public class PaymentService {
    private PaymentMethod method;
    private double balance;

    PaymentService(PaymentMethod method, double balance) {
        this.method = method;
        this.balance = balance;
    }

    public void pay(double total) {
        if (total > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance -= total;
    }

    public PaymentMethod getMethod() {
        return method;
    }
    public double getBalance() {
        return balance;
    }
}
