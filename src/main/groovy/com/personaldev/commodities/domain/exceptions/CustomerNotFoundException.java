package com.personaldev.commodities.domain.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    private String customer;

    public CustomerNotFoundException(String message, String customer) {
        super(message);
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
