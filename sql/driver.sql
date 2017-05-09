CREATE TABLE `driver` (
  `driver_id` varchar(13) NOT NULL,
  `driver_number` varchar(11) NOT NULL,
  `driver_name` varchar(10) NOT NULL,
  `driver_gender` varchar(2) NOT NULL,
  `driver_age` int(11) NOT NULL,
  `driver_company_id` int(10) NOT NULL,
  `driver_image` varchar(100) NOT NULL,
  `driver_bind_car_id` varchar(12) DEFAULT NULL,
  `driver_exam` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`driver_id`),
  UNIQUE KEY `driver_id_UNIQUE` (`driver_id`),
  UNIQUE KEY `driver_number_UNIQUE` (`driver_number`),
  UNIQUE KEY `driver_bind_car_id` (`driver_bind_car_id`),
  KEY `company_id_idx` (`driver_company_id`),
  KEY `company_id_driver_idx` (`driver_company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
