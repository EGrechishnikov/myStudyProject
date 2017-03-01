-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Мар 01 2017 г., 17:10
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
(10, 'Crocus', 'Бумага, водостойкие', '1м. х 10,05 м.', 'Beladeco', 'Украина', '1058-X', 'assets/img/Beladeco.jpg', 20, 0, 20),
(11, 'Sirpi', 'Виниловые обои на флизелиновой основе', '0,53м. х 10,05 м.', 'Altagamma Home', 'Италия', '', 'assets/img/Altagamma.jpg', 32, 5, 30);

-- --------------------------------------------------------

--
-- Структура таблицы `order_list`
--

CREATE TABLE `order_list` (
  `id` int(11) NOT NULL,
  `FK_User` int(11) NOT NULL,
  `FK_Goods` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `isPayed` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `order_list`
--

INSERT INTO `order_list` (`id`, `FK_User`, `FK_Goods`, `amount`, `isPayed`) VALUES
(9, 98, 2, 0, 'y'),
(52, 147, 1, 4, 'y'),
(53, 147, 3, 5, 'y'),
(56, 147, 2, 6, 'y'),
(59, 147, 1, 0, 'y'),
(119, 147, 3, 4, 'y'),
(120, 147, 5, 2, 'y');

-- --------------------------------------------------------

--
-- Структура таблицы `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'admin'),
(2, 'user'),
(3, 'test');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` varchar(13) NOT NULL,
  `salt` varchar(20) NOT NULL,
  `FK_Role` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `login`, `password`, `email`, `phone`, `salt`, `FK_Role`) VALUES
(1, 'admin', 'adminn', 'admin@mail.ru', '', '', 1),
(3, 'petya', '000000', 'petya@mail.ru', '', '', 2),
(4, 'kostya', '123456', 'kos@mail.ru', '', '', 2),
(5, 'vova', 'vov4ik', 'vov4ik@mail.ru', '', '', 2),
(6, 'sasha', '000000', 'sasha@mail.ru', '', '', 2),
(7, 'абв', '000000', 'a@m.ru', '', '', 2),
(10, 'вася', '000000', 'ma@mama.ru', '', '', 2),
(11, 'peter', '000000', 'a@aaaa.ru', '', '', 2),
(98, 'семен', '78aff9f68196282dcb61fdcaa4d90835e5a4ad2d825a2b05e5639ee69f4c7fca', 'semen@s.ru', '+375257778899', '195eec2282888148ad63', 2),
(126, 'evgeniy', '83d443b344d45c652dc9745ea23717e924f7e9da1d00ce4270b359b81308088b', 'ke6a93@gmail.com', '+375259243621', '885cc032fa4e0d5716e0', 2),
(136, 'Евгений', '657e7292fde2bb3c5f0441e0a90441c6f2c2e6b835dbc1a9293bfc5a2564b59a', 'abv@mail.ru', '+375255555555', 'ad32374eb4a7231ce627', 2),
(147, 'batman', '13e17d8a3e2a8bb4bc278768de5e5704603a50a8d728a0f8e91f8c106e2df2f4', 'superman@mail.ru', '+111111111111', '96ec501ffc6836c3e32c', 2),
(150, 'альфред', '81ad1212e0d5add06bad9e81f41dae3132aeff8d77fcc7c7450b34264de2f53c', 'alph@alph.ru', '+375221122121', '76902f237f1119e5a488', 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `order_list`
--
ALTER TABLE `order_list`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_User` (`FK_User`),
  ADD KEY `FK_Goods` (`FK_Goods`);

--
-- Индексы таблицы `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Roles` (`FK_Role`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `catalog`
--
ALTER TABLE `catalog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT для таблицы `order_list`
--
ALTER TABLE `order_list`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=139;
--
-- AUTO_INCREMENT для таблицы `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=159;
--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `order_list`
--
ALTER TABLE `order_list`
  ADD CONSTRAINT `order_list_ibfk_1` FOREIGN KEY (`FK_User`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `order_list_ibfk_2` FOREIGN KEY (`FK_Goods`) REFERENCES `catalog` (`id`);

--
-- Ограничения внешнего ключа таблицы `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`FK_Role`) REFERENCES `role` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
