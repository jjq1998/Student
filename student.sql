-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: student
-- ------------------------------------------------------
-- Server version	5.7.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academy`
--

DROP TABLE IF EXISTS `academy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academy` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(200) NOT NULL,
  `tel` varchar(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academy`
--

LOCK TABLES `academy` WRITE;
/*!40000 ALTER TABLE `academy` DISABLE KEYS */;
INSERT INTO `academy` VALUES (1,'国际文化教育学院','黑大A区','123456789'),(2,'计算机学院','黑大C区','123456789'),(3,'软件学院','黑大C区','123456789');
/*!40000 ALTER TABLE `academy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(5) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin','admin'),(2,'学生','123456','123456'),(3,'老师','t123456','123456');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL,
  `credit` int(1) NOT NULL,
  `hours` int(2) NOT NULL,
  `type` enum('必修','选修') NOT NULL DEFAULT '必修',
  `term` enum('上半学期','下半学期') DEFAULT NULL,
  `t_id` int(11) NOT NULL,
  `a_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_course_academy` (`a_id`),
  KEY `fk_c_teacher` (`t_id`),
  CONSTRAINT `fk_c_teacher` FOREIGN KEY (`t_id`) REFERENCES `teacher` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_course_academy` FOREIGN KEY (`a_id`) REFERENCES `academy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'大物',3,48,'必修','上半学期',1,1),(2,'数据库',3,48,'必修','下半学期',2,2),(3,'接口',3,32,'必修','下半学期',3,3),(4,'组成原理',5,48,'必修','上半学期',3,2),(5,'人工智能',2,24,'选修','下半学期',2,3);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_student`
--

DROP TABLE IF EXISTS `new_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `new_student` (
  `sno` int(8) NOT NULL,
  `c_id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` enum('男','女') NOT NULL,
  `birth` varchar(20) DEFAULT NULL,
  `address` varchar(200) NOT NULL,
  `dormitory` varchar(200) NOT NULL,
  `tel` varchar(11) NOT NULL,
  `duty` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`sno`),
  KEY `fk_s_class` (`c_id`),
  CONSTRAINT `fk_s_class` FOREIGN KEY (`c_id`) REFERENCES `t_class` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_student`
--

LOCK TABLES `new_student` WRITE;
/*!40000 ALTER TABLE `new_student` DISABLE KEYS */;
INSERT INTO `new_student` VALUES (20161111,1,'小白','男','1998','黑龙江','598','131313',''),(20161122,1,'小明','男','1998-01-02','黑龙江省','B4','114',''),(20161411,2,'小红','女','1998-02-07','黑龙江省哈尔滨市','B7-120','911','班长'),(20161426,1,'曲明晨','男','1998-01-01','黑龙江省密山','C25-529','01315456454','曲奇'),(20161437,1,'江家琦','男','1998-01-28','黑龙江省大庆市','C25-529','13163549296',NULL),(20161440,1,'王恺锋','男','2019/4/21','龙江','530寝室','13803627899','无'),(20161441,1,'史志同','男','1999-01-01','黑龙江省哈尔滨市','C25-529','13298705310','大使'),(20161442,1,'李鹏程','男','1998-01-01','黑龙江省哈尔滨市','C25-529','12345687988',NULL),(20161446,1,'张旭升','女','1998-01-01','黑龙江省五大连池市','C25-530','120','二孤');
/*!40000 ALTER TABLE `new_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result` (
  `s_id` int(8) NOT NULL,
  `c_id` int(11) NOT NULL,
  `mark` int(3) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_r_s` (`s_id`),
  KEY `fk_r_c` (`c_id`),
  CONSTRAINT `fk_r_c` FOREIGN KEY (`c_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_r_s` FOREIGN KEY (`s_id`) REFERENCES `new_student` (`sno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (20161437,1,100,1),(20161437,2,100,2),(20161437,3,87,3),(20161437,4,99,4),(20161437,5,99,5),(20161442,1,100,6),(20161442,2,60,7),(20161426,1,50,8),(20161442,3,59,9);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `sno` varchar(20) NOT NULL,
  `department` varchar(20) NOT NULL,
  `hometown` varchar(20) NOT NULL,
  `mark` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `tel` varchar(20) NOT NULL,
  `sex` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (18,'张旭升','001','国际文化教育学院','五大连池','80','LEO@163.com','13888888888','男'),(19,'温海强','002','法学院','山东','70','dagu@sina.com','13812341234','男'),(20,'曲奇','003','经管院','密山','88','quqi@126.com','13698765432','女'),(21,'小明','004','计软院','肇东','99','199984544@126.com','13544646444','女'),(22,'小红','023','国教','黑龙江','96','123456@123.com','156987456','女');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_class`
--

DROP TABLE IF EXISTS `t_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_class` (
  `id` int(11) NOT NULL,
  `classname` varchar(10) NOT NULL,
  `a_id` int(11) NOT NULL,
  `grade` int(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_c_academy` (`a_id`),
  CONSTRAINT `fk_c_academy` FOREIGN KEY (`a_id`) REFERENCES `academy` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_class`
--

LOCK TABLES `t_class` WRITE;
/*!40000 ALTER TABLE `t_class` DISABLE KEYS */;
INSERT INTO `t_class` VALUES (1,'国教计科班',1,2016),(2,'国教生计班',1,2016),(3,'计科一班',2,2016),(4,'软件三班',3,2017);
/*!40000 ALTER TABLE `t_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` enum('男','女') NOT NULL,
  `tel` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'李淑侠','女','119'),(2,'小白','男','120'),(3,'小明','男','114');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-08 13:04:42
