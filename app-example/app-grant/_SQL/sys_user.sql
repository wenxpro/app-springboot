/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : app-grant

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-11-20 15:34:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `account` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `nick_name` varchar(50) DEFAULT NULL COMMENT '昵称',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `avatar` bigint(20) DEFAULT NULL COMMENT '头像',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `sex` tinyint(4) NOT NULL COMMENT '性别(字典 1男 2女 3未知)',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机',
  `tel` varchar(50) DEFAULT NULL COMMENT '电话',
  `last_login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `admin_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '管理员类型（0超级管理员 1非管理员）',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态（字典 0正常 1冻结 2删除）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1265476890672672808', 'admin', '$2a$09$PiCiFNspSlTBE9CakVs8ZOqx0xa03X9wOm01gMasHch4929TpEWCC', '超级管理员', '超级管理员', null, '2020-03-16', '1', 'superAdmin@qq.com', '15228937093', '12345678', '127.0.0.1', '2020-11-20 07:21:40', '1', '0', '2020-05-29 16:39:28', '-1', '2020-11-20 07:21:40', '-1');
