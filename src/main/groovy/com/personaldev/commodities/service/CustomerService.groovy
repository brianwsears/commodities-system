package com.personaldev.commodities.service

import com.personaldev.commodities.dao.CustomerDao
import com.personaldev.commodities.domain.customer.Customer
import com.personaldev.commodities.domain.exceptions.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CustomerService {

    @Autowired
    CustomerDao userDao

    Customer getUser(String email) throws UserNotFoundException {
        Customer user = userDao.getUser(email)
        if(!user) {
            throw new UserNotFoundException("${email}' not found in Customer table.")
        }

        return userDao.getUser(email)
    }
}
