package com.personaldev.commodities.service

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.service.customer.CustomerAddressService
import com.personaldev.commodities.service.customer.CustomerPhoneService
import com.personaldev.commodities.service.customer.CustomerService

class CustomerServiceSpec extends BaseSpec {

    CustomerService service

    def setup() {
        service = new CustomerService(
                customerDao: Mock(CustomerDao),
                customerAddressService: Mock(CustomerAddressService),
                customerPhoneService: Mock(CustomerPhoneService)
        )

        service.customerDao.getCustomer(_) >> mockCustomer
        service.customerAddressService.getCustomerAddressList(_) >> mockCustomerAddressList
        service.customerPhoneService.getCustomerPhoneList(_) >> mockCustomerPhoneList
    }

    def "getCustomer returns a Customer object"() {
        when:
            def response = service.getCustomer(TEST_EMAIL)
        then:
            response instanceof Customer
    }

    //TODO - Move to CustomerPhoneServiceSpec
//    def "getCustomerPhoneList returns a list of CustomerPhone objects"() {
//        when:
//            def response = service.getCustomerPhoneList(TEST_EMAIL)
//        then:
//            response instanceof List<CustomerPhone>
//    }

    //TODO - Move to CustomerAddressServiceSpec
//    def "getCustomerAddressList returns a list of CustomerAddress objects"() {
//        when:
//            def response = service.getCustomerAddressList(TEST_EMAIL)
//        then:
//            response instanceof List<CustomerAddress>
//    }
}
