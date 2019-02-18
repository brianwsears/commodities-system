package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


@ToString
class CustomerPhone {

    @NotNull
    @Size(min=10, max=10)
    String phoneNumber

    String type
}
