package com.personaldev.commodities.domain.exceptions

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse {

    private final Logger logger = LoggerFactory.getLogger(this.getClass())

    public final String message
    public final String errorType
    public final int errorCode

    //TODO - Test this and enhance to what you want
    ErrorResponse(Exception ex, Integer errorCode, String detail, String requestUri = "") {
        this.errorType = detail
        this.message = ex.getLocalizedMessage()
        this.errorCode = errorCode

        logger.error("$errorType: $ex.message \n $requestUri")
    }
}
