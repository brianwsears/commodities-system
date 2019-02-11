package com.personaldev.commodities.service.customer

import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.service.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService extends BaseService {

    @Autowired
    CustomerAddressService customerAddressService

    @Autowired
    CustomerPhoneService customerPhoneService

    @Autowired
    CustomerDao customerDao

    Customer createCustomer(Customer customer) throws Exception {
        customerDao.insertCustomer(customer)
    }

    Customer getCustomer(String customerEmail) throws Exception {
        Customer customer       = customerDao.getCustomer(customerEmail)
        customer.addressList    = customerAddressService.getCustomerAddressList(customerEmail)
        customer.phoneList      = customerPhoneService.getCustomerPhoneList(customerEmail)

        return customer
    }
}