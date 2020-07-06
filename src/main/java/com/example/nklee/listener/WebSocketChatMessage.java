package com.example.nklee.listener;

import lombok.Data;

@Data
public class WebSocketChatMessage {
    private String type;
    private String content;
    private String sender;
}
