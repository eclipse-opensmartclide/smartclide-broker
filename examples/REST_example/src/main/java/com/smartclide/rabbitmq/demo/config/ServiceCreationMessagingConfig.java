package com.smartclide.rabbitmq.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceCreationMessagingConfig {

    public static final String SERVICE_CREATION_TOPIC_EXCHANGE = "service_creation_exchange";
    public static final String SECURITY_QUEUE = "smart_clide_security_queue";
    public static final String SERVICE_DISCOVERY_QUEUE = "smart_clide_service_discovery_queue";
    public static final String DEEP_LEARNING_QUEUE = "smart_clide_deep_learning_queue";
    public static final String SMART_ASSISTANT_QUEUE = "smart_clide_smart_assistant_queue";
    public static final String SERVICE_CREATION_ROUTING_KEY = "smart_clide_service_creation_routing_key";

    @Bean
    public Queue service_discovery_queue() {
        return new Queue(SERVICE_DISCOVERY_QUEUE);
    }

    @Bean
    public Queue security_queue() {
        return new Queue(SECURITY_QUEUE);
    }

    @Bean
    public Queue deep_learning_queue() {
        return new Queue(DEEP_LEARNING_QUEUE);
    }

    @Bean
    public Queue smart_assistant_queue() {
        return new Queue(SMART_ASSISTANT_QUEUE);
    }

    @Bean
    public TopicExchange service_creation_exchange() {
        return new TopicExchange(SERVICE_CREATION_TOPIC_EXCHANGE);
    }

    @Bean
    public Binding service_discovery_binding(Queue service_discovery_queue, TopicExchange service_creation_exchange) {
        return BindingBuilder.bind(service_discovery_queue).to(service_creation_exchange).with(SERVICE_CREATION_ROUTING_KEY);
    }

    @Bean
    public Binding security_binding(Queue security_queue, TopicExchange service_creation_exchange) {
        return BindingBuilder.bind(security_queue).to(service_creation_exchange).with(SERVICE_CREATION_ROUTING_KEY);
    }

    @Bean
    public Binding deep_learning_binding(Queue deep_learning_queue, TopicExchange service_creation_exchange) {
        return BindingBuilder.bind(deep_learning_queue).to(service_creation_exchange).with(SERVICE_CREATION_ROUTING_KEY);
    }

    @Bean
    public Binding smart_assistant_binding(Queue smart_assistant_queue, TopicExchange service_creation_exchange) {
        return BindingBuilder.bind(smart_assistant_queue).to(service_creation_exchange).with(SERVICE_CREATION_ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
