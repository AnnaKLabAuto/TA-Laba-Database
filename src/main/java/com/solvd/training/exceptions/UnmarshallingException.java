package com.solvd.training.exceptions;

public class UnmarshallingException extends Exception {

    public UnmarshallingException(String message) {
        super(message);
    }

    public UnmarshallingException(String message, Throwable cause) {
        super(message, cause);
    }
}