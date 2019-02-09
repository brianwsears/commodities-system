package com.personaldev.commodities.controller

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/commodities-service/v1")
class CustomerController implements AbstractRestController {

    @Autowired
    CustomerService customerService

    @PostMapping(path = "/user")
    Customer createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer)
    }

    @GetMapping(path = "/user/{customerEmail}")
    Customer getCustomer(@PathVariable(value = "customerEmail", required = true) String email) {
        customerService.getCustomer(email)
    }

    @GetMapping(path = "/user/address/{customerEmail}")
    List<CustomerAddress> getCustomerAddressList(@PathVariable(value = "customerEmail", required = true) String customerEmail) {
        customerService.getCustomerAddressList(customerEmail)
    }

    @GetMapping(path = "/user/phone/{customerEmail}")
    List<CustomerPhone> getCustomerPhoneList(@PathVariable(value = "customerEmail", required = true) String customerEmail) {
        customerService.getCustomerPhoneList(customerEmail)
    }
}
