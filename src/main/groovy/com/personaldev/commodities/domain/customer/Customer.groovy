package com.personaldev.commodities.domain.customer

import groovy.transform.ToString

import javax.validation.constraints.NotNull

@ToString
class Customer {

    @NotNull
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
