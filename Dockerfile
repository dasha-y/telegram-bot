#use OpenJDK as the base image
FROM openjdk:21-slim As build
#Install Maven
RUN apt-get update && apt-get install -y maven
#Set the working directory
WORKDIR /app
#copy the pom.xml and source code
COPY pom.xml .
COPY src ./src
#build the project
RUN mvn clean package && ls -l /app/target
#set the working directory for the runtime
WORKDIR /app
#Expose any necessary ports
EXPOSE 8080
#run the built jar
CMD ["java", "-jar", "target/java_tg_bot-1.0-SNAPSHOT.jar"]
