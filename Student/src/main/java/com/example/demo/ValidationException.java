package com.example.demo;

@SuppressWarnings("serial")
public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
