package Labs.oopChallenge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.file.Path;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {
    private ArrayList<ShoppingBasketItem> items;
    private double total;
    private PaymentService paymentService;
    private LocalDateTime savedTime;
    private final String basketPersistence = "src/main/java/Labs/oopChallenge/baskets.JSON";

    ShoppingBasket(PaymentService paymentService) {
        items = new ArrayList<>();
        this.paymentService = paymentService;
    }

    public void addItem(ShoppingBasketItem item) {

        int i = items.indexOf(item);

        if (i >= 0) {
            items.get(i).increment();
        } else {
            items.add(item);
        }
    }
    public void removeItem(ShoppingBasketItem item) {
        if (!items.contains(item)) {
            throw new IllegalArgumentException("Item is not in basket");
        } else {
            items.remove(item);
        }
    }
    public void clearBasket() {
        this.items = new ArrayList<>();
    }

    public void saveBasket() {
        savedTime = LocalDateTime.now();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(basketPersistence))) {
            gson.toJson(items, writer);
        } catch (IOException e) {
            System.out.println("Unable to save basket ):");
        }
    }

    public void loadBasket() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Type listType = new TypeToken<List<ShoppingBasketItem>>() {}.getType();

        Path file = Path.of(basketPersistence);

        try (Reader reader = Files.newBufferedReader(file)) {
            List<ShoppingBasketItem> loaded = gson.fromJson(reader, listType);


            if (loaded == null) {
                this.items = new ArrayList<>();
            } else {
                this.items = new ArrayList<>(loaded);
            }



        } catch (IOException e) {
            System.out.println("Unable to load basket ):");
        }
    }

    public double calculateTotal() {
        for (ShoppingBasketItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public boolean isPriceValid() {
        return savedTime.isAfter(LocalDateTime.now().minusDays(1));
    }

    public void checkout() {
        System.out.println("Account type:" + paymentService.getMethod() + "\n " +
                "Account balance: " + paymentService.getBalance() + "\n");
        paymentService.pay(calculateTotal());
        System.out.println("Account balance is now: " + paymentService.getBalance() + "\n");
    }
}
