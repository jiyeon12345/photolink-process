FROM openjdk:11-alpine

RUN apk update

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]