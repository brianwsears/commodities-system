package com.personaldev.commodities.domain.exceptions

import com.personaldev.commodities.domain.customer.CustomerPhone

class CustomerPhoneAlreadyExistsException extends Exception {

    String customerEmail
    CustomerPhone customerPhone

    CustomerPhoneAlreadyExistsException(String message, String customerEmail, CustomerPhone customerPhone) {
        super(message)
        this.customerEmail = customerEmail
        this.customerPhone = customerPhone
    }
}
