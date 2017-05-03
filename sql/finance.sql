CREATE TABLE `finance` (
  `finance_id` int(11) NOT NULL AUTO_INCREMENT,
  `finance_company_id` int(11) NOT NULL,
  `finance_amount` decimal(10,2) NOT NULL,
  `finance_status` varchar(6) NOT NULL,
  `finance_date` datetime NOT NULL,
  `finance_oprator_id` varchar(20) NOT NULL,
  PRIMARY KEY (`finance_id`),
  UNIQUE KEY `finance_id_UNIQUE` (`finance_id`),
  KEY `company_id_finance_idx` (`finance_company_id`),
  KEY `oprator_id_idx` (`finance_oprator_id`),
  CONSTRAINT `company_id_finance` FOREIGN KEY (`finance_company_id`) REFERENCES `company` (`company_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `oprator_id` FOREIGN KEY (`finance_oprator_id`) REFERENCES `oprator` (`oprator_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
