package com.personaldev.commodities.service.customer

import com.personaldev.commodities.dao.customer.CustomerDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.customer.CustomerAddress
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
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
        ArrayList<CustomerPhone> phoneList = customerPhoneService.getCustomerPhoneList(email)
        ArrayList<CustomerAddress> addressList = customerAddressService.getCustomerAddressList(email)

        if(phoneList) {
           phoneList.each{ phone ->
               customerPhoneService.removeCustomerPhoneNumber(phone.phoneNumber)
           }
        }

        if(addressList) {
            addressList.each{ address ->
                 customerAddressService.removeCustomerAddress(email, address.type, address.id)
            }
        }

        int dbResponse = customerDao.deleteCustomer(email)
        if(dbResponse == 0) {
            throw new CustomerNotFoundException("No Customer record found to delete for ${email}", email)
        }
    }

    Customer getCustomer(String email) throws Exception {
        Customer customer       = customerDao.getCustomer(email)
        customer.addressList    = customerAddressService.getCustomerAddressList(email)
        customer.phoneList      = customerPhoneService.getCustomerPhoneList(email)

        return customer
    }
}
