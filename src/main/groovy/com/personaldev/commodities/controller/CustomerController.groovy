package com.personaldev.commodities.controller

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.service.customer.CustomerAddressService
import com.personaldev.commodities.service.customer.CustomerPhoneService
import com.personaldev.commodities.service.customer.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/commodities-service/v1")
class CustomerController implements AbstractRestController {

    @Autowired
    CustomerService customerService

    @Autowired
    CustomerAddressService customerAddressService

    @Autowired
    CustomerPhoneService customerPhoneService


    @PostMapping(path = "/user")
    Customer createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer)
    }

    @PostMapping(path = "/user/address/{customerEmail}")
    CustomerAddress createCustomerAddress(
                        @PathVariable(value = "customerEmail", required = true ) String customerEmail,
                        @RequestBody CustomerAddress customerAddress) {
        customerAddressService.createCustomerAddress(customerEmail, customerAddress)
    }

    @PostMapping(path = "/user/phone/{customerEmail}")
    CustomerPhone createCustomerPhone(
                        @PathVariable(value = "customerEmail", required = true ) String customerEmail,
                        @RequestBody @Valid CustomerPhone customerPhone) {
        customerPhoneService.createCustomerPhone(customerEmail, customerPhone)
    }

    @DeleteMapping(path = "/user/{customerEmail}")
    void deleteCustomer(@PathVariable(value = "customerEmail", required = true) String customerEmail) {
        customerService.removeCustomer(customerEmail)
    }

    @GetMapping(path = "/user/{customerEmail}")
    Customer getCustomer(@PathVariable(value = "customerEmail", required = true) String customerEmail) {
        customerService.getCustomer(customerEmail)
    }

    @GetMapping(path = "/user/address/{customerEmail}")
    List<CustomerAddress> getCustomerAddressList(@PathVariable(value = "customerEmail", required = true) String customerEmail) {
        customerAddressService.getCustomerAddressList(customerEmail)
    }

    @GetMapping(path = "/user/phone/{customerEmail}")
    List<CustomerPhone> getCustomerPhoneList(@PathVariable(value = "customerEmail", required = true) String customerEmail) {
        customerService.customerPhoneService.getCustomerPhoneList(customerEmail)
    }

    @DeleteMapping(path = "/user/phone/{phoneNumber}")
    void deletePhoneNumber(@PathVariable(value = "phoneNumber", required = true) String phoneNumber) {
        customerPhoneService.removeCustomerPhoneNumber(phoneNumber)
    }
}
