package AdvancedStockManagementSystem;

public abstract class StockItem {
    protected String itemId;
    protected String itemName;
    protected int quantityInStock;
    protected double pricePerUnit;
    protected String category;
    protected String supplier;

    public abstract void updateStock(int quantity);
    public abstract double calculateStockValue();
    public abstract void generateStockReport();
    public abstract boolean validateStock();
}

/*
Exercise 1: Advanced Stock Management System
Scenario:

You are tasked to design an Advanced Stock Management System for a company that sells a variety of products. The system must help administrators and employees manage product stock, track inventory, generate reports, and ensure smooth sales operations.
Abstract Class: StockItem

This is the base class for all stock items (products).
Attributes:

    itemId (String)

    itemName (String)

    quantityInStock (int)

    pricePerUnit (double)

    category (String) – e.g., "Electronics", "Clothing", "Groceries"

    supplier (String)

Abstract Methods:

    updateStock(int quantity)

    calculateStockValue()

    generateStockReport()

    validateStock()

Concrete Classes (5 Total):
1. ElectronicsItem (extends StockItem)

    Validates stock quantity should be above zero for sale.

    Adds functionality for warranty period.

    Includes a method to apply discounts on electronic items.

2. ClothingItem (extends StockItem)

    Calculates the stock value based on item price and discount availability.

    Ensures stock is available in different sizes and colors.

3. GroceryItem (extends StockItem)

    Adds expiration date for each product.

    Ensures that products nearing expiration are flagged for discount.

4. FurnitureItem (extends StockItem)

    Adds a weight attribute for shipping calculation.

    Validates that all furniture items are well packed before delivery.

5. PerishableItem (extends StockItem)

    Validates that perishable items like fruits and vegetables have a short shelf life.

    Generates an alert if stock needs to be disposed of due to expiration.

Encapsulation (3 Classes):
Class: Product

    productId, productName, brand, supplier, stockQuantity

    Validate input values for product name, quantity, and brand.

Class: Supplier

    supplierId, companyName, contactPerson, phone, email

    Ensure that the supplier's contact details are valid and well formatted.

Class: Warehouse

    warehouseId, location, capacity, managerName

    Tracks stock movement and inventory across different locations.

Validations:

    Stock quantity must not be negative.

    Product name should be unique.

    Price per unit must be above zero.

    Discount should not exceed 50%.

    Warranty periods must be within a valid range.

Report Generation:

    Generate a detailed inventory report with:

        Item name, quantity, stock value, and category.

        Any expired or nearly expired items.

        Discounts applied and sales performance.
use Scanner and display all information
 */
