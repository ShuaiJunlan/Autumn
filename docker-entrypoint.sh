#!/usr/bin/env bash
cd autumn-blog/
nohup mvn tomvat7:run &
cd ../autumn-cms/
nohup mvn tpmcat7:run &
