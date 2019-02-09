package com.personaldev.commodities.domain.exceptions

class CustomerAlreadyExistsException extends RuntimeException {

    String customer

    CustomerAlreadyExistsException(String message, String customer) {
        super(message)
        this.customer = customer
    }
}
