package com.personaldev.commodities.domain.exceptions

class CustomerAlreadyExistsException extends Exception {

    String customer

    CustomerAlreadyExistsException(String message, String customer) {
        super(message)
        this.customer = customer
    }
}
