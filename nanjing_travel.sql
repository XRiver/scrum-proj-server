/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.5.15 : Database - nanjing_travel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nanjing_travel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nanjing_travel`;

/*Table structure for table `attraction` */

DROP TABLE IF EXISTS `attraction`;

CREATE TABLE `attraction` (
  `aId` int(11) NOT NULL AUTO_INCREMENT,
  `aName` varchar(50) DEFAULT NULL COMMENT '景点名字',
  `location` varchar(100) DEFAULT NULL COMMENT '景点位置',
  `pictureUrl` varchar(200) DEFAULT NULL COMMENT '景点图片url',
  `description` varchar(200) DEFAULT NULL COMMENT '对景点的描述',
  PRIMARY KEY (`aId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='景点信息';

/*Data for the table `attraction` */

insert  into `attraction`(`aId`,`aName`,`location`,`pictureUrl`,`description`) values 
(1,'夫子庙','南京市秦淮区贡院西街53号',NULL,'夫子庙是个好地方'),
(2,'中山陵','南京市玄武区石象路7号',NULL,'中山陵是个好地方'),
(3,'总统府','南京市玄武区长江路292号',NULL,'总统府是个好地方'),
(4,'明孝陵','南京市玄武区长江路292号',NULL,'明孝陵是个好地方'),
(5,'玄武湖公园','南京市玄武区玄武巷1号',NULL,'玄武湖是个好地方'),
(6,'南京博物院','南京市玄武区中山东路321号',NULL,'博物院是个好地方'),
(7,'雨花台','南京市雨花台区雨花路215号',NULL,'雨花台是个好地方'),
(8,'钟山风景区','南京市玄武区石象路7号',NULL,'中山风景区是个好地方');

/*Table structure for table `plan` */

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `creatorName` varchar(50) DEFAULT NULL COMMENT '计划创建者姓名',
  `aName` varchar(50) DEFAULT NULL COMMENT '景点名字',
  `travelTime` date DEFAULT NULL COMMENT '出行时间',
  `detail` varchar(200) DEFAULT NULL COMMENT '备注',
  `applyList` varchar(200) DEFAULT NULL COMMENT '申请加入者的ID列表',
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出行计划信息';

/*Data for the table `plan` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(50) DEFAULT NULL COMMENT '微信身份标识',
  `uName` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `school` varchar(100) DEFAULT NULL COMMENT '用户所在高校',
  `pictureUrl` varchar(100) DEFAULT NULL COMMENT '用户头像url',
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户信息';

/*Data for the table `user` */

insert  into `user`(`uId`,`openId`,`uName`,`school`,`pictureUrl`) values 
(1,'111','张三','南京大学','/root/picture/111');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
