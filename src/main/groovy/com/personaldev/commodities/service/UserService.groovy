package com.personaldev.commodities.service

import com.personaldev.commodities.dao.UserDao
import com.personaldev.commodities.domain.User
import com.personaldev.commodities.domain.exceptions.UserNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    UserDao userDao

    User getUser(String email) throws UserNotFoundException {
        User user = userDao.getUser(email)
        if(!user) {
            throw new UserNotFoundException("Email '${email}' not found.")
        }

        return userDao.getUser(email)
    }
}
