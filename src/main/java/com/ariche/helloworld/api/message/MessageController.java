package com.ariche.helloworld.api.message;

import com.ariche.helloworld.domain.message.MessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ariche.helloworld.api.message.MessageDTOMapper.toDTO;
import static com.ariche.helloworld.api.message.MessageDTOMapper.toDTOs;

@Slf4j
@RestController
@RequestMapping("/api/messages")
@CrossOrigin(origins = "*") // Temporary: allows frontend to talk to it
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MessageDTO> getMessages() {
        log.info("[GET] Get all messages");
        return toDTOs(messageService.getAll());
    }

    @PostMapping(
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageDTO createMessage(@RequestBody @Valid final MessageRequestDTO request) {
        log.info("[POST] Create message: {}", request);
        return toDTO(messageService.createMessage(request.getContent()));
    }

    @GetMapping(
        path = "/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public MessageDTO getMessageById(@PathVariable final Long id) {
        log.info("[GET] Get message by id {}", id);
        return toDTO(messageService.getById(id));
    }
}
