package com.tourmaster.model;

import java.math.BigDecimal;

public class Package {

    private int id;

    private int destinationId;

    private String packageName;

    private String packageType;

    private String description;

    private BigDecimal price;

    private int durationDays;

    private int durationNights;

    private int maxPeople;

    private String transportationType;

    private String status;


    // =========================================================
    // Empty Constructor
    // =========================================================

    public Package() {
    }


    // =========================================================
    // Constructor without ID
    // =========================================================

    public Package(
            int destinationId,
            String packageName,
            String packageType,
            String description,
            BigDecimal price,
            int durationDays,
            int durationNights,
            int maxPeople,
            String transportationType,
            String status) {

        this.destinationId = destinationId;
        this.packageName = packageName;
        this.packageType = packageType;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
        this.durationNights = durationNights;
        this.maxPeople = maxPeople;
        this.transportationType = transportationType;
        this.status = status;
    }


    // =========================================================
    // Constructor with ID
    // =========================================================

    public Package(
            int id,
            int destinationId,
            String packageName,
            String packageType,
            String description,
            BigDecimal price,
            int durationDays,
            int durationNights,
            int maxPeople,
            String transportationType,
            String status) {

        this.id = id;
        this.destinationId = destinationId;
        this.packageName = packageName;
        this.packageType = packageType;
        this.description = description;
        this.price = price;
        this.durationDays = durationDays;
        this.durationNights = durationNights;
        this.maxPeople = maxPeople;
        this.transportationType = transportationType;
        this.status = status;
    }


    // =========================================================
    // Getters and Setters
    // =========================================================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }


    public int getDurationNights() {
        return durationNights;
    }

    public void setDurationNights(int durationNights) {
        this.durationNights = durationNights;
    }


    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }


    public String getTransportationType() {
        return transportationType;
    }

    public void setTransportationType(
            String transportationType) {

        this.transportationType = transportationType;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    // =========================================================
    // To String
    // =========================================================

    @Override
    public String toString() {

        return "Package{" +
                "id=" + id +
                ", destinationId=" + destinationId +
                ", packageName='" + packageName + '\'' +
                ", packageType='" + packageType + '\'' +
                ", price=" + price +
                ", durationDays=" + durationDays +
                ", durationNights=" + durationNights +
                ", maxPeople=" + maxPeople +
                ", transportationType='" +
                transportationType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}