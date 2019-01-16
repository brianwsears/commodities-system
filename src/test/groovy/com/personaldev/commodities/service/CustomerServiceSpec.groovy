package com.personaldev.commodities.service

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.exceptions.UserNotFoundException

class CustomerServiceSpec extends BaseSpec {

    CustomerService service

    def setup() {
        service = new CustomerService(
                customerDao: Mock(CustomerDao)
        )
    }

    def "getUser returns a Customer object"() {
        given:
            service.customerDao.getUserByEmail("email") >> mockCustomer
        when:
            def response = service.getCustomer("email")
        then:
            response instanceof Customer
    }

    def "getUser throws UserNotFoundException when no user is found"() {
        given:
            service.customerDao.getUserByEmail("email") >> null
        when:
            service.getCustomer("email")
        then:
            thrown(UserNotFoundException)
    }
}
