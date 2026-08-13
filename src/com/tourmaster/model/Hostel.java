package com.tourmaster.model;

public class Hostel {

    private int id;
    private String name;
    private int destinationId;
    private String address;
    private String phone;
    private String description;
    private Double rating;
    private String status;

    public Hostel() {
    }

    public Hostel(
            String name,
            int destinationId,
            String address,
            String phone,
            String description,
            Double rating,
            String status) {

        this.name = name;
        this.destinationId = destinationId;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.rating = rating;
        this.status = status;
    }

    public Hostel(
            int id,
            String name,
            int destinationId,
            String address,
            String phone,
            String description,
            Double rating,
            String status) {

        this.id = id;
        this.name = name;
        this.destinationId = destinationId;
        this.address = address;
        this.phone = phone;
        this.description = description;
        this.rating = rating;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", destinationId=" + destinationId +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", status='" + status + '\'' +
                '}';
    }
}