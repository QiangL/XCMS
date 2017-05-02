CREATE TABLE `car` (
  `car_id` int(11) NOT NULL AUTO_INCREMENT,
  `car_number` int(11) NOT NULL,
  `car_model` varchar(100) DEFAULT NULL,
  `car_displacement` varchar(10) DEFAULT NULL,
  `car_color` varchar(10) DEFAULT NULL,
  `car_company_id` int(11) NOT NULL,
  `cahr_image` varchar(100) NOT NULL,
  PRIMARY KEY (`car_id`),
  UNIQUE KEY `car_number_UNIQUE` (`car_number`),
  UNIQUE KEY `car_id_UNIQUE` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
