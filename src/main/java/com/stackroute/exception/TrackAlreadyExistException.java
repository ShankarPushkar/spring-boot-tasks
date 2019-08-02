package com.stackroute.exception;

public class TrackAlreadyExistException extends Exception {
    private String message;

    public TrackAlreadyExistException() {
    }

    public TrackAlreadyExistException(String message) {
        this.message = message;
    }
}
