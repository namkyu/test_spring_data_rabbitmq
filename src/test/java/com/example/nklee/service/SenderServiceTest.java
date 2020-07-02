package com.example.nklee.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Project : test_spring_data_rabbitmq
 * @Date : 2020-07-02
 * @Author : nklee
 * @Description :
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SenderServiceTest {

    @Autowired
    private SenderService senderService;

    @Test
    public void test_send() {
        senderService.send("test1111");
    }

}