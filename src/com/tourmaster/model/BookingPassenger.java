package com.tourmaster.model;

public class BookingPassenger {

    private int id;
    private int bookingId;

    private String fullName;
    private String gender;
    private String nrc;
    private String phone;


    // Empty constructor
    public BookingPassenger() {
    }


    // Constructor without ID
    public BookingPassenger(
            int bookingId,
            String fullName,
            String gender,
            String nrc,
            String phone) {

        this.bookingId = bookingId;
        this.fullName = fullName;
        this.gender = gender;
        this.nrc = nrc;
        this.phone = phone;
    }


    // Constructor with ID
    public BookingPassenger(
            int id,
            int bookingId,
            String fullName,
            String gender,
            String nrc,
            String phone) {

        this.id = id;
        this.bookingId = bookingId;
        this.fullName = fullName;
        this.gender = gender;
        this.nrc = nrc;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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


    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {

        return "BookingPassenger{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", nrc='" + nrc + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}