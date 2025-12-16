package Exercises.Interfaces;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart(new CreditCard());
        cart.add("Beans", 0.95, 100);
        cart.add("Crisps", 1.45, 1);
        cart.add("Broccoli", 0.45, 2);
        cart.add("Bread", 1.20, 1);

        cart.checkout(cart.calculateTotal());

    }
}

class CreditCard implements  PaymentStrategy {
    private String accountHolder;
    private String CC;
    private double balance;

    @Override
    public void pay(double amount) {
        balance -= amount;
    }
}

class PayPal implements PaymentStrategy {
    private String userName;
    private double balance;

    @Override
    public void pay(double amount) {
        balance -= amount;
    }
}

class Item {
    public String name;
    public double price;
    public int quantity;
    Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class ShoppingCart {
    private ArrayList<Item> cart;
    PaymentStrategy paymentStrategy;
    ShoppingCart(PaymentStrategy paymentStrategy) {
        cart = new ArrayList<>();
        this.paymentStrategy = paymentStrategy;
    }
    public void add(String item, double price, int quantity) {
        cart.add(new Item(item, price, quantity));
    }
    public double calculateTotal() {
        double total = 0;
        for (Item item : cart) {
            total += item.price * item.quantity;
        }
        return total;
    }
    public void checkout(double total) {
        paymentStrategy.pay(total);
    }
}
