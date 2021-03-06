package com.personaldev.commodities.domain.enums

enum AddressType {

    BUSINESS("Business"),
    HOME("Home"),
    MAILING("Mailing")

    private String value;

    AddressType(final String value) {
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