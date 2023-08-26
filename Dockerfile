FROM openjdk:8

MAINTAINER devops

WORKDIR /microservices

COPY ServiceDiscovery-1.0.0.1.jar /microservices/ServiceDiscovery-1.0.0.1.jar

ENTRYPOINT ["java","-jar","-Dserver.port=8011","/microservices/ServiceDiscovery-1.0.0.1.jar"]
