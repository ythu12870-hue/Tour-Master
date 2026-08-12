package com.tourmaster.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Booking {

    private int id;
    private String bookingCode;

    private int customerId;
    private int packageId;

    private LocalDate travelDate;

    private int numberOfPeople;

    private BigDecimal totalAmount;

    private String bookingStatus;


    // Empty constructor
    public Booking() {
    }


    // Constructor without ID
    public Booking(
            String bookingCode,
            int customerId,
            int packageId,
            LocalDate travelDate,
            int numberOfPeople,
            BigDecimal totalAmount,
            String bookingStatus) {

        this.bookingCode = bookingCode;
        this.customerId = customerId;
        this.packageId = packageId;
        this.travelDate = travelDate;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
    }


    // Constructor with ID
    public Booking(
            int id,
            String bookingCode,
            int customerId,
            int packageId,
            LocalDate travelDate,
            int numberOfPeople,
            BigDecimal totalAmount,
            String bookingStatus) {

        this.id = id;
        this.bookingCode = bookingCode;
        this.customerId = customerId;
        this.packageId = packageId;
        this.travelDate = travelDate;
        this.numberOfPeople = numberOfPeople;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }


    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }


    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }


    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


    @Override
    public String toString() {

        return "Booking{" +
                "id=" + id +
                ", bookingCode='" + bookingCode + '\'' +
                ", customerId=" + customerId +
                ", packageId=" + packageId +
                ", travelDate=" + travelDate +
                ", numberOfPeople=" + numberOfPeople +
                ", totalAmount=" + totalAmount +
                ", bookingStatus='" + bookingStatus + '\'' +
                '}';
    }
}