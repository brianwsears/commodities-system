package com.personaldev.commodities.domain.exceptions

class CustomerNotFoundException extends Exception {

    String customer

    CustomerNotFoundException(String message, String customer) {
        super(message)
        this.customer = customer
    }
}
