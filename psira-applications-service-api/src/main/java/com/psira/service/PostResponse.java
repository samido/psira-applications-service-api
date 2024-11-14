package com.psira.service;

public class PostResponse {
    private Long id;
    private String postName;
    private String jobDescription;
    private String businessUnit;
    private Manager manager;
    private Integer experienceYears;
    private String qualification;  // The field we're interested in
    private Boolean driversLicenseRequired;
    private String openingDate;
    private String closingDate;

    // Getter and Setter for qualification
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    // Nested class for manager information
    public static class Manager {
        private Long id;
        private String name;
        private String surname;
        private String email;
        private String tell;
        private String position;

        // Getters and Setters
    }

    // Getters and Setters for PostResponse
}
