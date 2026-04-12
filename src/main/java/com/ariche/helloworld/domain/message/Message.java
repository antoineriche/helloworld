package com.ariche.helloworld.domain.message;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Message {
    Long id;
    String content;
}
