package AdvancedStockManagementSystem;

public class Supplier {
    private String supplierId;
    private String companyName;
    private String contactPerson;
    private String phone;
    private String email;


    public Supplier (String id, String company, String names, String phone, String email) {
        if (!email.contains("@") || phone.length() < 10) {
            System.out.println("Please input a valid email address");
        }
        this.supplierId = id;
        this.companyName = company;
        this.contactPerson= names;
        this.phone = phone;
        this.email = email;
    }

//    public static void main(String[] args) {
//        Supplier sup1 = new Supplier(2344, )
//    }

}
