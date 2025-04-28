package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class Claim {
    private String claimId;
    private double claimAmount;
    private LocalDate claimDate;
    private String claimStatus; // "Pending", "Approved", "Rejected"

    public Claim(String claimId, double claimAmount, LocalDate claimDate) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimStatus = "Pending";
    }

    public String getClaimId() {
        return claimId;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void approveClaim() {
        this.claimStatus = "Approved";
    }

    public void rejectClaim() {
        this.claimStatus = "Rejected";
    }
}
