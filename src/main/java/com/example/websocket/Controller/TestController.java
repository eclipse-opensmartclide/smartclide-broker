package com.example.websocket.Controller;

import com.example.websocket.Model.GitMessage;
import com.example.websocket.Model.Greeting;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @MessageMapping("/gitMessage")
    @SendTo("/topic/git")
    public GitMessage sendAbstract(GitMessage message){
        //template.convertAndSend("/topic/test", message);
        return message;
    }

    @MessageMapping("/greeting")
    @SendTo("/topic/greetings")
    public Greeting sendGreeting(Greeting message){
        //template.convertAndSend("/topic/test", message);
        return message;
    }
}
