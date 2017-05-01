CREATE TABLE `finance` (
  `finance_id` int(11) NOT NULL AUTO_INCREMENT,
  `finance_company_id` int(11) NOT NULL,
  `finance_amount` decimal(10,2) NOT NULL,
  `finance_satues` int(11) NOT NULL,
  `finance_date` datetime NOT NULL,
  `finance_oprator_id` int(11) NOT NULL,
  PRIMARY KEY (`finance_id`),
  UNIQUE KEY `finance_id_UNIQUE` (`finance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
