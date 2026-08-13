package com.tourmaster.model;

public class TourGuide {

    private int id;
    private String fullName;
    private String gender;
    private String phone;
    private String email;
    private String languages;
    private int experienceYears;
    private String status;


    // Empty constructor
    public TourGuide() {
    }


    // Constructor without ID
    public TourGuide(
            String fullName,
            String gender,
            String phone,
            String email,
            String languages,
            int experienceYears,
            String status) {

        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.languages = languages;
        this.experienceYears = experienceYears;
        this.status = status;
    }


    // Constructor with ID
    public TourGuide(
            int id,
            String fullName,
            String gender,
            String phone,
            String email,
            String languages,
            int experienceYears,
            String status) {

        this.id = id;
        this.fullName = fullName;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.languages = languages;
        this.experienceYears = experienceYears;
        this.status = status;
    }


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


    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }


    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {

        return "TourGuide{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", languages='" + languages + '\'' +
                ", experienceYears=" + experienceYears +
                ", status='" + status + '\'' +
                '}';
    }
}