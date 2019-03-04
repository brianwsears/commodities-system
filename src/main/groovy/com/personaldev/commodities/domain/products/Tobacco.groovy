package com.personaldev.commodities.domain.products

import groovy.transform.ToString

@ToString
class Tobacco extends BaseProduct {

    int id
    String manufacturer
    String name
    String type
    String blendType
    String cut
}
