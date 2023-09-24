package com.example.demo.chat.repository;

import com.example.demo.chat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebSocketMessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByRoom(String room);
}
