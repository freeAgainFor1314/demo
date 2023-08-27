package com.testwe.mobile.mq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
@RabbitListener(queues = "hello")
public class HelloReceiverTest {

    @RabbitHandler
    public void recv(String msg){
        log.info("recv: "+msg);
    }

}
