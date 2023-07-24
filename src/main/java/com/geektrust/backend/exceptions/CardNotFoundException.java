package com.geektrust.backend.exceptions;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(String message) {
        super(message);
    }
}

