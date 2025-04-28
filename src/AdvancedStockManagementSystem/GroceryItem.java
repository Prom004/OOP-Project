package AdvancedStockManagementSystem;

import java.util.Date;

public class GroceryItem extends StockItem {
    private Date expirationDate;

    public GroceryItem(String itemId, String itemName, int quantity, double price, String supplier, Date expirationDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = quantity;
        this.pricePerUnit = price;
        this.category = "Groceries";
        this.supplier = supplier;
        this.expirationDate = expirationDate;
    }

    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        return quantityInStock * pricePerUnit;
    }

    @Override
    public void generateStockReport() {
        System.out.println("\n[Grocery Item]");
        System.out.printf("Name: %s | Expiry: %s | Stock: %d | Value: %.2f\n",
                itemName, expirationDate.toString(), quantityInStock, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0 && pricePerUnit > 0 && new Date().before(expirationDate);
    }
}