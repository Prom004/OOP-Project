package AdvancedStockManagementSystem;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    private static String inputString(String prompt) {
        System.out.print(prompt);
        String input = sc.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Input cannot be empty. " + prompt);
            input = sc.nextLine().trim();
        }
        return input;
    }

    private static int inputPositiveInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value < 0) throw new NumberFormatException();
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid non-negative integer.");
            }
        }
    }

    private static double inputPositiveDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value < 0) throw new NumberFormatException();
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid non-negative number.");
            }
        }
    }

    public static void main(String[] args) {
        List<StockItem> stockItems = new ArrayList<>();
        System.out.println("=== Advanced Stock Management System ===");

        boolean run = true;
        while (run) {
            System.out.println("\n1. Add Electronics\n2. Add Clothing\n3. Add Grocery\n4. Add Furniture\n5. Add Perishable\n6. Generate Reports\n7. Exit");
            System.out.print("Select option: ");
            String choiceInput = sc.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(choiceInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            switch (choice) {
                case 1: {
                    String name = inputString("Item Name: ");
                    int qty = inputPositiveInt("Quantity: ");
                    double price = inputPositiveDouble("Price per unit: ");
                    int warranty = inputPositiveInt("Warranty (months): ");
                    double discount;
                    while (true) {
                        discount = inputPositiveDouble("Discount (%): ");
                        if (discount <= 50) break;
                        System.out.println("Discount should be 50% or less.");
                    }
                    ElectronicsItem ei = new ElectronicsItem("E01", name, qty, price, "ElectroSupplier", warranty, discount);
                    if (ei.validateStock()) stockItems.add(ei);
                    else System.out.println("Invalid item details. Not added.");
                    break;
                }

                case 2: {
                    String name = inputString("Item Name: ");
                    int qty = inputPositiveInt("Quantity: ");
                    double price = inputPositiveDouble("Price per unit: ");
                    ClothingItem ci = new ClothingItem("C01", name, qty, price, "ClothCorp", Arrays.asList("S", "M", "L"), Arrays.asList("Red", "Blue"));
                    if (ci.validateStock()) stockItems.add(ci);
                    else System.out.println("Invalid item details. Not added.");
                    break;
                }

                case 3: {
                    String name = inputString("Item Name: ");
                    int qty = inputPositiveInt("Quantity: ");
                    double price = inputPositiveDouble("Price per unit: ");
                    Date expiry = new Date(System.currentTimeMillis() + 5 * 86400000L);
                    GroceryItem gi = new GroceryItem("G01", name, qty, price, "GroceryPro", expiry);
                    if (gi.validateStock()) stockItems.add(gi);
                    else System.out.println("Invalid item or expired date. Not added.");
                    break;
                }

                case 4: {
                    String name = inputString("Item Name: ");
                    int qty = inputPositiveInt("Quantity: ");
                    double price = inputPositiveDouble("Price per unit: ");
                    double weight = inputPositiveDouble("Weight (kg): ");
                    FurnitureItem fi = new FurnitureItem("F01", name, qty, price, "FurniHouse", weight);
                    if (fi.validateStock()) stockItems.add(fi);
                    else System.out.println("Invalid item details. Not added.");
                    break;
                }

                case 5: {
                    String name = inputString("Item Name: ");
                    int qty = inputPositiveInt("Quantity: ");
                    double price = inputPositiveDouble("Price per unit: ");
                    Date expiry = new Date(System.currentTimeMillis() + 3 * 86400000L); // 3 days ahead
                    PerishableItem pi = new PerishableItem("P01", name, qty, price, "FruitFarm", expiry);
                    if (pi.validateStock()) stockItems.add(pi);
                    else System.out.println("Invalid item or expired date. Not added.");
                    break;
                }

                case 6:
                    System.out.println("\n--- Stock Report ---");
                    for (StockItem item : stockItems) {
                        if (item.validateStock()) {
                            item.generateStockReport();
                        } else {
                            System.out.println("Invalid or expired item: " + item.itemName);
                        }
                    }
                    break;

                case 7:
                    run = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}
