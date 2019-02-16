package com.personaldev.commodities.domain.customer;

public class CustomerAddress {

    private String streetAddress1;
    private String streetAddress2;
    private String streetAddress3;
    private String city;
    private String state;
    private String zipCode;
    private String type;
    private Boolean mailingAddress;

    public String getStreetAddress1() {
        return streetAddress1;
    }
    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public String getStreetAddress3() {
        return streetAddress3;
    }

    public void setStreetAddress3(String streetAddress3) {
        this.streetAddress3 = streetAddress3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Boolean mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
