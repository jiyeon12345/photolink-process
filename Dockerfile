FROM amazoncorretto:11

RUN yum update -y

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "/app.jar" ]