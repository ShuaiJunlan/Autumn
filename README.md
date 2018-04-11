![logo](https://github.com/shuaijunlan/Autumn-Framework/raw/master/Autumn.png)
## Autumn
[![Build Status](https://travis-ci.org/shuaijunlan/Autumn.svg?branch=master)](https://travis-ci.org/shuaijunlan/Autumn)  [![LICENSE](https://img.shields.io/aur/license/yaourt.svg)](https://github.com/shuaijunlan/Autumn-Framework/blob/master/LICENSE) ![](https://img.shields.io/github/stars/shuaijunlan/Autumn-Framework.svg) ![](https://img.shields.io/github/forks/shuaijunlan/Autumn-Framework.svg) ![](https://img.shields.io/github/tag/shuaijunlan/Autumn-Framework.svg) ![](https://img.shields.io/github/release/shuaijunlan/Autumn-Framework.svg)

![autumn-cms](https://github.com/shuaijunlan/Autumn-Framework/raw/master/autumn-cms.gif)
![autumn-blog](https://github.com/shuaijunlan/Autumn-Framework/raw/master/autumn-blog.gif)



**Autumn** is a collection of web sub-system, aimes to provide universal web system solution. It is scalable and stable, you can develop your own web system  basing on it. Also, you can join us to maintain it together, if only you are interested in it.

[Autumn-CMS Live Demo](https://shuaijunlan.cn/autumn-cms/) 
[Autumn-Blog Live Demo](https://shuaijunlan.cn/autumn-blog/mainPage.html)

Please submit issues to corresponding projects, that'll help us make issues tracking easier so that we can provide timely help to you.

### Modules
* [AUTUMN-CMS](https://github.com/shuaijunlan/Autumn-Framework/tree/master/autumn-cms)
* [AUTUMN-BLOG](https://github.com/shuaijunlan/Autumn-Framework/tree/master/autumn-blog)
* [AUTUMN-COMMON](https://github.com/shuaijunlan/Autumn-Framework/tree/master/autumn-common)

### Environment
*Autumn-Framework* requires `java8` and `maven3` as bulid enviroment.

The project requires at minimum 512MB memory to run. Please ensure you have corresponding tools installed in your environment before build and run the project.

### Get Started
* Clone from github.com:
    `git clone git@github.com:shuaijunlan/Autumn.git`
* Import [autumn_framework.sql](https://github.com/shuaijunlan/Autumn-Framework/blob/master/autumn_framework.sql) to your MySQL Database, and must alter username and password in `druid-pool.properties`, the password is encrypted by Druid
* Enter the project root directory `cd Autumn`
* Install dependencies:
    `mvn install`

> If you want to run autumu-cms sub-system,

* Enter autumn-cms, `cd autumn-cms`
* Run server:`mvn tomcat7:run`. Server runs on port **8081** by default, visit `http://localhost:8081/autumn-cms` to check it out.

> If you want to run autumn-blog sub-system,

* Enter autumn-blog, `cd autumn-blog`
* Run server:`mvn tomcat7:run -Dspring.profiles.active="prod"`. Server runs on port **8082** by default, visit `http://localhost:8082/autumn-blog` to check it out.

### License

Licensed under GPL 2.0. See [LICENSE](https://github.com/shuaijunlan/Autumn-Framework/blob/master/LICENSE) for further details.