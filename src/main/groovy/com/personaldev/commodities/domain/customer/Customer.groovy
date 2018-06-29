package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

@ToString
class Customer {

    String customer_email
    String firstName
    String lastName
    String nickname
    int age
    String gender
    List<CustomerAddress> customerAddresses
}