package com.personaldev.commodities.domain.exceptions;

public class GenericException extends Exception {

    private String throwingClass;
    private String message;

    public GenericException(String throwingClass, String message) {
        super(message);
        this.throwingClass = throwingClass;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
