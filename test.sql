CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `test`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  /*`id_persona` int(11) DEFAULT NULL,*/
  `username` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fecha` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `username` (`username`)
  /*KEY `fk_usuario_persona_idx` (`id_persona`),*/
  /*CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id_persona`) ON DELETE SET NULL*/
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','admin123');
INSERT INTO `usuarios` VALUES (2,'usuario','usuario123');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-19 22:13:41

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personas` (
  `id_persona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `fecha` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  PRIMARY KEY (`id_persona`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,'Juan','Perez','jperez@mail.com','5513445567'),(2,'Karla','Gomez','kgomez@mail.com','7713445678'),(3,'Maria','Gutierrez','mgutierrez@mail.com','88991199'),(4,'Diego','Gutierrez','dgutierrez@mail.com','99999999'),(5,'Pablo','Gutierrez','pgutierrez@mail.com','88991197'),(6,'Julio','Gutierrez','jgutierrez@mail.com','88991197'),(7,'Hector','Gutierrez','hgutierrez@mail.com','88991159'),(8,'Rosa','Gutierrez','rgutierrez@mail.com','889911399'),(9,'Patricia','Gutierrez','pgutierrez@mail.com','88921199'),(10,'Mirta','Gutierrez','mgutierrez@mail.com','88991199'),(11,'Gonzalo','Gutierrez','mgutierrez@mail.com','88991199'),(12,'Peter','Gutierrez','mgutierrez@mail.com','88991199'),(13,'Federico','Gutierrez','mgutierrez@mail.com','88991199'),(14,'Lurdes','Gutierrez','lgutierrez@mail.com','88991199'),(15,'Jenny','Gutierrez','jgutierrez@mail.com','88991119'),(16,'Jessica','Gutierrez','jgutierrez@mail.com','18991199'),(17,'Luisa','Gutierrez','lgutierrez@mail.com','88091199'),(18,'Felipe','Gutierrez','fgutierrez@mail.com','88991169'),(19,'Pepe','Gutierrez','pgutierrez@mail.com','18991199'),(20,'Pepa','Gutierrez','pepagutierrez@mail.com','28991199'),(21,'Pepo','Gutierrez','pepogutierrez@mail.com','988991199'),(22,'Tita','Gutierrez','tgutierrez@mail.com','28991199'),(23,'Tito','Gutierrez','titogutierrez@mail.com','8238991199'),(24,'Tete','Gutierrez','tetegutierrez@mail.com','558991199'),(25,'Mario','Gutierrez','mgutierrez@mail.com','889911923'),(26,'Marito','Gutierrez','maritogutierrez@mail.com','23488991199'),(27,'Marita','Gutierrez','maritagutierrez@mail.com','455488991199'),(28,'Fernanda','Gutierrez','fgutierrez@mail.com','213488991199'),(29,'Fernando','Gutierrez','fgutierrez@mail.com','5656454688991199'),(30,'Fernandito','Gutierrez','fernanditogutierrez@mail.com','4354588991199'),(31,'Tomas','Gutierrez','tomgutierrez@mail.com','65767788991199'),(32,'Tomasito','Gutierrez','tsitogutierrez@mail.com','6666688991199'),(33,'Tamara','Gutierrez','tamaragutierrez@mail.com','534534588991199'),(34,'Silvio','Gutierrez','silviogutierrez@mail.com','77788991199'),(35,'Silvia','Gutierrez','sgutierrez@mail.com','77788991199'),(36,'Silverio','Gutierrez','silveriogutierrez@mail.com','6464588991199'),(37,'Walter','Gutierrez','wgutierrez@mail.com','888888991199'),(38,'Washington','Gutierrez','wgutierrez@mail.com','8899119988885'),(39,'Rodrigo','Gutierrez','rgutierrez@mail.com','0000088991199'),(40,'Roberto','Gutierrez','rgutierrez@mail.com','6767688991199');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;
