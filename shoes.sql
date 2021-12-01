-- MySQL dump 10.13  Distrib 8.0.21, for macos10.15 (x86_64)
--
-- Host: 127.0.0.1    Database: shoes
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `Brand`
--

DROP TABLE IF EXISTS `Brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Brand` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Brand`
--

LOCK TABLES `Brand` WRITE;
/*!40000 ALTER TABLE `Brand` DISABLE KEYS */;
INSERT INTO `Brand` VALUES (1,'Blue');
/*!40000 ALTER TABLE `Brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'Nam'),(2,'Nữ'),(3,'Trẻ Em');
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Oder`
--

DROP TABLE IF EXISTS `Oder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Oder` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `oderDate` date DEFAULT NULL,
  `status` int NOT NULL,
  `total` float NOT NULL,
  `userId` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1wagi9ts0f1g5nnb8k5443wtr` (`userId`),
  CONSTRAINT `FK1wagi9ts0f1g5nnb8k5443wtr` FOREIGN KEY (`userId`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Oder`
--

LOCK TABLES `Oder` WRITE;
/*!40000 ALTER TABLE `Oder` DISABLE KEYS */;
INSERT INTO `Oder` VALUES (1,'2021-11-30',2,20000,2),(2,'2021-11-30',2,8000,2),(3,'2021-11-30',2,20000,1),(4,'2021-11-30',2,120000,2),(5,'2021-11-30',1,20000,2),(6,'2021-12-01',0,6000.09,2),(7,'2021-11-30',1,20000,1),(8,'2021-11-30',2,2000.02,1),(9,'2021-11-30',0,20000,1);
/*!40000 ALTER TABLE `Oder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OderDetail`
--

DROP TABLE IF EXISTS `OderDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OderDetail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `quantity` int NOT NULL,
  `total` float NOT NULL,
  `unitPrice` float NOT NULL,
  `oderId` bigint NOT NULL,
  `productId` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhw943wf28anbwlglthm4jx6ex` (`oderId`),
  KEY `FK2b2fi4slsjni9rmu2mj5mwu1v` (`productId`),
  CONSTRAINT `FK2b2fi4slsjni9rmu2mj5mwu1v` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`),
  CONSTRAINT `FKhw943wf28anbwlglthm4jx6ex` FOREIGN KEY (`oderId`) REFERENCES `Oder` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OderDetail`
--

LOCK TABLES `OderDetail` WRITE;
/*!40000 ALTER TABLE `OderDetail` DISABLE KEYS */;
INSERT INTO `OderDetail` VALUES (2,1,20000,20000,1,10),(3,4,8000,2000,2,11),(4,1,20000,20000,3,10),(5,5,100000,20000,4,10),(6,1,20000,20000,5,10),(8,2,4000,2000,6,11),(9,1,20000,20000,7,10),(10,1,2000,2000,8,11),(11,1,0.0222,0.0222,8,13),(12,1,20000,20000,9,10),(13,4,0.0888,0.0222,6,13);
/*!40000 ALTER TABLE `OderDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `name` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `brandId` bigint NOT NULL,
  `categoryId` bigint NOT NULL,
  `stock` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa6of0r92t61g7xd5li0pi9xji` (`brandId`),
  KEY `FK42iy97xlo64j31dslbn36vmyh` (`categoryId`),
  CONSTRAINT `FK42iy97xlo64j31dslbn36vmyh` FOREIGN KEY (`categoryId`) REFERENCES `Category` (`id`),
  CONSTRAINT `FKa6of0r92t61g7xd5li0pi9xji` FOREIGN KEY (`brandId`) REFERENCES `Brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (10,'Mô tả A','Tên a',20000,'S',1,1,2),(11,'Mô tả B','Tên B',2000,'M',1,3,2),(12,'Mô tả C','Tên C',3000,'M',1,2,5),(13,'ád','huan',0.0222,'S',1,3,20),(15,'123','San phẩm D',0.0222,'S',1,3,10),(16,'123','san pham d',2000,'S',1,1,20);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product_img`
--

DROP TABLE IF EXISTS `Product_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Product_img` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `productId` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKonxxoh9y2ml0qja9uvwk4hb1x` (`productId`),
  CONSTRAINT `FKonxxoh9y2ml0qja9uvwk4hb1x` FOREIGN KEY (`productId`) REFERENCES `Product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product_img`
--

LOCK TABLES `Product_img` WRITE;
/*!40000 ALTER TABLE `Product_img` DISABLE KEYS */;
INSERT INTO `Product_img` VALUES (82,'c26ff56b60892917bf2bd341659208d8-15609686669901.jpeg',10),(83,'333e4b6ada3fffcaef4908e993d07189-15609726592616.jpeg',10),(84,'0cd1abf333c523b0bedc747826b9a315-15617736097078.jpeg',11),(85,'1e8821555cd21352df7e65529e1b3cca-15617742484022.jpeg',11),(86,'3416a4e4620d6ef4111dd6b780996ef0-15625051941424.jpeg',12),(87,'eddc5c8df57a7ca907ecbc5f13e9e205-15625057067383.jpeg',12),(88,'79ef309e5d24e6b6aa688d475511bc57-15631578241290.jpeg',13),(89,'96f012c9dece399229c0c9deb2e4cee6-15631583517484.jpeg',13),(90,'79004b305001e2e8bddcb661c5b751ab-15653151979036.jpeg',15),(91,'1ee50094a884e867873af50dff711b9e-15653155823667.jpeg',15),(92,'e911e4a985041111137870f6997273ae-15673965182192.jpeg',16),(93,'1e3afcd667353757cbcfc0e57687a9c2-15673970620587.jpeg',16);
/*!40000 ALTER TABLE `Product_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userType` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'Hà Nha - Đại Đồng - Đại Lộc - Quảng Nam','votuonghuan185@gmail.com','202cb962ac59075b964b07152d234b70','0969272682','admin',0),(2,'ha nha','admin@gmail.com','202cb962ac59075b964b07152d234b70','0969272682','admin',1);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-01 13:48:53
