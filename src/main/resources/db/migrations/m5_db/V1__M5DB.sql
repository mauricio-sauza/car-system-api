-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: db:3306
-- Generation Time: Sep 09, 2022 at 08:49 PM
-- Server version: 8.0.30
-- PHP Version: 8.0.19
SET
  SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;

SET
  time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */
;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */
;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */
;

/*!40101 SET NAMES utf8mb4 */
;

--
-- Database: `m5_db`
--
-- --------------------------------------------------------
--
-- Table structure for table `cars`
--
CREATE TABLE `cars` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `brand` varchar(60) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `model` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `color` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

--
-- Dumping data for table `cars`
--
INSERT INTO
  `cars` (
    `id`,
    `brand`,
    `model`,
    `color`
  )
VALUES
  (
    1,
    'TOYOTA',
    'Supra xl',
    'Blue'
  ),
  (
    2,
    'SUBARU',
    'Impresa SX',
    'Blue'
  );

--
-- Indexes for dumped tables
--
--
-- Indexes for table `cars`
--
ALTER TABLE
  `cars`
ADD
  PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--
--
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE
  `cars`
MODIFY
  `id` int NOT NULL AUTO_INCREMENT,
  AUTO_INCREMENT = 3;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */
;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */
;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */
;

--mvn clean flyway:migrate -Dflyway.configFiles=myFlywayConfig.conf