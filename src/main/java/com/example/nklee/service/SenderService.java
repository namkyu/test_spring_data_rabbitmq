package com.example.nklee.service;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @Project : test_spring_data_rabbitmq
 * @Date : 2020-05-27
 * @Author : nklee
 * @Description :
 */
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
