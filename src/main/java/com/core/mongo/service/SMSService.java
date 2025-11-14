package com.core.mongo.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("smsService")
public class SMSService implements MessageService {
    @Override
    public String  send(String message) {
        return "Send SMS message...";
    }
}
