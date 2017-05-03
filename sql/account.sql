CREATE TABLE `account` (
  `account_id` varchar(20) NOT NULL,
  `account_password` varchar(24) NOT NULL,
  `account_company_id` int(7) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id_UNIQUE` (`account_id`),
  KEY `company)id_idx` (`account_company_id`),
  CONSTRAINT `company_id_account` FOREIGN KEY (`account_company_id`) REFERENCES `company` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
