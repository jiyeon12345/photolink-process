package com.example.demo.chat.controller;

import com.example.demo.chat.entity.Message;
import com.example.demo.chat.service.WebSocketMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class WebSocketController {

    final private WebSocketMessageService messageService;

    @GetMapping("/{room}")
    public List<Message> getMessage(@PathVariable String room) {
        log.info("getMessage(): " + room);
        return messageService.getMessages(room);
    }

    @PostMapping("/save")
    public void saveMessage(Message content) {
        log.info("saveMessage(): " + content);
        messageService.saveMessage(content);
    }
}
