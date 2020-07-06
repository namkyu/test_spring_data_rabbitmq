package com.example.nklee.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.socket.WebSocketSession;

import java.net.InetSocketAddress;

@Data
public class User {
    @JsonIgnore
    private WebSocketSession session;
    private String sessionId;
    private String userName;
    private InetSocketAddress remoteAddress;
    private int textMessageSizeLimit;
}
