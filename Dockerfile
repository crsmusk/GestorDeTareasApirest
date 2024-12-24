FROM eclipse-temurin:21.0.5_11-jdk as build

WORKDIR /app

COPY pom.xml .
COPY .mvn ./.mvn
COPY mvnw .
RUN sed -i 's/\r$//' mvnw
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean install -DskipTests

FROM eclipse-temurin:21.0.5_11-jdk-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT [ "java","jar","app.jar" ]