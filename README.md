# smartclide-broker

A MOM (Message-orientated Middleware) implementation for the communication of the SmartCLIDE components. [RabbitMQ](https://www.rabbitmq.com/) has been selected for the implementation of the message broker and the RabbitMQ server runs inside a Docker container.

The broker is accessible via a REST API implemented in [Spring Boot](https://spring.io/projects/spring-boot).

- **Publish message to broker**: in order to send a message to the broker, the following URL shall be used:

	http://160.40.53.126:8080/broker/api/v1/publisher/{publisher_name}
  
	E.g.
  
	`http://160.40.53.126:8080/broker/api/v1/publisher/serviceCreation`

- **Consume message from broker**: in order to get a message from the broker, the following URL shall be used:

	http://160.40.53.126:8080/broker/api/v1/consumer/{consumer_name}
  
	E.g.
  
	`http://160.40.53.126:8080/broker/api/v1/consumer/serviceDiscovery`
