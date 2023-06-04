FROM openjdk:8-jdk-alpine

ARG SERVICE_NAME
ARG PORT
ENV JAR_NAME ${SERVICE_NAME}

RUN addgroup -g 1001 -S appuser && adduser -u 1001 -S appuser -G appuser

USER appuser

COPY ./target/spring-boot-thymeleaf-example-0.0.1-SNAPSHOT.jar /app/

CMD java -Xmx200m -jar /app/spring-boot-thymeleaf-example-0.0.1-SNAPSHOT.jar
EXPOSE ${PORT}

VOLUME ["/app/logs"]
VOLUME ["/app/config"]
