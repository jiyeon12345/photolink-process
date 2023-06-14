FROM amazoncorretto:11

RUN apk update

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]