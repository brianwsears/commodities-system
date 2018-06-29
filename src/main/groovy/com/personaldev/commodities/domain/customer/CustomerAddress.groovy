package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

@ToString
class CustomerAddress {

    int addressId
    int customerAddressId
    String streetAddressLine1
    String streetAddressLine2
    String streetAddressLine3
    String city
    String state
    String zipCode
}
