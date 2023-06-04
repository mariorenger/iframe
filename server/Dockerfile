FROM openjdk:8-jdk-alpine

ARG SERVICE_NAME
ARG PORT
ENV JAR_NAME ${SERVICE_NAME}

RUN addgroup -g 1001 -S appuser && adduser -u 1001 -S appuser -G appuser
USER appuser

COPY ./${SERVICE_NAME}/target/${SERVICE_NAME}.jar /app/

CMD java -Xmx200m -jar /app/$JAR_NAME.jar
EXPOSE ${PORT}

VOLUME ["/app/logs"]
VOLUME ["/app/config"]