package AdvancedOnlineShoppingSystem;

import java.time.LocalDate;

public class GroceriesItem extends ShoppingItem {
    private LocalDate expirationDate;
    private boolean bulkDiscount;

    public GroceriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, LocalDate expirationDate, boolean bulkDiscount) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.expirationDate = expirationDate;
        this.bulkDiscount = bulkDiscount;
    }

    @Override
    public void updateStock(int quantity) {
        if (quantity > 0 && quantity <= stockAvailable) {
            stockAvailable -= quantity;
            System.out.println("✅ Stock updated for groceries. Remaining: " + stockAvailable);
        } else {
            System.out.println("⚠️ Not enough stock available.");
        }
    }

    @Override
    public void addToCart(Customer customer) {
        System.out.println("\n✅ " + itemName + " added to " + customer.getCustomerName() + "'s cart.");
    }

    @Override
    public void generateInvoice(Customer customer) {
        double finalPrice = bulkDiscount ? price * 0.95 : price; // 5% bulk discount
        System.out.println("\n=== Invoice ===");
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Item          : " + itemName);
        System.out.println("Description   : " + itemDescription);
        System.out.println("Price         : $" + (bulkDiscount ? price + " (-5% bulk discount)" : price));
        System.out.println("-----------------------------");
        System.out.println("Total         : $" + finalPrice);
    }

    @Override
    public boolean validateItem() {
        return price >= 0 && stockAvailable >= 0 && !itemName.isEmpty() && expirationDate.isAfter(LocalDate.now());
    }
}
