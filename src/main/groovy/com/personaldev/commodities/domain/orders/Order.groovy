package com.personaldev.commodities.domain.orders

import groovy.transform.ToString

@ToString
class Order {

    int orderId
    List<Product> products
    String email
}
