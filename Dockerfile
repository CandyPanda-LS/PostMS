FROM eclipse-temurin:23-jdk AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests

FROM openjdk:23-jdk-slim
COPY --from=build /app/target/PostService-0.0.1-SNAPSHOT.jar PostService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "PostService-0.0.1-SNAPSHOT.jar"]
LABEL authors="lasalhettiarachchi"
