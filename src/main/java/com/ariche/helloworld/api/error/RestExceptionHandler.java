package com.ariche.helloworld.api.error;


import com.ariche.helloworld.domain.error.NotFoundException;
import com.ariche.helloworld.domain.error.ValidationException;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.net.BindException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    @ExceptionHandler({NotFoundException.class, NoResourceFoundException.class})
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<ErrorDTO> handleNotFoundError(final Exception error) {
        log.info("Not found error: {}", error.getMessage());
        return buildResponse(NOT_FOUND, error);
    }

    @ExceptionHandler({
        ValidationException.class,
        ConstraintViolationException.class,
        HttpRequestMethodNotSupportedException.class,
        MethodArgumentNotValidException.class,
        MethodArgumentTypeMismatchException.class,
        HttpMessageNotReadableException.class,
        IllegalArgumentException.class,
        BindException.class
    })
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorDTO> handleValidationException(final Exception error) {
        log.info("Validation error: {}", error.getMessage());
        return buildResponse(BAD_REQUEST, error);
    }

    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorDTO> handleInternalServerError(final Exception error) {
        log.error("Unhandled server error", error);
        return buildResponse(INTERNAL_SERVER_ERROR, error);
    }

    private String getErrorMessage(final Throwable error) {
        return error.getMessage();
    }

    private ResponseEntity<ErrorDTO> buildResponse(final HttpStatus status, final Throwable error) {
        return ResponseEntity
            .status(status)
            .body(ErrorMapper.toDTO(status, getErrorMessage(error)));
    }

}
