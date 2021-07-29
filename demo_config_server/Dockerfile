FROM openjdk:11.0.12-jre-slim
COPY target/demo_config_server-0.0.1-SNAPSHOT.jar app.jar
COPY src/main/resources/application.properties application.properties
CMD ["java","-jar","app.jar"]