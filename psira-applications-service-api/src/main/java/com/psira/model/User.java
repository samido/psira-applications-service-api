package com.psira.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    private String username;
    private String password;
    private String name;
    private String surname;

    @Column(name = "id_number")
    private String idNumber;

    @Lob
    @Column(name = "cv_file")
    private String cvFile;  // Field for Base64-encoded PDF file

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<com.psira.model.ContactInfo> contactInfo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<com.psira.model.Address> addresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<com.psira.model.Application> applications;

    // Getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getCvFile() {
        return cvFile;
    }

    public void setCvFile(String cvFile) {
        this.cvFile = cvFile;
    }

    public List<com.psira.model.ContactInfo> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<com.psira.model.ContactInfo> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<com.psira.model.Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<com.psira.model.Address> addresses) {
        this.addresses = addresses;
    }

    public List<com.psira.model.Application> getApplications() {
        return applications;
    }

    public void setApplications(List<com.psira.model.Application> applications) {
        this.applications = applications;
    }
}
