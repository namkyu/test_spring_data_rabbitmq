package com.example.nklee;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Project : test_spring_data_rabbitmq
 * @Date : 2020-05-27
 * @Author : nklee
 * @Description :
 */
@Data
@AllArgsConstructor
public class CustomMessage {
    private String text;
    private int priority;
    private boolean secret;
}
