package com.personaldev.commodities.domain.exceptions

class CustomerNotFoundException extends RuntimeException {

    CustomerNotFoundException(String message) {
        super(message)
    }
}
