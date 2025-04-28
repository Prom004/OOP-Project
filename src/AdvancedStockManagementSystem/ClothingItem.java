package AdvancedStockManagementSystem;

import java.util.List;

public class ClothingItem extends StockItem {
    private List<String> sizes;
    private List<String> colors;

    public ClothingItem(String itemId, String itemName, int quantity, double price, String supplier, List<String> sizes, List<String> colors) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = quantity;
        this.pricePerUnit = price;
        this.category = "Clothing";
        this.supplier = supplier;
        this.sizes = sizes;
        this.colors = colors;
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
        System.out.println("\n[Clothing Item]");
        System.out.printf("Name: %s | Sizes: %s | Colors: %s | Stock: %d | Value: %.2f\n",
                itemName, sizes.toString(), colors.toString(), quantityInStock, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock >= 0 && pricePerUnit > 0;
    }
}