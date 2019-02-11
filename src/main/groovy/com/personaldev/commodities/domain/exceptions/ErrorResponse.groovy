package com.personaldev.commodities.domain.exceptions

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class ErrorResponse {

    public final String errorMessage
    public final int errorCode

    ErrorResponse(Exception exception, Integer errorCode, String genericMessage, String requestUri = "") {
        this.errorCode = errorCode
        this.errorMessage = genericMessage
        log.error(exception.getMessage())
    }
}
