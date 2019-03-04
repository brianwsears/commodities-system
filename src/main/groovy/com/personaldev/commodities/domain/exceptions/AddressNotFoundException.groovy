package com.personaldev.commodities.domain.exceptions

class AddressNotFoundException extends Exception {

    String customer

    AddressNotFoundException(String message, String customer) {
        super(message)
        this.customer = customer
    }
}
