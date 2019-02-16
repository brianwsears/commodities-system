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

    void removeCustomer(String email) throws Exception {
        customerDao.deleteCustomer(email)
        //TODO - Successful delete of customer should also remove their associated Address and Phone lists
    }

    Customer getCustomer(String email) throws Exception {
        Customer customer       = customerDao.getCustomer(email)
        customer.addressList    = customerAddressService.getCustomerAddressList(email)
        customer.phoneList      = customerPhoneService.getCustomerPhoneList(email)

        return customer
    }
}
