FROM gradle:8.5-jdk17-alpine AS build
WORKDIR /app
COPY --chown=gradle . .
RUN gradle bootJar --no-daemon

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
CMD [ "java", "-jar", "app.jar"]