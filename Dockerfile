FROM openjdk:8-jre-alpine
WORKDIR /app
COPY build/libs .
ENTRYPOINT ["java", "-jar", "boston-pipeline.jar"]