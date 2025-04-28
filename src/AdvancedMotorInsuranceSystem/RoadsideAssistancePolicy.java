package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class RoadsideAssistancePolicy extends InsurancePolicy {
    public RoadsideAssistancePolicy(String policyId, Vehicle vehicle, Person policyHolder,
                                    double coverageAmount, LocalDate startDate, LocalDate endDate) {
        super(policyId, vehicle, policyHolder, coverageAmount, startDate, endDate);
    }

    @Override
    public void calculatePremium() {
        premiumAmount = coverageAmount * 0.008;
    }

    @Override
    public boolean processClaim(double claimAmount) {
        return claimAmount <= coverageAmount;
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("Roadside Assistance Policy Report for " + policyHolder.getFullName());
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage left: $" + coverageAmount);
    }

    @Override
    public boolean validatePolicy() {
        return true;
    }
}
