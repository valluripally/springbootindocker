#pull image of jdk
FROM java:8-jre



#copy jar file to docker file System
ADD ./target/movie-service-0.0.1-SNAPSHOT.jar /usr/app/movie-service-0.0.1-SNAPSHOT.jar


#java -jar <jarfile name>
WORKDIR usr/app
ENTRYPOINT ["java","-jar","movie-service-0.0.1-SNAPSHOT.jar"]
