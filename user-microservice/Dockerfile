# Use an official JDK as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the built jar file into the container
COPY target/*.jar app.jar

# Copy the .env file into the container
COPY .env .env

# Make port 8081 available to the world outside this container
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]