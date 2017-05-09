CREATE TABLE `car` (
  `car_id` varchar(12) NOT NULL,
  `car_number` varchar(7) NOT NULL,
  `car_model` varchar(20) DEFAULT NULL,
  `car_displacement` varchar(10) DEFAULT NULL,
  `car_color` varchar(10) DEFAULT NULL,
  `car_company_id` int(10) NOT NULL,
  `car_image` varchar(100) NOT NULL,
  `car_exam` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`car_id`),
  UNIQUE KEY `car_number_UNIQUE` (`car_number`),
  UNIQUE KEY `car_id_UNIQUE` (`car_id`),
  KEY `company_id_idx` (`car_company_id`),
  CONSTRAINT `company_id` FOREIGN KEY (`car_company_id`) REFERENCES `company` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
