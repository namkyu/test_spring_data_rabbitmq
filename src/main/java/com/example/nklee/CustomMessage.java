package com.example.nklee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomMessage {
    private String text;
    private int priority;
    private boolean secret;
}
