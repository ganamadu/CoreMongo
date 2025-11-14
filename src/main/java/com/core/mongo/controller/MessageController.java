package com.core.mongo.controller;

import com.core.mongo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    @Qualifier("emailService")
    private MessageService emailMessageService;

    @Autowired
    @Qualifier("smsService")
    private MessageService smsMessageService;

    @GetMapping("/sms/{message}")
    public String smsMessage(@PathVariable("message") String message) {
        return smsMessageService.send(message);
    }

    @GetMapping("/email/{message}")
    public String emailMessage(@PathVariable("message") String message) {
        return emailMessageService.send(message);
    }

}
