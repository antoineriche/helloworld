package com.ariche.helloworld.api;

import com.ariche.helloworld.persistence.message.MessageEntity;
import com.ariche.helloworld.persistence.message.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") // Temporary: allows frontend to talk to it
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageRepository messageRepository;

    @GetMapping(
            path = "/hello",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String hello() {
        return "Hello World";
    }

    @GetMapping(
            path = "/messages",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<MessageEntity> getMessages() {
        return messageRepository.findAll();
    }

    @PostMapping(
            path = "/messages",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageEntity createMessage(final Map<String, String> contents) {
        final var entity = MessageEntity.builder()
                .content(contents.get("content"))
                .build();
        return messageRepository.save(entity);
    }

    @GetMapping(
            path = "/messages/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageEntity getMessageById(@PathVariable Long id) {
        return messageRepository.findById(id).orElse(null);
    }
}
