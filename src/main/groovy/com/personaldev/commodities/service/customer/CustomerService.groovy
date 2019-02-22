package com.personaldev.commodities.service.customer

import com.personaldev.commodities.dao.customer.CustomerDao
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
        Customer createdCustomer = customerDao.getCustomer(customer.customerEmail)
        return createdCustomer
    }

    void removeCustomer(String email) throws Exception {
        customerDao.deleteCustomer(email)
    }

    Customer getCustomer(String email) throws Exception {
        Customer customer       = customerDao.getCustomer(email)
        customer.addressList    = customerAddressService.getCustomerAddressList(email)
        customer.phoneList      = customerPhoneService.getCustomerPhoneList(email)

        return customer
    }
}
