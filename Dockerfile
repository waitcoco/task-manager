FROM openjdk:8-jre-alpine
WORKDIR /app
COPY build/libs .
ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-jar", "boston-pipeline.jar"]
