CREATE TABLE `driver` (
  `driver_id` varchar(8) NOT NULL,
  `driver_number` varchar(11) NOT NULL,
  `driver_name` varchar(5) NOT NULL,
  `driver_gender` varchar(2) NOT NULL,
  `driver_age` int(11) NOT NULL,
  `driver_company_id` int(7) NOT NULL,
  `driver_image` varchar(100) NOT NULL,
  `driver_bind_car_id` int(9) DEFAULT NULL,
  `driver_order_quantity` int(11) DEFAULT NULL,
  `driver_charging_time` double DEFAULT NULL,
  `driver_transaction_amount` decimal(6,2) DEFAULT NULL,
  `driver_bad_review` double DEFAULT NULL,
  `driver_score` double DEFAULT NULL,
  `driver_grade` varchar(2) DEFAULT NULL,
  `driver_exam` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`driver_id`),
  UNIQUE KEY `driver_id_UNIQUE` (`driver_id`),
  UNIQUE KEY `driver_number_UNIQUE` (`driver_number`),
  UNIQUE KEY `driver_bind_car_id_UNIQUE` (`driver_bind_car_id`),
  KEY `company_id_idx` (`driver_company_id`),
  KEY `company_id_driver_idx` (`driver_company_id`),
  CONSTRAINT `company_id_driver` FOREIGN KEY (`driver_company_id`) REFERENCES `company` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
