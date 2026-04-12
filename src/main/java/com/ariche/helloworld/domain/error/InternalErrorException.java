package com.ariche.helloworld.domain.error;


public class InternalErrorException extends DomainException {

    public InternalErrorException(final Error error, final String fieldName, final Object fieldValue) {
        super(error, fieldName, fieldValue);
    }

    public InternalErrorException(final String message, final Object... args) {
        super(message, args);
    }

    public InternalErrorException(final Error error, final Object... args) {
        super(error, args);
    }
}
