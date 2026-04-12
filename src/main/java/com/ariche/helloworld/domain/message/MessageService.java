package com.ariche.helloworld.domain.message;

import com.ariche.helloworld.persistence.message.MessageStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageStore messageStore;

    public List<Message> getAll() {
        return messageStore.getAllMessages();
    }

    public Message getById(final Long id) {
        return messageStore.findById(id);
    }

    public Message createMessage(final String content) {
        return messageStore.create(content);
    }
}
