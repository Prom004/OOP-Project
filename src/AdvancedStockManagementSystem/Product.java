package AdvancedStockManagementSystem;

public class Product {
    private String productId;
    private String productName;
    private String brand;
    private String supplier;
    private int stockQuantity;

    public Product(String id, String name, String brand, String supplier, int qty) {
        if (name == null || name.trim().isEmpty() || qty <0 || brand == null || brand.trim().isEmpty()) {
            System.out.println("Input valid data");
        }
        this.productId = id;
        this.productName = name;
        this.brand = brand;
        this.supplier = supplier;
        this.stockQuantity = qty;
    }

}