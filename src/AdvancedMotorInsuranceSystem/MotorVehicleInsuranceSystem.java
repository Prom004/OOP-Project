package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MotorVehicleInsuranceSystem {
    static Scanner scanner = new Scanner(System.in);

    // Input Methods with Strong Validations

    private static String inputNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("⚠️ Input cannot be empty. Please try again.");
        }
    }

    private static int inputPositiveInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("⚠️ Please enter a positive integer.");
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
                double value = Double.parseDouble(scanner.nextLine().trim());
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("⚠️ Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a valid number.");
            }
        }
    }

    private static LocalDate inputValidDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Invalid date format. Please use YYYY-MM-DD.");
            }
        }
    }

    private static String inputValidatedEmail(String prompt) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine().trim();
            if (Pattern.matches(emailPattern, email)) {
                return email;
            }
            System.out.println("⚠️ Invalid email format. Please try again.");
        }
    }

    private static String inputValidatedPhone(String prompt) {
        String phonePattern = "^[0-9]{8,15}$";
        while (true) {
            System.out.print(prompt);
            String phone = scanner.nextLine().trim();
            if (Pattern.matches(phonePattern, phone)) {
                return phone;
            }
            System.out.println("⚠️ Invalid phone number. Digits only (8-15 digits). Try again.");
        }
    }

    private static String inputValidatedVehicleType(String prompt) {
        while (true) {
            System.out.print(prompt);
            String type = scanner.nextLine().trim().toLowerCase();
            if (type.equals("private") || type.equals("commercial")) {
                return type.substring(0, 1).toUpperCase() + type.substring(1);
            } else {
                System.out.println("⚠️ Invalid vehicle type. Please enter either 'Private' or 'Commercial'.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Welcome to the Advanced Motor Vehicle Insurance System ===");

        try {
            String policyId = inputNonEmptyString("Enter Policy ID: ");
            String vehicleId = inputNonEmptyString("Enter Vehicle ID: ");
            String vehicleMake = inputNonEmptyString("Enter Vehicle Make: ");
            String vehicleModel = inputNonEmptyString("Enter Vehicle Model: ");
            int vehicleYear = inputPositiveInt("Enter Vehicle Year (e.g., 2015): ");
            String vehicleType = inputValidatedVehicleType("Enter Vehicle Type (Private/Commercial): ");

            Vehicle vehicle = new Vehicle(vehicleId, vehicleMake, vehicleModel, vehicleYear, vehicleType);

            String personId = inputNonEmptyString("Enter Person ID: ");
            String fullName = inputNonEmptyString("Enter Full Name: ");
            LocalDate dob = inputValidDate("Enter Date of Birth (YYYY-MM-DD): ");
            String email = inputValidatedEmail("Enter Email: ");
            String phone = inputValidatedPhone("Enter Phone Number: ");

            Person policyHolder = new Person(personId, fullName, dob, email, phone);

            double coverageAmount = inputPositiveDouble("Enter Coverage Amount: ");
            LocalDate startDate = inputValidDate("Enter Policy Start Date (YYYY-MM-DD): ");
            LocalDate endDate = inputValidDate("Enter Policy End Date (YYYY-MM-DD): ");

            System.out.println("\nSelect Policy Type:");
            System.out.println("1. Comprehensive Policy");
            System.out.println("2. Third Party Policy");
            System.out.println("3. Collision Policy");
            System.out.println("4. Liability Policy");
            System.out.println("5. Roadside Assistance Policy");
            int choice = inputPositiveInt("Enter your choice (1-5): ");

            InsurancePolicy policy = null;

            switch (choice) {
                case 1:
                    policy = new ComprehensivePolicy(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
                    break;
                case 2:
                    policy = new ThirdPartyPolicy(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
                    break;
                case 3:
                    policy = new CollisionPolicy(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
                    break;
                case 4:
                    policy = new LiabilityPolicy(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
                    break;
                case 5:
                    policy = new RoadsideAssistancePolicy(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid choice! Please select from 1 to 5.");
            }

            if (policy.validatePolicy()) {
                policy.calculatePremium();
                System.out.println("\n=== Policy Created Successfully ===");
                policy.generatePolicyReport();

                System.out.print("\nDo you want to file a claim? (yes/no): ");
                String fileClaim = scanner.nextLine().trim();

                if (fileClaim.equalsIgnoreCase("yes")) {
                    String claimId = inputNonEmptyString("Enter Claim ID: ");
                    double claimAmount = inputPositiveDouble("Enter Claim Amount: ");
                    LocalDate claimDate = inputValidDate("Enter Claim Date (YYYY-MM-DD): ");

                    Claim claim = new Claim(claimId, claimAmount, claimDate);

                    if (policy.processClaim(claim.getClaimAmount())) {
                        claim.approveClaim();
                        System.out.println("✅ Claim Approved!");
                    } else {
                        claim.rejectClaim();
                        System.out.println("❌ Claim Rejected! Claim amount exceeds coverage limit.");
                    }

                    System.out.println("\n=== Claim Details ===");
                    System.out.println("Claim ID: " + claim.getClaimId());
                    System.out.println("Claim Amount: $" + claim.getClaimAmount());
                    System.out.println("Claim Date: " + claim.getClaimDate());
                    System.out.println("Claim Status: " + claim.getClaimStatus());
                } else {
                    System.out.println("No claim filed.");
                }
            } else {
                System.out.println("⚠️ Policy validation failed. Please review vehicle and holder details.");
            }
        } catch (Exception e) {
            System.out.println("❗ Error: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\n=== Thank you for using the Advanced Motor Vehicle Insurance System ===");
        }
    }
}
