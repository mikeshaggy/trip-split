package com.mikeshaggy.tripsplit.api.rest.exception;

public class ParticipantAlreadyAddedException extends RuntimeException {

    public ParticipantAlreadyAddedException(String message) {
        super(message);
    }
}
