FROM maven:3.8.7-openjdk-18-slim
COPY . .
WORKDIR .
RUN mvn clean install -DskipTests
EXPOSE 8081
CMD ["mvn", "spring-boot:run"]
