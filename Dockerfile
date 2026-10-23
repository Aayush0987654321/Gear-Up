# ==========================================
# Stage 1: Build the Application (JAR banana)
# ==========================================
# Agar aap Java 17 use kar rahe hain toh 17 likhein, 21 hai toh 21 likhein
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# pom.xml aur source code copy karein
COPY pom.xml .
COPY src ./src

# Maven se project build karein (tests skip kar rahe hain time bachane ke liye)
RUN mvn clean package -DskipTests

# ==========================================
# Stage 2: Run the Application (App chalana)
# ==========================================
FROM eclipse-temurin:17-jre
WORKDIR /app

# Stage 1 se bani hui .jar file ko Stage 2 me copy karein
COPY --from=build /app/target/*.jar app.jar

# Spring Boot default 8080 par chalta hai
EXPOSE 8080

# App start karne ki command
ENTRYPOINT ["java", "-jar", "app.jar"]