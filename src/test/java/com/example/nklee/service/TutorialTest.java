package com.example.nklee.service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;
import java.util.stream.IntStream;

public class TutorialTest {

    private final static String QUEUE_NAME = "hello";
    private ConnectionFactory factory;

    @Before
    public void init() {
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("admin");
        factory.setPassword("admin");
    }

    @Test
    public void test_sender() {
        IntStream.range(1, 1000)
                .forEach(i -> {
                    try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
                        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                        String message = "Hello World" + i;
                        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
                        System.out.println("Sent '" + message + "'");
                        Thread.sleep(20);
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }

    @Test
    public void test_receiver() throws IOException, TimeoutException, InterruptedException {
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Received '" + message + "'");
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });

        Thread.sleep(3000);
    }
}
