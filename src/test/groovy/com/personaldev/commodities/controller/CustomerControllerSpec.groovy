package com.personaldev.commodities.controller

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.service.CustomerService

class CustomerControllerSpec extends BaseSpec {

    CustomerController controller

    def setup() {
        controller = new CustomerController(
                customerService: Mock(CustomerService)
        )
    }

    def "creatCustomer returns a Customer object"() {
        given:
            controller.customerService.createCustomer(_) >> mockCustomer
        when:
            def response = controller.createCustomer(mockCustomer)
        then:
            response instanceof Customer
    }

    def "getCustomer returns a Customer object"() {
        given:
            controller.customerService.getCustomer(_) >> mockCustomer
        when:
            def response = controller.customerService.getCustomer(TEST_EMAIL)
        then:
            response instanceof Customer
    }

    def "getCustomerAddressList returns a list of CustomerAddress objects"() {
        given:
            controller.customerService.getCustomerAddressList(_) >> mockCustomerAddressList
        when:
            def response = controller.customerService.getCustomerAddressList(TEST_EMAIL)
        then:
            response instanceof List<CustomerAddress>
    }

    def "getCustomerPhoneList returns a list of CustomerPhone objects"() {
        given:
            controller.customerService.getCustomerPhoneList(_) >> mockCustomerPhoneList
        when:
            def response = controller.getCustomerPhoneList(TEST_EMAIL)
        then:
            response instanceof List<CustomerPhone>
    }
}
