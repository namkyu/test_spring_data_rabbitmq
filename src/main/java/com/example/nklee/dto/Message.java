package com.example.nklee.dto;

import lombok.Data;

import java.util.List;

@Data
public class Message {

    private String event;
    private String name;
    private List<User> users;
}
