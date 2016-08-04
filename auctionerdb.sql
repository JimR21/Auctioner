-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: auctionerdb
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
-- Table structure for table `auction_bidding`
--

DROP TABLE IF EXISTS `auction_bidding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auction_bidding` (
  `auctionid` int(11) NOT NULL,
  `bidder_userid` int(11) NOT NULL,
  `amount` varchar(45) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`auctionid`,`bidder_userid`),
  KEY `fk_auction_bidding_users1_idx` (`bidder_userid`),
  CONSTRAINT `fk_auction_bidding_auctions1` FOREIGN KEY (`auctionid`) REFERENCES `auctions` (`auctionid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_auction_bidding_users1` FOREIGN KEY (`bidder_userid`) REFERENCES `users` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auction_categories`
--

DROP TABLE IF EXISTS `auction_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auction_categories` (
  `auction_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`auction_id`,`category_id`),
  KEY `auction_categories_categoryid_fk_idx` (`category_id`),
  CONSTRAINT `auction_categories_auctionid_fk` FOREIGN KEY (`auction_id`) REFERENCES `auctions` (`auctionid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `auction_categories_categoryid_fk` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `auctions`
--

DROP TABLE IF EXISTS `auctions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `auctions` (
  `auctionid` int(11) NOT NULL AUTO_INCREMENT,
  `seller_userid` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `description` mediumtext NOT NULL,
  `first_bid` varchar(45) NOT NULL,
  `buy_price` varchar(45) DEFAULT NULL,
  `currently` varchar(45) NOT NULL,
  `number_of_bids` int(11) NOT NULL,
  `country` varchar(45) NOT NULL,
  `location_id` int(11) NOT NULL,
  `started` datetime NOT NULL,
  `ends` datetime NOT NULL,
  PRIMARY KEY (`auctionid`),
  KEY `fk_auctions_users1_idx` (`seller_userid`),
  KEY `fk_auctions_location1_idx` (`location_id`),
  CONSTRAINT `fk_auctions_location1` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_auctions_users1` FOREIGN KEY (`seller_userid`) REFERENCES `users` (`userid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `userid` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`userid`,`role`),
  KEY `user_id_idx` (`userid`),
  CONSTRAINT `userid` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `latitude` decimal(11,8) DEFAULT NULL,
  `longitude` decimal(11,8) DEFAULT NULL,
  PRIMARY KEY (`location_id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=518 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(55) NOT NULL,
  `password` varchar(60) NOT NULL,
  `afm` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `approved` tinyint(4) NOT NULL,
  `bidder_rating` varchar(45) DEFAULT NULL,
  `seller_rating` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `afm_UNIQUE` (`afm`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-04  3:32:04
