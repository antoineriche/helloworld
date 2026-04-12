package com.ariche.helloworld.domain.error;


public class NotFoundException extends DomainException {

    public NotFoundException(final Error error, final String fieldName, final Object fieldValue) {
        super(error, fieldName, fieldValue);
    }

    public NotFoundException(final String message, final Object... args) {
        super(message, args);
    }

    public NotFoundException(final Error error, final Object... args) {
        super(error, args);
    }
}
