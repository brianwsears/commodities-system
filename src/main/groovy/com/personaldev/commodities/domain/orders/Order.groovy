package com.personaldev.commodities.domain.orders

import groovy.transform.ToString

import javax.validation.constraints.NotNull


@ToString
class Order {

    @NotNull
    int id

    @NotNull
    int quantity

    @NotNull
    int orderTransactionId

    @NotNull
    String customerEmail

    @NotNull
    String status

    @NotNull
    Date createDate

    @NotNull
    Date shippedDate
}
