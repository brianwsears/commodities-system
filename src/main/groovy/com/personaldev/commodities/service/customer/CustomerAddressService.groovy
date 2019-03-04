package com.personaldev.commodities.service.customer

import com.personaldev.commodities.dao.customer.CustomerAddressDao
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.exceptions.CustomerAddressNotFoundException
import com.personaldev.commodities.service.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerAddressService extends BaseService {

    @Autowired
    CustomerAddressDao customerAddressDao

    CustomerAddress createCustomerAddress(String customerEmail, CustomerAddress customerAddress) throws Exception {
        customerAddressDao.insertCustomerAddress(customerEmail, customerAddress)
    }

    List<CustomerAddress> getCustomerAddressList(String customerEmail) throws Exception {
        customerAddressDao.getCustomerAddressList(customerEmail)
    }

    void removeCustomerAddress(String email, String addressType, int addressId) throws Exception {
        int dbResponse = customerAddressDao.deleteCustomerAddress(addressId)
        if(dbResponse == 0) {
            throw new CustomerAddressNotFoundException("No ${addressType} address record found for ${email}")
        }
    }
}
