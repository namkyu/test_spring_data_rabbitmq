package com.example.nklee.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Project : test_spring_data_rabbitmq
 * @Date : 2020-05-27
 * @Author : nklee
 * @Description :
 */
@Service
public class CustomMessageListener {

    @RabbitListener(queues = "spring-boot")
    public void receiveMessage(final Message message) {
        System.out.println(message);
    }

}
