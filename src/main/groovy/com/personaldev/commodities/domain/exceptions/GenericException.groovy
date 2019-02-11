package com.personaldev.commodities.domain.exceptions

class GenericException extends Exception {

    String throwingClass
    String message

    GenericException(String throwingClass, String message) {
        super(message)
        this.throwingClass = throwingClass
    }
}
