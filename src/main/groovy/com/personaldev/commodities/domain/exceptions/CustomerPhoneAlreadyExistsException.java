package com.personaldev.commodities.domain.exceptions;

import com.personaldev.commodities.domain.customer.CustomerPhone;


public class CustomerPhoneAlreadyExistsException extends Exception {

    private String customerEmail;
    private CustomerPhone customerPhone;

    public CustomerPhoneAlreadyExistsException(String message, String customerEmail, CustomerPhone customerPhone) {
        super(message);
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public CustomerPhone getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(CustomerPhone customerPhone) {
        this.customerPhone = customerPhone;
    }
}
