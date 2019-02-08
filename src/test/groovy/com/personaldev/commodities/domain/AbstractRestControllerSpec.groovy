package com.personaldev.commodities.domain

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.controller.AbstractRestController
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
import spock.lang.Shared

class AbstractRestControllerSpec extends BaseSpec {

    @Shared
    AbstractRestController mockAbstractRestController = new Object() as AbstractRestController

    def 'UserNotFoundException returns the correct ErrorResponse object'() {
        given:
            String detailedMessage = "timmywoot@gmail.com not found in Customer database."
            CustomerNotFoundException userNotFoundException = new CustomerNotFoundException(detailedMessage)
        when:
            def response = mockAbstractRestController.handleUserNotFoundException(userNotFoundException)
        then:
            response.errorCode == 401002
            response.errorMessage == "Customer not found"
            response.detailedMessage == "timmywoot@gmail.com not found in Customer database."
    }

//    def 'Exception returns the correct ErrorResponse object'() {
//        given:
//            String detailedMessage = "Error accessing the database."
//            Exception genericException = new Exception(detailedMessage)
//        when:
//            def response = mockAbstractRestController.handleGenericException(genericException)
//        then:
//            response.errorCode == 900000
//            response.errorMessage == "Unexpected server error occurred. Something went wrong!"
//            response.detailedMessage == "Error accessing the database."
//    }
}
