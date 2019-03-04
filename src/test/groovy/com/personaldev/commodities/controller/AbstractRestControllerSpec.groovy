package com.personaldev.commodities.controller

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
import spock.lang.Shared

class AbstractRestControllerSpec extends BaseSpec {

    @Shared
    AbstractRestController mockAbstractRestController = new Object() as AbstractRestController

    def 'UserNotFoundException returns the correct ErrorResponse object with a generic message'() {
        given:
            String detailedMessage = "Customer not found for ${TEST_EMAIL}."
            CustomerNotFoundException customerNotFoundException = new CustomerNotFoundException(detailedMessage, TEST_EMAIL)
        when:
            def response = mockAbstractRestController.handleCustomerrNotFoundException(customerNotFoundException)
        then:
            response.errorCode == 404001
            response.errorMessage == "Customer not found."
    }

    def 'Exception returns the correct ErrorResponse object'() {
        given:
            String detailedMessage = "Error accessing the database."
            Exception genericException = new Exception(detailedMessage)
        when:
            def response = mockAbstractRestController.handleGenericException(genericException)
        then:
            response.errorCode == 900000
            response.errorMessage == "Unexpected server error occurred."
    }
}
