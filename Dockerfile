FROM amazoncorretto:17

MAINTAINER Andres Rubio <andresfra92@gmail.com>
 
#Copy source code
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
 
COPY src ./src

EXPOSE 8080
 
CMD ["./mvnw", "spring-boot:run"]
