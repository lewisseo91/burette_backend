FROM adoptopenjdk:11-jdk-hotspot AS builder
COPY gradlew .
COPY gradle gradle
COPY buretteAuth/build.gradle .
COPY settings.gradle .
COPY buretteAuth/src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

EXPOSE 9000