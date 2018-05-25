/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : sport

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-05-23 11:00:36
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `account_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO account VALUES ('1', '1', 'qw', 'qq', 'qq');
INSERT INTO account VALUES ('2', '2', 'ww', 'ww', 'ww');

-- ----------------------------
-- Table structure for `clas`
-- ----------------------------
DROP TABLE IF EXISTS `clas`;
CREATE TABLE `clas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL COMMENT 'banjibianma',
  `name` varchar(255) DEFAULT NULL COMMENT 'banjiming',
  `grade_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `grade_id` (`grade_id`),
  CONSTRAINT `clas_ibfk_1` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clas
-- ----------------------------
INSERT INTO clas VALUES ('62', '1101', '1', '36');
INSERT INTO clas VALUES ('63', '1102', '2', '37');
INSERT INTO clas VALUES ('64', '1201', '1', '38');

-- ----------------------------
-- Table structure for `env`
-- ----------------------------
DROP TABLE IF EXISTS `env`;
CREATE TABLE `env` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clas_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL COMMENT 'ticebiao',
  `name` varchar(255) DEFAULT NULL COMMENT 'jiaoshiming',
  `time` varchar(255) DEFAULT NULL COMMENT 'ceshishijian',
  `place` varchar(255) DEFAULT NULL COMMENT 'ceshididian',
  `equipment` varchar(255) DEFAULT NULL COMMENT 'qicai',
  `mode` varchar(255) DEFAULT NULL COMMENT 'ceshifangshi',
  PRIMARY KEY (`id`),
  KEY `clas_id` (`clas_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `env_ibfk_1` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`),
  CONSTRAINT `env_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of env
-- ----------------------------
INSERT INTO env VALUES ('1', '62', '1', '涨', '121', '11', '11', '11');
INSERT INTO env VALUES ('2', '63', '2', '11', '11', '11', '11', '11');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_id` int(11) NOT NULL,
  `num` int(11) DEFAULT NULL COMMENT 'nianjibianma',
  `name` varchar(255) DEFAULT NULL COMMENT 'nianjiming',
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO grade VALUES ('36', '19', '11', '一年级');
INSERT INTO grade VALUES ('37', '20', '12', '二年级');
INSERT INTO grade VALUES ('38', '21', '13', '三年级');

-- ----------------------------
-- Table structure for `grade_item`
-- ----------------------------
DROP TABLE IF EXISTS `grade_item`;
CREATE TABLE `grade_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `grade_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `grade_id` (`grade_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `grade_item_ibfk_1` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`),
  CONSTRAINT `grade_item_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_item
-- ----------------------------
INSERT INTO grade_item VALUES ('1', '36', '1');
INSERT INTO grade_item VALUES ('2', '36', '2');
INSERT INTO grade_item VALUES ('3', '37', '2');
INSERT INTO grade_item VALUES ('4', '38', '1');

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO item VALUES ('1', '身高');
INSERT INTO item VALUES ('2', '体重');

-- ----------------------------
-- Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `clas_id` int(11) DEFAULT NULL,
  `grade_id` int(11) DEFAULT NULL,
  `school_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `clas_id` (`clas_id`),
  KEY `grade_id` (`grade_id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `link_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `link_ibfk_2` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`),
  CONSTRAINT `link_ibfk_3` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`),
  CONSTRAINT `link_ibfk_4` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO link VALUES ('1', '1', '62', '36', '19');
INSERT INTO link VALUES ('2', '2', '63', '37', '20');
INSERT INTO link VALUES ('3', '3', '64', '38', '21');

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `score` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`),
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO result VALUES ('1', '1', '1', '23');
INSERT INTO result VALUES ('2', '2', '1', '42');
INSERT INTO result VALUES ('3', '1', '2', '12');
INSERT INTO result VALUES ('4', '2', '2', '12');
INSERT INTO result VALUES ('5', '1', '3', '33');
INSERT INTO result VALUES ('6', '2', '3', '12');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO role VALUES ('1', '12', null);
INSERT INTO role VALUES ('2', '22', null);
INSERT INTO role VALUES ('3', '23', null);

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xuexiaomingcheng',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xuexiaodizhi',
  `zipcode` int(11) DEFAULT NULL COMMENT 'youbian',
  `president` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xiaozhang',
  `tel` varchar(11) DEFAULT NULL COMMENT 'dianhua',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'youxiang',
  `schooltype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xuexiaoleixing',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO school VALUES ('19', '秦皇岛第一中学', '秦皇岛市河北大街1号', '66000', '陈一', '18332337167', '123456781@163.com', '小学');
INSERT INTO school VALUES ('20', '秦皇岛第二中学', '秦皇岛市河北大街2号', '66000', '陈二', '18332337168', '123456782@163.com', '小学');
INSERT INTO school VALUES ('21', '秦皇岛第三中学', '秦皇岛市河北大街3号', '66000', '陈三', '18332337169', '123456783@163.com', '初中');
INSERT INTO school VALUES ('22', '秦皇岛第四中学', '秦皇岛市河北大街4号', '66000', '陈四', '18332337170', '123456784@163.com', '初中');
INSERT INTO school VALUES ('23', '秦皇岛第五中学', '秦皇岛市河北大街5号', '66000', '陈五', '18332337171', '123456785@163.com', '高中');
INSERT INTO school VALUES ('24', '秦皇岛第五中学', '秦皇岛市河北大街6号', '66000', '陈六', '18332337172', '123456786@163.com', '高中');
INSERT INTO school VALUES ('25', '燕山大学', '秦皇岛市河北大街7号', '66000', '陈燕', '18332337173', '123456787@163.com', '大学');
INSERT INTO school VALUES ('26', '里仁学院', '秦皇岛市河北大街8号', '66000', '陈里', '18332337174', '123456788@163.com', '大学');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xingming',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xingbie',
  `birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'chushengriqi',
  `studentnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xuehao',
  `ethnic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'minzudaima',
  `personnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'shenfenzhenghao',
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'jiatingzhuzhi',
  `clas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clas_id` (`clas_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO student VALUES ('1', '白瑶瑶', '女', '2006.1.1', '001', '1', '1213', '1', '62');
INSERT INTO student VALUES ('2', '陈晨铭', '男', '2006.1.2', '002', '1', '1211', '2', '63');
INSERT INTO student VALUES ('3', '陈程翔', '男', '2006.1.3', '003', '2', '1222', '2', '64');
