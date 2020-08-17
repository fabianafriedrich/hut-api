FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["sh", "-c", "java -jar /api-0.0.1-SNAPSHOT.jar"]
