package com.psira.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.psira.model.Qualification;
import java.util.Date;

public class ApplicationDTO {

    @JsonProperty("applicationId")
    private Long applicationId;

    @JsonProperty("postId")
    private Long postId;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("qualification")
    private Qualification qualification;

    @JsonProperty("driversLicense")
    private Boolean driversLicense;

    @JsonProperty("currentPosition")
    private String currentPosition;

    @JsonProperty("currentCompany")
    private String currentCompany;

    @JsonProperty("yearsInPosition")
    private Long yearsInPosition;

    @JsonProperty("currentSalary")
    private Double currentSalary;

    @JsonProperty("totalExperience")
    private Long totalExperience;

    @JsonProperty("previousPosition")
    private String previousPosition;

    @JsonProperty("previousCompany")
    private String previousCompany;

    @JsonProperty("periodFrom")
    private Date periodFrom;

    @JsonProperty("periodTo")
    private Date periodTo;

    // Default constructor
    public ApplicationDTO() {}

    // Getters and Setters for all fields

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Boolean getDriversLicense() {
        return driversLicense;
    }

    public void setDriversLicense(Boolean driversLicense) {
        this.driversLicense = driversLicense;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public Long getYearsInPosition() {
        return yearsInPosition;
    }

    public void setYearsInPosition(Long yearsInPosition) {
        this.yearsInPosition = yearsInPosition;
    }

    public Double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(Double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public Long getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(Long totalExperience) {
        this.totalExperience = totalExperience;
    }

    public String getPreviousPosition() {
        return previousPosition;
    }

    public void setPreviousPosition(String previousPosition) {
        this.previousPosition = previousPosition;
    }

    public String getPreviousCompany() {
        return previousCompany;
    }

    public void setPreviousCompany(String previousCompany) {
        this.previousCompany = previousCompany;
    }

    public Date getPeriodFrom() {
        return periodFrom;
    }

    public void setPeriodFrom(Date periodFrom) {
        this.periodFrom = periodFrom;
    }

    public Date getPeriodTo() {
        return periodTo;
    }

    public void setPeriodTo(Date periodTo) {
        this.periodTo = periodTo;
    }
}
