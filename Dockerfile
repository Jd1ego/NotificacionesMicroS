FROM openjdk:17-jdk-slim

LABEL authors="sebas"

WORKDIR /app

COPY target/microservicio-notificaciones-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8082"]
