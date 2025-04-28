package AdvancedOnlineShoppingSystem;

public class ElectronicsItem extends ShoppingItem {
    private int warrantyPeriod;

    public ElectronicsItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, int warrantyPeriod) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void updateStock(int quantity) {
        if (quantity > 0 && quantity <= stockAvailable) {
            stockAvailable -= quantity;
            System.out.println("✅ Stock updated successfully. Remaining stock: " + stockAvailable);
        } else {
            System.out.println("⚠️ Not enough stock available!");
        }
    }

    @Override
    public void addToCart(Customer customer) {
        System.out.println("\n✅ " + itemName + " has been added to " + customer.getCustomerName() + "'s cart.");
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("\n=== Invoice ===");
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Item Name    : " + itemName);
        System.out.println("Description  : " + itemDescription);
        System.out.println("Price        : $" + price);
        System.out.println("Warranty     : " + warrantyPeriod);
        System.out.println("-----------------------------");
        System.out.println("Total        : $" + price);
    }

    @Override
    public boolean validateItem() {
        return price >= 0 && stockAvailable >= 0 && !itemName.isEmpty() && !itemDescription.isEmpty();
    }
}
