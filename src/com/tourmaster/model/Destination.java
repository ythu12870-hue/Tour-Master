package com.tourmaster.model;

public class Destination {

    private int id;
    private String name;
    private String description;
    private String location;
    private String image;
    private String status;

    // Empty constructor
    public Destination() {
    }

    // Constructor without ID
    public Destination(
            String name,
            String description,
            String location,
            String image,
            String status) {

        this.name = name;
        this.description = description;
        this.location = location;
        this.image = image;
        this.status = status;
    }

    // Constructor with ID
    public Destination(
            int id,
            String name,
            String description,
            String location,
            String image,
            String status) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.image = image;
        this.status = status;
    }

    // Getters and Setters

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}