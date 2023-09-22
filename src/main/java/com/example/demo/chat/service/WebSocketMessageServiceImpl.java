package com.example.demo.chat.service;

import com.example.demo.chat.entity.Message;
import com.example.demo.chat.repository.WebSocketMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WebSocketMessageServiceImpl implements WebSocketMessageService {

    final private WebSocketMessageRepository messageRepository;
    @Override
    public List<Message> getMessages(String room) {
        return messageRepository.findAllByRoom(room);
    }
    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
