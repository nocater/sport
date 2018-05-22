/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : sport

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-05-22 16:47:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `clas`
-- ----------------------------
DROP TABLE IF EXISTS `clas`;
CREATE TABLE `clas` (
  `id` int(11) NOT NULL,
  `num` int(11) DEFAULT NULL COMMENT 'banjibianma',
  `name` varchar(255) DEFAULT NULL COMMENT 'banjiming',
  `grade_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `grade_id` (`grade_id`),
  CONSTRAINT `clas_ibfk_1` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clas
-- ----------------------------

-- ----------------------------
-- Table structure for `cs`
-- ----------------------------
DROP TABLE IF EXISTS `cs`;
CREATE TABLE `cs` (
  `id` int(11) NOT NULL,
  `clas_id` int(11) DEFAULT NULL,
  `tc_id` int(11) DEFAULT NULL COMMENT 'ticebiao',
  `name` varchar(255) DEFAULT NULL COMMENT 'jiaoshiming',
  `time` varchar(255) DEFAULT NULL COMMENT 'ceshishijian',
  `place` varchar(255) DEFAULT NULL COMMENT 'ceshididian',
  `equipment` varchar(255) DEFAULT NULL COMMENT 'qicai',
  `mode` varchar(255) DEFAULT NULL COMMENT 'ceshifangshi',
  PRIMARY KEY (`id`),
  KEY `clas_id` (`clas_id`),
  KEY `tc_id` (`tc_id`),
  CONSTRAINT `cs_ibfk_1` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`),
  CONSTRAINT `cs_ibfk_2` FOREIGN KEY (`tc_id`) REFERENCES `tc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cs
-- ----------------------------

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `school_id` int(11) NOT NULL,
  `num` int(11) DEFAULT NULL COMMENT 'nianjibianma',
  `name` varchar(255) DEFAULT NULL COMMENT 'nianjiming',
  PRIMARY KEY (`id`),
  KEY `school_id` (`school_id`),
  CONSTRAINT `grade_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for `grade-tc`
-- ----------------------------
DROP TABLE IF EXISTS `grade-tc`;
CREATE TABLE `grade-tc` (
  `id` int(11) NOT NULL,
  `grade_id` int(11) NOT NULL,
  `tc_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `grade_id` (`grade_id`),
  KEY `tc_id` (`tc_id`),
  CONSTRAINT `grade-tc_ibfk_1` FOREIGN KEY (`grade_id`) REFERENCES `grade` (`id`),
  CONSTRAINT `grade-tc_ibfk_2` FOREIGN KEY (`tc_id`) REFERENCES `tc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade-tc
-- ----------------------------

-- ----------------------------
-- Table structure for `link`
-- ----------------------------
DROP TABLE IF EXISTS `link`;
CREATE TABLE `link` (
  `id` int(11) NOT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------

-- ----------------------------
-- Table structure for `result`
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL,
  `tc_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `score` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tc_id` (`tc_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`tc_id`) REFERENCES `tc` (`id`),
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'xuexiaomingcheng',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xuexiaodizhi',
  `zipcode` int(11) DEFAULT NULL COMMENT 'youbian',
  `president` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xiaozhang',
  `tel` int(11) DEFAULT NULL COMMENT 'dianhua',
  `e-mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'youxiang',
  `schooltype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xuexiaoleixing',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'xingming',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xingbie',
  `birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'chushengriqi',
  `studentnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'xuehao',
  `ethnic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'minzudaima',
  `personnum` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'shenfenzhenghao',
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'jiatingzhuzhi',
  `clas_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clas_id` (`clas_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for `tc`
-- ----------------------------
DROP TABLE IF EXISTS `tc`;
CREATE TABLE `tc` (
  `id` int(11) NOT NULL,
  `high` int(11) DEFAULT NULL COMMENT 'shengao',
  `weight` int(11) DEFAULT NULL COMMENT 'tizhong',
  `fhl` varchar(255) DEFAULT NULL COMMENT 'feihuoliang',
  `dp` varchar(255) DEFAULT NULL COMMENT '50mipao',
  `tqq` varchar(255) DEFAULT NULL COMMENT 'tiqianqu',
  `ts` varchar(255) DEFAULT NULL COMMENT 'tiaosheng',
  `ty` varchar(255) DEFAULT NULL COMMENT 'tiaoyuan',
  `ywqz` varchar(255) DEFAULT NULL COMMENT 'yangwoqizuo',
  `ytxs` varchar(255) DEFAULT NULL COMMENT 'yintixiangshang',
  `wfp` varchar(255) DEFAULT NULL COMMENT 'wangfanpao',
  `cp` varchar(255) DEFAULT NULL COMMENT '1000mi',
  `zcp` varchar(255) DEFAULT NULL COMMENT '800mi',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tc
-- ----------------------------
