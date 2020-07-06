package com.example.nklee.service;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    RabbitMessagingTemplate rabbitMessagingTemplate;

    public SenderService(RabbitMessagingTemplate rabbitMessagingTemplate) {
        this.rabbitMessagingTemplate = rabbitMessagingTemplate;
    }

    public void send(String message) {
        rabbitMessagingTemplate.convertAndSend("spring-boot-exchange", "foo.bar.aaa", message);
    }

}
