package AdvancedOnlineShoppingSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class OnlineShoppingSystem {

    static Scanner sc = new Scanner(System.in);

    private static String inputValidatedSize(String prompt) {
        while (true) {
            System.out.print(prompt);
            String size = sc.nextLine().trim().toUpperCase(); // Always capitalize
            if (size.equals("S") || size.equals("M") || size.equals("L") ||
                    size.equals("XL") || size.equals("XXL")) {
                return size;
            }
            System.out.println("⚠️ Invalid size. Please enter one of the following: S, M, L, XL, XXL.");
        }
    }
    private static String inputValidatedString(String prompt) {
        String pattern = "^[A-Za-z\\s\\-\\.]+$"; // Letters, spaces, hyphens, dots
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && Pattern.matches(pattern, input)) {
                return input;
            }
            System.out.println("⚠️ Invalid input. Please enter only letters, spaces, hyphens, or dots.");
        }
    }

    private static String inputValidatedEmail(String prompt) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        while (true) {
            System.out.print(prompt);
            String email = sc.nextLine().trim();
            if (Pattern.matches(emailPattern, email)) {
                return email;
            }
            System.out.println("⚠️ Invalid email format. Please enter a valid email (e.g., abc@example.com).");
        }
    }

    private static String inputValidatedPhone(String prompt) {
        String phonePattern = "^[0-9]{8,15}$"; // Accepts 8 to 15 digits
        while (true) {
            System.out.print(prompt);
            String phone = sc.nextLine().trim();
            if (Pattern.matches(phonePattern, phone)) {
                return phone;
            }
            System.out.println("⚠️ Invalid phone number. Enter digits only (8-15 digits).");
        }
    }

    private static int inputPositiveInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("⚠️ Please enter a non-negative integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static double inputPositiveDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("⚠️ Please enter a non-negative number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Advanced Online Shopping System ===\n");

        // First take Customer Details
        String name = inputValidatedString("Enter Customer Name: ");
        String email = inputValidatedEmail("Enter Email: ");
        String phone = inputValidatedPhone("Enter Phone (digits only): ");
        String address = inputValidatedString("Enter Address: ");

        Customer customer = new Customer("C001", name, email, address, phone);
        customer.displayInfo();

        ShoppingCart cart = new ShoppingCart("Cart001", customer);

        boolean run = true;
        while (run) {
            System.out.println("\n=== Shopping Menu ===");
            System.out.println("1. Add Electronics Item");
            System.out.println("2. Add Clothing Item");
            System.out.println("3. Add Book");
            System.out.println("4. Add Accessory");
            System.out.println("5. Add Groceries");
            System.out.println("6. View Cart");
            System.out.println("7. Checkout and Pay");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid choice. Please enter a number between 1-8.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- Enter Electronics Item Details ---");
                    String eName = inputValidatedString("Item Name: ");
                    String eDesc = inputValidatedString("Description: ");
                    double ePrice = inputPositiveDouble("Price: ");
                    int eStock = inputPositiveInt("Stock Available: ");
                    int warranty = inputPositiveInt("Warranty Period (e.g., 12 months): ");

                    ElectronicsItem eItem = new ElectronicsItem("E" + System.currentTimeMillis(), eName, eDesc, ePrice, eStock, warranty);
                    if (eItem.validateItem()) {
                        cart.addItem(eItem);
                    } else {
                        System.out.println("⚠️ Invalid item details. Item not added.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Enter Clothing Item Details ---");
                    String cName = inputValidatedString("Item Name: ");
                    String cDesc = inputValidatedString("Description: ");
                    double cPrice = inputPositiveDouble("Price: ");
                    int cStock = inputPositiveInt("Stock Available: ");
                    String size = inputValidatedSize("Size (S/M/L/XL): ");

                    ClothingItem cItem = new ClothingItem("C" + System.currentTimeMillis(), cName, cDesc, cPrice, cStock, size);
                    if (cItem.validateItem()) {
                        cart.addItem(cItem);
                    } else {
                        System.out.println("⚠️ Invalid item details. Item not added.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Enter Book Details ---");
                    String bName = inputValidatedString("Book Title: ");
                    String bDesc = inputValidatedString("Description: ");
                    double bPrice = inputPositiveDouble("Price: ");
                    int bStock = inputPositiveInt("Stock Available: ");
                    String isbn = inputValidatedString("ISBN: ");
                    String edition = inputValidatedString("Edition: ");

                    BooksItem bItem = new BooksItem("B" + System.currentTimeMillis(), bName, bDesc, bPrice, bStock, isbn, edition);
                    if (bItem.validateItem()) {
                        cart.addItem(bItem);
                    } else {
                        System.out.println("⚠️ Invalid book details. Item not added.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Enter Accessory Details ---");
                    String aName = inputValidatedString("Accessory Name: ");
                    String aDesc = inputValidatedString("Description: ");
                    double aPrice = inputPositiveDouble("Price: ");
                    int aStock = inputPositiveInt("Stock Available: ");
                    String variety = inputValidatedString("Variety (e.g., Necklace, Watch): ");
                    double rating = inputPositiveDouble("Customer Rating (0-5): ");

                    AccessoriesItem aItem = new AccessoriesItem("A" + System.currentTimeMillis(), aName, aDesc, aPrice, aStock, variety, rating);
                    if (aItem.validateItem()) {
                        cart.addItem(aItem);
                    } else {
                        System.out.println("⚠️ Invalid accessory details. Item not added.");
                    }
                    break;

                case 5:
                    System.out.println("\n--- Enter Grocery Item Details ---");
                    String gName = inputValidatedString("Item Name: ");
                    String gDesc = inputValidatedString("Description: ");
                    double gPrice = inputPositiveDouble("Price: ");
                    int gStock = inputPositiveInt("Stock Available: ");
                    int year = inputPositiveInt("Expiration Year: ");
                    int month = inputPositiveInt("Expiration Month (1-12): ");
                    int day = inputPositiveInt("Expiration Day (1-31): ");
                    boolean discount = inputValidatedString("Bulk Discount available? (yes/no): ").equalsIgnoreCase("yes");

                    LocalDate expDate = LocalDate.of(year, month, day);
                    GroceriesItem gItem = new GroceriesItem("G" + System.currentTimeMillis(), gName, gDesc, gPrice, gStock, expDate, discount);
                    if (gItem.validateItem()) {
                        cart.addItem(gItem);
                    } else {
                        System.out.println("⚠️ Invalid grocery details. Item not added.");
                    }
                    break;

                case 6:
                    cart.displayCart();
                    break;

                case 7:
                    if (cart.getTotalPrice() == 0) {
                        System.out.println("⚠️ Cart is empty. Add items first!");
                    } else {
                        System.out.println("\n--- Checkout ---");
                        double amount = inputPositiveDouble("Enter payment amount ($" + cart.getTotalPrice() + "): ");
                        String method = inputValidatedString("Enter payment method (Credit Card / PayPal / Mobile Money): ");
                        String transactionDate = LocalDate.now().toString();

                        Payment payment = new Payment("P" + System.currentTimeMillis(), method, amount, transactionDate);

                        if (payment.validatePayment(cart.getTotalPrice())) {
                            System.out.println("✅ Payment Successful!");
                            List<ShoppingCart> completedOrders = new ArrayList<>();
                            completedOrders.add(cart);
                            SalesReport.generateSalesReport(completedOrders);
                            run = false;
                        } else {
                            System.out.println("⚠️ Payment failed. Try again.");
                        }
                    }
                    break;

                case 8:
                    System.out.println("👋 Exiting the system. Thank you!");
                    run = false;
                    break;

                default:
                    System.out.println("⚠️ Invalid choice. Please select between 1 and 8.");
            }
        }

        sc.close();
    }
}
