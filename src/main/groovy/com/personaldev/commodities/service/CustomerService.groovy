package com.personaldev.commodities.service

import com.personaldev.commodities.dao.AddressDao
import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.dao.PhoneDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.Phone
import com.personaldev.commodities.domain.exceptions.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService extends BaseService {

    @Autowired
    AddressDao addressDao

    @Autowired
    CustomerDao customerDao

    @Autowired
    PhoneDao phoneDao

    Customer getCustomer(String email) throws UserNotFoundException {
        Customer customer
        customer = getCustomerData(email)
        customer.phoneList = getPhoneList(email)

        if(customer.customerAddressId) {
            customer.addressList = getAddressList(customer.customerAddressId)
        }

        return customer
    }

    protected Customer getCustomerData(String email) {
        Customer customer = customerDao.getUserByEmail(email)
        if(!customer) {
            throw new UserNotFoundException("${email}' not found in Customer table.")
        }
    }

    protected List<CustomerAddress> getAddressList(String customerAddressId) {
        return addressDao.getCustomerAddress(customerAddressId)
    }

    protected List<Phone> getPhoneList(String email) {
        phoneDao.getCustomerPhoneList(email)
    }
}
