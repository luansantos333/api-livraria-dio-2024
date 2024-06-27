FROM openjdk:21
MAINTAINER livraria.api-2024
COPY target/livraria.api-2024-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]