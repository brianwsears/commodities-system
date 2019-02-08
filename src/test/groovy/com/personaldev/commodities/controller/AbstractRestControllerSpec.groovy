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
            String detailedMessage = "No address records found for timmywoot@gmail.com."
            AddressNotFoundException addressNotFoundException = new AddressNotFoundException(detailedMessage)
        when:
            def response = mockAbstractRestController.handleAddressNotFoundException(addressNotFoundException)
        then:
            response.errorCode == 401001
            response.errorMessage == "No address records found for customer."
            response.detailedMessage == "No address records found for timmywoot@gmail.com."
    }

    def 'PhoneNotFoundException returns the correct ErrorResponse object'() {
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

    def 'UserNotFoundException returns the correct ErrorResponse object'() {
        given:
            String detailedMessage = "No phone records found for timmywoot@gmail.com."
            PhoneNotFoundException phoneNotFoundException = new PhoneNotFoundException(detailedMessage)
        when:
            def response = mockAbstractRestController.handlePhoneNotFoundException(phoneNotFoundException)
        then:
            response.errorCode == 401003
            response.errorMessage == "No phone records found for customer."
            response.detailedMessage == "No phone records found for timmywoot@gmail.com."
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
            response.detailedMessage == "Error accessing the database."
    }
}
