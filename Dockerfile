# Start with a base image
FROM openjdk:17-jdk-slim

# Add a volume to store logs
VOLUME /tmp

# Set the working directory
WORKDIR /app

# Create a variable to get JAR file name
ARG JAR_FILE=target/*.jar

# Copy the application JAR file
COPY ${JAR_FILE} app.jar

# Expose the application's port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
