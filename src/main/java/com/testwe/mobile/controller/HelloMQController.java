package com.testwe.mobile.controller;

import com.testwe.mobile.service.HelloMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class HelloMQController {
    @Autowired
    private HelloMQService helloMQService;

    @GetMapping("/send/hello")
    public String sendMQ(){
        return helloMQService.sendMQ();
    }
}
