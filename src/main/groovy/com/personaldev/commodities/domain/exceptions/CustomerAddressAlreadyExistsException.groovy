package com.personaldev.commodities.domain.exceptions

import com.personaldev.commodities.domain.customer.CustomerAddress

class CustomerAddressAlreadyExistsException extends Exception {

    String customerEmail
    CustomerAddress customerAddress

    CustomerAddressAlreadyExistsException(String message, String customerEmail, CustomerAddress customerAddress) {
        super(message)
        this.customerEmail = customerEmail
        this.customerAddress = customerAddress
    }
}
