package com.geektrust.backend.exceptions;

public class StationNotFoundException extends RuntimeException {

    public StationNotFoundException(String message) {
        super(message);
    }
}