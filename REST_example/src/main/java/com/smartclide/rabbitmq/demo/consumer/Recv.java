package com.smartclide.rabbitmq.demo.consumer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smartclide.rabbitmq.demo.config.MessagingConfig;
import com.smartclide.rabbitmq.demo.dto.SmartClideMessage;
import org.json.simple.parser.ParseException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "broker/api/consumer")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Recv {

    @Autowired
    private RabbitTemplate template;

    @JsonSerialize
    public class EmptyJsonResponse { }

    @GetMapping("/{queueName}")
    public ResponseEntity consumeMessageFromQueue() throws ParseException {
        //Message msg = template.receive(MessagingConfig.QUEUE);
        SmartClideMessage msg = (SmartClideMessage) template.receiveAndConvert(MessagingConfig.QUEUE);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
//        List<SmartClideMessage> l = new ArrayList<SmartClideMessage>();
//        while (msg != null) {
//            l.add(msg);
//            msg = (SmartClideMessage) template.receiveAndConvert(MessagingConfig.QUEUE);
//        }
        if (msg == null) {
            return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
            //return new ResponseEntity<SmartClideMessage>(headers, HttpStatus.OK);
        }
//        l.add(msg);
        //return new ResponseEntity<ArrayList>((ArrayList) l, headers, HttpStatus.OK);
        return new ResponseEntity<SmartClideMessage>(msg, headers, HttpStatus.OK);
       //return msg;
        //return  List.of(msg);
/*        if (msg != null) {
            System.out.println("Message recieved from queue : " + msg);
        }
        byte[] body = msg.getBody();
        String bodyString = new String(body);
        System.out.print("Message body String: " + bodyString);
        return  List.of(bodyString);*/
    }
}
