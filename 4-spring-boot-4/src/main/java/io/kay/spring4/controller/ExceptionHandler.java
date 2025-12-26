package io.kay.spring4.controller;

import io.kay.spring4.exception.InvalidDataInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = InvalidDataInput.class)
    public ErrorResponse handleException(InvalidDataInput exception) {
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, exception.getMessage()).build();
    }
}
