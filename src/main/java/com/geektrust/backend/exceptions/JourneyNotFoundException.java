package com.geektrust.backend.exceptions;

public class JourneyNotFoundException extends RuntimeException {
    public JourneyNotFoundException(String message) {
        super(message);
    }
}
