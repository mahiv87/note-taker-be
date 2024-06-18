FROM gradle:8.8.0-jdk22
WORKDIR /app

COPY gradlew /app/
COPY gradle /app/gradle

COPY build.gradle settings.gradle /app/

COPY src /app/src


RUN chmod +x gradlew

RUN ./gradlew build --no-daemon

EXPOSE 8080

CMD ["./gradlew", "bootRun"]