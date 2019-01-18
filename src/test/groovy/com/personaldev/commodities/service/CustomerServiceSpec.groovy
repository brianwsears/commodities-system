package com.personaldev.commodities.service

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.dao.CustomerAddressDao
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.dao.CustomerPhoneDao
import com.personaldev.commodities.domain.customer.Customer

class CustomerServiceSpec extends BaseSpec {

    CustomerService service

    def setup() {
        service = new CustomerService(
                customerDao: Mock(CustomerDao),
                addressDao: Mock(CustomerAddressDao),
                phoneDao: Mock(CustomerPhoneDao)
        )
    }

    def "getCustomer returns a Customer object"() {
        given:
            service.customerDao.getUserByEmail(_) >> mockCustomer
            service.addressDao.getCustomerAddress(_) >> mockCustomerAddressList
            service.phoneDao.getCustomerPhoneList(_) >> mockCustomerPhoneList
        when:
            def response = service.getCustomer("email")
        then:
            response instanceof Customer
    }
}
