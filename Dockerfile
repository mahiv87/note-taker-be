# Use an official OpenJDK 22 runtime as a parent image
FROM openjdk:22-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle wrapper files
COPY gradlew /app/
COPY gradle /app/gradle

# Copy the build.gradle and settings.gradle files
COPY build.gradle settings.gradle /app/

# Copy the application source code to the container
COPY src /app/src

# Grant execute permission to the Gradle wrapper
RUN chmod +x gradlew

# Run the Gradle build to resolve dependencies
RUN ./gradlew build --no-daemon

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the application
CMD ["./gradlew", "bootRun"]
