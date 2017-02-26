-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Фев 26 2017 г., 12:43
-- Версия сервера: 10.1.16-MariaDB
-- Версия PHP: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `GeneratedStore`
--

-- --------------------------------------------------------

--
-- Структура таблицы `catalog`
--

CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(40) NOT NULL,
  `size` varchar(20) NOT NULL,
  `collection` varchar(20) NOT NULL,
  `country` varchar(20) NOT NULL,
  `vendor_code` varchar(15) NOT NULL,
  `img` varchar(40) NOT NULL,
  `price` int(11) NOT NULL,
  `sale` int(11) DEFAULT NULL,
  `salePrice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `catalog`
--

INSERT INTO `catalog` (`id`, `name`, `description`, `size`, `collection`, `country`, `vendor_code`, `img`, `price`, `sale`, `salePrice`) VALUES
(1, 'Andrea Rossi', 'Виниловые на флизелиновой основе', '1,06м. х 10,05 м.', 'Burano', 'Италия', '', 'assets/img/Burano.jpg', 50, 30, 35),
(2, 'Andrea Rossi', 'Виниловые на флизелиновой основе', '1,06м. х 10,05 м.', 'Ponza', 'Италия', '', 'assets/img/Ponza.jpg', 50, 0, 50),
(3, 'Loymina', 'Флизелиновые обои', '1м. х 10,05 м.', 'Boudoir', 'Россия', '', 'assets/img/Boudoir.jpg', 120, 20, 96),
(4, 'Loymina', 'Флизелиновые обои', '1м. х 10,05 м', 'Amber Salon', 'Россия', '', 'assets/img/AmberSalon.jpg', 120, 0, 120),
(5, 'Marburg', 'Виниловые на флизелиновой основе', '0,75 м x 10,05 м', 'Pure', 'Германия', '', 'assets/img/Pure.jpg', 50, 0, 50),
(6, 'Milassa', 'Флизелиновые обои', '1м. х 10,05 м.', 'Joli', 'Россия', '', 'assets/img/Joli.jpg', 70, 0, 70),
(7, 'Murella', 'Винил на флизелиновой основе', '1,06м. х 10,05 м.', 'Splendor', 'Италия', '', 'assets/img/Splendor.jpg', 80, 0, 80),
(8, 'Murella', 'Винил на флизелиновой основе', '1,06м. х 10,05 м.', 'Regalis', 'Италия', '', 'assets/img/Regalis.jpg', 70, 0, 70),
(9, 'Milassa', 'Флизелиновые обои', '1м. х 10,05 м.', 'Flos', 'Россия', '', 'assets/img/Flos.jpg', 50, 0, 50),
(10, 'Crocus', 'Бумага, водостойкие', '1м. х 10,05 м.', 'Beladeco', 'Украина', '1058-X', 'assets/img/Beladeco.jpg', 20, 0, 20);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `catalog`
--
ALTER TABLE `catalog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
