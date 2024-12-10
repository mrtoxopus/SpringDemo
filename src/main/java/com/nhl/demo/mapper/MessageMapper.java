package com.nhl.demo.mapper;

import com.nhl.demo.DTO.MessageDTO;
import com.nhl.demo.model.Message;
import com.nhl.demo.repository.AuthorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageMapper implements Mapper<MessageDTO, Message> {

    private final AuthorRepository authorRepository;

    public MessageMapper(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }
    @Override
    public MessageDTO toDTO(Message message) {
        return new MessageDTO(
                message.getId(),
                message.getTitle(),
                message.getContent(),
                message.getAuthor().getId()
        );
    }

    @Override
    public List<MessageDTO> toDTO(List<Message> u) {
        return u.stream()
                .map(this::toDTO)
                .toList();
    }

    @Override
    public Message toEntity(MessageDTO messageDTO) {
        return new Message(
                messageDTO.getTitle(),
                messageDTO.getContent(),
                authorRepository.findById(messageDTO.getAuthorId()).orElseThrow()
        );
    }
}
