FROM openjdk:17-alpine

ARG POKEBATTLEMON_JAR=pokebattlemon-0.1-all.jar
ARG SERVER_DIR=/opt/java

RUN mkdir -p ${SERVER_DIR}

COPY build/libs/${POKEBATTLEMON_JAR} ${SERVER_DIR}

WORKDIR ${SERVER_DIR}

ENTRYPOINT [ "sh" ]
#ENTRYPOINT [ "java", "-Dmicronaut.environtments=prod", "-jar", ${POKEBATTLEMON_JAR} ]