package com.personaldev.commodities

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.Phone
import spock.lang.Specification

class BaseSpec extends Specification {

    Customer mockCustomer
    CustomerAddress mockCustomerAddress
    Phone mockPhone

    def setup() {
        mockCustomer            = MockBuilder.buildCustomer()
        mockCustomerAddress     = MockBuilder.buildCustomerAddress(1001)
        mockPhone               = MockBuilder.buildPhone(5732915568)
    }
}
