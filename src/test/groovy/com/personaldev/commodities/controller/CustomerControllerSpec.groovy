package com.personaldev.commodities.controller

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.service.CustomerService

class CustomerControllerSpec extends BaseSpec {

    CustomerController controller

    def setup() {
        controller = new CustomerController(
                customerService: Mock(CustomerService)
        )
    }

//    def "getUser returns a Customer object"() {
//        given:
//            controller.customerService.getCustomer(_) >> mockCustomer
//        when:
//            def response = controller.customerService.getCustomer("email")
//        then:
//            1 * controller.customerService.getCustomer(_)
//            response instanceof Customer
//    }
}
