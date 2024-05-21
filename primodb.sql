-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2024 at 12:01 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `primodb`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounttb`
--

CREATE TABLE `accounttb` (
  `Username` varchar(100) DEFAULT NULL,
  `Type` varchar(8) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `PhoneNumber` varchar(15) DEFAULT NULL,
  `NIK` varchar(16) DEFAULT NULL,
  `Balance` double NOT NULL,
  `Password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `accounttb`
--

INSERT INTO `accounttb` (`Username`, `Type`, `Email`, `PhoneNumber`, `NIK`, `Balance`, `Password`) VALUES
('Jawa', 'Premium', 'Jawa@mail.com', '0821247910', '4536123476521324', 249022, 'JAwa'),
('FansClub Raka', 'Reguler', 'Uhuy@gmail.com', '01923890128', '0', 0, 'Uhuy'),
('Mawan', 'Reguler', '123@gmail.com', '0812398109', '0', 11120, '123'),
('premiumDUMMY', 'Premium', '123', '123', '0', 49100, '123'),
('Ella', 'Reguler', 'ellacantik@gmail.com', '086767892035', '0', 174321, 'Ellacantik123'),
('dwa', 'Reguler', 'ddawa@gmail.com', '081212678789', '0', 0, 'Jomok1234');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
