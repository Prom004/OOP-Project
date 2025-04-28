package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public abstract class InsurancePolicy {
    protected String policyId;
    protected Vehicle vehicle;
    protected Person policyHolder;
    protected double coverageAmount;
    protected double premiumAmount;
    protected LocalDate policyStartDate;
    protected LocalDate policyEndDate;

    public InsurancePolicy(String policyId, Vehicle vehicle, Person policyHolder,
                           double coverageAmount, LocalDate startDate, LocalDate endDate) {
        this.policyId = policyId;
        this.vehicle = vehicle;
        this.policyHolder = policyHolder;
        this.coverageAmount = coverageAmount;
        this.policyStartDate = startDate;
        this.policyEndDate = endDate;
    }

    public abstract void calculatePremium();

    public abstract boolean processClaim(double claimAmount);

    public abstract void generatePolicyReport();

    public abstract boolean validatePolicy();
}
