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



-- Dumping structure for table e-waste.kategori_terbanyak
CREATE TABLE IF NOT EXISTS `kategori_terbanyak` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nama_kategori` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `jumlah_order` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `kategori_nama_unique` (`nama_kategori`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table e-waste.kategori_terbanyak: ~2 rows (approximately)
REPLACE INTO `kategori_terbanyak` (`id`, `nama_kategori`, `jumlah_order`) VALUES
	(1, 'Plastik', 1),
	(2, 'Kertas', 1),
	(3, 'botol plastik', 1),
	(4, 'komputer', 1);

-- Dumping structure for table e-waste.kurir
CREATE TABLE IF NOT EXISTS `kurir` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `email_kurir` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `point_kurir` int DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `kurir_email_unique` (`email_kurir`),
  CONSTRAINT `kurir_ibfk_1` FOREIGN KEY (`email_kurir`) REFERENCES `users` (`email_user`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table e-waste.kurir: ~1 rows (approximately)
REPLACE INTO `kurir` (`id`, `email_kurir`, `point_kurir`) VALUES
	(11, 'sarip@gmail.com', 72);

-- Dumping structure for table e-waste.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `email_user` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `daerah` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `total_sampah` int DEFAULT '0',
  `kategori_sampah` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `email_kurir` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `tanggal_order` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `email_kurir` (`email_kurir`),
  KEY `email_user` (`email_user`),
  KEY `total_sampah` (`total_sampah`,`email_user`,`daerah`,`email_kurir`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`email_kurir`) REFERENCES `kurir` (`email_kurir`),
  CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`email_user`) REFERENCES `users` (`email_user`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table e-waste.orders: ~6 rows (approximately)
REPLACE INTO `orders` (`id`, `email_user`, `daerah`, `total_sampah`, `kategori_sampah`, `email_kurir`, `tanggal_order`) VALUES
	(15, 'jack@gmail.com', 'Daerah A', 5, 'Plastik', 'sarip@gmail.com', '2024-01-07 17:20:47'),
	(16, 'jack@gmail.com', 'Daerah B', 8, 'Kertas', 'sarip@gmail.com', '2024-01-07 17:20:48'),
	(17, 'jack@gmail.com', 'Daerah A', 5, 'Plastik', 'sarip@gmail.com', '2024-01-07 17:45:56'),
	(18, 'jack@gmail.com', 'Daerah B', 8, 'Kertas', 'sarip@gmail.com', '2024-01-07 17:45:56'),
	(19, 'jack@gmail.com', 'Daerah S', 5, 'botol plastik', 'sarip@gmail.com', '2024-01-07 17:52:13'),
	(20, 'jack@gmail.com', 'Daerah G', 8, 'komputer', 'sarip@gmail.com', '2024-01-07 17:52:13');

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
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dumping data for table e-waste.users: ~3 rows (approximately)
REPLACE INTO `users` (`id`, `name`, `email_user`, `password`, `telp`, `alamat`, `point`, `is_kurir`, `is_admin`) VALUES
	(11, 'admin', 'admin@gmail.com', 'admin123', '081234567890', 'Bandung', 0, _binary 0x30, _binary 0x31),
	(14, 'saripudin', 'sarip@gmail.com', 'sarip123', '98989898989', 'Bandung', 0, _binary 0x31, _binary 0x30),
	(20, 'jack sparows', 'jack@gmail.com', 'jack123', '012345678910', 'Bandung', 36, _binary 0x30, _binary 0x30);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
