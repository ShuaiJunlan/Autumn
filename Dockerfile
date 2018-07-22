#FROM registry.cn-hangzhou.aliyuncs.com/aliware2018/debian-jdk8-devel
FROM maven

MAINTAINER Junlan Shuai <shuaijunlan@gmail.com>

COPY . /root/workspace/agent
COPY docker-entrypoint.sh /usr/local/bin
WORKDIR /root/workspace/agent

#COPY docker-entrypoint.sh $PATH

RUN mvn clean
RUN mvn install -Dmaven.test.skip=true

EXPOSE 8081
EXPOSE 8088

CMD ["docker-entrypoint.sh"]