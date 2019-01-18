package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

@ToString
class CustomerAddress {

    int addressId
    int customerAddressId
    String streetAddress1
    String streetAddress2
    String streetAddress3
    String city
    String state
    String zipCode
}
