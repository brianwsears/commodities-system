package com.personaldev.commodities.service

import com.personaldev.commodities.dao.CustomerAddressDao
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.exceptions.CustomerAddressAlreadyExistsException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerAddressService extends BaseService {

    @Autowired
    CustomerAddressDao customerAddressDao

    CustomerAddress createCustomerAddress(String customerEmail, CustomerAddress customerAddress) throws Exception {
        if(customerAddressAlreadyExists(customerEmail, customerAddress.type)) {
            String errorMessage = "!!~ ERROR: $customerEmail already has a $customerAddress.type address in the database."
            throw new CustomerAddressAlreadyExistsException(errorMessage, customerEmail, customerAddress)
        }
        customerAddressDao.insertCustomerAddress(customerAddress)
    }

    boolean customerAddressAlreadyExists(String customerEmail, String customerAddressType) {
        CustomerAddress existingCustomerAddress = customerAddressDao.getCustomerAddressByType(customerEmail, customerAddressType)

        if(existingCustomerAddress) {
            return true
        }
        return false
    }

    List<CustomerAddress> getCustomerAddressList(String customerEmail) throws Exception {
        customerAddressDao.getCustomerAddressList(customerEmail)
    }
}
