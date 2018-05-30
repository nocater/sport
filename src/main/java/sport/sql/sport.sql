/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : sport

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-30 11:26:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
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
INSERT INTO `account` VALUES ('1', '1', 'cs', '陈帅', 'cs');
INSERT INTO `account` VALUES ('2', '2', 'bb', '兵兵', 'bb');

-- ----------------------------
-- Table structure for addscore
-- ----------------------------
DROP TABLE IF EXISTS `addscore`;
CREATE TABLE `addscore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `add` varchar(255) DEFAULT NULL,
  `standrad` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `addscore_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addscore
-- ----------------------------
INSERT INTO `addscore` VALUES ('1', '11', '20', '40');
INSERT INTO `addscore` VALUES ('2', '11', '19', '38');
INSERT INTO `addscore` VALUES ('3', '11', '18', '36');
INSERT INTO `addscore` VALUES ('4', '11', '17', '34');
INSERT INTO `addscore` VALUES ('5', '11', '16', '32');
INSERT INTO `addscore` VALUES ('6', '11', '15', '30');
INSERT INTO `addscore` VALUES ('7', '11', '14', '28');
INSERT INTO `addscore` VALUES ('8', '11', '13', '26');
INSERT INTO `addscore` VALUES ('9', '11', '12', '24');
INSERT INTO `addscore` VALUES ('10', '11', '11', '22');
INSERT INTO `addscore` VALUES ('11', '11', '10', '20');
INSERT INTO `addscore` VALUES ('12', '11', '9', '18');
INSERT INTO `addscore` VALUES ('13', '11', '8', '16');
INSERT INTO `addscore` VALUES ('14', '11', '7', '14');
INSERT INTO `addscore` VALUES ('15', '11', '6', '12');
INSERT INTO `addscore` VALUES ('16', '11', '5', '10');
INSERT INTO `addscore` VALUES ('17', '11', '4', '8');
INSERT INTO `addscore` VALUES ('18', '11', '3', '6');
INSERT INTO `addscore` VALUES ('19', '11', '2', '4');
INSERT INTO `addscore` VALUES ('20', '11', '1', '2');

-- ----------------------------
-- Table structure for clas
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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of clas
-- ----------------------------
INSERT INTO `clas` VALUES ('62', '11010', '1', '36');
INSERT INTO `clas` VALUES ('63', '11020', '2', '37');
INSERT INTO `clas` VALUES ('64', '1201', '1', '38');
INSERT INTO `clas` VALUES ('65', '1127', '27', '39');
INSERT INTO `clas` VALUES ('66', '1128', '28', '40');
INSERT INTO `clas` VALUES ('67', '4201', '1', '40');
INSERT INTO `clas` VALUES ('68', '4202', '2', '40');
INSERT INTO `clas` VALUES ('69', '4301', '1', '41');
INSERT INTO `clas` VALUES ('70', '4302', '2', '41');
INSERT INTO `clas` VALUES ('71', '4401', '1', '42');
INSERT INTO `clas` VALUES ('72', '4402', '2', '42');

-- ----------------------------
-- Table structure for criterion
-- ----------------------------
DROP TABLE IF EXISTS `criterion`;
CREATE TABLE `criterion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `grade_num` varchar(255) DEFAULT NULL,
  `standrad` varchar(255) DEFAULT NULL,
  `levl` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `criterion_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=161 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of criterion
-- ----------------------------
INSERT INTO `criterion` VALUES ('1', '11', '11', '109', '优秀', '100', '0');
INSERT INTO `criterion` VALUES ('2', '11', '11', '104', '优秀', '95', '0');
INSERT INTO `criterion` VALUES ('3', '11', '11', '99', '优秀', '90', '0');
INSERT INTO `criterion` VALUES ('4', '11', '11', '93', '良好', '85', '0');
INSERT INTO `criterion` VALUES ('5', '11', '11', '87', '良好', '80', '0');
INSERT INTO `criterion` VALUES ('6', '11', '11', '80', '及格', '78', '0');
INSERT INTO `criterion` VALUES ('7', '11', '11', '73', '及格', '76', '0');
INSERT INTO `criterion` VALUES ('8', '11', '11', '66', '及格', '74', '0');
INSERT INTO `criterion` VALUES ('9', '11', '11', '59', '及格', '72', '0');
INSERT INTO `criterion` VALUES ('10', '11', '11', '52', '及格', '70', '0');
INSERT INTO `criterion` VALUES ('11', '11', '11', '45', '及格', '68', '0');
INSERT INTO `criterion` VALUES ('12', '11', '11', '38', '及格', '66', '0');
INSERT INTO `criterion` VALUES ('13', '11', '11', '31', '及格', '64', '0');
INSERT INTO `criterion` VALUES ('14', '11', '11', '24', '及格', '62', '0');
INSERT INTO `criterion` VALUES ('15', '11', '11', '17', '及格', '60', '0');
INSERT INTO `criterion` VALUES ('16', '11', '11', '14', '不及格', '50', '0');
INSERT INTO `criterion` VALUES ('17', '11', '11', '11', '不及格', '40', '0');
INSERT INTO `criterion` VALUES ('18', '11', '11', '8', '不及格', '30', '0');
INSERT INTO `criterion` VALUES ('19', '11', '11', '5', '不及格', '20', '0');
INSERT INTO `criterion` VALUES ('20', '11', '11', '2', '不及格', '10', '0');
INSERT INTO `criterion` VALUES ('21', '11', '11', '117', '优秀', '100', '1');
INSERT INTO `criterion` VALUES ('22', '11', '11', '110', '优秀', '95', '1');
INSERT INTO `criterion` VALUES ('23', '11', '11', '103', '优秀', '90', '1');
INSERT INTO `criterion` VALUES ('24', '11', '11', '95', '良好', '85', '1');
INSERT INTO `criterion` VALUES ('25', '11', '11', '87', '良好', '80', '1');
INSERT INTO `criterion` VALUES ('26', '11', '11', '80', '及格', '78', '1');
INSERT INTO `criterion` VALUES ('27', '11', '11', '73', '及格', '76', '1');
INSERT INTO `criterion` VALUES ('28', '11', '11', '66', '及格', '74', '1');
INSERT INTO `criterion` VALUES ('29', '11', '11', '59', '及格', '72', '1');
INSERT INTO `criterion` VALUES ('30', '11', '11', '52', '及格', '70', '1');
INSERT INTO `criterion` VALUES ('31', '11', '11', '45', '及格', '68', '1');
INSERT INTO `criterion` VALUES ('32', '11', '11', '38', '及格', '66', '1');
INSERT INTO `criterion` VALUES ('33', '11', '11', '31', '及格', '64', '1');
INSERT INTO `criterion` VALUES ('34', '11', '11', '24', '及格', '62', '1');
INSERT INTO `criterion` VALUES ('35', '11', '11', '17', '及格', '60', '1');
INSERT INTO `criterion` VALUES ('36', '11', '11', '14', '不及格', '50', '1');
INSERT INTO `criterion` VALUES ('37', '11', '11', '11', '不及格', '40', '1');
INSERT INTO `criterion` VALUES ('38', '11', '11', '8', '不及格', '30', '1');
INSERT INTO `criterion` VALUES ('39', '11', '11', '5', '不及格', '20', '1');
INSERT INTO `criterion` VALUES ('40', '11', '11', '2', '不及格', '10', '1');
INSERT INTO `criterion` VALUES ('41', '14', '11', '225', '优秀', '100', '0');
INSERT INTO `criterion` VALUES ('42', '14', '11', '218', '优秀', '95', '0');
INSERT INTO `criterion` VALUES ('43', '14', '11', '211', '优秀', '90', '0');
INSERT INTO `criterion` VALUES ('44', '14', '11', '203', '良好', '85', '0');
INSERT INTO `criterion` VALUES ('45', '14', '11', '195', '良好', '80', '0');
INSERT INTO `criterion` VALUES ('46', '14', '11', '191', '及格', '78', '0');
INSERT INTO `criterion` VALUES ('47', '14', '11', '187', '及格', '76', '0');
INSERT INTO `criterion` VALUES ('48', '14', '11', '183', '及格', '74', '0');
INSERT INTO `criterion` VALUES ('49', '14', '11', '179', '及格', '72', '0');
INSERT INTO `criterion` VALUES ('50', '14', '11', '175', '及格', '70', '0');
INSERT INTO `criterion` VALUES ('51', '14', '11', '171', '及格', '68', '0');
INSERT INTO `criterion` VALUES ('52', '14', '11', '167', '及格', '66', '0');
INSERT INTO `criterion` VALUES ('53', '14', '11', '163', '及格', '64', '0');
INSERT INTO `criterion` VALUES ('54', '14', '11', '159', '及格', '62', '0');
INSERT INTO `criterion` VALUES ('55', '14', '11', '155', '及格', '60', '0');
INSERT INTO `criterion` VALUES ('56', '14', '11', '150', '不及格', '50', '0');
INSERT INTO `criterion` VALUES ('57', '14', '11', '145', '不及格', '40', '0');
INSERT INTO `criterion` VALUES ('58', '14', '11', '140', '不及格', '30', '0');
INSERT INTO `criterion` VALUES ('59', '14', '11', '135', '不及格', '20', '0');
INSERT INTO `criterion` VALUES ('60', '14', '11', '130', '不及格', '10', '0');
INSERT INTO `criterion` VALUES ('61', '14', '11', '196', '优秀', '100', '1');
INSERT INTO `criterion` VALUES ('62', '14', '11', '190', '优秀', '95', '1');
INSERT INTO `criterion` VALUES ('63', '14', '11', '184', '优秀', '90', '1');
INSERT INTO `criterion` VALUES ('64', '14', '11', '177', '良好', '85', '1');
INSERT INTO `criterion` VALUES ('65', '14', '11', '170', '良好', '80', '1');
INSERT INTO `criterion` VALUES ('66', '14', '11', '167', '及格', '78', '1');
INSERT INTO `criterion` VALUES ('67', '14', '11', '164', '及格', '76', '1');
INSERT INTO `criterion` VALUES ('68', '14', '11', '161', '及格', '74', '1');
INSERT INTO `criterion` VALUES ('69', '14', '11', '158', '及格', '72', '1');
INSERT INTO `criterion` VALUES ('70', '14', '11', '155', '及格', '70', '1');
INSERT INTO `criterion` VALUES ('71', '14', '11', '152', '及格', '68', '1');
INSERT INTO `criterion` VALUES ('72', '14', '11', '149', '及格', '66', '1');
INSERT INTO `criterion` VALUES ('73', '14', '11', '146', '及格', '64', '1');
INSERT INTO `criterion` VALUES ('74', '14', '11', '143', '及格', '62', '1');
INSERT INTO `criterion` VALUES ('75', '14', '11', '140', '及格', '60', '1');
INSERT INTO `criterion` VALUES ('76', '14', '11', '135', '不及格', '50', '1');
INSERT INTO `criterion` VALUES ('77', '14', '11', '130', '不及格', '40', '1');
INSERT INTO `criterion` VALUES ('78', '14', '11', '125', '不及格', '30', '1');
INSERT INTO `criterion` VALUES ('79', '14', '11', '120', '不及格', '20', '1');
INSERT INTO `criterion` VALUES ('80', '14', '11', '115', '不及格', '10', '1');
INSERT INTO `criterion` VALUES ('81', '5', '11', '1700', '优秀', '100', '0');
INSERT INTO `criterion` VALUES ('82', '5', '11', '1600', '优秀', '95', '0');
INSERT INTO `criterion` VALUES ('83', '5', '11', '1500', '优秀', '90', '0');
INSERT INTO `criterion` VALUES ('84', '5', '11', '1400', '良好', '85', '0');
INSERT INTO `criterion` VALUES ('85', '5', '11', '1300', '良好', '80', '0');
INSERT INTO `criterion` VALUES ('86', '5', '11', '1240', '及格', '78', '0');
INSERT INTO `criterion` VALUES ('87', '5', '11', '1180', '及格', '76', '0');
INSERT INTO `criterion` VALUES ('88', '5', '11', '1120', '及格', '74', '0');
INSERT INTO `criterion` VALUES ('89', '5', '11', '1060', '及格', '72', '0');
INSERT INTO `criterion` VALUES ('90', '5', '11', '1000', '及格', '70', '0');
INSERT INTO `criterion` VALUES ('91', '5', '11', '940', '及格', '68', '0');
INSERT INTO `criterion` VALUES ('92', '5', '11', '880', '及格', '66', '0');
INSERT INTO `criterion` VALUES ('93', '5', '11', '820', '及格', '64', '0');
INSERT INTO `criterion` VALUES ('94', '5', '11', '760', '及格', '62', '0');
INSERT INTO `criterion` VALUES ('95', '5', '11', '700', '及格', '60', '0');
INSERT INTO `criterion` VALUES ('96', '5', '11', '660', '不及格', '50', '0');
INSERT INTO `criterion` VALUES ('97', '5', '11', '620', '不及格', '40', '0');
INSERT INTO `criterion` VALUES ('98', '5', '11', '580', '不及格', '30', '0');
INSERT INTO `criterion` VALUES ('99', '5', '11', '540', '不及格', '20', '0');
INSERT INTO `criterion` VALUES ('100', '5', '11', '500', '不及格', '10', '0');
INSERT INTO `criterion` VALUES ('101', '5', '11', '1400', '优秀', '100', '1');
INSERT INTO `criterion` VALUES ('102', '5', '11', '1300', '优秀', '95', '1');
INSERT INTO `criterion` VALUES ('103', '5', '11', '1200', '优秀', '90', '1');
INSERT INTO `criterion` VALUES ('104', '5', '11', '1100', '良好', '85', '1');
INSERT INTO `criterion` VALUES ('105', '5', '11', '1000', '良好', '80', '1');
INSERT INTO `criterion` VALUES ('106', '5', '11', '960', '及格', '78', '1');
INSERT INTO `criterion` VALUES ('107', '5', '11', '920', '及格', '76', '1');
INSERT INTO `criterion` VALUES ('108', '5', '11', '880', '及格', '74', '1');
INSERT INTO `criterion` VALUES ('109', '5', '11', '840', '及格', '72', '1');
INSERT INTO `criterion` VALUES ('110', '5', '11', '800', '及格', '70', '1');
INSERT INTO `criterion` VALUES ('111', '5', '11', '760', '及格', '68', '1');
INSERT INTO `criterion` VALUES ('112', '5', '11', '720', '及格', '66', '1');
INSERT INTO `criterion` VALUES ('113', '5', '11', '680', '及格', '64', '1');
INSERT INTO `criterion` VALUES ('114', '5', '11', '640', '及格', '62', '1');
INSERT INTO `criterion` VALUES ('115', '5', '11', '600', '及格', '60', '1');
INSERT INTO `criterion` VALUES ('116', '5', '11', '580', '不及格', '50', '1');
INSERT INTO `criterion` VALUES ('117', '5', '11', '560', '不及格', '40', '1');
INSERT INTO `criterion` VALUES ('118', '5', '11', '540', '不及格', '30', '1');
INSERT INTO `criterion` VALUES ('119', '5', '11', '520', '不及格', '20', '1');
INSERT INTO `criterion` VALUES ('120', '5', '11', '500', '不及格', '10', '1');
INSERT INTO `criterion` VALUES ('121', '7', '11', '10.2', '优秀', '100', '0');
INSERT INTO `criterion` VALUES ('122', '7', '11', '10.3', '优秀', '95', '0');
INSERT INTO `criterion` VALUES ('123', '7', '11', '10.4', '优秀', '90', '0');
INSERT INTO `criterion` VALUES ('124', '7', '11', '10.5', '良好', '85', '0');
INSERT INTO `criterion` VALUES ('125', '7', '11', '10.6', '良好', '80', '0');
INSERT INTO `criterion` VALUES ('126', '7', '11', '10.8', '及格', '78', '0');
INSERT INTO `criterion` VALUES ('127', '7', '11', '11', '及格', '76', '0');
INSERT INTO `criterion` VALUES ('128', '7', '11', '11.2', '及格', '74', '0');
INSERT INTO `criterion` VALUES ('129', '7', '11', '11.4', '及格', '72', '0');
INSERT INTO `criterion` VALUES ('130', '7', '11', '11.6', '及格', '70', '0');
INSERT INTO `criterion` VALUES ('131', '7', '11', '11.8', '及格', '68', '0');
INSERT INTO `criterion` VALUES ('132', '7', '11', '12', '及格', '66', '0');
INSERT INTO `criterion` VALUES ('133', '7', '11', '12.2', '及格', '64', '0');
INSERT INTO `criterion` VALUES ('134', '7', '11', '12.4', '及格', '62', '0');
INSERT INTO `criterion` VALUES ('135', '7', '11', '12.6', '及格', '60', '0');
INSERT INTO `criterion` VALUES ('136', '7', '11', '12.8', '不及格', '50', '0');
INSERT INTO `criterion` VALUES ('137', '7', '11', '13', '不及格', '40', '0');
INSERT INTO `criterion` VALUES ('138', '7', '11', '13.2', '不及格', '30', '0');
INSERT INTO `criterion` VALUES ('139', '7', '11', '13.4', '不及格', '20', '0');
INSERT INTO `criterion` VALUES ('140', '7', '11', '13.6', '不及格', '10', '0');
INSERT INTO `criterion` VALUES ('141', '7', '11', '11', '优秀', '100', '1');
INSERT INTO `criterion` VALUES ('142', '7', '11', '11.1', '优秀', '95', '1');
INSERT INTO `criterion` VALUES ('143', '7', '11', '11.2', '优秀', '90', '1');
INSERT INTO `criterion` VALUES ('144', '7', '11', '11.5', '良好', '85', '1');
INSERT INTO `criterion` VALUES ('145', '7', '11', '11.8', '良好', '80', '1');
INSERT INTO `criterion` VALUES ('146', '7', '11', '12', '及格', '78', '1');
INSERT INTO `criterion` VALUES ('147', '7', '11', '12.2', '及格', '76', '1');
INSERT INTO `criterion` VALUES ('148', '7', '11', '12.4', '及格', '74', '1');
INSERT INTO `criterion` VALUES ('149', '7', '11', '12.6', '及格', '72', '1');
INSERT INTO `criterion` VALUES ('150', '7', '11', '12.8', '及格', '70', '1');
INSERT INTO `criterion` VALUES ('151', '7', '11', '13', '及格', '68', '1');
INSERT INTO `criterion` VALUES ('152', '7', '11', '13.2', '及格', '66', '1');
INSERT INTO `criterion` VALUES ('153', '7', '11', '13.4', '及格', '64', '1');
INSERT INTO `criterion` VALUES ('154', '7', '11', '13.6', '及格', '62', '1');
INSERT INTO `criterion` VALUES ('155', '7', '11', '13.8', '及格', '60', '1');
INSERT INTO `criterion` VALUES ('156', '7', '11', '14', '不及格', '50', '1');
INSERT INTO `criterion` VALUES ('157', '7', '11', '14.2', '不及格', '40', '1');
INSERT INTO `criterion` VALUES ('158', '7', '11', '14.4', '不及格', '30', '1');
INSERT INTO `criterion` VALUES ('159', '7', '11', '14.6', '不及格', '20', '1');
INSERT INTO `criterion` VALUES ('160', '7', '11', '14.8', '不及格', '10', '1');

-- ----------------------------
-- Table structure for env
-- ----------------------------
DROP TABLE IF EXISTS `env`;
CREATE TABLE `env` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clas_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL COMMENT 'ticebiao',
  `name` varchar(255) DEFAULT NULL COMMENT 'jiaoshiming',
  `dater` date DEFAULT NULL COMMENT 'ceshishijian',
  `place` varchar(255) DEFAULT NULL COMMENT 'ceshididian',
  `equipment` varchar(255) DEFAULT NULL COMMENT 'qicai',
  `mode` varchar(255) DEFAULT NULL COMMENT 'ceshifangshi',
  PRIMARY KEY (`id`),
  KEY `clas_id` (`clas_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `env_ibfk_1` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`),
  CONSTRAINT `env_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of env
-- ----------------------------
INSERT INTO `env` VALUES ('24', '65', '11', '12', null, null, null, null);
INSERT INTO `env` VALUES ('25', '66', '11', '12', null, null, null, null);

-- ----------------------------
-- Table structure for grade
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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('36', '19', '110', '大一');
INSERT INTO `grade` VALUES ('37', '20', '12', '二年级');
INSERT INTO `grade` VALUES ('38', '21', '13', '三年级');
INSERT INTO `grade` VALUES ('39', '25', '11', '一年级');
INSERT INTO `grade` VALUES ('40', '25', '42', '大二');
INSERT INTO `grade` VALUES ('41', '25', '43', '大三');
INSERT INTO `grade` VALUES ('42', '25', '44', '大四');

-- ----------------------------
-- Table structure for grade_item
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
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade_item
-- ----------------------------
INSERT INTO `grade_item` VALUES ('1', '39', '11');
INSERT INTO `grade_item` VALUES ('13', '40', '5');
INSERT INTO `grade_item` VALUES ('14', '39', '5');
INSERT INTO `grade_item` VALUES ('15', '39', '7');
INSERT INTO `grade_item` VALUES ('16', '39', '14');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('1', '身高');
INSERT INTO `item` VALUES ('2', '体重');
INSERT INTO `item` VALUES ('5', '肺活量');
INSERT INTO `item` VALUES ('7', '50米跑');
INSERT INTO `item` VALUES ('9', '坐位体前曲');
INSERT INTO `item` VALUES ('11', '一分钟跳绳');
INSERT INTO `item` VALUES ('13', '引体向上');
INSERT INTO `item` VALUES ('14', '立定跳远');
INSERT INTO `item` VALUES ('16', '仰卧起坐');
INSERT INTO `item` VALUES ('17', '800米');
INSERT INTO `item` VALUES ('18', '1000米');

-- ----------------------------
-- Table structure for link
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of link
-- ----------------------------
INSERT INTO `link` VALUES ('1', '1', '65', '39', '25');
INSERT INTO `link` VALUES ('2', '1', '66', '39', '25');
INSERT INTO `link` VALUES ('3', '1', '67', '40', '25');
INSERT INTO `link` VALUES ('4', '1', '68', '40', '25');

-- ----------------------------
-- Table structure for result
-- ----------------------------
DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `score` varchar(255) DEFAULT NULL,
  `term` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `item_id` (`item_id`),
  KEY `student_id` (`student_id`),
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `result_ibfk_3` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of result
-- ----------------------------
INSERT INTO `result` VALUES ('1', '11', '1', '109', '1', null);
INSERT INTO `result` VALUES ('5', '11', '2', '93', '1', null);
INSERT INTO `result` VALUES ('8', '11', '3', '80', '1', null);
INSERT INTO `result` VALUES ('11', '11', '4', '14', '1', null);
INSERT INTO `result` VALUES ('50', '11', '5', '116', '1', null);
INSERT INTO `result` VALUES ('51', '11', '6', '50', '1', null);
INSERT INTO `result` VALUES ('52', '11', '1', '121', '2', null);
INSERT INTO `result` VALUES ('53', '11', '2', '87', '2', null);
INSERT INTO `result` VALUES ('54', '11', '3', '93', '2', null);
INSERT INTO `result` VALUES ('55', '11', '4', '67', '2', null);
INSERT INTO `result` VALUES ('56', '11', '5', '70', '2', null);
INSERT INTO `result` VALUES ('57', '11', '6', '88', '2', null);
INSERT INTO `result` VALUES ('58', '14', '1', '230', '1', null);
INSERT INTO `result` VALUES ('59', '14', '2', '200', '1', null);
INSERT INTO `result` VALUES ('60', '14', '3', '185', '1', null);
INSERT INTO `result` VALUES ('61', '14', '4', '200', '1', null);
INSERT INTO `result` VALUES ('62', '14', '5', '168', '1', null);
INSERT INTO `result` VALUES ('63', '14', '6', '120', '1', null);
INSERT INTO `result` VALUES ('64', '14', '1', '220', '2', null);
INSERT INTO `result` VALUES ('65', '14', '2', '230', '2', null);
INSERT INTO `result` VALUES ('66', '14', '3', '180', '2', null);
INSERT INTO `result` VALUES ('67', '14', '4', '210', '2', null);
INSERT INTO `result` VALUES ('68', '14', '5', '170', '2', null);
INSERT INTO `result` VALUES ('69', '14', '6', '130', '2', null);
INSERT INTO `result` VALUES ('70', '5', '1', '1700', '1', null);
INSERT INTO `result` VALUES ('71', '5', '2', '1400', '1', null);
INSERT INTO `result` VALUES ('72', '5', '3', '1100', '1', null);
INSERT INTO `result` VALUES ('73', '5', '4', '1400', '1', null);
INSERT INTO `result` VALUES ('74', '5', '5', '1100', '1', null);
INSERT INTO `result` VALUES ('75', '5', '6', '960', '1', null);
INSERT INTO `result` VALUES ('76', '5', '1', '1800', '2', null);
INSERT INTO `result` VALUES ('77', '5', '2', '1500', '2', null);
INSERT INTO `result` VALUES ('78', '5', '3', '1200', '2', null);
INSERT INTO `result` VALUES ('79', '5', '4', '1500', '2', null);
INSERT INTO `result` VALUES ('80', '5', '5', '1200', '2', null);
INSERT INTO `result` VALUES ('81', '5', '6', '980', '2', null);
INSERT INTO `result` VALUES ('82', '7', '1', '10.1', '1', null);
INSERT INTO `result` VALUES ('83', '7', '2', '11.3', '1', null);
INSERT INTO `result` VALUES ('84', '7', '3', '11.8', '1', null);
INSERT INTO `result` VALUES ('85', '7', '4', '11.1', '1', null);
INSERT INTO `result` VALUES ('86', '7', '5', '11.2', '1', null);
INSERT INTO `result` VALUES ('87', '7', '6', '12.9', '1', null);
INSERT INTO `result` VALUES ('88', '7', '1', '10.5', '2', null);
INSERT INTO `result` VALUES ('89', '7', '2', '11.2', '2', null);
INSERT INTO `result` VALUES ('90', '7', '3', '11.5', '2', null);
INSERT INTO `result` VALUES ('91', '7', '4', '11.3', '2', null);
INSERT INTO `result` VALUES ('92', '7', '5', '11.5', '2', null);
INSERT INTO `result` VALUES ('93', '7', '6', '12.5', '2', null);

-- ----------------------------
-- Table structure for role
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
INSERT INTO `role` VALUES ('1', '秦皇小学管理员', null);
INSERT INTO `role` VALUES ('2', '燕大管理员', null);
INSERT INTO `role` VALUES ('3', 'XX高校管理员', null);

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'xuexiaomingcheng',
  `address` varchar(255) DEFAULT NULL COMMENT 'xuexiaodizhi',
  `zipcode` int(11) DEFAULT NULL COMMENT 'youbian',
  `president` varchar(255) DEFAULT NULL COMMENT 'xiaozhang',
  `tel` varchar(11) DEFAULT NULL COMMENT 'dianhua',
  `email` varchar(255) DEFAULT NULL COMMENT 'youxiang',
  `schooltype` varchar(255) DEFAULT NULL COMMENT 'xuexiaoleixing',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('19', '秦皇岛第一中学', '秦皇岛市河北大街1号', '66000', '陈一', '18332337167', '123456781@163.com', '小学');
INSERT INTO `school` VALUES ('20', '秦皇岛第二中学', '秦皇岛市河北大街2号', '66000', '陈二', '18332337168', '123456782@163.com', '小学');
INSERT INTO `school` VALUES ('21', '秦皇岛第三中学', '秦皇岛市河北大街3号', '66000', '陈三', '18332337169', '123456783@163.com', '初中');
INSERT INTO `school` VALUES ('22', '秦皇岛第四中学', '秦皇岛市河北大街4号', '66000', '陈四', '18332337170', '123456784@163.com', '初中');
INSERT INTO `school` VALUES ('23', '秦皇岛第五中学', '秦皇岛市河北大街5号', '66000', '陈五', '18332337171', '123456785@163.com', '高中');
INSERT INTO `school` VALUES ('24', '秦皇岛第五中学', '秦皇岛市河北大街6号', '66000', '陈六', '18332337172', '123456786@163.com', '高中');
INSERT INTO `school` VALUES ('25', '燕山大学', '秦皇岛市河北大街7号', '66000', '陈燕', '18332337173', '123456787@163.com', '大学');
INSERT INTO `school` VALUES ('26', '里仁学院', '秦皇岛市河北大街8号', '66000', '陈里', '18332337174', '123456788@163.com', '大学');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT 'xingming',
  `sex` varchar(255) DEFAULT NULL COMMENT 'xingbie',
  `birth` date DEFAULT NULL COMMENT 'chushengriqi',
  `studentnum` varchar(255) DEFAULT NULL COMMENT 'xuehao',
  `ethnic` varchar(255) DEFAULT NULL COMMENT 'minzudaima',
  `personnum` varchar(255) DEFAULT NULL COMMENT 'shenfenzhenghao',
  `adress` varchar(255) DEFAULT NULL COMMENT 'jiatingzhuzhi',
  `clas_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `clas_id` (`clas_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`clas_id`) REFERENCES `clas` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '白瑶瑶', '男', '2006-01-01', '001', '1', '1213', '1', '65');
INSERT INTO `student` VALUES ('2', '陈晨铭', '男', '2006-01-02', '002', '1', '1211', '2', '65');
INSERT INTO `student` VALUES ('3', '陈程翔', '男', '2006-01-03', '003', '2', '1222', '2', '65');
INSERT INTO `student` VALUES ('4', '朱静', '女', '2006-01-01', '004', '1', '1215', '3', '65');
INSERT INTO `student` VALUES ('5', '张三', '女', '2004-01-23', '005', '1', '1234', '1', '65');
INSERT INTO `student` VALUES ('6', '张四', '女', '2005-01-01', '006', '1', '1233', '1', '65');
INSERT INTO `student` VALUES ('7', '李三', '女', '2006-01-06', '007', '1', '1123', '1', '66');
INSERT INTO `student` VALUES ('8', '李四', '女', '2006-02-21', '008', '1', '1345', '1', '66');
INSERT INTO `student` VALUES ('9', '张五', '女', '2004-04-04', '009', '1', '1456', '1', '67');
INSERT INTO `student` VALUES ('10', '张六', '男', '2004-03-05', '010', '1', '1236', '1', '67');
INSERT INTO `student` VALUES ('11', '李五', '男', '2004-02-08', '011', '1', '1346', '1', '67');
INSERT INTO `student` VALUES ('12', '李六', '男', '2004-05-09', '012', '1', '2134', '1', '67');
INSERT INTO `student` VALUES ('13', '张七', '男', '2003-02-03', '013', '1', '1093', '1', '68');
INSERT INTO `student` VALUES ('14', '张八', '男', '2003-09-09', '014', '1', '5423', '1', '68');
INSERT INTO `student` VALUES ('15', '李七', '女', '2003-12-12', '015', '1', '2321', '1', '68');
INSERT INTO `student` VALUES ('16', '李八', '女', '2003-04-05', '016', '1', '4321', '1', '68');
