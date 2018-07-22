FROM openjdk:8
FROM maven
MAINTAINER Junlan Shuai <shuaijunlan@gmail.com>

RUN mvn clean
RUN mvn install -Dmaven.test.skip=true

EXPOSE 8081
EXPOSE 8088

ENTRYPOINT ["docker-entrypoint.sh"]