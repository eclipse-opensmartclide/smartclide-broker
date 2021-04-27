package com.smartclide.rabbitmq.demo.publisher;

import com.smartclide.rabbitmq.demo.config.MessagingConfig;
import com.smartclide.rabbitmq.demo.dto.SmartClideMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/broker/api/publisher")
public class MsgPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/{queueName}")
    public String msgPublish(@RequestBody SmartClideMessage msg, @PathVariable String queueName) {
        msg.setMessageId(UUID.randomUUID().toString());
        //restaurantservice
        //payment service
        //SmartClideMsgStatus msgStatus = new SmartClideMsgStatus(msg, "PROCESS", "message placed succesfully in queue " + queueName);
        //SmartClideMessage msgToSend = new SmartClideMessage(msg);
        template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, msg);
        //template.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, msgStatus);
        return ("Message placed successfully in queue " + queueName);
    }
}
