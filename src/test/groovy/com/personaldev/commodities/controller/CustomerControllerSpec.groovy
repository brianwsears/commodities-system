package com.personaldev.commodities.controller

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.service.customer.CustomerAddressService
import com.personaldev.commodities.service.customer.CustomerService

class CustomerControllerSpec extends BaseSpec {

    CustomerController controller

    def setup() {
        controller = new CustomerController(
                customerService: Mock(CustomerService),
                customerAddressService: Mock(CustomerAddressService)
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
            controller.customerAddressService.getCustomerAddressList(_) >> mockCustomerAddressList
        when:
            def response = controller.customerAddressService.getCustomerAddressList(TEST_EMAIL)
        then:
            response instanceof List<CustomerAddress>
    }

//    def "getCustomerPhoneList returns a list of CustomerPhone objects"() {
//        given:
//            controller.customerPhoneService.getCustomerPhoneList(_) >> mockCustomerPhoneList
//        when:
//            def response = controller.customerPhoneService.getCustomerPhoneList(TEST_EMAIL)
//        then:
//            response instanceof List<CustomerPhone>
//    }
}
