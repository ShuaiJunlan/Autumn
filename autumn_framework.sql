-- MySQL dump 10.14  Distrib 5.5.56-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: autumn_framework
-- ------------------------------------------------------
-- Server version	5.5.56-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `af_api_visitorstatistics`
--

DROP TABLE IF EXISTS `af_api_visitorstatistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_api_visitorstatistics` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_id` int(8) NOT NULL COMMENT '用户 id',
  `website_domain` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '网站域名',
  `website_name` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '网站名称',
  `secretkey` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '密钥',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_id_api_visitorstatistics_user_id` (`user_id`),
  KEY `user_id_FK_ID_api_visitorstatistics_creator_id` (`creator_id`),
  KEY `user_id_FK_ID_api_visitorstatistics_modifier_id` (`modifier_id`),
  CONSTRAINT `user_id_api_visitorstatistics_user_id` FOREIGN KEY (`user_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_ID_api_visitorstatistics_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_ID_api_visitorstatistics_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_api_visitorstatistics`
--

LOCK TABLES `af_api_visitorstatistics` WRITE;
/*!40000 ALTER TABLE `af_api_visitorstatistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_api_visitorstatistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_articleinfo`
--

DROP TABLE IF EXISTS `af_articleinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_articleinfo` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `user_id` int(8) NOT NULL,
  `user_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `title` varchar(256) COLLATE utf8_bin NOT NULL,
  `abstracts` varchar(1024) COLLATE utf8_bin DEFAULT NULL,
  `post_time` datetime NOT NULL,
  `modification_time` datetime NOT NULL,
  `visit_times` int(8) NOT NULL DEFAULT '0',
  `comment_times` int(8) NOT NULL DEFAULT '0',
  `up_vote` int(8) NOT NULL DEFAULT '0',
  `down_vote` int(8) NOT NULL DEFAULT '0',
  `state` int(4) NOT NULL DEFAULT '1',
  `tags` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `type` int(4) NOT NULL,
  `visit_id` varchar(256) COLLATE utf8_bin NOT NULL,
  `privilege` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `af_articleinfo_FK_ID_user_id` (`user_id`),
  CONSTRAINT `af_articleinfo_FK_ID_user_id` FOREIGN KEY (`user_id`) REFERENCES `af_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_articleinfo`
--

LOCK TABLES `af_articleinfo` WRITE;
/*!40000 ALTER TABLE `af_articleinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_articleinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_func`
--

DROP TABLE IF EXISTS `af_func`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_func` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `sys` varchar(8) COLLATE utf8_bin NOT NULL COMMENT '系统号',
  `name` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `namee` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '英文名',
  `namec` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '中文名',
  `disporder` int(4) NOT NULL COMMENT '排列顺序',
  `plugin` varchar(64) COLLATE utf8_bin DEFAULT 'javascript:;' COMMENT '插件名',
  `status` int(4) NOT NULL COMMENT '1表示有效， 2表示无效',
  `type` varchar(16) COLLATE utf8_bin NOT NULL,
  `grp_name` varchar(32) COLLATE utf8_bin NOT NULL,
  `icon` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `grp_name_FK_ID_grp_name` (`grp_name`),
  CONSTRAINT `grp_name_FK_ID_grp_name` FOREIGN KEY (`grp_name`) REFERENCES `af_funcgrp` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_func`
--

LOCK TABLES `af_func` WRITE;
/*!40000 ALTER TABLE `af_func` DISABLE KEYS */;
INSERT INTO `af_func` VALUES (1,'01','m1','child module','侧边菜单管理',1,'LeftMenuManage',1,'leftMenu','module1',NULL),(2,'01','m2','child module','顶部菜单管理',2,'javascript:;',0,'leftMenu','module1',NULL),(16,'01','LoginInfoManage','LoginInfoManage','登录日志管理',1,'LoginInfoManage',1,'leftMenu','module4',NULL),(17,'01','SystemUpdatingLogManage','SystemUpdatingLogManage','系统更新日志管理',2,'SystemUpdatingLogManage',1,'leftMenu','module4',NULL),(24,'01','m5','child module','用户管理',3,'UserManage',1,'leftMenu','module1',NULL),(25,'01','MakeSuggestion','MakeSuggestion','联系管理员',1,'MakeSuggestion',1,'leftMenu','module3',NULL),(26,'01','RoleManage','role manage','角色管理',4,'RoleManage',1,'leftMenu','module1',NULL),(27,'01','ArticleList','ArticleList','文章列表',1,'ArticleList',1,'leftMenu','ArticleManage',NULL),(28,'01','SystemNotice','SystemNotice','系统公告',1,'SystemNotice',1,'leftMenu','module3',NULL),(29,'01','VisitorStatistics','VisitorStatistics','访问统计',1,'VisitorStatistics',1,'leftMenu','OpenAPI',NULL);
/*!40000 ALTER TABLE `af_func` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_funcgrp`
--

DROP TABLE IF EXISTS `af_funcgrp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_funcgrp` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `sys` varchar(8) COLLATE utf8_bin NOT NULL COMMENT '系统号',
  `name` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `namee` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '英文名',
  `namec` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '中文名',
  `disporder` int(4) NOT NULL COMMENT '排列顺序',
  `plugin` varchar(32) COLLATE utf8_bin DEFAULT 'javascript:;' COMMENT '插件名',
  `status` int(4) NOT NULL COMMENT '1表示有效， 2表示无效',
  `type` varchar(16) COLLATE utf8_bin NOT NULL,
  `icon` varchar(36) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_funcgrp`
--

LOCK TABLES `af_funcgrp` WRITE;
/*!40000 ALTER TABLE `af_funcgrp` DISABLE KEYS */;
INSERT INTO `af_funcgrp` VALUES (1,'01','module1','module1','系统设置',1,'javascript:;',1,'leftMenu','&#xe614;'),(4,'01','module4','module4','日志管理',4,'javascript:;',1,'leftMenu','&#xe622;'),(5,'01','module3','module3','消息中心',3,'javascript:;',1,'leftMenu','&#xe857;'),(6,'01','ArticleManage','article manage','文章管理',5,'javascript:;',1,'leftMenu','&#xe63c;'),(7,'03','SystemMonitor','system monitor','系统监控',1,'javascript:;',1,'leftMenu','&#xe629;'),(8,'03','FailureProcess','failure process','故障处理',2,'javascript:;',1,'leftMenu','&#xe639;'),(9,'03','UserManage','user manage','用户管理',3,'javascript:;',1,'leftMenu','&#xe612;'),(10,'01','OpenAPI','open api','开放接口',6,'javascript:;',1,'leftMenu','&#xe635;');
/*!40000 ALTER TABLE `af_funcgrp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_logininfo`
--

DROP TABLE IF EXISTS `af_logininfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_logininfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) COLLATE utf8_bin NOT NULL,
  `area` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `area_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `city_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `country_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `county` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `county_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `isp` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `isp_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `region` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `region_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `user_login_name` varchar(32) COLLATE utf8_bin NOT NULL,
  `type` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8098 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_logininfo`
--

LOCK TABLES `af_logininfo` WRITE;
/*!40000 ALTER TABLE `af_logininfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_logininfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_openapi`
--

DROP TABLE IF EXISTS `af_openapi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_openapi` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `api` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'api',
  `status` int(4) NOT NULL COMMENT '1表示有效， 2表示无效',
  `httptype` varchar(16) COLLATE utf8_bin NOT NULL COMMENT 'http 请求方式',
  `params` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '参数:json格式',
  `response` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '返回结果:json格式',
  `tablename` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '对应统计信息数据库表名',
  `interfaces_format` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '接口格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_openapi`
--

LOCK TABLES `af_openapi` WRITE;
/*!40000 ALTER TABLE `af_openapi` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_openapi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_plugin`
--

DROP TABLE IF EXISTS `af_plugin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_plugin` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `sys` varchar(8) COLLATE utf8_bin NOT NULL COMMENT '系统号',
  `name` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '名称',
  `namee` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '英文名',
  `namec` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '中文名',
  `titlee` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '英文标题',
  `titlec` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '中文标题',
  `autorun` int(4) NOT NULL COMMENT '是否自动运行',
  `plugin` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '插件名',
  `dir` varchar(128) COLLATE utf8_bin NOT NULL COMMENT '相对路径',
  `jsurl` varchar(128) COLLATE utf8_bin NOT NULL COMMENT 'js名称',
  `htmleurl` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'htmle名称',
  `htmlcurl` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT 'htmlc名称',
  `icon` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '图标',
  `status` int(4) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_plugin`
--

LOCK TABLES `af_plugin` WRITE;
/*!40000 ALTER TABLE `af_plugin` DISABLE KEYS */;
INSERT INTO `af_plugin` VALUES (1,'01','LeftMenuManage',NULL,NULL,NULL,NULL,0,'Fv.plugin.LeftMenuManage','/Sys/plugin/SysConfig/LeftMenuManage/','LeftMenuManage.js',NULL,'LeftMenuManage.html',NULL,1),(2,'01','登陆日志管理',NULL,NULL,NULL,NULL,0,'Fv.plugin.LoginInfoManage','/Sys/plugin/SysConfig/LoginInfoManage/','LoginInfoManage.js',NULL,'LoginInfoManage.html',NULL,1),(3,'01','系统更新日志管理',NULL,NULL,NULL,NULL,0,'Fv.plugin.SysUpdateLogManage','/Sys/plugin/SysConfig/SysUpdateLogManage/','SysUpdateLogManage.js',NULL,'SysUpdateLogManage.html',NULL,1);
/*!40000 ALTER TABLE `af_plugin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_resource`
--

DROP TABLE IF EXISTS `af_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_resource` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `parent_id` int(8) DEFAULT NULL COMMENT '父id',
  `namee` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '英文名',
  `namec` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '中文名',
  `status` int(4) NOT NULL COMMENT '状态：1表示有效，0表示无效',
  `link_address` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '请求接口',
  `icon` varchar(64) COLLATE utf8_bin DEFAULT NULL COMMENT '图标',
  `level` int(4) DEFAULT NULL COMMENT '级别',
  `type` int(4) DEFAULT NULL COMMENT '类型',
  `remark` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(16) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_id_FK_ID_resource_creator_id` (`creator_id`),
  KEY `user_id_FK_ID_resource_modifier_id` (`modifier_id`),
  CONSTRAINT `user_id_FK_ID_resource_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_ID_resource_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_resource`
--

LOCK TABLES `af_resource` WRITE;
/*!40000 ALTER TABLE `af_resource` DISABLE KEYS */;
INSERT INTO `af_resource` VALUES (3,NULL,NULL,'获取系统菜单',1,'/sys/getMenu/*',NULL,NULL,NULL,NULL,'admin',-1,'2017-10-29 11:04:19','admin',-1,'2017-10-29 11:04:19'),(4,NULL,NULL,'获取菜单列表',1,'/menu/getMenuList/',NULL,NULL,NULL,NULL,'admin',-1,'2017-10-29 11:04:19','admin',-1,'2017-10-29 11:04:19'),(5,NULL,NULL,'删除菜单',1,'/menu/deleteMenu/',NULL,NULL,NULL,NULL,'admin',-1,'2017-10-31 15:38:06','admin',-1,'2017-10-31 15:38:06'),(6,NULL,NULL,'获取所有登录日志',1,'/log/allLoginLog/',NULL,NULL,NULL,NULL,'admin',-1,'2017-10-31 20:16:13','admin',-1,'2017-10-31 20:16:13'),(7,NULL,NULL,'获取某用户登录日志',1,'/log/userLoginLog/',NULL,NULL,NULL,NULL,'admin',-1,'2017-10-31 20:16:13','admin',-1,'2017-10-31 20:16:13'),(8,NULL,NULL,'登录信息图表',1,'/log/loginInfoCharts/',NULL,NULL,NULL,NULL,'admin',-1,'2017-11-02 17:25:33','admin',-1,'2017-11-02 17:25:33');
/*!40000 ALTER TABLE `af_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_role`
--

DROP TABLE IF EXISTS `af_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_name` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `status` int(1) NOT NULL COMMENT '表示角色的状态，0无效， 1表示有效',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `mofifier_id` int(16) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_id_FK_KEY_creator_id` (`creator_id`),
  KEY `user_id_FK_KEY_modifier_id` (`mofifier_id`),
  CONSTRAINT `user_id_FK_KEY_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_KEY_modifier_id` FOREIGN KEY (`mofifier_id`) REFERENCES `af_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_role`
--

LOCK TABLES `af_role` WRITE;
/*!40000 ALTER TABLE `af_role` DISABLE KEYS */;
INSERT INTO `af_role` VALUES (1,'administrator',1,'admin',-1,'2017-10-25 14:50:16','admin',-1,'2017-10-25 14:50:16'),(2,'sys',1,'admin',-1,'2017-10-29 15:49:41','admin',-1,'2017-10-29 15:49:41');
/*!40000 ALTER TABLE `af_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_role_plugin`
--

DROP TABLE IF EXISTS `af_role_plugin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_role_plugin` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `plugin_id` int(8) NOT NULL COMMENT '资源id',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `plugin_id_FK_ID_role_plugin_plugin_id` (`plugin_id`),
  KEY `role_id_FK_ID_role_plugin_role_id` (`role_id`),
  KEY `user_id_FK_ID_role_plugin_creator_id` (`creator_id`),
  KEY `user_id_FK_ID_role_plugin_modifier_id` (`modifier_id`),
  CONSTRAINT `plugin_id_FK_ID_role_plugin_plugin_id` FOREIGN KEY (`plugin_id`) REFERENCES `af_plugin` (`id`),
  CONSTRAINT `role_id_FK_ID_role_plugin_role_id` FOREIGN KEY (`role_id`) REFERENCES `af_role` (`id`),
  CONSTRAINT `user_id_FK_ID_role_plugin_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_ID_role_plugin_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_role_plugin`
--

LOCK TABLES `af_role_plugin` WRITE;
/*!40000 ALTER TABLE `af_role_plugin` DISABLE KEYS */;
INSERT INTO `af_role_plugin` VALUES (1,1,1,'admin',-1,'2017-10-30 21:00:44','admin',-1,'2017-10-30 21:00:44'),(2,1,2,'admin',-1,'2017-10-31 21:14:47','admin',-1,'2017-10-31 21:14:47'),(3,1,3,'admin',-1,'2017-11-01 16:26:25','admin',-1,'2017-11-01 16:26:25'),(4,2,1,'admin',-1,'2017-11-02 10:25:02','admin',-1,'2017-11-02 10:25:02'),(5,2,2,'admin',-1,'2017-11-02 15:32:08','admin',-1,'2017-11-02 15:32:08'),(6,2,3,'admin',-1,'2017-11-02 15:32:08','admin',-1,'2017-11-02 15:32:08');
/*!40000 ALTER TABLE `af_role_plugin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_role_resource`
--

DROP TABLE IF EXISTS `af_role_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_role_resource` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `resource_id` int(8) NOT NULL COMMENT '资源id',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `resource_id_FK_ID_role_resource_resource_id` (`resource_id`),
  KEY `role_id_FK_ID_role_resource_role_id` (`role_id`),
  KEY `user_id_FK_ID_role_resource_creator_id` (`creator_id`),
  KEY `user_id_FK_ID_role_resource_modifier_id` (`modifier_id`),
  CONSTRAINT `resource_id_FK_ID_role_resource_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `af_resource` (`id`),
  CONSTRAINT `role_id_FK_ID_role_resource_role_id` FOREIGN KEY (`role_id`) REFERENCES `af_role` (`id`),
  CONSTRAINT `user_id_FK_ID_role_resource_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_ID_role_resource_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_role_resource`
--

LOCK TABLES `af_role_resource` WRITE;
/*!40000 ALTER TABLE `af_role_resource` DISABLE KEYS */;
INSERT INTO `af_role_resource` VALUES (1,1,3,'admin',-1,'2017-10-29 11:42:42','admin',-1,'2017-10-29 11:42:42'),(2,1,4,'admin',-1,'2017-10-29 11:42:42','admin',-1,'2017-10-29 11:42:42'),(3,2,3,'admin',-1,'2017-10-29 15:52:37','admin',-1,'2017-10-29 15:52:37'),(5,1,6,'admin',-1,'2017-10-31 20:17:10','admin',-1,'2017-10-31 20:17:10'),(6,1,7,'admin',-1,'2017-10-31 20:17:11','admin',-1,'2017-10-31 20:17:11'),(7,2,4,'admin',-1,'2017-11-02 11:07:29','admin',-1,'2017-11-02 11:07:29'),(8,2,6,'admin',-1,'2017-11-02 15:34:13','admin',-1,'2017-11-02 15:34:13'),(9,1,8,'admin',-1,'2017-11-02 17:26:57','admin',-1,'2017-11-02 17:26:57'),(11,2,8,'admin',-1,'2017-11-09 12:36:49','admin',-1,'2017-11-09 12:36:49');
/*!40000 ALTER TABLE `af_role_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_user`
--

DROP TABLE IF EXISTS `af_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_login_name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT '用户登录名，唯一',
  `username` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户密码，加密',
  `status` int(1) NOT NULL COMMENT '用户状态：0表示无效，1表示有效',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  `email` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_login_name` (`user_login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=533 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_user`
--

LOCK TABLES `af_user` WRITE;
/*!40000 ALTER TABLE `af_user` DISABLE KEYS */;
INSERT INTO `af_user` VALUES (-1,'admin','admin','2A394798A5EA52F6F7358EAB170D277C',1,'admin',-1,'2017-10-25 14:49:57','admin',-1,'2017-10-25 14:49:57',NULL),(1,'sys1','sys1','2A394798A5EA52F6F7358EAB170D277C',1,'admin',-1,'2017-10-29 15:49:12','admin',-1,'2017-10-29 15:49:12',NULL),(6,'sys2','sys2','D59673F49914792B4B7637A66471E366',1,'sys1',1,'2017-11-07 16:49:32','sys1',1,'2017-11-07 16:49:32',NULL);
/*!40000 ALTER TABLE `af_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_user_role`
--

DROP TABLE IF EXISTS `af_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_user_role` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_id` int(8) NOT NULL COMMENT '用户id',
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `user_id_FK_ID` (`user_id`),
  KEY `role_id_FK_ID` (`role_id`),
  KEY `user_id_FK_ID_creator_id` (`creator_id`),
  KEY `user_id_FK_ID_modifier_id` (`modifier_id`),
  CONSTRAINT `role_id_FK_ID` FOREIGN KEY (`role_id`) REFERENCES `af_role` (`id`),
  CONSTRAINT `user_id_FK_ID` FOREIGN KEY (`user_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_ID_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`),
  CONSTRAINT `user_id_FK_ID_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_user_role`
--

LOCK TABLES `af_user_role` WRITE;
/*!40000 ALTER TABLE `af_user_role` DISABLE KEYS */;
INSERT INTO `af_user_role` VALUES (2,-1,1,'admin',-1,'2017-10-25 14:51:17','admin',-1,'2017-10-25 14:51:17'),(3,1,2,'admin',-1,'2017-10-29 15:50:35','admin',-1,'2017-10-29 15:50:35');
/*!40000 ALTER TABLE `af_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_visitoripinfo`
--

DROP TABLE IF EXISTS `af_visitoripinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_visitoripinfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) COLLATE utf8_bin NOT NULL,
  `area` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `area_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `city_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `country_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `county` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `county_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `isp` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `isp_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `region` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `region_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `type` int(8) NOT NULL COMMENT '类型：',
  `request_url` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `api_visitorstatistics_id` int(8) NOT NULL COMMENT 'api_visitorstatistics id',
  PRIMARY KEY (`id`),
  KEY `api_visitorstatistics_id_FK_api_visitorstatistics_id` (`api_visitorstatistics_id`),
  CONSTRAINT `api_visitorstatistics_id_FK_api_visitorstatistics_id` FOREIGN KEY (`api_visitorstatistics_id`) REFERENCES `af_api_visitorstatistics` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_visitoripinfo`
--

LOCK TABLES `af_visitoripinfo` WRITE;
/*!40000 ALTER TABLE `af_visitoripinfo` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_visitoripinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `af_visitorstatistics_detail`
--

DROP TABLE IF EXISTS `af_visitorstatistics_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `af_visitorstatistics_detail` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `api_visitorstatistics_id` int(8) NOT NULL COMMENT 'api_visitorstatistics id',
  `request_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT '请求url',
  `visit_times` int(16) NOT NULL DEFAULT '0' COMMENT '访问次数',
  `voteup_times` int(16) NOT NULL DEFAULT '0' COMMENT '赞同次数',
  `votedown_times` int(16) NOT NULL DEFAULT '0' COMMENT '否决次数',
  PRIMARY KEY (`id`),
  KEY `api_visitorstatistics_id_FK` (`api_visitorstatistics_id`),
  CONSTRAINT `api_visitorstatistics_id_FK` FOREIGN KEY (`api_visitorstatistics_id`) REFERENCES `af_api_visitorstatistics` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `af_visitorstatistics_detail`
--

LOCK TABLES `af_visitorstatistics_detail` WRITE;
/*!40000 ALTER TABLE `af_visitorstatistics_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `af_visitorstatistics_detail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-16 19:51:59
