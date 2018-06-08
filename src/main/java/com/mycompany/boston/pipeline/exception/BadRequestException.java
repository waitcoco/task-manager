package com.mycompany.boston.pipeline.exception;

public class BadRequestException extends RuntimeException {
    private final String message;

    public BadRequestException(String message) {
        this.message = message;
    }

    public BadRequestException(Exception e) {
        this(e.getMessage());
    }

    public String getMessage() {
        return message;
    }
}
