package com.tourmaster.model;

public class Transportation {

    private int id;
    private int packageId;

    private String transportationType;
    private String vehicleName;
    private String vehicleNumber;

    private int capacity;
    private String status;


    // Empty constructor
    public Transportation() {
    }


    // Constructor without ID
    public Transportation(
            int packageId,
            String transportationType,
            String vehicleName,
            String vehicleNumber,
            int capacity,
            String status) {

        this.packageId = packageId;
        this.transportationType = transportationType;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.status = status;
    }


    // Constructor with ID
    public Transportation(
            int id,
            int packageId,
            String transportationType,
            String vehicleName,
            String vehicleNumber,
            int capacity,
            String status) {

        this.id = id;
        this.packageId = packageId;
        this.transportationType = transportationType;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }


    public String getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(
            String transportationType) {

        this.transportationType = transportationType;
    }


    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {

        return "Transportation{" +
                "id=" + id +
                ", packageId=" + packageId +
                ", transportationType='" +
                transportationType + '\'' +
                ", vehicleName='" +
                vehicleName + '\'' +
                ", vehicleNumber='" +
                vehicleNumber + '\'' +
                ", capacity=" + capacity +
                ", status='" + status + '\'' +
                '}';
    }
}