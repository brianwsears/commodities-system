package com.personaldev.commodities.domain.orders

import groovy.transform.ToString

import javax.validation.constraints.NotNull

@ToString
class OrderTransaction {

    @NotNull
    int id

    @NotNull
    int productId

    @NotNull
    int quantity

    @NotNull
    int orderId

    @NotNull
    float pricePerUnit
}
