-- MySQL dump 10.13  Distrib 8.0.12, for macos10.13 (x86_64)
--
-- Host: localhost    Database: parcial-iot
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `dispositivo`
--

DROP TABLE IF EXISTS `dispositivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dispositivo` (
  `iddispositivo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`iddispositivo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dispositivo`
--

LOCK TABLES `dispositivo` WRITE;
/*!40000 ALTER TABLE `dispositivo` DISABLE KEYS */;
INSERT INTO `dispositivo` VALUES (1,'cortina pieza',_binary ''),(2,'cortina cocina',_binary ''),(3,'cortina balcon',_binary ''),(4,'temp pieza',_binary ''),(5,'temp cocina',_binary '');
/*!40000 ALTER TABLE `dispositivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `evento` (
  `idevento` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `iddispositivo` int NOT NULL,
  `fechaHora` datetime NOT NULL,
  PRIMARY KEY (`idevento`),
  KEY `fk_dispositivo_evento_idx` (`iddispositivo`),
  CONSTRAINT `fk_dispositivo_evento` FOREIGN KEY (`iddispositivo`) REFERENCES `dispositivo` (`iddispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensorcortinaventana`
--

DROP TABLE IF EXISTS `sensorcortinaventana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
CREATE TABLE `sensorcortinaventana` (
  `idsensor` int NOT NULL,
  `aperturadesde` time NOT NULL,
  `aperturahasta` time NOT NULL,
  PRIMARY KEY (`idsensor`),
  CONSTRAINT `fk_sensor_dispositivo` FOREIGN KEY (`idsensor`) REFERENCES `dispositivo` (`iddispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensorcortinaventana`
--

LOCK TABLES `sensorcortinaventana` WRITE;
/*!40000 ALTER TABLE `sensorcortinaventana` DISABLE KEYS */;
INSERT INTO `sensorcortinaventana` VALUES (1,'09:00:00','19:00:00'),(2,'12:00:00','20:00:00'),(3,'10:00:00','18:00:00');
/*!40000 ALTER TABLE `sensorcortinaventana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sensortemperatura`
--

DROP TABLE IF EXISTS `sensortemperatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
CREATE TABLE `sensortemperatura` (
  `idsensor` int NOT NULL,
  `valorminimo` double NOT NULL,
  `valormaximo` double NOT NULL,
  PRIMARY KEY (`idsensor`),
  CONSTRAINT `fk_sensortemp_dispositivo` FOREIGN KEY (`idsensor`) REFERENCES `dispositivo` (`iddispositivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sensortemperatura`
--

LOCK TABLES `sensortemperatura` WRITE;
/*!40000 ALTER TABLE `sensortemperatura` DISABLE KEYS */;
INSERT INTO `sensortemperatura` VALUES (4,17.5,22),(5,22,24);
/*!40000 ALTER TABLE `sensortemperatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'parcial-iot'
--

--
-- Dumping routines for database 'parcial-iot'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-18 19:08:23
