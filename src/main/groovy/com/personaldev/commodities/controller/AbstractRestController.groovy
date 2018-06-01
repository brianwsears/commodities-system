package com.personaldev.commodities.controller

import com.personaldev.commodities.domain.exceptions.ErrorResponse
import com.personaldev.commodities.domain.exceptions.UserNotFoundException
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

import javax.servlet.http.HttpServletRequest

@Controller
@CompileStatic
abstract trait AbstractRestController {

    @Autowired
    private HttpServletRequest context

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = UserNotFoundException)
    @ResponseBody
    handleUserNotFoundException(Exception exception) {
        new ErrorResponse(exception, 401001, "User not found", context.getRequestURI())
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception)
    @ResponseBody
    handleGenericException(Exception exception) {
        new ErrorResponse(exception, 900000, "Unexpected server error occurred. Someting went wong!", context.getRequestURI())
    }
}