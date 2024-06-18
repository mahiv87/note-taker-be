FROM gradle:jdk-21-and-22
WORKDIR /app

COPY gradlew /app/
COPY gradle /app/gradle

COPY build.gradle settings.gradle /app/

COPY src /app/src


RUN chmod +x gradlew

RUN ./gradlew build --no-daemon

EXPOSE 8080

CMD ["./gradlew", "bootRun"]