package com.tourmaster.model;

public class Customer {

    private int id;
    private String fullName;
    private String gender;

    private String nrcStateCode;
    private String nrcTownshipCode;
    private String nrcType;
    private String nrcNumber;

    private String phone;
    private String email;
    private String address;

    // Empty constructor
    public Customer() {
    }

    // Constructor without ID
    public Customer(
            String fullName,
            String gender,
            String nrcStateCode,
            String nrcTownshipCode,
            String nrcType,
            String nrcNumber,
            String phone,
            String email,
            String address) {

        this.fullName = fullName;
        this.gender = gender;
        this.nrcStateCode = nrcStateCode;
        this.nrcTownshipCode = nrcTownshipCode;
        this.nrcType = nrcType;
        this.nrcNumber = nrcNumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNrcStateCode() {
        return nrcStateCode;
    }

    public void setNrcStateCode(String nrcStateCode) {
        this.nrcStateCode = nrcStateCode;
    }

    public String getNrcTownshipCode() {
        return nrcTownshipCode;
    }

    public void setNrcTownshipCode(String nrcTownshipCode) {
        this.nrcTownshipCode = nrcTownshipCode;
    }

    public String getNrcType() {
        return nrcType;
    }

    public void setNrcType(String nrcType) {
        this.nrcType = nrcType;
    }

    public String getNrcNumber() {
        return nrcNumber;
    }

    public void setNrcNumber(String nrcNumber) {
        this.nrcNumber = nrcNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}