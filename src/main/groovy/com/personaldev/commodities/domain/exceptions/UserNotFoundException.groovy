package com.personaldev.commodities.domain.exceptions

class UserNotFoundException extends RuntimeException {

    UserNotFoundException(String message) {
        super(message)
    }
}
