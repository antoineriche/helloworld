package com.ariche.helloworld.api.message;

import com.ariche.helloworld.domain.message.Message;
import lombok.experimental.UtilityClass;

import java.util.List;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@UtilityClass
public class MessageDTOMapper {

    static MessageDTO toDTO(final Message domain) {
        if (domain == null) {
            return null;
        }

        return MessageDTO.builder()
            .id(domain.getId())
            .content(domain.getContent())
            .build();
    }

    static List<MessageDTO> toDTOs(final List<Message> domains) {
        return emptyIfNull(domains).stream()
            .map(MessageDTOMapper::toDTO)
            .toList();
    }
}
