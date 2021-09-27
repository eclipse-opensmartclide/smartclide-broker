package com.demo.springbootrabbitmqexample;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@SpringBootApplication
@EnableScheduling
public class SpringBootRabbitmqExampleApplication {

	// RabbitMQ configuration
	public static final String EXCHANGE_NAME = "custom-json-messages";
	public static final String DEFAULT_PARSING_QUEUE = "example-json-queue";
	public static final String ROUTING_KEY = "custom-json";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRabbitmqExampleApplication.class, args);
	}

	@Bean
	public TopicExchange tipsExchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue defaultParsingQueue() {
		return new Queue(DEFAULT_PARSING_QUEUE);
	}

	@Bean
	public Binding queueToExchangeBinding(){
		return BindingBuilder.bind(defaultParsingQueue()).to(tipsExchange()).with(ROUTING_KEY);
	}

	// Json converter configuration
	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory){
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}
}
