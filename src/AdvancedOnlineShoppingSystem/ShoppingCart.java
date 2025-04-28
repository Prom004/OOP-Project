package AdvancedOnlineShoppingSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private String cartId;
    private Customer customer;
    List<ShoppingItem> cartItems;
    private double totalPrice;

    public ShoppingCart(String cartId, Customer customer) {
        this.cartId = cartId;
        this.customer = customer;
        this.cartItems = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addItem(ShoppingItem item) {
        if (item.stockAvailable > 0) {
            cartItems.add(item);
            totalPrice += item.price;
            System.out.println("✅ " + item.itemName + " added to cart.");
        } else {
            System.out.println("⚠️ Item is out of stock.");
        }
    }

    public void removeItem(ShoppingItem item) {
        if (cartItems.remove(item)) {
            totalPrice -= item.price;
            System.out.println("✅ " + item.itemName + " removed from cart.");
        } else {
            System.out.println("⚠️ Item not found in cart.");
        }
    }

    public void displayCart() {
        System.out.println("\n=== Cart Items ===");
        for (ShoppingItem item : cartItems) {
            System.out.println("- " + item.itemName + " ($" + item.price + ")");
        }
        System.out.println("Total Price: $" + totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
