# Use the official OpenJDK base image for Java 11
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file into the container
COPY target/api-0.0.1-SNAPSHOT.jar /app/api.jar

# Expose the port your application will run on
EXPOSE 1010

# Command to run the application
CMD ["java", "-jar", "api.jar"]