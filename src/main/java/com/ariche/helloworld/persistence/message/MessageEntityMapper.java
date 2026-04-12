package com.ariche.helloworld.persistence.message;

import com.ariche.helloworld.domain.message.Message;
import lombok.experimental.UtilityClass;

import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@UtilityClass
public class MessageEntityMapper {

    static Message toDomain(final MessageEntity entity) {
        if (entity == null) {
            return null;
        }

        return Message.builder()
            .id(entity.getId())
            .content(entity.getContent())
            .build();
    }

    static List<Message> toDomains(final List<MessageEntity> entities) {
        return emptyIfNull(entities).stream()
            .map(MessageEntityMapper::toDomain)
            .toList();
    }
}
