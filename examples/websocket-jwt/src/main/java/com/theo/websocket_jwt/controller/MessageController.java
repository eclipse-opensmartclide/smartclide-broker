package com.theo.websocket_jwt.controller;

import com.theo.websocket_jwt.model.MyMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MyMessage getMessages(MyMessage message){
        return message;
    }
}
