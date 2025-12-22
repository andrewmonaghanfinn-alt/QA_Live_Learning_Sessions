package Labs.oopChallenge;

import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ProductCatalogue productCatalogue = new ProductCatalogue();

        ShoppingBasket basket = new ShoppingBasket(new PaymentService(PaymentMethod.DEBITCARD, 800.02));
//        Random random = new Random();
//        for (Product p : productCatalogue.catalogue) {
//            basket.addItem(new ShoppingBasketItem(p, random.nextInt(20)));
//        }
//
//        basket.saveBasket();

        basket.loadBasket();

        basket.checkout();


    }
}
