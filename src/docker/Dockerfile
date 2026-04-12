# Build Stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# 1. Copy pom first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# 2. Copy the actual source code
COPY src ./src

# 3. Build the jar
RUN mvn clean package -DskipTests

# Run Stage
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]