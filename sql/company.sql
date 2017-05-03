CREATE TABLE `company` (
  `company_id` int(7) NOT NULL,
  `company_name` varchar(50) NOT NULL,
  `company_owner` varchar(50) NOT NULL,
  `company_tel` varchar(11) DEFAULT NULL,
  `company_email` varchar(50) DEFAULT NULL,
  `company_public_account` varchar(9) NOT NULL,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `company_id_UNIQUE` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
