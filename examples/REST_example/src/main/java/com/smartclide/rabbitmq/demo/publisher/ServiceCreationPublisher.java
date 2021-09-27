package com.smartclide.rabbitmq.demo.publisher;

import com.smartclide.rabbitmq.demo.config.ServiceCreationMessagingConfig;
import com.smartclide.rabbitmq.demo.dto.ServiceCreationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/broker/api/publisher/serviceCreation")
public class ServiceCreationPublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping
    public String msgPublish(@RequestBody ServiceCreationMessage msg) {
//        msg.setServiceId(UUID.randomUUID().toString());
//        //msg.setDate(LocalDate.now().toString());
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = currentDateTime.format(myFormatObj);
//        msg.setDate(formattedDate);

        template.convertAndSend(ServiceCreationMessagingConfig.SERVICE_CREATION_TOPIC_EXCHANGE, ServiceCreationMessagingConfig.SERVICE_CREATION_ROUTING_KEY, msg);
        return ("Message sent successfully");
    }
}
