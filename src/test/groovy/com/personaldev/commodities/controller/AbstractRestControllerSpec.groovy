package com.personaldev.commodities.controller

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.exceptions.AddressNotFoundException
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
import com.personaldev.commodities.domain.exceptions.PhoneNotFoundException
import spock.lang.Shared

class AbstractRestControllerSpec extends BaseSpec {

    @Shared
    AbstractRestController mockAbstractRestController = new Object() as AbstractRestController

    def 'AddressNotFoundException returns the correct ErrorResponse object'() {
        given:
            String detailedMessage = "No address records found for ${TEST_EMAIL}."
            AddressNotFoundException addressNotFoundException = new AddressNotFoundException(detailedMessage, TEST_EMAIL)
        when:
            def response = mockAbstractRestController.handleAddressNotFoundException(addressNotFoundException)
        then:
            response.errorCode == 404001
            response.errorMessage == "No address records found for customer."
    }

    def 'PhoneNotFoundException returns the correct ErrorResponse object'() {
        given:
            String detailedMessage = "${TEST_EMAIL} not found in Customer database."
            CustomerNotFoundException userNotFoundException = new CustomerNotFoundException(detailedMessage, TEST_EMAIL)
        when:
            def response = mockAbstractRestController.handleUserNotFoundException(userNotFoundException)
        then:
            response.errorCode == 404002
            response.errorMessage == "Customer not found"
    }

    def 'UserNotFoundException returns the correct ErrorResponse object with a generic message'() {
        given:
            String detailedMessage = "No phone records found for ${TEST_EMAIL}."
            PhoneNotFoundException phoneNotFoundException = new PhoneNotFoundException(detailedMessage)
        when:
            def response = mockAbstractRestController.handlePhoneNotFoundException(phoneNotFoundException)
        then:
            response.errorCode == 404003
            response.errorMessage == "No phone records found for customer."
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
