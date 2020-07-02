package com.example.nklee.controller;

import com.example.nklee.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Project : test_spring_data_rabbitmq
 * @Date : 2020-05-27
 * @Author : nklee
 * @Description :
 */
@RestController
public class SendController {

    @Autowired
    private SenderService senderService;

    @RequestMapping(value ="/send", produces = MediaType.APPLICATION_JSON_VALUE)
    public void setMessages (@RequestParam String msg) {
        senderService.send(msg);
    }
}