/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.17 : Database - ring
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ring` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ring`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `AdminId` int(11) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(128) DEFAULT NULL,
  `AdminPwd` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`AdminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`AdminId`,`AdminName`,`AdminPwd`) values (1,'Admin','Admin');

/*Table structure for table `buy` */

DROP TABLE IF EXISTS `buy`;

CREATE TABLE `buy` (
  `BuyId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `RingId` int(11) DEFAULT NULL,
  `OrderId` int(11) DEFAULT NULL,
  `BuyNum` int(11) DEFAULT NULL,
  `BuySize` int(11) DEFAULT NULL,
  `BuyStatus` int(11) DEFAULT '0',
  PRIMARY KEY (`BuyId`),
  KEY `FK_Reference_3` (`RingId`),
  KEY `FK_Reference_6` (`UserId`),
  KEY `FK_Reference_7` (`OrderId`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`RingId`) REFERENCES `ring` (`RingId`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`OrderId`) REFERENCES `orders` (`OrderId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `buy` */

insert  into `buy`(`BuyId`,`UserId`,`RingId`,`OrderId`,`BuyNum`,`BuySize`,`BuyStatus`) values (17,1,1,1,1,8,1),(20,1,1,1,5,10,1),(21,1,1,1,5,10,1),(22,1,1,1,1,10,1),(23,1,1,2,1,8,1),(24,1,1,2,3,11,1),(25,3,1,3,1,8,1),(29,5,1,3,3,10,1),(30,5,1,4,5,8,0),(32,1,1,4,1,9,1),(33,1,1,4,3,9,1),(35,3,6,5,3,17,1);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `CommentId` int(11) NOT NULL AUTO_INCREMENT,
  `RingId` int(11) DEFAULT NULL,
  `UserId` int(11) DEFAULT NULL,
  `Content` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`CommentId`),
  KEY `FK_Reference_1` (`RingId`),
  KEY `FK_Reference_2` (`UserId`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`RingId`) REFERENCES `ring` (`RingId`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`CommentId`,`RingId`,`UserId`,`Content`) values (1,1,1,'质量很好！'),(3,1,1,'大幅度'),(5,1,1,'功夫的三国杀的故事'),(6,2,1,'  shuaidiannaifdas ');

/*Table structure for table `newring` */

DROP TABLE IF EXISTS `newring`;

CREATE TABLE `newring` (
  `Newringid` int(11) NOT NULL AUTO_INCREMENT,
  `Price` int(11) DEFAULT NULL,
  `SaleNum` int(28) DEFAULT NULL,
  `Weight` varchar(58) DEFAULT NULL,
  `Color` varchar(58) DEFAULT NULL,
  `Clean` varchar(58) DEFAULT NULL,
  `Cut` varchar(58) DEFAULT NULL,
  `Quality` varchar(58) DEFAULT NULL,
  `Size` int(11) DEFAULT NULL,
  `RingImage` varchar(58) DEFAULT NULL,
  `CommentNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`Newringid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `newring` */

insert  into `newring`(`Newringid`,`Price`,`SaleNum`,`Weight`,`Color`,`Clean`,`Cut`,`Quality`,`Size`,`RingImage`,`CommentNum`) values (1,1000,0,'1g','White','clean','soft','good',12,'h10.png',0),(2,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(4,4000,2,'3g','4e','4e','4e','4e',14,'h13.jpg',0),(5,3000,3,'3g','black','good','lv','gh',6,'h3.jpg',3),(6,6000,3,'t','gg','hg','jh','jk',0,'h6.jpg',4),(7,4000,4,'3g','FFC','fg','hj','et',13,'h4.jpg',5),(8,3000,0,'1g','w','w','w','w',10,'h12.jpg',1),(9,1290,1,'3g','qer','qre','qre','qre',12,'h16.png',1),(10,5000,5,'4G','CC','DD','HG','dfh',8,'h5.jpg',4),(11,3000,3,'3g','black','good','lv','gh',6,'h3.jpg',3),(12,2000,3,'2g','yellow','bb','cc','dd',10,'h2.jpg',3),(13,6000,3,'t','gg','hg','jh','jk',0,'h6.jpg',4),(14,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(15,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(16,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(18,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(19,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(20,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(21,1000,0,'1g','White','clean','soft','good',12,'h10.png',0),(23,5000,5,'4G','CC','DD','HG','dfh',8,'h5.jpg',4);

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `OrderId` int(11) NOT NULL AUTO_INCREMENT,
  `UserId` int(11) DEFAULT NULL,
  `OrderAllPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderId`),
  KEY `FK_Reference_5` (`UserId`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`UserId`) REFERENCES `users` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`OrderId`,`UserId`,`OrderAllPrice`) values (1,1,1000),(2,2,250),(3,1,16000),(4,5,3000),(5,1,7000),(6,3,19000);

/*Table structure for table `ring` */

DROP TABLE IF EXISTS `ring`;

CREATE TABLE `ring` (
  `RingId` int(11) NOT NULL AUTO_INCREMENT,
  `Price` int(11) DEFAULT NULL,
  `SaleNum` int(28) DEFAULT NULL,
  `Weight` varchar(58) DEFAULT NULL,
  `Color` varchar(58) DEFAULT NULL,
  `Clean` varchar(58) DEFAULT NULL,
  `Cut` varchar(58) DEFAULT NULL,
  `Quality` varchar(58) DEFAULT NULL,
  `Size` int(11) DEFAULT NULL,
  `RingImage` varchar(58) DEFAULT NULL,
  `CommentNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`RingId`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `ring` */

insert  into `ring`(`RingId`,`Price`,`SaleNum`,`Weight`,`Color`,`Clean`,`Cut`,`Quality`,`Size`,`RingImage`,`CommentNum`) values (1,1000,2,'2g','White','aa','bb','cc',9,'h1.jpg',2),(2,2000,3,'2g','yellow','bb','cc','dd',10,'h2.jpg',3),(6,6000,3,'t','gg','hg','jh','jk',17,'h6.jpg',4),(13,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(16,2000,1,'2g','3w','3w','3w','3w',12,'h11.png',1),(17,5000,5,'4G','CC','DD','HG','dfh',8,'h5.jpg',4),(18,5000,5,'4G','CC','DD','HG','dfh',8,'h5.jpg',4),(19,4000,2,'3g','4e','4e','4e','4e',14,'h13.jpg',0),(20,4000,2,'3g','4e','4e','4e','4e',14,'h13.jpg',0);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(128) NOT NULL,
  `Pwd` varchar(128) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`UserId`,`UserName`,`Pwd`) values (1,'12','1'),(2,'123邱厚森','123123'),(3,'邱厚森','123'),(5,'邱厚森123','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
