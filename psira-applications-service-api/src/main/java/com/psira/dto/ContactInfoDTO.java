package com.psira.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactInfoDTO {
    @JsonProperty("email")
    private String email;

    @JsonProperty("cellphone")
    private String cellphone;

    @JsonProperty("fax")
    private String fax;

    @JsonProperty("workPhone")
    private String workPhone;

    // Getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }
}