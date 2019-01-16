package com.personaldev.commodities.domain.exceptions

class DaoSelectException extends RuntimeException {

    DaoSelectException(String identifier, String message) {
        super("${identifier} - ${message}")
    }
}
