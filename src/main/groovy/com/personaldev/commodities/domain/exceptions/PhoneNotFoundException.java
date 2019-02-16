package com.personaldev.commodities.domain.exceptions;

public class PhoneNotFoundException extends RuntimeException {

    public PhoneNotFoundException(String message) {
        super(message);
    }
}
