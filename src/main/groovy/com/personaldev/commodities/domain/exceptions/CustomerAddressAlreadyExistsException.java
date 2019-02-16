package com.personaldev.commodities.domain.exceptions;

import com.personaldev.commodities.domain.customer.CustomerAddress;


public class CustomerAddressAlreadyExistsException extends Exception {

    private String customerEmail;
    private CustomerAddress customerAddress;

    public CustomerAddressAlreadyExistsException(String message, String customerEmail, CustomerAddress customerAddress) {
        super(message);
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }
}
