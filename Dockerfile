FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
RUN curl -u admin:0000 -o achat.jar "http://192.168.1.230:8081/repository/maven-releases/tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089