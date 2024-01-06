-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for e-waste
CREATE DATABASE IF NOT EXISTS `e-waste` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `e-waste`;

-- Dumping structure for table e-waste.kurir
CREATE TABLE IF NOT EXISTS `kurir` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `email_kurir` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `point_kurir` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `kurir_email_unique` (`email_kurir`),
  CONSTRAINT `kurir_ibfk_1` FOREIGN KEY (`email_kurir`) REFERENCES `users` (`email_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table e-waste.kurir: ~0 rows (approximately)

-- Dumping structure for table e-waste.sampah
CREATE TABLE IF NOT EXISTS `sampah` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name_sampah` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `kategori_sampah` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_kurir` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `view_sampah` int DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `email_kurir` (`email_kurir`),
  KEY `email_user` (`email_user`),
  CONSTRAINT `sampah_ibfk_1` FOREIGN KEY (`email_kurir`) REFERENCES `kurir` (`email_kurir`),
  CONSTRAINT `sampah_ibfk_2` FOREIGN KEY (`email_user`) REFERENCES `users` (`email_user`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table e-waste.sampah: ~0 rows (approximately)

-- Dumping structure for table e-waste.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `telp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `alamat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `point` int DEFAULT '0',
  `is_kurir` tinyblob NOT NULL,
  `is_admin` tinyblob NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_unique` (`email_user`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table e-waste.users: ~2 rows (approximately)
REPLACE INTO `users` (`id`, `name`, `email_user`, `password`, `telp`, `alamat`, `point`, `is_kurir`, `is_admin`) VALUES
	(13, 'admin', 'admin@gmail.com', 'admin123', '081234567890', 'Bandung', 0, _binary 0x30, _binary 0x31),
	(14, 'nama saya ini', 'ini@gmail.com', '123123', '56789098765', 'alamat saya ini', 0, _binary 0x30, _binary 0x30);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
