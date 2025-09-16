package com.example.messageassignment.controller;

import com.example.messageassignment.models.Message;
import com.example.messageassignment.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("message")
public class MessageController {
    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> messages = service.getMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable int id, @RequestParam(required = false) String caps) {
        Message message = service.findMessageById(id, caps);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Message> addMessage(@RequestBody Message message) {
       Message newMessage = service.addMessage(message);
        return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
    }
}
