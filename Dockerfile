FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/tpAchatProject-0.0.1-RELEASE.war tpachatproject.jar
ENTRYPOINT ["java","-jar","/tpachatproject.jar"]