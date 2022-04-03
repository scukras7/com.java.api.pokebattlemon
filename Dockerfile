FROM openjdk:17-alpine

ENV POKEBATTLEMON_JAR=pokebattlemon-0.1-all.jar

ARG SERVER_DIR=/opt/java

ENV micronaut.environments=prod

RUN mkdir -p ${SERVER_DIR}

COPY build/libs/${POKEBATTLEMON_JAR} ${SERVER_DIR}

WORKDIR ${SERVER_DIR}

ENTRYPOINT java -Dmicronaut.environments=prod -jar ${POKEBATTLEMON_JAR}