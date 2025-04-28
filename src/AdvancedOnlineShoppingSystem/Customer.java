package AdvancedOnlineShoppingSystem;

public class Customer {
    private String customerId;
    private String customerName;
    private String email;
    private String address;
    private String phone;

    public Customer(String customerId, String customerName, String email, String address, String phone) {
        if (!email.contains("@") || phone.length() > 10) {
            System.out.println("invalid input.");
        }
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void displayInfo() {
        System.out.println("==== Customer information: ====");
        System.out.println("Customer name: "+ getCustomerName());
        System.out.println("Customer ID: "+customerId);
        System.out.println("Address: " + address);
        System.out.println("Email: "+email);
        System.out.println("Phone: "+phone);
    }
}
