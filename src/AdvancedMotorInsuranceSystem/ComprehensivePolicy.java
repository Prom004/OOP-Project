package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;
import java.time.Period;

public class ComprehensivePolicy extends InsurancePolicy {
    public ComprehensivePolicy(String policyId, Vehicle vehicle, Person policyHolder,
                               double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    @Override
    public void calculatePremium() {
        int age = Period.between(LocalDate.of(vehicle.getVehicleYear(), 1, 1), LocalDate.now()).getYears();
        premiumAmount = coverageAmount * (0.02 + (age * 0.001));
    }

    @Override
    public boolean processClaim(double claimAmount) {
        if (claimAmount <= coverageAmount) {
            coverageAmount -= claimAmount;
            return true;
        }
        return false;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("Comprehensive Policy Report for " + policyHolder.getFullName());
        System.out.println("Vehicle: " + vehicle.getVehicleMake() + " " + vehicle.getVehicleModel());
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage left: $" + coverageAmount);
    }

    @Override
    public boolean validatePolicy() {
        return vehicle.getVehicleYear() >= 2000;
    }
}
