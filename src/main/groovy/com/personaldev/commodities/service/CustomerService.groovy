package com.personaldev.commodities.service

import com.personaldev.commodities.dao.CustomerAddressDao
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.dao.CustomerPhoneDao
import com.personaldev.commodities.domain.customer.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService extends BaseService {

    @Autowired
    CustomerAddressDao addressDao

    @Autowired
    CustomerDao customerDao

    @Autowired
    CustomerPhoneDao phoneDao

    Customer getCustomer(String email) throws Exception {
        Customer customer       = customerDao.getUserByEmail(email)
        customer.addressList    = addressDao.getCustomerAddressList(email)
        customer.phoneList      = phoneDao.getCustomerPhoneList(email)

        return customer
    }

    Customer createCustomer(Customer customer) throws Exception {
        customerDao.insertCustomer(customer)
    }
}
