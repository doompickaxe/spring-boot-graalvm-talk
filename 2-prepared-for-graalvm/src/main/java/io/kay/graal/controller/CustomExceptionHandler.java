package io.kay.graal.controller;

import io.kay.graal.exception.InvalidDataInput;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// FIXME was renamed from ExceptionHandle to CustomExceptionHandler to avoid naming conflict with an annotation
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = InvalidDataInput.class)
    public ErrorResponse handleException(InvalidDataInput exception) {
        return ErrorResponse.builder(exception, HttpStatus.BAD_REQUEST, exception.getMessage()).build();
    }
}
