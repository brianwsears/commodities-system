package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

@ToString
class Customer {

    String customerEmail
    Date createDate
    String firstName
    String lastName
    String nickname
    int age
    String gender
    List<CustomerAddress> addressList
    List<CustomerPhone> phoneList
}
