package io.kay.spring4.exception;

public class InvalidDataInput extends RuntimeException {
    public InvalidDataInput(String message) {
        super(message);
    }
}
