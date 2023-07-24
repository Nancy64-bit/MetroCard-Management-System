package com.geektrust.backend.exceptions;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
}
