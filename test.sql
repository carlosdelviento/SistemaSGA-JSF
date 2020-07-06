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
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
    `id_persona` INT(4) NOT NULL AUTO_INCREMENT,
    `nombre` VARCHAR(45) NOT NULL,
    `apellido` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `telefono` VARCHAR(45) NOT NULL,
    `fecha` TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    PRIMARY KEY (`id_persona`),
    UNIQUE KEY `email_UNIQUE` (`email`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `test`.`persona` (`id_persona`,`nombre`, `apellido`, `email`, `telefono`) VALUES 
('1','Juan','Perez','jperez@mail.com','5513445567'),
('2','Karla','Gomez','kgomez@mail.com','7713445678'),
('3','Maria','Gutierrez','mariagutierrez@mail.com','88991199'),
('4','Diego','Gutierrez','dgutierrez@mail.com','99999999'),
('5','Pablo','Gutierrez','pgutierrez@mail.com','88991197'),
('6','Julio','Gutierrez','jgutierrez@mail.com','88991197'),
('7','Hector','Gutierrez','hgutierrez@mail.com','88991159'),
('8','Rosa','Gutierrez','rgutierrez@mail.com','889911399'),
('9','Patricia','Gutierrez','patgutierrez@mail.com','88921199'),
('10','Mirta','Gutierrez','mirtagutierrez@mail.com','88991199'),
('11','Gonzalo','Gutierrez','ggutierrez@mail.com','88991199'),
('12','Peter','Gutierrez','putierrez@mail.com','88991199'),
('13','Federico','Gutierrez','fgutierrez@mail.com','88991199'),
('14','Lurdes','Gutierrez','lurdesgutierrez@mail.com','88991199'),
('15','Jenny','Gutierrez','jengutierrez@mail.com','88991119'),
('16','Jessica','Gutierrez','jesgutierrez@mail.com','18991199'),
('17','Luisa','Gutierrez','luisagutierrez@mail.com','88091199'),
('18','Felipe','Gutierrez','felipegutierrez@mail.com','88991169'),
('19','Pepe','Gutierrez','pepegutierrez@mail.com','18991199'),
('20','Pepa','Gutierrez','pepagutierrez@mail.com','28991199');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
    `id_usuario` INT(4) NOT NULL AUTO_INCREMENT,
    `id_persona` INT(4),
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id_usuario`),
    KEY `fk_usuario_persona_idx` (`id_persona`),
    CONSTRAINT `fk_usuario_persona` FOREIGN KEY (`id_persona`)
        REFERENCES `persona` (`id_persona`)
        ON DELETE SET NULL
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `test`.`usuario` VALUES ('1','1','jperez','123'),('2','2','kgomez','123'),('3','3','admin','admin123');
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