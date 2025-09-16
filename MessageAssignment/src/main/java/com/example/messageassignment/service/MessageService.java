package com.example.messageassignment.service;

import com.example.messageassignment.models.Message;
import com.example.messageassignment.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public List<Message> getMessages() {
        return repository.getAllMessages();
    }

    public Message findMessageById(int id, String caps) {
        Message message = repository.findMessageById(id);
        if (caps != null && caps.equals("yes")) {
            return new Message(message.getId(), message.getContent().toUpperCase());
        }
        return message;
    }

    public Message addMessage(Message message) {
        Message newMessage = repository.addMessage(message);
        return newMessage;
    }
}
