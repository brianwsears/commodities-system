package com.personaldev.commodities.domain.products

import groovy.transform.ToString

@ToString
class Coffee extends BaseProduct {

    int id
    String manufacturer
    String productName
    String roast
    Boolean caffeinated
}
