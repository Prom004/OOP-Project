package AdvancedStockManagementSystem;

import java.util.Date;

public class PerishableItem extends StockItem {
    private Date expirationDate;

    public PerishableItem(String itemId, String itemName, int quantity, double price, String supplier, Date expirationDate) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = quantity;
        this.pricePerUnit = price;
        this.category = "Perishable";
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
        System.out.println("\n[Perishable Item]");
        System.out.printf("Name: %s | Expiry: %s | Stock: %d | Value: %.2f\n",
                itemName, expirationDate.toString(), quantityInStock, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return expirationDate.after(new Date());
    }
}