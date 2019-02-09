package com.personaldev.commodities.controller

import com.personaldev.commodities.domain.exceptions.*
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

    /************************************************************************************************
        404 RESPONSE CODES
    *************************************************************************************************/
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = AddressNotFoundException)
    @ResponseBody
    handleAddressNotFoundException(Exception exception) {
        new ErrorResponse(exception, 404001, "No address records found for customer.")
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = CustomerNotFoundException)
    @ResponseBody
    handleUserNotFoundException(CustomerNotFoundException exception) {
        new ErrorResponse(exception, 404002, "Customer not found")
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = PhoneNotFoundException)
    @ResponseBody
    handlePhoneNotFoundException(Exception exception) {
        new ErrorResponse(exception, 404003, "No phone records found for customer.")
    }


    /************************************************************************************************
     409 RESPONSE CODES
     *************************************************************************************************/
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = CustomerAlreadyExistsException)
    @ResponseBody
    handleCustomeAlreadyExistsException(CustomerAlreadyExistsException exception) {
        new ErrorResponse(exception, 409001, "User ${exception.customer} already exists.")
    }


    /************************************************************************************************
        500 RESPONSE CODES
     *************************************************************************************************/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception)
    @ResponseBody
    handleGenericException(Exception exception) {
        new ErrorResponse(exception, 900000, "Unexpected server error occurred.")
    }

}