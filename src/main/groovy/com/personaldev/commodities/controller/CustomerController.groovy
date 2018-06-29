package com.personaldev.commodities.controller

import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/commodities-service/v1")
class CustomerController implements AbstractRestController {

    @Autowired
    CustomerService userService

    @GetMapping(path = "/user/{email}")
    Customer getUser(@PathVariable(value = "email", required = true) String email) {
        userService.getUser(email)
    }
}
