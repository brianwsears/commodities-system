package com.personaldev.commodities.service

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.dao.CustomerAddressDao
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.dao.CustomerPhoneDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone

class CustomerServiceSpec extends BaseSpec {

    CustomerService service

    def setup() {
        service = new CustomerService(
                customerDao: Mock(CustomerDao),
                customerAddressDao: Mock(CustomerAddressDao),
                customerPhoneDao: Mock(CustomerPhoneDao)
        )

        service.customerDao.getUserByEmail(_) >> mockCustomer
        service.customerAddressDao.getCustomerAddressList(_) >> mockCustomerAddressList
        service.customerPhoneDao.getCustomerPhoneList(_) >> mockCustomerPhoneList
    }

    def "getCustomer returns a Customer object"() {
        when:
            def response = service.getCustomer(TEST_EMAIL)
        then:
            response instanceof Customer
    }

    def "getCustomerPhoneList returns a list of CustomerPhone objects"() {
        when:
            def response = service.getCustomerPhoneList(TEST_EMAIL)
        then:
            response instanceof List<CustomerPhone>
    }

    def "getCustomerAddressList returns a list of CustomerAddress objects"() {
        when:
            def response = service.getCustomerAddressList(TEST_EMAIL)
        then:
            response instanceof List<CustomerAddress>
    }
}
