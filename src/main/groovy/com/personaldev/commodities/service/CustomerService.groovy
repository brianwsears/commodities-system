package com.personaldev.commodities.service


import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.dao.CustomerPhoneDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerPhone
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService extends BaseService {

    @Autowired
    CustomerAddressService customerAddressService

    @Autowired
    CustomerDao customerDao

    @Autowired
    CustomerPhoneDao customerPhoneDao

    Customer createCustomer(Customer customer) throws Exception {
        customerDao.insertCustomer(customer)
    }

    Customer getCustomer(String customerEmail) throws Exception {
        Customer customer       = customerDao.getCustomer(customerEmail)
        customer.addressList    = customerAddressService.getCustomerAddressList(customerEmail)
        customer.phoneList      = customerPhoneDao.getCustomerPhoneList(customerEmail)

        return customer
    }

    List<CustomerPhone> getCustomerPhoneList(String customerEmail) throws Exception {
        customerPhoneDao.getCustomerPhoneList(customerEmail)
    }
}
