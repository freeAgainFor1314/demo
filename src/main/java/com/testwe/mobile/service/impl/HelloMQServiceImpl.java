package com.testwe.mobile.service.impl;

import com.testwe.mobile.component.HelloSender;
import com.testwe.mobile.service.HelloMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class HelloMQServiceImpl implements HelloMQService {

    @Autowired
    private HelloSender helloSender;

    @Override
    public String sendMQ() {
        helloSender.send();
        return "ok";
    }
}
