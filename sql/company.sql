CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_number` int(11) NOT NULL,
  `company_name` varchar(50) NOT NULL,
  `company_owner` varchar(50) NOT NULL,
  `company_tel` varchar(11) DEFAULT NULL,
  `company_email` varchar(50) DEFAULT NULL,
  `company_account` varchar(30) NOT NULL,
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `company_id_UNIQUE` (`company_id`),
  UNIQUE KEY `company_number_UNIQUE` (`company_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
