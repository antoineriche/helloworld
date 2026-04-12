package com.ariche.helloworld.api.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDTO {
    private int status;
    private String reason;
    private String name;
    private String message;
    private Instant occurredAt;
}
