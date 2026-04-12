package com.ariche.helloworld.domain.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static org.apache.commons.lang3.ArrayUtils.isNotEmpty;

@Getter
@RequiredArgsConstructor
public abstract class DomainException extends RuntimeException {

    private final Error error;

    protected DomainException(final Error error, final Object... args) {
        super(isNotEmpty(args) ? String.format(error.getMessage(), args) : error.getMessage());
        this.error = error;
    }

    protected DomainException(final Throwable cause, final Error error, final Object... args) {
        super(isNotEmpty(args) ? String.format(error.getMessage(), args) : error.getMessage(), cause);
        this.error = error;
    }

    protected DomainException(final String message, final Object... args) {
        super(isNotEmpty(args) ? String.format(message, args) : message);
        error = null;
    }

    protected DomainException(final Throwable cause, final String message, final Object... args) {
        super(isNotEmpty(args) ? String.format(message, args) : message, cause);
        error = null;
    }
}
