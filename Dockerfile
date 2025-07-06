# ---------- Build Stage ----------
    FROM maven:3.8.4-openjdk-17 AS build

    # Set working directory
    WORKDIR /app
    
    # Copy all project files
    COPY . .
    
    # Package the application
    RUN mvn clean install -DskipTests
    
    # ---------- Runtime Stage ----------
    FROM openjdk:17-jdk-alpine
    
    # Set working directory
    WORKDIR /app
    
    # Copy the built jar from build stage
    COPY --from=build /app/target/*.jar app.jar
    
    # Expose application port
    EXPOSE 8080
    
    # Entry point
    ENTRYPOINT ["java", "-jar", "app.jar"]
    