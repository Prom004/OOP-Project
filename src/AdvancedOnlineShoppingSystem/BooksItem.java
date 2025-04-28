package AdvancedOnlineShoppingSystem;

public class BooksItem extends ShoppingItem {
    private String isbn;
    private String edition;

    public BooksItem(String itemId, String itemName, String itemDescription, double price, int stockAvailable, String isbn, String edition) {
        super(itemId, itemName, itemDescription, price, stockAvailable);
        this.isbn = isbn;
        this.edition = edition;
    }

    @Override
    public void updateStock(int quantity) {
        if (quantity > 0 && quantity <= stockAvailable) {
            stockAvailable -= quantity;
            System.out.println("✅ Stock updated for books. Remaining: " + stockAvailable);
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
        System.out.println("\n=== Invoice ===");
        System.out.println("Customer Name : " + customer.getCustomerName());
        System.out.println("Book Title    : " + itemName);
        System.out.println("ISBN          : " + isbn);
        System.out.println("Edition       : " + edition);
        System.out.println("Price         : $" + price);
        System.out.println("-----------------------------");
        System.out.println("Total         : $" + price);
    }

    @Override
    public boolean validateItem() {
        return price >= 0 && stockAvailable >= 0 && !itemName.isEmpty() && !isbn.isEmpty() && !edition.isEmpty();
    }
}
