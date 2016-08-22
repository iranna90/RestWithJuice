FROM centos:centos7

MAINTAINER Sergii Kozlov "derzaicheg@gmail.com"

#Install dependencies and download java8
RUN yum -y install wget && \
    yum -y install tar && \
    wget --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u25-b17/jdk-8u25-linux-x64.tar.gz"

#Install Java
RUN tar -zxf jdk-8u25-linux-x64.tar.gz && \
    mv jdk1.8.0_25/ /opt && \
    alternatives --install /usr/bin/java java /opt/jdk1.8.0_25/bin/java 2 && \
    alternatives --auto java

ENV JAVA_HOME /opt/jdk1.8.0_25
ENV JRE_HOME ${JAVA_HOME}/jre
ENV PATH $PATH:${JAVA_HOME}/bin:${JRE_HOME}/bin

#Deploy jetty
ENV JETTY_VERSION 9.3.2.v20150730
RUN wget https://repo1.maven.org/maven2/org/eclipse/jetty/jetty-distribution/${JETTY_VERSION}/jetty-distribution-${JETTY_VERSION}.zip -O /tmp/jetty.zip && \
    cd /opt && jar xf /tmp/jetty.zip && \
    ln -s /opt/jetty-distribution-${JETTY_VERSION} /opt/jetty && \
    rm /tmp/jetty.zip

#Set jetty env variables
ENV JETTY_HOME /opt/jetty
ENV PATH $PATH:$JETTY_HOME/bin
ENV JETTY_HOME /opt/jetty
ENV JETTY_USER root
ENV JETTY_HOST 0.0.0.0
ENV JETTY_LOGS /opt/jetty/logs

#Download artifacts
COPY jersey2-guice-1.0.0-SNAPSHOT.war /opt/jetty/webapps/jersey2-guice-1.0.0-SNAPSHOT.war
RUN chmod 777 /opt/jetty/webapps/jersey2-guice-1.0.0-SNAPSHOT.war
WORKDIR /opt/jetty
EXPOSE 8080
CMD ["java", "-jar", "/opt/jetty/start.jar"]

