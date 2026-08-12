package com.tourmaster.model;

public class Bus {

    private int id;
    private int transportationId;

    private String busName;
    private String busNumber;

    private int totalSeats;

    private String seatLayout;
    private String status;


    public Bus() {
    }


    public Bus(
            int transportationId,
            String busName,
            String busNumber,
            int totalSeats,
            String seatLayout,
            String status) {

        this.transportationId = transportationId;
        this.busName = busName;
        this.busNumber = busNumber;
        this.totalSeats = totalSeats;
        this.seatLayout = seatLayout;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(
            int transportationId) {

        this.transportationId = transportationId;
    }


    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }


    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }


    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }


    public String getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(String seatLayout) {
        this.seatLayout = seatLayout;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {

        return "Bus{" +
                "id=" + id +
                ", transportationId=" +
                transportationId +
                ", busName='" + busName + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", totalSeats=" + totalSeats +
                ", seatLayout='" + seatLayout + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}