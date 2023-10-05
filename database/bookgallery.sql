-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Oct 05, 2023 at 02:48 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookgallery`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `cover` varchar(255) DEFAULT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL DEFAULT 0,
  `tag` varchar(255) DEFAULT NULL,
  `downloads` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `author`, `content`, `cover`, `intro`, `name`, `price`, `tag`, `downloads`) VALUES
(1, 'Ernest Hemingway', 'https://www.aliceandbooks.com/book/download-link/626/1874', 'https://m.media-amazon.com/images/I/61y4XeiQLnL._AC_UF894,1000_QL80_.jpg', 'It tells the story of Santiago, an aging fisherman who catches a giant marlin after a lengthy struggle, but who then loses his bounty to sharks.', 'The Old Man and the Sea', 1.2, '	Literary Fiction', 7),
(2, 'Thomas H. Cormen', 'https://www.aliceandbooks.com/book/download-link/626/1874', 'https://m.media-amazon.com/images/I/41vLer1KbmL.jpg', 'A comprehensive update of the leading algorithms text, with new material on matchings in bipartite graphs, online algorithms, machine learning, and other topics.', 'Introduction to Algorithms', 3.8, 'Computer Science', 0),
(4, 'Jane Doe', 'https://www.aliceandbooks.com/book/download-link/626/1874', 'https://m.media-amazon.com/images/I/41vLer1KbmL.jpg', 'Just a book.', 'Demo Book 2', 1, 'Other', 6),
(5, 'John Doe', 'https://www.aliceandbooks.com/book/download-link/626/1874', 'https://m.media-amazon.com/images/I/41vLer1KbmL.jpg', 'Just a book.', 'Demo Book', 1, 'Other', 5),
(8, 'John Doe', 'https://www.aliceandbooks.com/book/download-link/626/1874', 'https://m.media-amazon.com/images/I/41vLer1KbmL.jpg', 'Just a book.', 'Demo Book', 1, 'Other', 5),
(9, 'abc', 'https://www.aliceandbooks.com/book/download-link/626/1874', 'https://m.media-amazon.com/images/I/61y4XeiQLnL._AC_UF894,1000_QL80_.jpg', 'abcdefghijklmn', 'The Ninth Book', 9.9, 'Unknow', 0),
(18, 'Z', 'https://www.aliceandbooks.com/book/download-link/626/1874', 'https://m.media-amazon.com/images/I/41vLer1KbmL.jpg', 'Z file.', 'Demo Book Z', 3.1, 'Z', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
