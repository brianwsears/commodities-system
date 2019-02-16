package com.personaldev.commodities.domain.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import groovy.util.logging.Slf4j;


@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    public final String errorMessage;
    public final int errorCode;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public ErrorResponse(Exception exception, Integer errorCode, String genericMessage, String requestUri) {
        this.errorCode = errorCode;
        this.errorMessage = genericMessage;
        logger.error(exception.getMessage());
    }

    public ErrorResponse(Exception exception, Integer errorCode, String genericMessage) {
        this(exception, errorCode, genericMessage, "");
    }
}
