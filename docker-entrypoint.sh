#!/usr/bin/env bash
cd /root/workspace/agent/autumn-blog/
nohup mvn tomcat7:run &
cd /root/workspace/agent/autumn-cms/
nohup mvn tomcat7:run &
