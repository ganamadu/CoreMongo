package com.core.mongo.controller;

import com.core.mongo.service.MessageService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/msg")
@Validated
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

    //Added required for request param.
    //If Request Param is missing getting the org.springframework.web.bind.MissingServletRequestParameterException.
    @GetMapping("/greet")
    public String hello(@RequestParam(name = "userName", required = true) String userName,
                        @RequestParam(name = "userType", required = true) String userType) {
        return "Hello, "+userName;
    }

    @GetMapping("/user")
    public String getUserDetails(@RequestParam("fname") @NotBlank @Size(min = 1,max = 5) String fname,
                                 @RequestParam("age") @Min(18) Integer userAge) {
        return "User Id: "+fname+" , Age: "+userAge;
    }

}
