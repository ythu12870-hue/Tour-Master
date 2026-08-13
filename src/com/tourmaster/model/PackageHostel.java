package com.tourmaster.model;

public class PackageHostel {

    private int id;
    private int packageId;
    private int hostelId;
    private int nights;
    private String roomType;
    private int roomsRequired;
    private String notes;

    public PackageHostel() {
    }

    public PackageHostel(
            int packageId,
            int hostelId,
            int nights,
            String roomType,
            int roomsRequired,
            String notes) {

        this.packageId = packageId;
        this.hostelId = hostelId;
        this.nights = nights;
        this.roomType = roomType;
        this.roomsRequired = roomsRequired;
        this.notes = notes;
    }

    public PackageHostel(
            int id,
            int packageId,
            int hostelId,
            int nights,
            String roomType,
            int roomsRequired,
            String notes) {

        this.id = id;
        this.packageId = packageId;
        this.hostelId = hostelId;
        this.nights = nights;
        this.roomType = roomType;
        this.roomsRequired = roomsRequired;
        this.notes = notes;
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

    public int getHostelId() {
        return hostelId;
    }

    public void setHostelId(int hostelId) {
        this.hostelId = hostelId;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomsRequired() {
        return roomsRequired;
    }

    public void setRoomsRequired(int roomsRequired) {
        this.roomsRequired = roomsRequired;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "PackageHostel{" +
                "id=" + id +
                ", packageId=" + packageId +
                ", hostelId=" + hostelId +
                ", nights=" + nights +
                ", roomType='" + roomType + '\'' +
                ", roomsRequired=" + roomsRequired +
                ", notes='" + notes + '\'' +
                '}';
    }
}