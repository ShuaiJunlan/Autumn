FROM openjdk:8
FROM maven
MAINTAINER Junlan Shuai <shuaijunlan@gmail.com>
COPY . /root/workspace/system
WORKDIR /root/workspace/system

RUN mvn clean

