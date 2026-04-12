package com.ariche.helloworld.persistence.message;

import com.ariche.helloworld.domain.error.NotFoundException;
import com.ariche.helloworld.domain.message.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.ariche.helloworld.persistence.message.MessageEntityMapper.toDomain;
import static com.ariche.helloworld.persistence.message.MessageEntityMapper.toDomains;

@Component
@RequiredArgsConstructor
public class MessageStore {

    private final MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return toDomains(messageRepository.findAll());
    }

    public Message findById(final Long id) {
        return messageRepository.findById(id)
            .map(MessageEntityMapper::toDomain)
            .orElseThrow(() -> new NotFoundException(""));
    }

    public Message create(final String content) {
        final var entity = MessageEntity.builder()
            .content(content)
            .build();
        return toDomain(messageRepository.save(entity));
    }

}
