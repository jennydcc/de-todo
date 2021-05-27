-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: DeTodo
-- ------------------------------------------------------
-- Server version	8.0.25-0ubuntu0.20.04.1

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
-- Table structure for table `ACTIVIDAD`
--

DROP TABLE IF EXISTS `ACTIVIDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ACTIVIDAD` (
  `idACTIVIDAD` varchar(45) NOT NULL,
  `ACTIVIDAD_nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idACTIVIDAD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ACTIVIDAD`
--

LOCK TABLES `ACTIVIDAD` WRITE;
/*!40000 ALTER TABLE `ACTIVIDAD` DISABLE KEYS */;
/*!40000 ALTER TABLE `ACTIVIDAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ADMINISTRADOR`
--

DROP TABLE IF EXISTS `ADMINISTRADOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ADMINISTRADOR` (
  `idADMINISTRADOR` varchar(45) NOT NULL,
  `ADMINISTRADOR_nombre` varchar(45) NOT NULL,
  `ADMINISTRADOR_apellidopaterno` varchar(45) NOT NULL,
  `ADMINISTRADOR_apellidomaterno` varchar(45) NOT NULL,
  `ADMINISTRADOR_correo` varchar(45) DEFAULT NULL,
  `ADMINISTRADOR_celular` int DEFAULT NULL,
  `ADMINISTRADOR_tipodocumento` varchar(45) DEFAULT NULL,
  `ADMINISTRADOR_numerodocumento` int DEFAULT NULL,
  `ADMINISTRADOR_contrasena` varchar(45) DEFAULT NULL,
  `ADMINISTRADOR_cargo` varchar(45) DEFAULT NULL,
  `ADMINISTRADOR_direccion` varchar(45) DEFAULT NULL,
  `ADMINISTRADOR_departamento` varchar(45) DEFAULT NULL,
  `ADMINISTRADOR_provincia` varchar(45) DEFAULT NULL,
  `ADMINISTRADOR_distrito` varchar(45) DEFAULT NULL,
  `idUSUARIO` varchar(45) NOT NULL,
  PRIMARY KEY (`idADMINISTRADOR`),
  KEY `fk_ADMINISTRADOR_TIPO_USUARIO1_idx` (`idUSUARIO`),
  CONSTRAINT `fk_ADMINISTRADOR_TIPO_USUARIO1` FOREIGN KEY (`idUSUARIO`) REFERENCES `TIPO_USUARIO` (`idUSUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ADMINISTRADOR`
--

LOCK TABLES `ADMINISTRADOR` WRITE;
/*!40000 ALTER TABLE `ADMINISTRADOR` DISABLE KEYS */;
/*!40000 ALTER TABLE `ADMINISTRADOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTE` (
  `idCLIENTE` varchar(45) NOT NULL,
  `CLIENTE_nombre` varchar(45) NOT NULL,
  `CLIENTE_apellidopaterno` varchar(45) NOT NULL,
  `CLIENTE_apellidomaterno` varchar(45) NOT NULL,
  `CLIENTE_tipodocumento` varchar(45) NOT NULL,
  `CLIENTE_numerodocumento` int NOT NULL,
  `CLIENTE_correo` varchar(45) NOT NULL,
  `CLIENTE_sexo` varchar(45) NOT NULL,
  `CLIENTE_fechanacimiento` datetime DEFAULT NULL,
  `CLIENTE_direccion` varchar(45) DEFAULT NULL,
  `CLIENTE_departamento` varchar(45) DEFAULT NULL,
  `CLIENTE_provincia` varchar(45) DEFAULT NULL,
  `CLIENTE_distrito` varchar(45) DEFAULT NULL,
  `CLIENTE_celular` int DEFAULT NULL,
  `CLIENTE_contrasena` varchar(45) DEFAULT NULL,
  `CLIENTE_estado` varchar(45) DEFAULT NULL,
  `idUSUARIO` varchar(45) NOT NULL,
  PRIMARY KEY (`idCLIENTE`),
  KEY `fk_CLIENTE_TIPO_USUARIO1_idx` (`idUSUARIO`),
  CONSTRAINT `fk_CLIENTE_TIPO_USUARIO1` FOREIGN KEY (`idUSUARIO`) REFERENCES `TIPO_USUARIO` (`idUSUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESPECIALISTA`
--

DROP TABLE IF EXISTS `ESPECIALISTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ESPECIALISTA` (
  `idESPECIALISTA` varchar(45) NOT NULL,
  `ESPECIALISTA_nombre` varchar(45) NOT NULL,
  `ESPECIALISTA_apellidopaterno` varchar(45) NOT NULL,
  `ESPECIALISTA_apellidomaterno` varchar(45) NOT NULL,
  `ESPECIALISTA_tipodocumento` varchar(45) NOT NULL,
  `ESPECIALISTA_numerodocumento` int NOT NULL,
  `ESPECIALISTA_correo` varchar(45) NOT NULL,
  `ESPECIALISTA_sexo` varchar(45) NOT NULL,
  `ESPECIALISTA_fechanacimiento` datetime NOT NULL,
  `ESPECIALISTA_direccion` varchar(45) DEFAULT NULL,
  `ESPECIALISTA_departamento` varchar(45) DEFAULT NULL,
  `ESPECIALISTA_provincia` varchar(45) DEFAULT NULL,
  `ESPECIALISTA_distrito` varchar(45) DEFAULT NULL,
  `ESPECIALISTA_celular` int NOT NULL,
  `ESPECIALISTA_contrasena` varchar(45) DEFAULT NULL,
  `ESPECIALISTA_estado` varchar(45) DEFAULT NULL,
  `idUSUARIO` varchar(45) NOT NULL,
  PRIMARY KEY (`idESPECIALISTA`),
  KEY `fk_ESPECIALISTA_TIPO_USUARIO1_idx` (`idUSUARIO`),
  CONSTRAINT `fk_ESPECIALISTA_TIPO_USUARIO1` FOREIGN KEY (`idUSUARIO`) REFERENCES `TIPO_USUARIO` (`idUSUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESPECIALISTA`
--

LOCK TABLES `ESPECIALISTA` WRITE;
/*!40000 ALTER TABLE `ESPECIALISTA` DISABLE KEYS */;
/*!40000 ALTER TABLE `ESPECIALISTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ESPECIALISTA_has_ACTIVIDAD`
--

DROP TABLE IF EXISTS `ESPECIALISTA_has_ACTIVIDAD`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ESPECIALISTA_has_ACTIVIDAD` (
  `idESPECIALISTA` varchar(45) NOT NULL,
  `idACTIVIDAD` varchar(45) NOT NULL,
  `EA_precioconsulta` double DEFAULT NULL,
  `EA_descripcionconsulta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idESPECIALISTA`,`idACTIVIDAD`),
  KEY `fk_ESPECIALISTA_has_ACTIVIDAD_ACTIVIDAD1_idx` (`idACTIVIDAD`),
  KEY `fk_ESPECIALISTA_has_ACTIVIDAD_ESPECIALISTA1_idx` (`idESPECIALISTA`),
  CONSTRAINT `fk_ESPECIALISTA_has_ACTIVIDAD_ACTIVIDAD1` FOREIGN KEY (`idACTIVIDAD`) REFERENCES `ACTIVIDAD` (`idACTIVIDAD`),
  CONSTRAINT `fk_ESPECIALISTA_has_ACTIVIDAD_ESPECIALISTA1` FOREIGN KEY (`idESPECIALISTA`) REFERENCES `ESPECIALISTA` (`idESPECIALISTA`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ESPECIALISTA_has_ACTIVIDAD`
--

LOCK TABLES `ESPECIALISTA_has_ACTIVIDAD` WRITE;
/*!40000 ALTER TABLE `ESPECIALISTA_has_ACTIVIDAD` DISABLE KEYS */;
/*!40000 ALTER TABLE `ESPECIALISTA_has_ACTIVIDAD` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SERVICIO`
--

DROP TABLE IF EXISTS `SERVICIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SERVICIO` (
  `idSERVICIO` varchar(45) NOT NULL,
  `SERVICIO_direccion` varchar(200) NOT NULL,
  `SERVICIO_distrito` varchar(45) NOT NULL,
  `SERVICIO_descripcion` varchar(140) NOT NULL,
  `SERVICIO_estado` varchar(45) NOT NULL,
  `SERVICIO_calificacion` int DEFAULT NULL,
  `SERVICIO_fechasolicitud` datetime NOT NULL,
  `SERVICIO_fechaatencion` datetime DEFAULT NULL,
  `SERVICIO_fechafin` datetime DEFAULT NULL,
  `SERVICIO_observacion` varchar(45) DEFAULT NULL,
  `idCLIENTE` varchar(45) NOT NULL,
  PRIMARY KEY (`idSERVICIO`),
  KEY `fk_SERVICIO_CLIENTE_idx` (`idCLIENTE`),
  CONSTRAINT `fk_SERVICIO_CLIENTE` FOREIGN KEY (`idCLIENTE`) REFERENCES `CLIENTE` (`idCLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SERVICIO`
--

LOCK TABLES `SERVICIO` WRITE;
/*!40000 ALTER TABLE `SERVICIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `SERVICIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TIPO_USUARIO`
--

DROP TABLE IF EXISTS `TIPO_USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TIPO_USUARIO` (
  `idUSUARIO` varchar(45) NOT NULL,
  `TI_tipousuario` varchar(100) NOT NULL,
  PRIMARY KEY (`idUSUARIO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TIPO_USUARIO`
--

LOCK TABLES `TIPO_USUARIO` WRITE;
/*!40000 ALTER TABLE `TIPO_USUARIO` DISABLE KEYS */;
/*!40000 ALTER TABLE `TIPO_USUARIO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-20 22:53:41
