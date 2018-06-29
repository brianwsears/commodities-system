package com.personaldev.commodities.service

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.exceptions.UserNotFoundException

class CustomerServiceSpec extends BaseSpec {

    CustomerService service

    def setup() {
        service = new CustomerService(
                userDao: Mock(CustomerDao)
        )
    }

    def "getUser returns a Customer object"() {
        given:
            service.userDao.getUserByEmail("email") >> mockCustomer
        when:
            def response = service.getUser("email")
        then:
            response instanceof Customer
    }

    def "getUser throws UserNotFoundException when no user is found"() {
        given:
            service.userDao.getUserByEmail("email") >> null
        when:
            service.getUser("email")
        then:
            thrown(UserNotFoundException)
    }
}
