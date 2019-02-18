package com.personaldev.commodities.domain.enums

enum ProductType {

    COFFEE("Coffee"),
    TOBACCO("Tobacco")

    private String value;

    ProductType(final String value) {
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