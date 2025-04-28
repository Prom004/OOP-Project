package AdvancedMotorInsuranceSystem;

public class Vehicle {
    private String vehicleId;
    private String vehicleMake;
    private String vehicleModel;
    private int vehicleYear;
    private String vehicleType; // "Private" or "Commercial"

    public Vehicle(String vehicleId, String vehicleMake, String vehicleModel, int vehicleYear, String vehicleType) {
        this.vehicleId = vehicleId;
        this.vehicleMake = vehicleMake;
        this.vehicleModel = vehicleModel;
        setVehicleYear(vehicleYear);
        setVehicleType(vehicleType);
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int year) {
        if (year >= 1900 && year <= 2025) {
            this.vehicleYear = year;
        } else {
            throw new IllegalArgumentException("Vehicle year must be between 1900 and 2025.");
        }
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String type) {
        if (type.equalsIgnoreCase("Private") || type.equalsIgnoreCase("Commercial")) {
            this.vehicleType = type;
        } else {
            throw new IllegalArgumentException("Vehicle type must be 'Private' or 'Commercial'.");
        }
    }
}
