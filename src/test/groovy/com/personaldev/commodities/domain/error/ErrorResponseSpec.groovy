package com.personaldev.commodities.domain.error

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.exceptions.CustomerNotFoundException
import com.personaldev.commodities.domain.exceptions.ErrorResponse

class ErrorResponseSpec extends BaseSpec {

    def setup() {}

    def "Constructing ErrorResponse object builds an ErrorResponse with the passed parameters"() {
        given:
            int errorCode = 400101
            String genericMessage = "Customer not found."
            String detailedMessage = "${TEST_EMAIL} not found."
            String requestUri = "http://localhost:8080/commodities-service/customer/testUser@commoditeis.com"
            CustomerNotFoundException customerNotFoundException = new CustomerNotFoundException(detailedMessage, TEST_EMAIL)
        when:
            def result = new ErrorResponse(customerNotFoundException, errorCode, genericMessage, requestUri)
        then:
            result instanceof ErrorResponse
            result.errorCode == errorCode
            result.errorMessage == genericMessage
    }
}
