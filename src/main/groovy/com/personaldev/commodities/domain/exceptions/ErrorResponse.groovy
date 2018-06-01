package com.personaldev.commodities.domain.exceptions

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse {

    private final Logger logger = LoggerFactory.getLogger(this.getClass())

    public final String genericMessage
    public final String detailedMessage
    public final int errorCode

    ErrorResponse(Exception ex, Integer errorCode, String genericMessage, String requestUri = "") {
        this.genericMessage = genericMessage
        this.detailedMessage = ex.getLocalizedMessage()
        this.errorCode = errorCode

        logger.error("$detailedMessage: $ex.message \n $requestUri")
    }
}
