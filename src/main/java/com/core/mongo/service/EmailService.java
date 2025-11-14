package com.core.mongo.service;

import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService implements MessageService {
    @Override
    public String send(String message) {
        return "Send EMail Message....";
    }
}
