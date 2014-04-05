CREATE DATABASE  IF NOT EXISTS `webshop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `webshop`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: webshop
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `Category`
--

DROP TABLE IF EXISTS `Category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `staff_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Category`
--

LOCK TABLES `Category` WRITE;
/*!40000 ALTER TABLE `Category` DISABLE KEYS */;
INSERT INTO `Category` VALUES (1,'Cars',23),(2,'Toys',12),(7,'Other',30),(8,'Test',52),(9,'Cards',45);
/*!40000 ALTER TABLE `Category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CheckOut`
--

DROP TABLE IF EXISTS `CheckOut`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CheckOut` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_date` int(11) NOT NULL,
  `prod_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CheckOut`
--

LOCK TABLES `CheckOut` WRITE;
/*!40000 ALTER TABLE `CheckOut` DISABLE KEYS */;
INSERT INTO `CheckOut` VALUES (58,140405,1,2,1),(59,140405,4,10,1);
/*!40000 ALTER TABLE `CheckOut` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CheckOut_User`
--

DROP TABLE IF EXISTS `CheckOut_User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CheckOut_User` (
  `OrderUserList_id` int(11) NOT NULL,
  `userOrderList_id` int(11) NOT NULL,
  KEY `FK_n7cef7lif1lr16nkkx6f2nm92` (`userOrderList_id`),
  KEY `FK_c9px5c9ojkflaqc3u74irxty8` (`OrderUserList_id`),
  KEY `FK_seqakmmh8ckiohkl7l9rwrpeu` (`OrderUserList_id`),
  CONSTRAINT `FK_seqakmmh8ckiohkl7l9rwrpeu` FOREIGN KEY (`OrderUserList_id`) REFERENCES `CheckOut` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CheckOut_User`
--

LOCK TABLES `CheckOut_User` WRITE;
/*!40000 ALTER TABLE `CheckOut_User` DISABLE KEYS */;
INSERT INTO `CheckOut_User` VALUES (58,1),(59,1);
/*!40000 ALTER TABLE `CheckOut_User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cost` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `rrp` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES (1,700000,'Smeksi bil','Audi R8',0,1600000),(2,80000,'Another Smeksi Car','BMW',0,320000),(3,500000,'Italian car.','Lambourghini',0,1500000),(4,200300,'XC90','Volvo',0,475000),(5,90000,'Golf','Volkswagen',2,200000),(6,10,'Gallardo','Leksaks Lambourghini',14,30),(7,200,'Klocka som har BMW logo bakgrund.','BMW Klocka',0,500),(8,3000,'Apples senaste klocka','Apple iWatch',3,7000),(9,123,'paste','Copy',-3,321);
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ShoppingCart`
--

DROP TABLE IF EXISTS `ShoppingCart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ShoppingCart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cost` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `rrp` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ShoppingCart`
--

LOCK TABLES `ShoppingCart` WRITE;
/*!40000 ALTER TABLE `ShoppingCart` DISABLE KEYS */;
INSERT INTO `ShoppingCart` VALUES (5,10,'Gallardo','Leksaks Lambourghini',15,30);
/*!40000 ALTER TABLE `ShoppingCart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ShoppingCart_User`
--

DROP TABLE IF EXISTS `ShoppingCart_User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ShoppingCart_User` (
  `cartList_id` int(11) NOT NULL,
  `userList_id` int(11) NOT NULL,
  KEY `FK_j9wor5g1ktng8oxprayehoecm` (`userList_id`),
  KEY `FK_4bqp3aoy852g85vtgk77prawi` (`cartList_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ShoppingCart_User`
--

LOCK TABLES `ShoppingCart_User` WRITE;
/*!40000 ALTER TABLE `ShoppingCart_User` DISABLE KEYS */;
INSERT INTO `ShoppingCart_User` VALUES (5,1);
/*!40000 ALTER TABLE `ShoppingCart_User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `telephone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1,'toplane','jo6han@gmail.com','Johan','abc123','0737087699'),(2,'botlane','jo6han@hotmail.com','Saiesan','abc123','botlane'),(3,'Copy','newton@mail.com','Isak','ok','Copy'),(4,'abc','copy@paste.com','CopyPaste','abc123','abc');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_product`
--

DROP TABLE IF EXISTS `category_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_product` (
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  KEY `FK_32qtx2uykh20mtk86gcqsc1u` (`category_id`),
  KEY `FK_a3fu50r1ffabepxw94y19s10s` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_product`
--

LOCK TABLES `category_product` WRITE;
/*!40000 ALTER TABLE `category_product` DISABLE KEYS */;
INSERT INTO `category_product` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,2),(7,7),(8,7),(9,7),(9,8);
/*!40000 ALTER TABLE `category_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_product`
--

DROP TABLE IF EXISTS `user_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_product` (
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  KEY `FK_gbrvdyv4h0adtukip1glaft27` (`user_id`),
  KEY `FK_dc1y63v3t2xgya5tbcr0po7it` (`product_id`),
  CONSTRAINT `FK_dc1y63v3t2xgya5tbcr0po7it` FOREIGN KEY (`product_id`) REFERENCES `ShoppingCart` (`id`),
  CONSTRAINT `FK_gbrvdyv4h0adtukip1glaft27` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_product`
--

LOCK TABLES `user_product` WRITE;
/*!40000 ALTER TABLE `user_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-05 19:11:14
