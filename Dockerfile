FROM openjdk:8
ADD target/achat-1.0.jar operateur.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "operateur.jar"]
