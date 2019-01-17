package com.personaldev.commodities.domain.exceptions

class DataNotFoundException extends RuntimeException {

    DataNotFoundException(String message) {
        super(message)
    }
}
