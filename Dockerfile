FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=build ./app/target/*.jar ./springboot_weather_webapp.jar

EXPOSE 8080

CMD [ "java", "-jar", "app.jar"]