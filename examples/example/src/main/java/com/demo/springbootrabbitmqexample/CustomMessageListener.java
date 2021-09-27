package com.demo.springbootrabbitmqexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageListener {
    private static final Logger log = LoggerFactory.getLogger(CustomMessageListener.class);

    @RabbitListener(queues = SpringBootRabbitmqExampleApplication.DEFAULT_PARSING_QUEUE)
    public void consumeDefaultMessage(final Message message){
        log.info("Received message: {}", message.toString());
    }
}
