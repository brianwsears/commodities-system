package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

@ToString
class Customer {

    String customerEmail
    String firstName
    String lastName
    String nickname
    int age
    String gender
    String customerAddressId
    List<CustomerAddress> addressList
    List<Phone> phoneList
}
