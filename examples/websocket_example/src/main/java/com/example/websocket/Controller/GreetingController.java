package com.example.websocket.Controller;

import com.example.websocket.Model.Greeting;
import com.example.websocket.Model.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message){
        return new Greeting("Hello", message.getFrom(), message.getText(), message.getTimestamp());
    }
}
