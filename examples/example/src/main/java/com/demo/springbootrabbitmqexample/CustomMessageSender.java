package com.demo.springbootrabbitmqexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CustomMessageSender {

    private static final Logger log = LoggerFactory.getLogger(CustomMessageSender.class);

    // use RabbitTemplate to send messages
    private final RabbitTemplate rabbitTemplate;

    public CustomMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelay = 3000L)
    public void sendCustomMessage() {
        CustomMessage customMessage = new CustomMessage("This is a new message", 1);
        rabbitTemplate.convertAndSend(SpringBootRabbitmqExampleApplication.EXCHANGE_NAME, SpringBootRabbitmqExampleApplication.ROUTING_KEY, customMessage);
        log.info("Message has been sent!");
    }
}
