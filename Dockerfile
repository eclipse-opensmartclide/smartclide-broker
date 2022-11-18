FROM adoptopenjdk:16-jre-hotspot
ADD target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]