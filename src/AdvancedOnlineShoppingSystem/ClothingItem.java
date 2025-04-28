package AdvancedOnlineShoppingSystem;

public class ClothingItem extends ShoppingItem {
    private String size; // Size like S, M, L, XL
    private boolean seasonalDiscount;

    public ClothingItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String size) {
        super(itemId, itemName, itemDescription, price, stockAvailable);

        this.size = size;
        this.seasonalDiscount = seasonalDiscount;
    }

    @Override
    public void updateStock(int quantity) {
        if (quantity > 0 && quantity <= stockAvailable) {
            stockAvailable -= quantity;
            System.out.println("✅ Stock updated for clothing. Remaining: " + stockAvailable);
        } else {
            System.out.println("⚠️ Not enough stock available for this size.");
        }
    }

    @Override
    public void addToCart(Customer customer) {
        if (size != "S" || size != "M" || size != "L"|| size != "XL") {
            System.out.println("please input the right size");
        } else {
            System.out.println("\n✅ " + itemName + " (Size " + size + ") added to " + customer.getCustomerName() + "'s cart.");
        }
    }

    @Override
    public void generateInvoice(Customer customer) {
        double finalPrice = seasonalDiscount ? price * 0.9 : price; // 10% discount if seasonal
        System.out.println("\n=== Invoice ===");
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Item          : " + itemName + " (Size " + size + ")");
        System.out.println("Description   : " + itemDescription);
        System.out.println("Price         : $" + (seasonalDiscount ? price + " (-10% discount)" : price));
        System.out.println("-----------------------------");
        System.out.println("Total         : $" + finalPrice);
    }

    @Override
    public boolean validateItem() {
        return price >= 0 && stockAvailable >= 0 && !itemName.isEmpty() && !itemDescription.isEmpty() && !size.isEmpty();
    }
}
