package com.personaldev.commodities.service

import com.personaldev.commodities.dao.UserDao
import com.personaldev.commodities.domain.user.Customer
import com.personaldev.commodities.domain.exceptions.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    UserDao userDao

    Customer getUser(String email) throws UserNotFoundException {
        Customer user = userDao.getUser(email)
        if(!user) {
            throw new UserNotFoundException("${email}' not found in Customer table.")
        }

        return userDao.getUser(email)
    }
}
