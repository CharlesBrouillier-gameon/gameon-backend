FROM openjdk:17-jdk-slim

WORKDIR /gameon-backend

COPY target/gameon-0.0.1.jar gameon-0.0.1.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gameon-0.0.1.jar"]