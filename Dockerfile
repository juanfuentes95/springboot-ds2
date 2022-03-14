FROM openjdk:11-jdk-slim
COPY "./target/spring-boot-docker-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8085
ENTRYPOINT ["java","-jar","app.jar"]
