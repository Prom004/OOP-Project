package AdvancedOnlineShoppingSystem;

import java.util.List;

public class SalesReport {

    public static void generateSalesReport(List<ShoppingCart> completedOrders) {
        double totalRevenue = 0;
        int totalItemsSold = 0;

        System.out.println("\n=== Sales Report ===");
        for (ShoppingCart cart : completedOrders) {
            totalRevenue += cart.getTotalPrice();
            totalItemsSold += cart.cartItems.size();
        }

        System.out.println("Total Revenue  : $" + totalRevenue);
        System.out.println("Total Items Sold: " + totalItemsSold);
    }
}
