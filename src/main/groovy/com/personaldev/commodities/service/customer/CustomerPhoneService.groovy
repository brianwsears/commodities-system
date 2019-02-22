package com.personaldev.commodities.service.customer

import com.personaldev.commodities.dao.customer.CustomerPhoneDao
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.service.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerPhoneService extends BaseService {

    @Autowired
    CustomerPhoneDao customerPhoneDao

    CustomerPhone createCustomerPhone(String customerEmail, CustomerPhone customerPhone) throws Exception {
        customerPhoneDao.insertCustomerPhone(customerEmail, customerPhone)
    }

    List<CustomerPhone> getCustomerPhoneList(String customerEmail) throws Exception {
        customerPhoneDao.getCustomerPhoneList(customerEmail)
    }
}
