package com.springboot.app.Exception;
public class FlightEventCreationException extends RuntimeException {

    public FlightEventCreationException(String message) {
        super(message);
    }

    public FlightEventCreationException(String message, Exception exception) {
        super(message, exception);
    }
}