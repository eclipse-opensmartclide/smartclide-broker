package com.example.websocket.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GitMessage {

    private String timestamp;
    private String user;
    private String repository;
    private String branch;
}
