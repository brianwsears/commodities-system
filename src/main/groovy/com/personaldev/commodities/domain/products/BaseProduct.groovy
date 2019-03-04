package com.personaldev.commodities.domain.products

import groovy.transform.ToString

@ToString
class BaseProduct {

    int id
    String type
    String unitOfSale
    Float pricePerUnit
    Boolean inStock
}
