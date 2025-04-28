package AdvancedOnlineShoppingSystem;

public class AccessoriesItem extends ShoppingItem {
    private String variety;
    private double customerRating; // rating out of 5

    public AccessoriesItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String variety, double customerRating) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.variety = variety;
        this.customerRating = customerRating;
    }

    @Override
    public void updateStock(int quantity) {
        if (quantity > 0 && quantity <= stockAvailable) {
            stockAvailable -= quantity;
            System.out.println("✅ Stock updated for accessories. Remaining: " + stockAvailable);
        } else {
            System.out.println("⚠️ Not enough stock available.");
        }
    }

    @Override
    public void addToCart(Customer customer) {
        System.out.println("\n✅ " + itemName + " (" + variety + ") added to " + customer.getCustomerName() + "'s cart.");
    }

    @Override
    public void generateInvoice(Customer customer) {
        System.out.println("\n=== Invoice ===");
        System.out.println("Customer Name : " + customer.getCustomerName());
        System.out.println("Accessory     : " + itemName + " (" + variety + ")");
        System.out.println("Customer Rating: " + customerRating + "/5");
        System.out.println("Price         : $" + price);
        System.out.println("-----------------------------");
        System.out.println("Total         : $" + price);
    }

    @Override
    public boolean validateItem() {
        return price >= 0 && stockAvailable >= 0 && !itemName.isEmpty() && !variety.isEmpty() && customerRating >= 0 && customerRating <= 5;
    }
}
