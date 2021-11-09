FROM openjdk:11.0.12-jdk-oracle
COPY target/spring-websocket-0.0.1-SNAPSHOT.jar spring-websocket-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/spring-websocket-0.0.1-SNAPSHOT.jar"]