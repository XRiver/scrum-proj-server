/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.6.42 : Database - nanjing_travel
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

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `applyid` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '申请加入者的openid',
  `pid` int(11) DEFAULT NULL COMMENT '申请加入的景点pid',
  `mess` varchar(200) DEFAULT NULL COMMENT '申请者的留言',
  PRIMARY KEY (`applyid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='申请信息';

/*Data for the table `apply` */

insert  into `apply`(`applyid`,`openid`,`pid`,`mess`) values 
(1,'007',3,'take me away~'),
(2,'007',6,'take me away~'),
(3,'111',6,'take me away~'),
(4,'111',3,NULL),
(5,'111',3,NULL),
(6,'112',3,NULL),
(20,'112',3,NULL),
(21,'88888888',3,NULL);

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
  `openId` varchar(50) DEFAULT NULL COMMENT '计划创建者微信标识号',
  `aId` varchar(50) DEFAULT NULL COMMENT '景点编号',
  `travelTime` date DEFAULT NULL COMMENT '出行时间',
  `detail` varchar(200) DEFAULT NULL COMMENT '备注',
  `applyList` varchar(200) DEFAULT NULL COMMENT '申请加入者的ID列表',
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='出行计划信息';

/*Data for the table `plan` */

insert  into `plan`(`pId`,`openId`,`aId`,`travelTime`,`detail`,`applyList`) values 
(1,'111','1','2019-01-01','come on guys!!!','007,111,112,'),
(2,'2','2','2019-01-31','please join us!!!','111,007,'),
(3,'88888888','3','2019-02-28',NULL,'112,88888888,'),
(8,'88888888','5',NULL,NULL,NULL);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(50) DEFAULT NULL COMMENT '微信身份标识',
  `uName` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `school` varchar(100) DEFAULT NULL COMMENT '用户所在高校',
  `pictureUrl` text COMMENT '用户头像url',
  `sex` enum('男','女') DEFAULT NULL COMMENT '性别',
  `nickName` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `city` varchar(50) DEFAULT NULL COMMENT '用户所在城市',
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户信息';

/*Data for the table `user` */

insert  into `user`(`uId`,`openId`,`uName`,`school`,`pictureUrl`,`sex`,`nickName`,`city`) values 
(1,'111','张三','南京大学','/root/picture/111','男','小三','南京'),
(2,'1','劫','河海大学','/root/picture/112','男','影流之主','纽约'),
(3,'007','JamesBund','HaFo','www.halliwood','男','特工','Samfromsisco'),
(4,'11',NULL,NULL,NULL,'女',NULL,NULL),
(5,'o9VBV4x48dxVHVXeozv_jKb9MQHE','徐江河','南京大学','https://wx.qlogo.cn/mmopen/vi_32/fcnvXSfjbaib862WeK7ibia442aSU1TqdEfOKs45I22TuIQmgNrzAGAibhG7g0pibHGwTE3ZEniaUGZf8Xia0YJlkYaEw/132','男',NULL,'Zibo'),
(6,'19960305','刘正元',NULL,NULL,NULL,NULL,NULL),
(7,'88888888','张三','金陵学院','/root/jinling','男','dasan','nanjing');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
