FROM openjdk:11

MAINTAINER devops

WORKDIR /microservices

COPY target/learning-college-service-1.0.0.1.jar /microservices/learning-college-service-1.0.0.1.jar

ENTRYPOINT ["java","-jar","/microservices/learning-college-service-1.0.0.1.jar"]
