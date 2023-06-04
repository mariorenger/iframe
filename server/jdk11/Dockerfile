FROM openjdk:11

ARG SERVICE_NAME
ARG PORT
ENV JAR_NAME ${SERVICE_NAME}

COPY ./${SERVICE_NAME}/target/${SERVICE_NAME}.jar /app/
CMD java -Xmx200m -jar /app/$JAR_NAME.jar

EXPOSE ${PORT}

VOLUME ["/app/logs"]
VOLUME ["/app/config"]