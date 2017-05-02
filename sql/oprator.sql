CREATE TABLE `oprator` (
  `oprator_id` int(11) NOT NULL AUTO_INCREMENT,
  `oprator_number` int(11) NOT NULL,
  `oprator_password` varchar(20) NOT NULL,
  PRIMARY KEY (`oprator_id`),
  UNIQUE KEY `oprator_number_UNIQUE` (`oprator_number`),
  UNIQUE KEY `oprator_id_UNIQUE` (`oprator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
