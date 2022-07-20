# smartclide-broker

A MOM (Message-orientated Middleware) implementation for the communication of the SmartCLIDE components. [RabbitMQ](https://www.rabbitmq.com/) has been selected for the implementation of the message broker and the RabbitMQ server runs inside a Docker container.

The broker is accessible via two APIs, both implemented in [Spring Boot](https://spring.io/projects/spring-boot).

- **Websocket API**: a client can send messages to the broker using a websocket connection. MOM uses the [/exchange](https://www.rabbitmq.com/stomp.html#d) destination prefix, thus supporting flexible, dynamic routing keys. A client should first establish a connection using the "/websocket" endpoint:

	ws://localhost:8080/websocket
  
	Then the client can send messages to arbitrary routing keys, e.g.
  
	`/exchange/mom/foo.bar.baz`

	or receive messages by subscribing to arbitrary binding patterns, e.g.

	`/exchange/mom/foo.bar.*`

- **REST API**: a client can send messages to a regular REST endpoint using a POST request with the JSON string as payload and the routing key in the path. The REST endpoint will then forward the JSON string directly to the broker using the given routing key:
  
	E.g.
  
	`http://localhost:8080/mom/message/foo.bar.HURZ`
