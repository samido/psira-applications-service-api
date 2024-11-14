package com.psira.dto;

public class SiftingApplicationDTO {
    private String name;
    private String surname;
    private String province;
    private String driversLicense; // 2 for Yes, 0 for No
    private String qualification1;
    private String qualification2;
    private Long experience; // Actual years of experience for reference
    private Integer experiencePoints; // Calculated experience points (0 or 2)
    private Integer totalPoints;
    private String meetRequirement;
    private String reviewCV;

    // Getters and Setters

    public Integer getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(Integer experiencePoints) {
        this.experiencePoints = experiencePoints;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(String driversLicense) {
        this.driversLicense = driversLicense;
    }

    public String getQualification1() {
        return qualification1;
    }

    public void setQualification1(String qualification1) {
        this.qualification1 = qualification1;
    }

    public String getQualification2() {
        return qualification2;
    }

    public void setQualification2(String qualification2) {
        this.qualification2 = qualification2;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getMeetRequirement() {
        return meetRequirement;
    }

    public void setMeetRequirement(String meetRequirement) {
        this.meetRequirement = meetRequirement;
    }

    public String getReviewCV() {
        return reviewCV;
    }

    public void setReviewCV(String reviewCV) {
        this.reviewCV = reviewCV;
    }
}
