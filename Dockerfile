FROM openjdk:20-slim AS build

RUN apt-get update && \
    apt-get install -y maven wget && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY src ./src
COPY pom.xml .

RUN mvn package -DskipTests

FROM openjdk:20-slim
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]