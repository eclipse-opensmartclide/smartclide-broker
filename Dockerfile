FROM openjdk:11.0.12-jdk-oracle
COPY target/jwt_rabbitmq-0.0.1-SNAPSHOT.jar jwt_rabbitmq-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/jwt_rabbitmq-0.0.1-SNAPSHOT.jar"]