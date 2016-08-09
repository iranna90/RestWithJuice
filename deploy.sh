#!/bin/bash

echo "Removing all docker instances"
docker rm -f $(docker ps -aq)

echo "Remove the existing docker image"
docker rmi jetty:1

echo "install the application"
mvn clean
mvn install

echo "copy the war file to dockerfile location"
rm -rf jersey2-guice-1.0.0-SNAPSHOT.war
cp /Office/REPOSITORY/OTHERS/jersey2-guice/target/jersey2-guice-1.0.0-SNAPSHOT.war .

echo "Build new image"
docker build -t jetty:1 -f Dockerfile .

echo "Run the container"
docker run --name jetty-local -p 4321:8080 jetty:1

