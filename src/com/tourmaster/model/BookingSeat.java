package com.tourmaster.model;

public class BookingSeat {

    private int id;
    private int bookingId;
    private int seatId;


    // Empty constructor
    public BookingSeat() {
    }


    // Constructor without ID
    public BookingSeat(
            int bookingId,
            int seatId) {

        this.bookingId = bookingId;
        this.seatId = seatId;
    }


    // Constructor with ID
    public BookingSeat(
            int id,
            int bookingId,
            int seatId) {

        this.id = id;
        this.bookingId = bookingId;
        this.seatId = seatId;
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


    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }


    @Override
    public String toString() {

        return "BookingSeat{" +
                "id=" + id +
                ", bookingId=" + bookingId +
                ", seatId=" + seatId +
                '}';
    }
}