package com.psira.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_id")
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    @Column(name = "post_id", nullable = false)
    private Long postId;

    @Enumerated(EnumType.STRING)
    @Column(name = "qualification", nullable = false)
    private Qualification qualification;

    @Column(name = "drivers_license", nullable = false)
    private Boolean driversLicense;

    @Column(name = "current_position", nullable = false)
    private String currentPosition;

    @Column(name = "current_company", nullable = false)
    private String currentCompany;

    @Column(name = "years_in_position", nullable = false)
    private Long yearsInPosition;

    @Column(name = "current_salary", nullable = false)
    private Double currentSalary;

    @Column(name = "total_experience", nullable = false)
    private Long totalExperience;

    @Column(name = "previous_position", nullable = false)
    private String previousPosition;

    @Column(name = "previous_company", nullable = false)
    private String previousCompany;

    @Temporal(TemporalType.DATE)
    @Column(name = "period_from", nullable = false)
    private Date periodFrom;

    @Temporal(TemporalType.DATE)
    @Column(name = "period_to", nullable = false)
    private Date periodTo;

    // Default constructor
    public Application() {}

    // Getters and Setters for all fields

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
