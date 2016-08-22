#!/bin/bash

echo "Removing all docker instances"
docker rm -f $(docker ps -aq)

echo "Remove the existing docker image"
docker rmi jetty:1

echo "install the application"
mvn clean
mvn install


echo "Build new image"
docker build -t jetty:1 -f Dockerfile .

echo "Run the container"
docker run --name jetty-local -p 4321:8080 jetty:1

