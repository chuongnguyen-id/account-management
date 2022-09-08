-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: testing_system_2
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `AccountID` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `Email` varchar(100) DEFAULT NULL,
  `Username` varchar(50) NOT NULL,
  `Fullname` varchar(50) DEFAULT NULL,
  `DepartmentID` tinyint DEFAULT '1',
  `PositionID` tinyint unsigned DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `Role` varchar(45) DEFAULT 'USER',
  `Password` varchar(150) DEFAULT '$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u',
  PRIMARY KEY (`AccountID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'vti_account1@vtiacademy.com','vti1','Nguyen Van Tinh',7,1,'2022-06-28 11:41:08','ADMIN','$2a$12$4.Cxc4picqYclMaqZfDNXeCk.PtrwouqikrD5ATUpe4wZM9jUzJv.'),(2,'vti_account2@vtiacademy.com','vti2','Trinh Hoai Linh',1,2,'2020-12-01 00:00:00','MANAGER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(3,'vti_account3@vtiacademy.com','vti3','Nguyen Van Test',1,1,'2020-07-01 00:00:00','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(4,'vti_account4@vtiacademy.com','vti4','Tran Van Tinh',1,2,'2019-09-01 00:00:00','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(5,'vti_account5@vtiacademy.com','account5','Ho Van Tinh',3,2,'2021-07-01 00:00:00','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(6,'vti_account6@vtiacademy.com','account_vti6','Cao Thai Son',3,1,'2022-06-23 19:02:21','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(7,'vti_7@vtiacademy.com','account_vti7','Tam Thất Tùng',3,3,'2020-10-01 00:00:00','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(8,'vti_8@vtiacademy.com','account_vti8','Nguyen Quynh Thu',3,4,'2019-04-01 00:00:00','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(9,'vti_9@vtiacademy.com','account_vti9','Tran Kim Tuyen',2,1,'2022-06-23 19:02:21','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(10,'vti_account10@vtiacademy.com','account_vti10','Nguyen Ba Dao',1,5,'2019-10-01 00:00:00','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(11,'vti_account11@vtiacademy.com','account_vti11','Nguyen Van Binh',1,3,'2022-06-28 07:44:48','USER','$2a$12$B8fDPKsXaBQgcMvzVj9oxuJaBJN9Phj9EBVtud3Kg61kvEwCLmE3u'),(22,'ccc@gmail.com','c','c',7,NULL,'2022-06-28 07:44:34',NULL,NULL),(25,'aaa@gmail.com','a','a',5,NULL,'2022-06-28 10:56:33',NULL,NULL),(26,'bbb@gmail.com','b','b',4,NULL,'2022-06-28 11:02:15',NULL,NULL),(27,'ad@gmail.com','vti5','bbb',4,NULL,'2022-08-14 13:57:41',NULL,'$2a$10$lrkFqHpmLYlIoFbkPro0P.8grzgm98SA1erxkXMwEMRezSj5Y.4dy');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `AnswerID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `Content` varchar(50) DEFAULT NULL,
  `QuestionID` tinyint unsigned DEFAULT NULL,
  `isCorrect` bit(1) DEFAULT NULL,
  PRIMARY KEY (`AnswerID`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,'Câu trả lời 1 - question SQL 1',1,_binary ''),(2,'Câu trả lời 2 - question SQL 1',1,_binary '\0'),(3,'Câu trả lời 3 - question SQL 1',1,_binary '\0'),(4,'Câu trả lời 4 - question SQL 1',1,_binary ''),(5,'Câu trả lời 1 - question SQL 2',2,_binary '\0'),(6,'Câu trả lời 2 - question SQL 2',2,_binary '\0'),(7,'Câu trả lời 3 - question SQL 2',2,_binary '\0'),(8,'Câu trả lời 4 - question SQL 2',2,_binary ''),(9,'Câu trả lời 1 - question JAVA 1',3,_binary '\0'),(10,'Câu trả lời 2 - question JAVA 1',3,_binary ''),(11,'Câu trả lời 1 - question JAVA 2',4,_binary '\0'),(12,'Câu trả lời 2 - question JAVA 2',4,_binary '\0'),(13,'Câu trả lời 3 - question JAVA 2',4,_binary '\0'),(14,'Câu trả lời 4 - question JAVA 2',4,_binary ''),(15,'Câu trả lời 1 - question HTML 1',5,_binary ''),(16,'Câu trả lời 2 - question HTML 2',5,_binary '\0');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoryquestion`
--

DROP TABLE IF EXISTS `categoryquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoryquestion` (
  `CategoryID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `CategoryName` enum('Java','SQL','.NET','Ruby','Python','NodeJS','HTML','CSS','JavaScript') DEFAULT NULL,
  PRIMARY KEY (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoryquestion`
--

LOCK TABLES `categoryquestion` WRITE;
/*!40000 ALTER TABLE `categoryquestion` DISABLE KEYS */;
INSERT INTO `categoryquestion` VALUES (1,'Java'),(2,'SQL'),(3,'HTML'),(4,'CSS'),(5,'.NET'),(6,'Python'),(7,'Ruby'),(8,'JavaScript');
/*!40000 ALTER TABLE `categoryquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `DepartmentID` tinyint NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'Phong Ky Thuat 1'),(2,'Phong Ky Thuat 2'),(3,'Phong Dev 1'),(4,'Phong Dev 2'),(5,'Phong Sale'),(6,'Phong Marketing'),(7,'Phong Giam Doc'),(8,'Phong Tai Chinh');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `ExamID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `Code` varchar(20) NOT NULL,
  `Title` varchar(50) NOT NULL,
  `CategoryID` tinyint unsigned DEFAULT NULL,
  `Duration` tinyint DEFAULT NULL,
  `CreatorID` mediumint unsigned DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`ExamID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'MS_01','De thi 01',1,90,1,'2022-06-23 19:02:21'),(2,'MS_02','De thi 02',1,60,5,'2022-06-23 19:02:21'),(3,'MS_03','De thi 03',2,60,9,'2022-06-23 19:02:21'),(4,'MS_04','De thi 04',2,90,1,'2022-06-23 19:02:21'),(5,'MS_05','De thi 05',1,60,2,'2022-06-23 19:02:21'),(6,'MS_06','De thi 06',2,90,2,'2022-06-23 19:02:21'),(7,'MS_07','De thi 07',1,60,1,'2022-06-23 19:02:21');
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examquestion`
--

DROP TABLE IF EXISTS `examquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examquestion` (
  `ExamID` tinyint unsigned DEFAULT NULL,
  `QuestionID` tinyint unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examquestion`
--

LOCK TABLES `examquestion` WRITE;
/*!40000 ALTER TABLE `examquestion` DISABLE KEYS */;
INSERT INTO `examquestion` VALUES (1,1),(2,1),(3,1),(4,1),(5,2),(6,2),(7,2),(8,2),(9,3),(10,3),(11,4),(12,4),(13,4),(14,4),(15,5),(16,5);
/*!40000 ALTER TABLE `examquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group` (
  `GroupID` mediumint unsigned NOT NULL AUTO_INCREMENT,
  `GroupName` varchar(50) NOT NULL,
  `CreatorID` mediumint unsigned DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`GroupID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (1,'Nhom 1',3,'2021-04-03 00:00:00'),(2,'Nhom 2',3,'2019-01-03 00:00:00'),(3,'Nhom 3',2,'2020-04-03 00:00:00'),(4,'Nhom 4',1,'2022-06-23 19:02:21'),(5,'Nhom 5',3,'2021-06-03 00:00:00'),(6,'Nhom 6',1,'2020-04-03 00:00:00'),(7,'Nhom 7',5,'2021-04-03 00:00:00'),(8,'Nhom 8',5,'2019-05-03 00:00:00'),(9,'Nhom 9',3,'2019-01-03 00:00:00'),(10,'Nhom 10',1,'2022-06-23 19:02:21');
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupaccount`
--

DROP TABLE IF EXISTS `groupaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupaccount` (
  `GroupID` mediumint NOT NULL,
  `AccountID` mediumint NOT NULL,
  `JoinDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`GroupID`,`AccountID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupaccount`
--

LOCK TABLES `groupaccount` WRITE;
/*!40000 ALTER TABLE `groupaccount` DISABLE KEYS */;
INSERT INTO `groupaccount` VALUES (1,1,'2021-06-01 00:00:00'),(1,2,'2022-06-23 19:02:21'),(1,3,'2020-01-01 00:00:00'),(1,4,'2021-06-01 00:00:00'),(2,1,'2021-06-01 00:00:00'),(2,10,'2019-05-01 00:00:00'),(3,1,'2021-06-01 00:00:00'),(5,1,'2021-06-01 00:00:00'),(5,3,'2020-01-01 00:00:00'),(5,4,'2021-07-01 00:00:00'),(9,2,'2021-06-01 00:00:00'),(10,1,'2022-06-23 19:02:21');
/*!40000 ALTER TABLE `groupaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `position` (
  `PositionID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `PositionName` enum('DEV1','DEV2','PM','LEADER','SCRUM_MASTER','TEST') DEFAULT NULL,
  PRIMARY KEY (`PositionID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'DEV1'),(2,'DEV2'),(3,'TEST'),(4,'PM'),(5,'LEADER'),(6,'SCRUM_MASTER');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `QuestionID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `Content` varchar(50) DEFAULT NULL,
  `CategoryID` tinyint unsigned DEFAULT NULL,
  `TypeID` tinyint unsigned DEFAULT NULL,
  `CreatorID` mediumint unsigned DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  PRIMARY KEY (`QuestionID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'Câu hỏi SQL 1',2,2,1,'2021-04-01 00:00:00'),(2,'Câu hỏi SQL 2',2,2,2,'2020-01-01 00:00:00'),(3,'Câu hỏi JAVA 1',1,1,10,'2021-07-01 00:00:00'),(4,'Câu hỏi JAVA 2',1,2,5,'2021-06-01 00:00:00'),(5,'Câu hỏi HTML 1',3,1,2,'2022-06-23 19:02:21'),(6,'Câu hỏi HTML 2',3,2,2,'2022-06-23 19:02:21');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typequestion`
--

DROP TABLE IF EXISTS `typequestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `typequestion` (
  `TypeID` tinyint unsigned NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`TypeID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typequestion`
--

LOCK TABLES `typequestion` WRITE;
/*!40000 ALTER TABLE `typequestion` DISABLE KEYS */;
INSERT INTO `typequestion` VALUES (1,'Trac nghiem'),(2,'Tu Luan');
/*!40000 ALTER TABLE `typequestion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-21 22:18:45
