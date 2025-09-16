package com.example.messageassignment.repository;

import com.example.messageassignment.models.Message;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {
    private final List<Message> messages = new ArrayList<>();
    private int messageId = 1;

    public MessageRepository() {
        populateMessages();
    }

    private void populateMessages() {
        while (messageId <= 3) {
            messages.add(new Message(messageId, "Velkommen til " + messageId + ".semester"));
            messageId++;
        }
    }

    public List<Message> getAllMessages() {
        return messages;
    }

    public Message findMessageById(int id) {
        for (Message message : messages) {
            if (message.getId() == id) {
                return message;
            }
        }
        return null;
    }

    private void addMessageId(Message message) {
        message.setId(messageId++);
    }


    public Message addMessage(Message message) {
        addMessageId(message);
        messages.add(message);
        return message;
    }
}
