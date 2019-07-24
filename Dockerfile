FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar sap.jar
RUN mkdir config
COPY config/application.properties config/application.properties
ENTRYPOINT ["java", "-jar", "/sap.jar"]