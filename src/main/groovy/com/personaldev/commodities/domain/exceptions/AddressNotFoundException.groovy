package com.personaldev.commodities.domain.exceptions

class AddressNotFoundException extends RuntimeException {

    AddressNotFoundException(String message) {
        super(message)
    }
}
