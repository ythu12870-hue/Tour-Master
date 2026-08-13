package com.tourmaster.model;

public class PackageGuide {

    private int id;
    private int packageId;
    private int guideId;
    private String assignmentType;
    private String notes;

    public PackageGuide() {
    }

    public PackageGuide(
            int packageId,
            int guideId,
            String assignmentType,
            String notes) {

        this.packageId = packageId;
        this.guideId = guideId;
        this.assignmentType = assignmentType;
        this.notes = notes;
    }

    public PackageGuide(
            int id,
            int packageId,
            int guideId,
            String assignmentType,
            String notes) {

        this.id = id;
        this.packageId = packageId;
        this.guideId = guideId;
        this.assignmentType = assignmentType;
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

    public int getGuideId() {
        return guideId;
    }

    public void setGuideId(int guideId) {
        this.guideId = guideId;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "PackageGuide{" +
                "id=" + id +
                ", packageId=" + packageId +
                ", guideId=" + guideId +
                ", assignmentType='" + assignmentType + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}