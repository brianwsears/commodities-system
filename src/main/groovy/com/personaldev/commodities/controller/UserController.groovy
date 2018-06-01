package com.personaldev.commodities.controller

import com.personaldev.commodities.domain.User
import com.personaldev.commodities.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/commodities-service/v1")
class UserController implements AbstractRestController {

    @Autowired
    UserService userService

    @GetMapping(path = "/user/{email}")
    User getUser(@PathVariable(value = "email", required = true) String email) {
        userService.getUser(email)
    }
}
