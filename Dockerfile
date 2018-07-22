#FROM registry.cn-hangzhou.aliyuncs.com/aliware2018/debian-jdk8-devel
FROM maven:3.5.4-jdk-8

MAINTAINER Junlan Shuai <shuaijunlan@gmail.com>

COPY . /root/workspace/agent
COPY docker-entrypoint.sh /usr/local/bin
WORKDIR /root/workspace/agent

RUN mvn clean
RUN mvn install -Dmaven.test.skip=true

EXPOSE 8081
EXPOSE 8088

ENTRYPOINT ["docker-entrypoint.sh"]