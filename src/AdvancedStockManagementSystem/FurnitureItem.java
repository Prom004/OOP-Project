package AdvancedStockManagementSystem;

public class FurnitureItem extends StockItem {
    private double weight;

    public FurnitureItem(String itemId, String itemName, int quantity, double price, String supplier, double weight) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = quantity;
        this.pricePerUnit = price;
        this.category = "Furniture";
        this.supplier = supplier;
        this.weight = weight;
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
        System.out.println("\n[Furniture Item]");
        System.out.printf("Name: %s | Weight: %.1fkg | Stock: %d | Value: %.2f\n",
                itemName, weight, quantityInStock, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock >= 0 && pricePerUnit > 0 && weight > 0;
    }
}

