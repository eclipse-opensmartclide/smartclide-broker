package com.example.websocket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    private final MessageBrokerConfig messageBrokerConfig;
    private final AmqpAdmin amqpAdmin;

    public WebSocketConfiguration(final MessageBrokerConfig messageBrokerConfig, final AmqpAdmin amqpAdmin) {
        this.messageBrokerConfig = messageBrokerConfig;
        this.amqpAdmin = amqpAdmin;
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        // websocket / stomp clients can connect using "ws(s)://<IP_OR_DNS_NAME>:<PORT>/websocket"
        log.info("Registering websocket endpoint \"{}\" with allowed origins \"{}\"",
                 MessageBrokerConfig.WS_ENDPOINT,
                 messageBrokerConfig.getAllowedOrigins());
        registry.addEndpoint(MessageBrokerConfig.WS_ENDPOINT)
                .setAllowedOrigins(messageBrokerConfig.getAllowedOrigins());
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        // use rabbitmq as broker for websocket messages
        // websocket / stomp clients can send / subscribe using destinations of this format:
        // "<DESTINATION_PREFIX>/<EXCHANGE_NAME>/<ROUTING_KEY>"
        // <ROUTING_KEY> may contain dots (".")
        // <ROUTING_KEY> may contain wildcards ("*", "#") when subscribing
        log.info("Setting up message broker with config \"{}\" and destination prefix \"{}\"",
                 messageBrokerConfig,
                 MessageBrokerConfig.DESTINATION_PREFIX);
        registry.enableStompBrokerRelay(MessageBrokerConfig.DESTINATION_PREFIX)
                .setRelayHost(messageBrokerConfig.getHost())
                .setRelayPort(messageBrokerConfig.getStompPort())
                .setClientLogin(messageBrokerConfig.getUsername())
                .setClientPasscode(messageBrokerConfig.getPassword());

        // create the exchange on rabbitmq if it does not exist yet
        log.info("Creating topic exchange \"{}\"", MessageBrokerConfig.EXCHANGE_NAME);
        final TopicExchange topicExchange = new TopicExchange(MessageBrokerConfig.EXCHANGE_NAME, true, false);
        amqpAdmin.declareExchange(topicExchange);
    }
}
