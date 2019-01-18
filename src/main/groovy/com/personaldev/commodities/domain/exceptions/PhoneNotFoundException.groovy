package com.personaldev.commodities.domain.exceptions

class PhoneNotFoundException extends RuntimeException {

    PhoneNotFoundException(String message) {
        super(message)
    }
}
