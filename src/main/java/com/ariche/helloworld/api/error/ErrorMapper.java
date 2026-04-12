package com.ariche.helloworld.api.error;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.time.Instant;


@UtilityClass
public final class ErrorMapper {

    static ErrorDTO toDTO(final HttpStatus httpStatus, final String message) {
        return ErrorDTO.builder()
            .status(httpStatus.value())
            .reason(httpStatus.getReasonPhrase())
            .name(httpStatus.name())
            .message(message)
            .occurredAt(Instant.now())
            .build();
    }

}
