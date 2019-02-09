package com.personaldev.commodities.service

import com.personaldev.commodities.dao.CustomerAddressDao
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.dao.CustomerPhoneDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService extends BaseService {

    @Autowired
    CustomerAddressDao customerAddressDao

    @Autowired
    CustomerDao customerDao

    @Autowired
    CustomerPhoneDao customerPhoneDao


    Customer createCustomer(Customer customer) throws Exception {
        customerDao.insertCustomer(customer)
    }

    Customer getCustomer(String customerEmail) throws Exception {
        Customer customer       = customerDao.getUserByEmail(customerEmail)
        customer.addressList    = customerAddressDao.getCustomerAddressList(customerEmail)
        customer.phoneList      = customerPhoneDao.getCustomerPhoneList(customerEmail)

        return customer
    }

    List<CustomerAddress> getCustomerAddressList(String customerEmail) throws Exception {
        customerAddressDao.getCustomerAddressList(customerEmail)
    }
}
