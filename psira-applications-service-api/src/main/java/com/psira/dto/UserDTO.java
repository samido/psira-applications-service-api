package com.psira.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class UserDTO {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("idNumber")
    private String idNumber;

    @JsonProperty("cvFile")
    private String cvFile;  // Field for Base64-encoded PDF file

    @JsonProperty("address")
    private List<AddressDTO> address;

    @JsonProperty("contactInfo")
    private List<ContactInfoDTO> contactInfo;

    // Getters and setters
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

    public List<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(List<AddressDTO> address) {
        this.address = address;
    }

    public List<ContactInfoDTO> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(List<ContactInfoDTO> contactInfo) {
        this.contactInfo = contactInfo;
    }
}
