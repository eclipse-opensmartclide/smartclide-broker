//package com.example.websocket.Config;
//
//import com.example.websocket.Model.Greeting;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//@EnableScheduling
//@Configuration
//public class SchedulerConfig {
//    @Autowired
//    SimpMessagingTemplate template;
//
//    @Scheduled(fixedDelay = 3000)
//    public void sendAdhocMessages(){
//        Greeting myGreeting = new Greeting("Hello","Scheduler","message from scheduler");
//        template.convertAndSend("/topic/greetings", myGreeting);
//        System.out.println(myGreeting.toString());
//        //template.convertAndSend("/topic/greetings", new Greeting("Hello","Scheduler","message from scheduler"));
//    }
//}
