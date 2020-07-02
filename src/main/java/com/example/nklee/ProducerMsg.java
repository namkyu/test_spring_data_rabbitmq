package com.example.nklee;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Project : test_spring_data_rabbitmq
 * @Date : 2020-05-27
 * @Author : nklee
 * @Description :
 */
@Component
public class ProducerMsg implements CommandLineRunner {

    private static final String topicExchange = "spring-boot-exchange";

    private final RabbitTemplate rabbitTemplate;

    public ProducerMsg(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(topicExchange, "foo.bar.baz", "Hello Message!");
    }

}