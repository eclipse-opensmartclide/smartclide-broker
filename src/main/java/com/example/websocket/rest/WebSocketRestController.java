package com.example.websocket.rest;

import com.example.websocket.config.MessageBrokerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebSocketRestController {

    private final AmqpTemplate amqpTemplate;

    public WebSocketRestController(final AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    /**
     * POST endpoint that will forward the given {@code message} to the rabbitmq exchange using the {@code routingKey} given in
     * the path.
     * <p>
     * Endpoint accepts body with "Content-Type" {@code MediaType#TEXT_PLAIN_VALUE}.
     * <p>
     * Endpoint returns empty response with HTTP status code 200 OK.
     *
     * @param routingKey Determines where to send {@code message} to. May may contain dots (".").
     * @param message    The message to forward. <i>SHOULD</i> be JSON string.
     * @return HTTP response status 200 OK
     */
    @PostMapping(
            value = "/" + MessageBrokerConfig.EXCHANGE_NAME + "/message/{routingKey}",
            consumes = {MediaType.TEXT_PLAIN_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<Void> send(@PathVariable("routingKey") final String routingKey,
                                     @RequestBody final String message) {
        log.debug("Forwarding to \"{}\": \"{}\"", routingKey, message);
        this.amqpTemplate.convertAndSend(MessageBrokerConfig.EXCHANGE_NAME, routingKey, message);
        return ResponseEntity.ok().build();
    }
}
