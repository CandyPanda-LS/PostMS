FROM openjdk:23-jdk-slim
COPY target/PostService-0.0.1-SNAPSHOT.jar PostService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","PostService-0.0.1-SNAPSHOT.jar"]
LABEL authors="lasalhettiarachchi"

