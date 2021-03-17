# RabbitMQ sender and listener example

This is a Spring Boot application to send and receive Messages using AMQP and RabbitMQ.

## Prerequisites

This project was created as a Maven project using Spring Initializr for Java 15.
If needed, modify the dependencies for specific Java version.

Additional Maven dependencies (defined in pom.xml):

- Jackson for handling JSON serialization/deserialization
- Spring for RabbitMQ (spring-boot-starter-amqp)

Before running the application, you need to install RabbitMQ server. The latest release of RabbitMQ is 3.8.9.

Depending on your OS, follow the installation guide here: https://www.rabbitmq.com/download.html

After successful installation, the server can be started using the following commands:

### Ubuntu

```bash
# enable rabbitmq server
sudo systemctl enable rabbitmq-server
```

```bash
# enable rabbitmq server
sudo systemctl start rabbitmq-server
```

### Windows

You can use the installed RabbitMQ Command Prompt or open a terminal
as administrator and change directory to C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.9\sbin

```bash
# check status
rabbitmqctl status
```

```bash
# start RabbitMQ service
rabbitmq-service start
```

## Start RabbitMQ Management Dashboard

The RabbitMQ management plugin is a GUI tool to manage the message queues using an user-friendly interface. 
In order to enable it use the following command:

### Ubuntu

```bash
sudo rabbitmq-plugins enable rabbitmq_management
```

### Windows

You can use the installed RabbitMQ Command Prompt or open a terminal
as administrator and change directory to C:\Program Files\RabbitMQ Server\rabbitmq_server-3.8.9\sbin

```bash
rabbitmq-plugins enable rabbitmq_management
```

The GUI is now accessible through your browser at: http://localhost:15672

The default username and password for RabbitMQ management plugin is: guest.

## Run the application

Download the project and import it in your IDE. 

This application example assumes RabbitMQ is installed and running on localhost on the standard port (5672). 
In case you use a different host, port or credentials, connections settings would require adjusting.

In order to start the application, run SpringBootRabbitmqExampleApplication.java. 

Every three seconds, a message is sent to the queue with name "example-json-queue" (created automatically if it doesn't already exist)

A sender class (CustomMessageSender.java) sends a custom JSON message every 3 seconds, while a listener class (CustomMessageListener.java) receives them.

All operations and messages are logged in the console.