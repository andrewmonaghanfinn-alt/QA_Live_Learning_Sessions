package Labs.oopChallenge;

import java.util.ArrayList;
import java.util.Random;

public class ProductCatalogue {
    ArrayList<Product> catalogue;

    ProductCatalogue() {
        catalogue = new ArrayList<>();
        defaultPopulate();
    }

    public void defaultPopulate() {
        Random random = new Random();
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Beans", 0.95));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Tiger loaf", 1.55));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Mild cheddar", 3.00));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Broccoli", 0.45));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Chocolate cake", 2.95));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Mince pies", 1.45));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Washing-up liquid", 1.80));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Toilet paper", 2.00));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Roast chicken", 4.95));
        catalogue.add(new Product(random.nextInt(9000) + 1000, "Potatoes", 0.75));
    }
}
