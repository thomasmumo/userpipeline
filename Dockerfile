FROM openjdk:17-jdk

EXPOSE 8080
ADD target/usersPipeline.jar usersPipeline.jar
ENTRYPOINT ["java", "-jar", "/usersPipeline.jar"]