package com.example.demo.chat.service;

import com.example.demo.chat.entity.Message;

import java.util.List;

public interface WebSocketMessageService {
    List<Message> getMessages(String room);
    Message saveMessage(Message message);
}
