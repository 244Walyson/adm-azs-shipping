FROM openjdk:22-ea-21-slim-bullseye
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/az-ship.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/az-ship.jar"]