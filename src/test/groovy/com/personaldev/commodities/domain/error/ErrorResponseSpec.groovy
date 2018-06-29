package com.personaldev.commodities.domain.error

import com.personaldev.commodities.BaseSpec
import com.personaldev.commodities.domain.exceptions.ErrorResponse
import com.personaldev.commodities.domain.exceptions.UserNotFoundException

class ErrorResponseSpec extends BaseSpec {

    def setup() {}

    def "Constructing ErrorResponse object builds an ErrorResponse with the passed parameters"() {
        given:
            int errorCode = 400101
            String genericMessage = "Customer not found."
            String detailedMessage = "testUser@commodities.com not found."
            String requestUri = "http://localhost:8080/commodities-service/user/testUser@commoditeis.com"
            UserNotFoundException userNotFoundException = new UserNotFoundException(detailedMessage)
        when:
            def result = new ErrorResponse(userNotFoundException, errorCode, genericMessage, requestUri)
        then:
            result instanceof ErrorResponse
            result.errorCode == errorCode
            result.detailedMessage == detailedMessage
            result.genericMessage == genericMessage
    }
}
