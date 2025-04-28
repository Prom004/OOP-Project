package AdvancedStockManagementSystem;

//import AdvancedStockManagementSystem.StockItem;

public class ElectronicsItem extends StockItem {
    private int warrantyMonths;
    private double discount;

    public ElectronicsItem(String itemId, String itemName, int quantity, double price, String supplier, int warrantyMonths, double discount) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityInStock = quantity;
        this.pricePerUnit = price;
        this.category = "Electronics";
        this.supplier = supplier;
        this.warrantyMonths = warrantyMonths;
        this.discount = discount;
    }


    @Override
    public void updateStock(int quantity) {
        this.quantityInStock += quantity;
    }

    @Override
    public double calculateStockValue() {
        double discountedPrice = pricePerUnit - (pricePerUnit * discount / 100);
        return discountedPrice * quantityInStock;
    }

    @Override
    public void generateStockReport() {
        System.out.println("\n[Electronics Item]");
        System.out.printf("Name: %s | Stock: %d | Unit Price: %.2f | Discount: %.1f%% | Warranty: %d months | Value: %.2f\n",
                itemName, quantityInStock, pricePerUnit, discount, warrantyMonths, calculateStockValue());
    }

    @Override
    public boolean validateStock() {
        return quantityInStock > 0 && pricePerUnit > 0 && discount <= 50 && warrantyMonths > 0;
    }
}