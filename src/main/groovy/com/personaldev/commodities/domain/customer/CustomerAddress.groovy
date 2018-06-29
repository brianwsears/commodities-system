package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

@ToString
class CustomerAddress {

    int addressId
    int customerAddressId
    String addressLine1
    String addressLine2
    String addressLine3
    String city
    String state
    String zipCode
}
