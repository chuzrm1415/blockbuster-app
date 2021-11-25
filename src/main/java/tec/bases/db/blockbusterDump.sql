CREATE DATABASE  IF NOT EXISTS `blockbuster` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blockbuster`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: blockbuster
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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cat_ID` int NOT NULL AUTO_INCREMENT,
  `cat_descrip` varchar(50) NOT NULL,
  PRIMARY KEY (`cat_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Terror'),(2,'Comedia'),(3,'Drama'),(4,'Parodia'),(5,'Accion');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `client_ID` int NOT NULL AUTO_INCREMENT,
  `client_name` varchar(50) NOT NULL,
  `client_lastName` varchar(50) NOT NULL,
  `client_dir` varchar(100) DEFAULT 'N/A',
  `client_cel` int NOT NULL,
  PRIMARY KEY (`client_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Miguel','Alvarado','Cartago',87675643),(2,'Maria','Ramirez','San Jose',88923452),(3,'Pedro','Ramos','Cartago',86436790),(4,'Ana','Rojas','Heredia',81235674),(5,'Sebastian','Alpizar','Alajuela',81230967),(6,'Jimena','Mora','Alajuela',84562381),(7,'Carlos','Gomez','Guanacaste',88763421),(8,'Vannesa','Monge','Puntarenas',80673456),(9,'Juan','Cascante','San Jose',83011178),(10,'Clara','Arias','Cartago',85674439);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `film_cod` int NOT NULL AUTO_INCREMENT,
  `film_tittle` varchar(50) NOT NULL,
  `film_releaseDate` date NOT NULL,
  `film_catID` int NOT NULL,
  PRIMARY KEY (`film_cod`),
  KEY `film_category_FK` (`film_catID`),
  CONSTRAINT `film_category_FK` FOREIGN KEY (`film_catID`) REFERENCES `category` (`cat_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'SpiderMan','2002-05-03',5),(2,'SpiderMan2','2004-05-03',5),(3,'SpiderMan3','2007-04-04',5),(4,'Anabelle','2014-10-03',1),(5,'Anabelle2','2017-08-11',1),(6,'Son como ninos','2010-06-25',2),(7,'Son como ninos2','2013-07-12',2),(8,'Scary Movie','2000-07-07',4),(9,'Scary Movie2','2001-07-04',5),(10,'A dogs propose','2017-03-31',3);
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loan`
--

DROP TABLE IF EXISTS `loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loan` (
  `loan_ID` int NOT NULL AUTO_INCREMENT,
  `loan_filmID` int NOT NULL,
  `loan_clientID` int NOT NULL,
  `loan_date` date NOT NULL,
  `loan_devolutionDate` date NOT NULL,
  `state` tinyint(1) NOT NULL,
  PRIMARY KEY (`loan_ID`),
  KEY `loan_film_FK` (`loan_filmID`),
  KEY `loan_client_FK` (`loan_clientID`),
  CONSTRAINT `loan_client_FK` FOREIGN KEY (`loan_clientID`) REFERENCES `client` (`client_ID`),
  CONSTRAINT `loan_film_FK` FOREIGN KEY (`loan_filmID`) REFERENCES `film` (`film_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loan`
--

LOCK TABLES `loan` WRITE;
/*!40000 ALTER TABLE `loan` DISABLE KEYS */;
INSERT INTO `loan` VALUES (1,3,4,'2021-03-25','2021-03-28',0),(3,1,4,'2021-11-21','2021-11-24',1),(5,4,5,'2021-07-23','2021-07-26',0),(6,2,1,'2021-04-25','2021-04-28',0),(7,2,4,'2021-07-15','2021-07-18',0),(8,4,1,'2020-06-25','2020-06-28',0);
/*!40000 ALTER TABLE `loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'blockbuster'
--

--
-- Dumping routines for database 'blockbuster'
--
/*!50003 DROP PROCEDURE IF EXISTS `create_category` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `create_category`(
    IN _catDescrip VARCHAR(100) )
BEGIN
        DECLARE EXIT HANDLER FOR SQLEXCEPTION
            BEGIN
                ROLLBACK;
                SELECT 'INSERT ERROR' AS ERROR_MENSSAGE;
            END;
        START TRANSACTION;
            INSERT INTO blockbuster.Category (cat_descrip) VALUE (_catDescrip);
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `create_loan` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `create_loan`(
    IN _filmID LONG,
    IN _clientID LONG,
    IN _loanDate DATE )
BEGIN
        DECLARE _devolutionDate DATE DEFAULT DATE_ADD(_loanDate, INTERVAL 3 DAY);
        DECLARE _state BOOL DEFAULT 1;

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
            BEGIN
                ROLLBACK;
                SELECT 'inserted Error' AS ERROR_MENSSAGE;
            END;

        IF (_devolutionDate < DATE(now())) THEN
            SET _state = 0;
        END IF;

        START TRANSACTION;
            INSERT INTO Loan (loan_filmID, loan_clientID, loan_date, loan_devolutionDate, state)
            VALUES (_filmID, _clientID, _loanDate, _devolutionDate, _state);
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_categoryById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `delete_categoryById`(
    IN _catID LONG )
BEGIN
        DECLARE EXIT HANDLER FOR SQLEXCEPTION
            BEGIN
                ROLLBACK;
                SELECT 'DELETE ERROR' AS ERROR_MENSSAGE;
            END;
        START TRANSACTION;
            DELETE FROM blockbuster.Category AS cat
            WHERE cat.cat_ID = _catID;
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `delete_loans` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `delete_loans`(
    IN _filmID LONG,
    IN _clientID LONG )
BEGIN
        DECLARE EXIT HANDLER FOR SQLEXCEPTION
            BEGIN
                ROLLBACK;
                SELECT 'DELETE ERROR' AS ERROR_MENSSAGE;
            END;

        START TRANSACTION;
            DELETE FROM blockbuster.loan
            WHERE loan.loan_filmID = _filmID AND loan.loan_clientID = _clientID;
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `find_categoryById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `find_categoryById`(
    IN _catID LONG )
BEGIN

        START TRANSACTION READ ONLY;
            SELECT * FROM blockbuster.Category AS cat
            WHERE cat.cat_ID = _catID;
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `find_loansByFilm` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `find_loansByFilm`(
    IN _filmID LONG )
BEGIN

        START TRANSACTION READ ONLY;
            SELECT * FROM blockbuster.Loan
            WHERE blockbuster.Loan.loan_filmID = _filmID;
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `show_categorys` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `show_categorys`()
BEGIN
        START TRANSACTION READ ONLY;
            SELECT * FROM blockbuster.Category;
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `show_loans` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `show_loans`()
BEGIN

        START TRANSACTION READ ONLY;
            SELECT * FROM blockbuster.Loan;
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `update_categoryById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`chuzrm`@`%` PROCEDURE `update_categoryById`(
    IN _catID LONG,
    IN _catDescrip VARCHAR(100) )
BEGIN

        DECLARE EXIT HANDLER FOR SQLEXCEPTION
            BEGIN
                ROLLBACK;
                SELECT 'UPDATE ERROR' AS ERROR_MENSSAGE;
            END;

        START TRANSACTION;
            UPDATE blockbuster.Category AS cat
            SET cat.cat_descrip = _catDescrip
            WHERE cat.cat_ID = _catID;
        COMMIT;
        SET AUTOCOMMIT = 0;

    END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-25  5:59:26

DROP USER IF EXISTS 'blockbusterappuser'@'localhost';
CREATE USER IF NOT EXISTS 'blockbusterappuser'@'localhost' IDENTIFIED BY 'blockbusterapppass';
GRANT SELECT, INSERT, DELETE, UPDATE, EXECUTE ON blockbuster.* TO 'blockbusterappuser'@'localhost';

SET autocommit = OFF;
