package AdvancedOnlineShoppingSystem;

import java.util.Arrays;
import java.util.List;

public class Payment {
    private String paymentId;
    private String paymentMethod;
    private double amountPaid;
    private String transactionDate;

    private static final List<String> VALID_METHODS = Arrays.asList("Credit Card", "PayPal", "Mobile Money");

    public Payment(String paymentId, String paymentMethod, double amountPaid, String transactionDate) {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amountPaid = amountPaid;
        this.transactionDate = transactionDate;
    }

    public boolean validatePayment(double expectedAmount) {
        if (!VALID_METHODS.contains(paymentMethod)) {
            System.out.println("⚠️ Invalid payment method. Valid options: " + VALID_METHODS);
            return false;
        }
        if (amountPaid != expectedAmount) {
            System.out.println("⚠️ Payment amount does not match the total price.");
            return false;
        }
        return true;
    }
}
