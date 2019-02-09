package com.personaldev.commodities

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
import spock.lang.Specification

class BaseSpec extends Specification {

    static final String TEST_EMAIL      = "timmywoot@gmail.com"

    Customer mockCustomer
    List<CustomerAddress> mockCustomerAddressList
    List<CustomerPhone> mockCustomerPhoneList

    def setup() {
        mockCustomer                    = MockBuilder.buildCustomer()
        mockCustomerAddressList         = MockBuilder.buildCustomerAddressList()
        mockCustomerPhoneList           = MockBuilder.buildCustomerPhoneList()
    }
}
