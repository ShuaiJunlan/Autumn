/*
Navicat MySQL Data Transfer

Source Server         : 139.199.210.120
Source Server Version : 50556
Source Host           : 139.199.210.120:3306
Source Database       : autumn_framework

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2017-11-06 20:02:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for af_func
-- ----------------------------
DROP TABLE IF EXISTS `af_func`;
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of af_func
-- ----------------------------
INSERT INTO `af_func` VALUES ('1', '01', 'm1', 'child module', '侧边菜单管理', '1', 'LeftMenuManage', '1', 'leftMenu', 'module1', null);
INSERT INTO `af_func` VALUES ('2', '01', 'm2', 'child module', '顶部菜单管理', '2', 'javascript:;', '1', 'leftMenu', 'module1', null);
INSERT INTO `af_func` VALUES ('16', '01', 'LoginInfoManage', 'LoginInfoManage', '登录日志管理', '1', 'LoginInfoManage', '1', 'leftMenu', 'module4', null);
INSERT INTO `af_func` VALUES ('17', '01', 'SystemUpdatingLogManage', 'SystemUpdatingLogManage', '系统更新日志管理', '2', 'SystemUpdatingLogManage', '1', 'leftMenu', 'module4', null);
INSERT INTO `af_func` VALUES ('24', '01', 'm5', 'child module', '用户管理', '3', 'UserManage', '1', 'leftMenu', 'module1', null);

-- ----------------------------
-- Table structure for af_funcgrp
-- ----------------------------
DROP TABLE IF EXISTS `af_funcgrp`;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of af_funcgrp
-- ----------------------------
INSERT INTO `af_funcgrp` VALUES ('1', '01', 'module1', 'module1', '系统设置', '1', 'javascript:;', '1', 'leftMenu', '&#xe614;');
INSERT INTO `af_funcgrp` VALUES ('4', '01', 'module4', 'module4', '日志管理', '4', 'javascript:;', '1', 'leftMenu', '&#xe622;');
INSERT INTO `af_funcgrp` VALUES ('5', '01', 'module3', 'module3', '公告管理', '3', 'javascript:;', '1', 'leftMenu', '&#xe857;');


-- ----------------------------
-- Table structure for af_logininfo
-- ----------------------------
DROP TABLE IF EXISTS `af_logininfo`;
CREATE TABLE `af_logininfo` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) COLLATE utf8_bin NOT NULL,
  `area` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `area_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `city` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `city_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `country` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `country_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `county` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `county_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `isp` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `isp_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `region` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `region_id` varchar(8) COLLATE utf8_bin DEFAULT NULL,
  `visit_time` datetime DEFAULT NULL,
  `user_login_name` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=330 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


-- ----------------------------
-- Table structure for af_plugin
-- ----------------------------
DROP TABLE IF EXISTS `af_plugin`;
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

-- ----------------------------
-- Records of af_plugin
-- ----------------------------
INSERT INTO `af_plugin` VALUES ('1', '01', 'LeftMenuManage', null, null, null, null, '0', 'Fv.plugin.LeftMenuManage', '/Sys/plugin/SysConfig/LeftMenuManage/', 'LeftMenuManage.js', null, 'LeftMenuManage.html', null, '1');
INSERT INTO `af_plugin` VALUES ('2', '01', '登陆日志管理', null, null, null, null, '0', 'Fv.plugin.LoginInfoManage', '/Sys/plugin/SysConfig/LoginInfoManage/', 'LoginInfoManage.js', null, 'LoginInfoManage.html', null, '1');
INSERT INTO `af_plugin` VALUES ('3', '01', '系统更新日志管理', null, null, null, null, '0', 'Fv.plugin.SysUpdateLogManage', '/Sys/plugin/SysConfig/SysUpdateLogManage/', 'SysUpdateLogManage.js', null, 'SysUpdateLogManage.html', null, '1');

-- ----------------------------
-- Table structure for af_resource
-- ----------------------------
DROP TABLE IF EXISTS `af_resource`;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of af_resource
-- ----------------------------
INSERT INTO `af_resource` VALUES ('3', null, null, '获取系统菜单', '1', '/sys/getMenu/*', null, null, null, null, 'admin', '-1', '2017-10-29 11:04:19', 'admin', '-1', '2017-10-29 11:04:19');
INSERT INTO `af_resource` VALUES ('4', null, null, '获取菜单列表', '1', '/menu/getMenuList/', null, null, null, null, 'admin', '-1', '2017-10-29 11:04:19', 'admin', '-1', '2017-10-29 11:04:19');
INSERT INTO `af_resource` VALUES ('5', null, null, '删除菜单', '1', '/menu/deleteMenu/', null, null, null, null, 'admin', '-1', '2017-10-31 15:38:06', 'admin', '-1', '2017-10-31 15:38:06');
INSERT INTO `af_resource` VALUES ('6', null, null, '获取所有登录日志', '1', '/log/allLoginLog/', null, null, null, null, 'admin', '-1', '2017-10-31 20:16:13', 'admin', '-1', '2017-10-31 20:16:13');
INSERT INTO `af_resource` VALUES ('7', null, null, '获取某用户登录日志', '1', '/log/userLoginLog/', null, null, null, null, 'admin', '-1', '2017-10-31 20:16:13', 'admin', '-1', '2017-10-31 20:16:13');
INSERT INTO `af_resource` VALUES ('8', null, null, '登录信息图表', '1', '/log/loginInfoCharts/', null, null, null, null, 'admin', '-1', '2017-11-02 17:25:33', 'admin', '-1', '2017-11-02 17:25:33');

-- ----------------------------
-- Table structure for af_role
-- ----------------------------
DROP TABLE IF EXISTS `af_role`;
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

-- ----------------------------
-- Records of af_role
-- ----------------------------
INSERT INTO `af_role` VALUES ('1', 'administrator', '1', 'admin', '-1', '2017-10-25 14:50:16', 'admin', '-1', '2017-10-25 14:50:16');
INSERT INTO `af_role` VALUES ('2', 'sys', '1', 'admin', '-1', '2017-10-29 15:49:41', 'admin', '-1', '2017-10-29 15:49:41');

-- ----------------------------
-- Table structure for af_role_plugin
-- ----------------------------
DROP TABLE IF EXISTS `af_role_plugin`;
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

-- ----------------------------
-- Records of af_role_plugin
-- ----------------------------
INSERT INTO `af_role_plugin` VALUES ('1', '1', '1', 'admin', '-1', '2017-10-30 21:00:44', 'admin', '-1', '2017-10-30 21:00:44');
INSERT INTO `af_role_plugin` VALUES ('2', '1', '2', 'admin', '-1', '2017-10-31 21:14:47', 'admin', '-1', '2017-10-31 21:14:47');
INSERT INTO `af_role_plugin` VALUES ('3', '1', '3', 'admin', '-1', '2017-11-01 16:26:25', 'admin', '-1', '2017-11-01 16:26:25');
INSERT INTO `af_role_plugin` VALUES ('4', '2', '1', 'admin', '-1', '2017-11-02 10:25:02', 'admin', '-1', '2017-11-02 10:25:02');
INSERT INTO `af_role_plugin` VALUES ('5', '2', '2', 'admin', '-1', '2017-11-02 15:32:08', 'admin', '-1', '2017-11-02 15:32:08');
INSERT INTO `af_role_plugin` VALUES ('6', '2', '3', 'admin', '-1', '2017-11-02 15:32:08', 'admin', '-1', '2017-11-02 15:32:08');

-- ----------------------------
-- Table structure for af_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `af_role_resource`;
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of af_role_resource
-- ----------------------------
INSERT INTO `af_role_resource` VALUES ('1', '1', '3', 'admin', '-1', '2017-10-29 11:42:42', 'admin', '-1', '2017-10-29 11:42:42');
INSERT INTO `af_role_resource` VALUES ('2', '1', '4', 'admin', '-1', '2017-10-29 11:42:42', 'admin', '-1', '2017-10-29 11:42:42');
INSERT INTO `af_role_resource` VALUES ('3', '2', '3', 'admin', '-1', '2017-10-29 15:52:37', 'admin', '-1', '2017-10-29 15:52:37');
INSERT INTO `af_role_resource` VALUES ('5', '1', '6', 'admin', '-1', '2017-10-31 20:17:10', 'admin', '-1', '2017-10-31 20:17:10');
INSERT INTO `af_role_resource` VALUES ('6', '1', '7', 'admin', '-1', '2017-10-31 20:17:11', 'admin', '-1', '2017-10-31 20:17:11');
INSERT INTO `af_role_resource` VALUES ('7', '2', '4', 'admin', '-1', '2017-11-02 11:07:29', 'admin', '-1', '2017-11-02 11:07:29');
INSERT INTO `af_role_resource` VALUES ('8', '2', '6', 'admin', '-1', '2017-11-02 15:34:13', 'admin', '-1', '2017-11-02 15:34:13');
INSERT INTO `af_role_resource` VALUES ('9', '1', '8', 'admin', '-1', '2017-11-02 17:26:57', 'admin', '-1', '2017-11-02 17:26:57');
INSERT INTO `af_role_resource` VALUES ('10', '2', '8', 'admin', '-1', '2017-11-02 19:39:09', 'admin', '-1', '2017-11-02 19:39:09');

-- ----------------------------
-- Table structure for af_user
-- ----------------------------
DROP TABLE IF EXISTS `af_user`;
CREATE TABLE `af_user` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_login_name` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '用户登录名，唯一',
  `username` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '用户姓名',
  `password` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '用户密码，加密',
  `status` int(1) NOT NULL COMMENT '用户状态：0表示无效，1表示有效',
  `creator` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_login_name` (`user_login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of af_user
-- ----------------------------
INSERT INTO `af_user` VALUES ('-1', 'admin', 'admin', 'BBAD8D72C1FAC1D081727158807A8798', '1', 'admin', '-1', '2017-10-25 14:49:57', 'admin', '-1', '2017-10-25 14:49:57');
INSERT INTO `af_user` VALUES ('1', 'sys1', 'sys1', '2A394798A5EA52F6F7358EAB170D277C', '1', 'admin', '-1', '2017-10-29 15:49:12', 'admin', '-1', '2017-10-29 15:49:12');

-- ----------------------------
-- Table structure for af_user_role
-- ----------------------------
DROP TABLE IF EXISTS `af_user_role`;
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of af_user_role
-- ----------------------------
INSERT INTO `af_user_role` VALUES ('2', '-1', '1', 'admin', '-1', '2017-10-25 14:51:17', 'admin', '-1', '2017-10-25 14:51:17');
INSERT INTO `af_user_role` VALUES ('3', '1', '2', 'admin', '-1', '2017-10-29 15:50:35', 'admin', '-1', '2017-10-29 15:50:35');
