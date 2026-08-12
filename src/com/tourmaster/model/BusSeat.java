package com.tourmaster.model;

public class BusSeat {

    private int id;
    private int busId;

    private String seatNumber;
    private String seatType;
    private String status;


    public BusSeat() {
    }


    public BusSeat(
            int busId,
            String seatNumber,
            String seatType,
            String status) {

        this.busId = busId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getBusId() {
        return busId;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }


    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }


    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {

        return "BusSeat{" +
                "id=" + id +
                ", busId=" + busId +
                ", seatNumber='" +
                seatNumber + '\'' +
                ", seatType='" +
                seatType + '\'' +
                ", status='" +
                status + '\'' +
                '}';
    }
}