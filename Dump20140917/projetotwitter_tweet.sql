CREATE DATABASE  IF NOT EXISTS `projetotwitter` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `projetotwitter`;
-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: projetotwitter
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.12.04.1

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
-- Table structure for table `tweet`
--

DROP TABLE IF EXISTS `tweet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tweet` (
  `idTweet` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(140) NOT NULL,
  `dataTweet` datetime NOT NULL,
  `resposta` binary(1) NOT NULL,
  `idTweetRespondido` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idTweet`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tweet`
--

LOCK TABLES `tweet` WRITE;
/*!40000 ALTER TABLE `tweet` DISABLE KEYS */;
INSERT INTO `tweet` VALUES (1,'asdasda','2014-09-04 00:00:00','0',0,1),(2,'teste','2014-09-04 00:00:00','0',0,1),(3,'asdasd','2014-09-04 00:00:00','0',0,1),(4,'dhjdghgd','2014-09-04 00:00:00','0',0,1),(5,'aaaaaaaaaaaa','2014-09-04 00:00:00','0',0,1),(6,'qwewqe','2014-09-06 00:00:00','0',0,1),(7,'testeeeee','2014-09-09 00:00:00','0',0,1),(8,'teste 2','2014-09-09 00:00:00','0',0,1),(9,'testandoo','2014-09-10 00:00:00','0',0,1),(10,'ngvmhgvmnbvmhg','2014-09-11 00:00:00','0',0,1),(11,'testeaaaa','2014-09-11 00:00:00','0',0,1),(12,'hhhhhh','2014-09-11 00:00:00','0',0,1),(13,'kkllklklklklkl','2014-09-11 00:00:00','0',0,1),(14,'teste 123','2014-09-16 00:00:00','0',0,1);
/*!40000 ALTER TABLE `tweet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-17 16:49:58
