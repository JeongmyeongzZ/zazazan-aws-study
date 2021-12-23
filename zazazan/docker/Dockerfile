FROM adoptopenjdk/openjdk11

ARG JAR_FILE=zazazan-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} zazazan.jar
ENTRYPOINT ["java", "-jar", "-Dserver.port=8080", "zazazan.jar"]
