package com.smartclide.rabbitmq.demo.consumer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smartclide.rabbitmq.demo.config.ServiceCreationMessagingConfig;
import com.smartclide.rabbitmq.demo.dto.ServiceCreationMessage;
import org.json.simple.parser.ParseException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "broker/api/v1/consumer/security")
public class SecurityConsumer {

    @Autowired
    private RabbitTemplate template;

    @JsonSerialize
    public class EmptyJsonResponse { }

    @GetMapping()
    public ResponseEntity getMessage(@RequestParam(required = false) String from) throws ParseException {

        Object msg = null;

//        if (from == null) {
//            return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
//        }
//
//        if (from.equals(new String("serviceCreation"))) {
//            msg = (ServiceCreationMessage) template.receiveAndConvert(ServiceCreationMessagingConfig.SECURITY_QUEUE);
//        }

        msg = (ServiceCreationMessage) template.receiveAndConvert(ServiceCreationMessagingConfig.SECURITY_QUEUE);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        if (msg == null) {
            return new ResponseEntity(new EmptyJsonResponse(), HttpStatus.OK);
        }

        return new ResponseEntity<ServiceCreationMessage>((ServiceCreationMessage) msg, headers, HttpStatus.OK);
    }
}
