-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.6-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table SurveyTestDB.surveytestdb
CREATE TABLE IF NOT EXISTS `surveytestdb` (
  `id` int(11) DEFAULT NULL,
  `timestamp` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `role` varchar(150) DEFAULT NULL,
  `piclink` varchar(150) DEFAULT NULL,
  `project` varchar(150) DEFAULT NULL,
  `client` varchar(150) DEFAULT NULL,
  `college` varchar(150) DEFAULT NULL,
  `degree` varchar(150) DEFAULT NULL,
  `fact1` varchar(150) DEFAULT NULL,
  `fact2` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
