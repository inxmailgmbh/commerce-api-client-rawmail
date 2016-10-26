package com.inxmail.commerce.api.rawmail.model;

public class InvalidMessageDataException extends RuntimeException {
    public InvalidMessageDataException( String message ) {
        super( message );
    }

    public InvalidMessageDataException( String message, Throwable cause ) {
        super( message, cause );
    }
}
