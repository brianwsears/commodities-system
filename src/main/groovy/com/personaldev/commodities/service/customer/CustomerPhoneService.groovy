package com.personaldev.commodities.service.customer

import com.personaldev.commodities.dao.CustomerPhoneDao
import com.personaldev.commodities.domain.customer.CustomerPhone
import com.personaldev.commodities.service.BaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerPhoneService extends BaseService {

    @Autowired
    CustomerPhoneDao customerPhoneDao

    List<CustomerPhone> getCustomerPhoneList(String customerEmail) throws Exception {
        customerPhoneDao.getCustomerPhoneList(customerEmail)
    }
}
