package com.personaldev.commodities.domain.exceptions

class AddressNotFoundException extends RuntimeException {

    String customer

    AddressNotFoundException(String message, String customer) {
        super(message)
        this.customer = customer
    }
}
