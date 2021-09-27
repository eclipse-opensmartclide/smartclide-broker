package com.example.websocket.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

        private String helloMessage;
        private String from;
        private String text;
        private String timestamp;
}
