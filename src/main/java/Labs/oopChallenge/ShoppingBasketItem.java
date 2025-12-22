package Labs.oopChallenge;

import java.util.Objects;

public class ShoppingBasketItem {
    private Product product;
    private int quantity;

    ShoppingBasketItem() {}

    ShoppingBasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public void increment() {
        this.quantity++;
    }

    public void decrement() {
        if (this.quantity < 1) {
            throw new IllegalArgumentException("Cannot have a negative quantity");
        }
        this.quantity--;
    }
    @Override
    public String toString() {
        return "Product: " + product.getName() + "\n" +
                "Price: " + product.getPrice() + "\n" +
                "Quantity: " + quantity + "\n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingBasketItem)) return false;

        ShoppingBasketItem other = (ShoppingBasketItem) o;

        return Objects.equals(this.product, other.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

}
