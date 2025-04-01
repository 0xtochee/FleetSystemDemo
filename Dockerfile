# Build stage
FROM maven:3.8.7-eclipse-temurin-11 AS build

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Run stage
FROM tomcat:9.0-jre11-temurin-focal

# Remove default Tomcat applications
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the built WAR file from the build stage
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

# Copy Jasper Reports files
COPY src/main/resources/reports /usr/local/tomcat/webapps/reports

# Create a non-root user
RUN useradd -m myuser
USER myuser

# Expose the port Tomcat runs on
EXPOSE 8080

CMD ["catalina.sh", "run"]