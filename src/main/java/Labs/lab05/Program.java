package Labs.lab05;

import java.lang.reflect.Array;
import java.util.*;

public class Program {
    public static void main(String[] args) {
//        ShoppingBasket b1 = new ShoppingBasket();
//        ShoppingBasket b2 = new ShoppingBasket();
//        ShoppingBasket b3 = new ShoppingBasket();
//
//        b1.add(new ShoppingBasketItem("Beans", 200, 0.30));
//        b1.add(new ShoppingBasketItem("Kingsmill 50/50", 100, 1.55));
//        b2.add(new ShoppingBasketItem("Garlic bread", 2, 2.00));
//        b3.add(new ShoppingBasketItem("Diet coke", 1, 2.50));
//        b3.add(new ShoppingBasketItem("Mentos", 1, 0.95));
//
//        baskets = new LinkedList<>();
//
//        baskets.add(b1);
//        baskets.add(b2);
//        baskets.add(b3);
//
//        processBaskets();

        Zoo zoo = new Zoo();
        zoo.displayAnimalData();


    }

    static Queue<ShoppingBasket> baskets;

    static void processBaskets() {
        while(!baskets.isEmpty()) {
            ShoppingBasket basket = baskets.poll();
            System.out.println("Basket: ");
            for (ShoppingBasketItem item : basket.basketItems) {
                System.out.println(item.getDetails());
            }
            System.out.println("---------------------------------");

        }
    }


}

class ShoppingBasketItem {
    String productName;
    int quantity;
    double price;

    ShoppingBasketItem(String productName, int quantity, double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getDetails() {
        return "Product name: " + productName + "\n" + "Quantity " + quantity + "\n" + "Price: " + price;
    }
}

class ShoppingBasket {
    ArrayList<ShoppingBasketItem> basketItems;

    ShoppingBasket() {
        basketItems = new ArrayList<>();
    }

    void add(ShoppingBasketItem item) {
        basketItems.add(item);
    }
}


class Zoo {

    HashMap<String, Integer> animalMap = null;

    String[] originalAnimals = {"Zebra", "Lion", "Buffalo"};

    String[] newAnimals = {"Zebra", "Gazelle", "Buffalo", "Zebra"};

    Zoo() {
        animalMap = new HashMap<>();

        addAnimals(originalAnimals);
        addAnimals(newAnimals);
    }

    public void addAnimals(String[] animals) {
        for (String animal : animals) {
            if (animalMap.containsKey(animal)) {
                animalMap.put(animal, animalMap.get(animal) + 1);
            } else {
                animalMap.put(animal, 1);
            }
        }
    }
    public void displayAnimalData() {
        //QA genuinely TWEAKING telling me to use an enhanced for loop to iterate over this
        for (Map.Entry<String, Integer> entry : animalMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            //could just use a while loop but aight
        }
    }
}