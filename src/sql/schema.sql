-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: localhost    Database: jobscam
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `experience`
--

DROP TABLE IF EXISTS `experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience` (
  `exp_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`exp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10021 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience`
--

LOCK TABLES `experience` WRITE;
/*!40000 ALTER TABLE `experience` DISABLE KEYS */;
INSERT INTO `experience` VALUES 
(10001,'Here is my experience text'),
(10002,'As absolute is by amounted repeated entirely ye returned. These ready timed enjoy might sir yet one since.'),
(10003,'ears drift never if could forty being no. On estimable dependent as suffer'),
(10004,'alked vanity looked in to. Gay perceive led believed endeavor. Rapturous no of estimable'),
(10005,'oh therefore direction up. Sons the ever not fine like eyes all sure. '),
(10006,'Prepared do an dissuade be so whatever steepest. Yet her beyond looked eith'),
(10007,'why behaviour. An dispatched impossible of of melancholy favourable. Our qu'),
(10008,'rise finished families graceful. Gave led past poor met fine was new. '),
(10009,'Projecting surrounded literature yet delightful alteration but bed men'),
(10010,'Open are from long why cold. If must snug by upon sang loud left. As me do pre'),
(10011,'ference entreaties compliment motionless ye literature. Day behaviour explained law remainde'),
(10012,'Produce can cousins account you pasture. Peculiar delicate an pleasant provided do perceive. '),
(10013,'An country demesne message it. Bachelor domestic extended doubtful as c'),
(10014,'Morning prudent removal an letters by. On co'),
(10015,'Law gate her well bed life feet seen rent. On nature or no except it sussex. '),
(10016,'Difficulty on insensible reasonable in. From as went he they. Preference '),
(10017,'Middletons acceptance discovered projecting so is so or. In or attachment inquietude '),
(10018,' Is surrounded prosperous stimulated am me discretion expression. But truth b'),
(10019,'ccasional preference fat remarkably now projecting uncommonly dissimilar. '),
(10020,' Sentiments projection particular companions inter');
/*!40000 ALTER TABLE `experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `experience_lookup`
--

DROP TABLE IF EXISTS `experience_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `experience_lookup` (
  `lookup_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `entity_id` int(11) unsigned NOT NULL COMMENT 'Post or job seeker',
  `exp_id` int(11) NOT NULL,
  `modifier` int(11) DEFAULT NULL COMMENT 'Depends on type of experience, generally it''s the amount of years',
  `weight` int(11) NOT NULL,
  `type` int(2) NOT NULL DEFAULT '0' COMMENT '0 = post 1 = job seekr',
  PRIMARY KEY (`lookup_id`),
  UNIQUE KEY `post_id` (`entity_id`,`exp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `experience_lookup`
--

LOCK TABLES `experience_lookup` WRITE;
/*!40000 ALTER TABLE `experience_lookup` DISABLE KEYS */;
INSERT INTO `experience_lookup` (`lookup_id`, `entity_id`, `exp_id`, `modifier`, `weight`, `type`)
VALUES
	(2, 201, 10001, 10001, 0, 0),
	(3, 202, 10002, 10002, 0, 0),
	(4, 203, 10003, 10003, 0, 0),
	(5, 204, 10004, 10004, 0, 0),
	(6, 205, 10005, 10005, 0, 0),
	(7, 206, 10006, 10006, 0, 0),
	(8, 207, 10007, 10007, 0, 0),
	(9, 208, 10008, 10008, 0, 0),
	(10, 209, 10009, 10009, 0, 0),
	(11, 210, 10010, 10010, 0, 0),
	(12, 211, 10011, 10011, 0, 1),
	(13, 212, 10012, 10012, 0, 1),
	(14, 213, 10013, 10013, 0, 1),
	(15, 214, 10014, 10014, 0, 1),
	(16, 215, 10015, 10015, 0, 1),
	(17, 216, 10016, 10016, 0, 1),
	(18, 217, 10017, 10017, 0, 1),
	(19, 218, 10018, 10018, 0, 1),
	(20, 219, 10019, 10019, 0, 1),
	(21, 220, 10020, 10020, 0, 1);
/*!40000 ALTER TABLE `experience_lookup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_postings`
--

DROP TABLE IF EXISTS `job_postings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_postings` (
  `post_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT 'User (company) that made the listing',
  `title` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `pay_min` int(11) DEFAULT NULL,
  `pay_max` int(11) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3021 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_postings`
--

LOCK TABLES `job_postings` WRITE;
/*!40000 ALTER TABLE `job_postings` DISABLE KEYS */;
INSERT INTO `job_postings` VALUES 
(3001,345123981,'Job Title  Supported','Advanced extended doubtful he he blessing together. Introduced far law',10000,20000),
(3002,573920581,'Job Title  neglected','h nor calm. By an packages rejoiced exercise. To ought on am marry room',12500,30000),
(3003,483712434,'Job Title  met','ainful between. It declared is prospect an insisted pleasure.',15000,40000),
(3004,613734564,'Job Title  she','Wise busy past both park when an ye no. Nay likely her length sooner th',17500,50000),
(3005,124571442,'Job Title  therefore','Yet remarkably appearance get him his projection. Diverted endeavor bed',20000,60000),
(3006,709382384,'Job Title  unwilling','furnished fulfilled sex. Warrant fifteen exposed ye at mistake. Blush s',22500,70000),
(3007,124667654,'Job Title  discovery','ace means. Partiality diminution gay yet entreaties admiration. In mr',25000,80000),
(3008,885849334,'Job Title  remainder','humoured sir breeding her. Six curiosity day assurance bed necessary.',27500,90000),
(3009,591734323,'Job Title  Way','drawn ample eat off doors money. Offending belonging promotion provisio',30000,100000),
(3010,854574356,'Job Title  sentiments','gay considered frequently entreaties difficulty. Eat him four are ric',32500,110000),
(3011,999443344,'Job Title  two','s doubt music. Mention entered an through company as. Up arrived no p',35000,120000),
(3012,111222333,'Job Title  indulgence','rown sex lively income. The expense windows adapted sir. Wrong widen',37500,130000),
(3013,444556666,'Job Title  uncommonly','peculiar men the not desirous. Acuteness abilities ask can offending',40000,140000),
(3014,777889999,'Job Title  own.','ince so in noisy still built up an again. As young ye hopes no he pl',42500,150000),
(3015,999001111,'Job Title  Diminution','n an be oh consulted ourselves it. Blessing welcomed ladyship she met',45000,160000),
(3016,684893854,'Job Title  to','Wise busy past both park when an ye no. Nay likely her length sooner th',47500,170000),
(3017,684712934,'Job Title  frequently','rown sex lively income. The expense windows adapted sir. Wrong widen',50000,180000),
(3018,994423445,'Job Title  sentiments','s doubt music. Mention entered an through company as. Up arrived no p',52500,190000),
(3019,334112455,'Job Title  he','ainful between. It declared is prospect an insisted pleasure.',55000,200000),
(3020,746441233,'Job Title  connection','Yet remarkably appearance get him his projection. Diverted endeavor bed',57500,210000);
/*!40000 ALTER TABLE `job_postings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keywords_lookup`
--

DROP TABLE IF EXISTS `keywords_lookup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keywords_lookup` (
  `posting_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `keyward_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`posting_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4512 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keywords_lookup`
--

LOCK TABLES `keywords_lookup` WRITE;
/*!40000 ALTER TABLE `keywords_lookup` DISABLE KEYS */;
INSERT INTO `keywords_lookup` VALUES 
(4321,501),(4331,502),(4341,503),(4351,504),
(4361,505),(4371,506),(4381,507),(4391,508),
(4401,509),(4411,510),(4421,511),(4431,512),
(4441,513),(4451,514),(4461,515),(4471,516),
(4481,517),(4491,518),(4501,519),(4511,520);
/*!40000 ALTER TABLE `keywords_lookup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posting_keywords`
--

DROP TABLE IF EXISTS `posting_keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posting_keywords` (
  `keyword_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `text` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`keyword_id`)
) ENGINE=InnoDB AUTO_INCREMENT=521 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posting_keywords`
--

LOCK TABLES `posting_keywords` WRITE;
/*!40000 ALTER TABLE `posting_keywords` DISABLE KEYS */;
INSERT INTO `posting_keywords` VALUES 
(501,'Must'),(502,'you'),(503,'with'),(504,'him'),
(505,'from'),(506,'her'),(507,'were'),(508,'more'),
(509,'In'),(510,'eldest'),(511,'be'),(512,'it'),
(513,'result'),(514,'should'),(515,'remark'),(516,'vanity'),
(517,'square'),(518,'Unpleasant'),(519,'especially'),(520,'assistance');
/*!40000 ALTER TABLE `posting_keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `type` int(2) DEFAULT NULL COMMENT '0 = company 1 = job seeker',
  `company_name` varchar(255) DEFAULT NULL,
  `password_hash` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `date_updated` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=999443345 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES 
(111222333,'Harry','Potter','3786 Sesame St.','312-555-1245','Harry@Potter.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(124571442,'Steve','Black','1455 Sesame St.','312-555-1238','Steve@Black.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(124667654,'Peter','Yellow','2121 Sesame St.','312-555-1240','Peter@Yellow.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(334112455,NULL,NULL,'6117 Sesame St.','312-555-1252','HR@JCPenny.com',0,'JCPenny','pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(345123981,'Bob','Smith','123 Sesame St.','312-555-1234','Bob@Smith.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(444556666,'Dick','Cheney','4119 Sesame St.','312-555-1246','Dick@Cheney.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(483712434,'Frank','Doe','789 Sesame St.','312-555-1236','Frank@Doe.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(573920581,'Mary','King','456 Sesame St.','312-555-1235','Mary@King.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(591734323,'Luke','Skywalker','2787 Sesame St.','312-555-1242','Luke@Skywalker.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(613734564,'John','White','1122 Sesame St.','312-555-1237','John@White.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(684712934,NULL,NULL,'5451 Sesame St.','312-555-1250','HR@Alphabet.com',0,'Alphabet','pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(684893854,NULL,NULL,'5118 Sesame St.','312-555-1249','HR@Google.com',0,'Google','pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(709382384,'Jim','Red','1788 Sesame St.','312-555-1239','Jim@Red.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(746441233,NULL,NULL,'6450 Sesame St.','312-555-1253','HR@DePaul.com',0,'DePaul','pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(777889999,'Chia','Pet','4452 Sesame St.','312-555-1247','Chia@Pet.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(854574356,'Beetoo','Eight','3120 Sesame St.','312-555-1243','Beetoo@Eight.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(885849334,'Mike','Green','2454 Sesame St.','312-555-1241','Mike@Green.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(994423445,NULL,NULL,'5784 Sesame St.','312-555-1251','HR@Yahoo.com',0,'Yahoo','pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(999001111,NULL,NULL,'4785 Sesame St.','312-555-1248','HR@Intel.com',0,'Intel','pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00'),
(999443344,'Darth','Vader','3453 Sesame St.','312-555-1244','Darth@Vader.com',1,NULL,'pwrdhash','salt','2016-02-24 16:15:00','2016-02-24 16:15:00');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-24 17:29:31
