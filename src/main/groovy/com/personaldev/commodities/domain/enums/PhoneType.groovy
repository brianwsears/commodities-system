package com.personaldev.commodities.domain.enums

enum PhoneType {

    HOME("H"),
    MOBILE("M"),
    WORK("W")

    private String value;

    PhoneType(final String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }

    @Override
    String toString() {
        return this.getValue();
    }
}