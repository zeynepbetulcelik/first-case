package com.example.firstcase.exception;

public class UserAlreadyExist extends RuntimeException {

    public UserAlreadyExist(final String message) {
        super(message);
    }
}
