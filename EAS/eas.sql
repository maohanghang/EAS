/*
SQLyog Ultimate v11.27 (32 bit)
MySQL - 5.5.53 : Database - eas
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eas` /*!40100 DEFAULT CHARACTER SET gb2312 */;

USE `eas`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `Ano` char(12) NOT NULL,
  `Aname` char(20) DEFAULT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Ano`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

/*Data for the table `admin` */

insert  into `admin`(`Ano`,`Aname`,`Password`) values ('201408010206','梁贻乐','123456');

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `Classno` char(6) NOT NULL,
  `TotalCredit` decimal(4,1) DEFAULT NULL,
  `Tno` char(6) DEFAULT NULL,
  `Dno` char(3) DEFAULT NULL,
  PRIMARY KEY (`Classno`),
  KEY `Tno` (`Tno`),
  KEY `Dno` (`Dno`),
  CONSTRAINT `class_ibfk_1` FOREIGN KEY (`Tno`) REFERENCES `teacher` (`Tno`),
  CONSTRAINT `class_ibfk_2` FOREIGN KEY (`Dno`) REFERENCES `department` (`Dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `class` */

insert  into `class`(`Classno`,`TotalCredit`,`Tno`,`Dno`) values ('jk1402','50.0','1001','001');

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `Cno` char(6) NOT NULL,
  `Cname` char(20) NOT NULL,
  `Credit` decimal(2,1) DEFAULT NULL,
  `Ctime` date DEFAULT NULL,
  `Cnum` smallint(6) DEFAULT NULL,
  `Tno` char(6) DEFAULT NULL,
  PRIMARY KEY (`Cno`),
  KEY `Tno` (`Tno`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`Tno`) REFERENCES `teacher` (`Tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`Cno`,`Cname`,`Credit`,`Ctime`,`Cnum`,`Tno`) values ('2001','C++','5.0','2014-09-30',50,'1001'),('2002','Math','4.0','2017-05-02',60,'1002'),('2003','Physical','5.0','2017-06-21',90,'1001'),('2004','C#','5.0','2017-06-01',50,'1001');

/*Table structure for table `department` */

DROP TABLE IF EXISTS `department`;

CREATE TABLE `department` (
  `Dno` char(3) NOT NULL,
  `Dept` char(20) NOT NULL,
  `Dphone` char(11) DEFAULT NULL,
  PRIMARY KEY (`Dno`),
  UNIQUE KEY `Dept` (`Dept`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `department` */

insert  into `department`(`Dno`,`Dept`,`Dphone`) values ('001','CS',NULL);

/*Table structure for table `sc` */

DROP TABLE IF EXISTS `sc`;

CREATE TABLE `sc` (
  `Sno` char(11) NOT NULL,
  `Cno` char(6) NOT NULL,
  `Grade` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`Sno`,`Cno`),
  KEY `Cno` (`Cno`),
  CONSTRAINT `sc_ibfk_1` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sc_ibfk_2` FOREIGN KEY (`Cno`) REFERENCES `course` (`Cno`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sc` */

insert  into `sc`(`Sno`,`Cno`,`Grade`) values ('20140801','2001',60),('20140801','2002',70),('20140802','2001',60),('20140802','2002',70);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `Sno` char(11) NOT NULL,
  `Sname` char(20) NOT NULL,
  `Ssex` char(2) DEFAULT NULL,
  `Sbirth` datetime DEFAULT NULL,
  `Classno` char(6) DEFAULT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`Sno`),
  KEY `Class` (`Classno`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Classno`) REFERENCES `class` (`Classno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`Sno`,`Sname`,`Ssex`,`Sbirth`,`Classno`,`Password`) values ('20140801','mhh','男','1993-05-04 00:00:00','jk1402','111111'),('20140802','maa','男','1994-05-04 00:00:00','jk1402','123456'),('20140803','毛航航','男','2014-08-01 00:00:00','jk1402','123456');

/*Table structure for table `teacher` */

DROP TABLE IF EXISTS `teacher`;

CREATE TABLE `teacher` (
  `Tno` char(6) NOT NULL,
  `Tname` char(20) NOT NULL,
  `Title` char(20) DEFAULT NULL,
  `Tel` char(11) DEFAULT NULL,
  `Dno` char(3) DEFAULT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`Tno`),
  KEY `Dno` (`Dno`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`Dno`) REFERENCES `department` (`Dno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `teacher` */

insert  into `teacher`(`Tno`,`Tname`,`Title`,`Tel`,`Dno`,`Password`) values ('1001','a',NULL,'12345678910','001','123456'),('1002','b',NULL,'11111111111','001','123456'),('1003','王东','教授','110','001','123456');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
