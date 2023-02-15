FROM amazoncorretto:17-alpine
WORKDIR /app
COPY ./target/Seccion1-1.0.0.jar .
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "Seccion1-1.0.0.jar"]