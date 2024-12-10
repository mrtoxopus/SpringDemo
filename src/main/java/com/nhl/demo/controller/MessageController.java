package com.nhl.demo.controller;

import com.nhl.demo.DTO.MessageDTO;
import com.nhl.demo.mapper.MessageMapper;
import com.nhl.demo.model.Message;
import com.nhl.demo.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public MessageController(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }
    
    @GetMapping()
    public List<MessageDTO> getAllMessages() {
        return messageMapper.toDTO(messageRepository.findAll());
    }
   
    @GetMapping("/{id}")
    public Message getMessageById(@PathVariable("id") long id) {
        return messageRepository.findById(id).orElseThrow();
    }
    
    @GetMapping("/hello")
    public MessageDTO getMessage() {
        return new MessageDTO("Welcome", "NHL Stenden");
    }
    
    @PostMapping
    public void newMessage(@RequestBody MessageDTO message) {
        messageRepository.save(messageMapper.toEntity(message));
    }
}
