/*
 Navicat Premium Data Transfer

 Source Server         : 139.199.210.120
 Source Server Type    : MariaDB
 Source Server Version : 50556
 Source Host           : 139.199.210.120:3306
 Source Schema         : autumn_framework

 Target Server Type    : MariaDB
 Target Server Version : 50556
 File Encoding         : 65001

 Date: 06/12/2017 16:26:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for af_func
-- ----------------------------
DROP TABLE IF EXISTS `af_func`;
CREATE TABLE `af_func`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `sys` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '系统号',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `namee` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '英文名',
  `namec` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '中文名',
  `disporder` int(4) NOT NULL COMMENT '排列顺序',
  `plugin` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT 'javascript:;' COMMENT '插件名',
  `status` int(4) NOT NULL COMMENT '1表示有效， 2表示无效',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `grp_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `icon` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  INDEX `grp_name_FK_ID_grp_name`(`grp_name`) USING BTREE,
  CONSTRAINT `grp_name_FK_ID_grp_name` FOREIGN KEY (`grp_name`) REFERENCES `af_funcgrp` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_funcgrp
-- ----------------------------
DROP TABLE IF EXISTS `af_funcgrp`;
CREATE TABLE `af_funcgrp`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `sys` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '系统号',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `namee` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '英文名',
  `namec` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '中文名',
  `disporder` int(4) NOT NULL COMMENT '排列顺序',
  `plugin` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT 'javascript:;' COMMENT '插件名',
  `status` int(4) NOT NULL COMMENT '1表示有效， 2表示无效',
  `type` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `icon` varchar(36) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_logininfo
-- ----------------------------
DROP TABLE IF EXISTS `af_logininfo`;
CREATE TABLE `af_logininfo`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `area` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `area_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `city` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `city_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `country` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `country_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `county` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `county_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `isp` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `isp_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `region` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `region_id` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `visit_time` datetime(0) NULL DEFAULT NULL,
  `user_login_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `type` int(8) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5229 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_plugin
-- ----------------------------
DROP TABLE IF EXISTS `af_plugin`;
CREATE TABLE `af_plugin`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `sys` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '系统号',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `namee` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '英文名',
  `namec` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '中文名',
  `titlee` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '英文标题',
  `titlec` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '中文标题',
  `autorun` int(4) NOT NULL COMMENT '是否自动运行',
  `plugin` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '插件名',
  `dir` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '相对路径',
  `jsurl` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'js名称',
  `htmleurl` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'htmle名称',
  `htmlcurl` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'htmlc名称',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图标',
  `status` int(4) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_resource
-- ----------------------------
DROP TABLE IF EXISTS `af_resource`;
CREATE TABLE `af_resource`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `parent_id` int(8) NULL DEFAULT NULL COMMENT '父id',
  `namee` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '英文名',
  `namec` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '中文名',
  `status` int(4) NOT NULL COMMENT '状态：1表示有效，0表示无效',
  `link_address` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '请求接口',
  `icon` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图标',
  `level` int(4) NULL DEFAULT NULL COMMENT '级别',
  `type` int(4) NULL DEFAULT NULL COMMENT '类型',
  `remark` varchar(128) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '备注',
  `creator` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(16) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_FK_ID_resource_creator_id`(`creator_id`) USING BTREE,
  INDEX `user_id_FK_ID_resource_modifier_id`(`modifier_id`) USING BTREE,
  CONSTRAINT `user_id_FK_ID_resource_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID_resource_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_role
-- ----------------------------
DROP TABLE IF EXISTS `af_role`;
CREATE TABLE `af_role`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `role_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色名称',
  `status` int(1) NOT NULL COMMENT '表示角色的状态，0无效， 1表示有效',
  `creator` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `mofifier_id` int(16) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_FK_KEY_creator_id`(`creator_id`) USING BTREE,
  INDEX `user_id_FK_KEY_modifier_id`(`mofifier_id`) USING BTREE,
  CONSTRAINT `user_id_FK_KEY_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_KEY_modifier_id` FOREIGN KEY (`mofifier_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_role_plugin
-- ----------------------------
DROP TABLE IF EXISTS `af_role_plugin`;
CREATE TABLE `af_role_plugin`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `plugin_id` int(8) NOT NULL COMMENT '资源id',
  `creator` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `plugin_id_FK_ID_role_plugin_plugin_id`(`plugin_id`) USING BTREE,
  INDEX `role_id_FK_ID_role_plugin_role_id`(`role_id`) USING BTREE,
  INDEX `user_id_FK_ID_role_plugin_creator_id`(`creator_id`) USING BTREE,
  INDEX `user_id_FK_ID_role_plugin_modifier_id`(`modifier_id`) USING BTREE,
  CONSTRAINT `plugin_id_FK_ID_role_plugin_plugin_id` FOREIGN KEY (`plugin_id`) REFERENCES `af_plugin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_id_FK_ID_role_plugin_role_id` FOREIGN KEY (`role_id`) REFERENCES `af_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID_role_plugin_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID_role_plugin_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `af_role_resource`;
CREATE TABLE `af_role_resource`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `resource_id` int(8) NOT NULL COMMENT '资源id',
  `creator` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `resource_id_FK_ID_role_resource_resource_id`(`resource_id`) USING BTREE,
  INDEX `role_id_FK_ID_role_resource_role_id`(`role_id`) USING BTREE,
  INDEX `user_id_FK_ID_role_resource_creator_id`(`creator_id`) USING BTREE,
  INDEX `user_id_FK_ID_role_resource_modifier_id`(`modifier_id`) USING BTREE,
  CONSTRAINT `resource_id_FK_ID_role_resource_resource_id` FOREIGN KEY (`resource_id`) REFERENCES `af_resource` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_id_FK_ID_role_resource_role_id` FOREIGN KEY (`role_id`) REFERENCES `af_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID_role_resource_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID_role_resource_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_user
-- ----------------------------
DROP TABLE IF EXISTS `af_user`;
CREATE TABLE `af_user`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_login_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户登录名，唯一',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码，加密',
  `status` int(1) NOT NULL COMMENT '用户状态：0表示无效，1表示有效',
  `creator` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime(0) NOT NULL COMMENT '修改时间',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_login_name`(`user_login_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 391 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for af_user_role
-- ----------------------------
DROP TABLE IF EXISTS `af_user_role`;
CREATE TABLE `af_user_role`  (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `user_id` int(8) NOT NULL COMMENT '用户id',
  `role_id` int(8) NOT NULL COMMENT '角色id',
  `creator` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '创建者',
  `creator_id` int(8) NOT NULL COMMENT '创建者id',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `modifier` varchar(16) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '修改者',
  `modifier_id` int(8) NOT NULL COMMENT '修改者id',
  `modifier_time` datetime(0) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id_FK_ID`(`user_id`) USING BTREE,
  INDEX `role_id_FK_ID`(`role_id`) USING BTREE,
  INDEX `user_id_FK_ID_creator_id`(`creator_id`) USING BTREE,
  INDEX `user_id_FK_ID_modifier_id`(`modifier_id`) USING BTREE,
  CONSTRAINT `role_id_FK_ID` FOREIGN KEY (`role_id`) REFERENCES `af_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID` FOREIGN KEY (`user_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID_creator_id` FOREIGN KEY (`creator_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_id_FK_ID_modifier_id` FOREIGN KEY (`modifier_id`) REFERENCES `af_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
