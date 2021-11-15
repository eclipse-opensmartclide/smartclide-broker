package com.example.websocket.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TopicController {

    @MessageMapping("/gitMessage")
    @SendTo("/topic/gitMessage")
    public String sendGitMessage(String message){
        return message;
    }

    @MessageMapping("/commitMessage")
    @SendTo("/topic/commitMessage")
    public String sendCommitMessage(String message){
        return message;
    }

    @MessageMapping("/dleMessage")
    @SendTo("/topic/dleMessage")
    public String sendDleMessage(String message){
        return message;
    }

    @MessageMapping("/test")
    @SendTo("/topic/test")
    public String sendTestMessage(String message){
        return message;
    }
}
