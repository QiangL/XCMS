CREATE TABLE `oprator` (
  `oprator_id` varchar(20) NOT NULL,
  `oprator_password` varchar(24) NOT NULL,
  PRIMARY KEY (`oprator_id`),
  UNIQUE KEY `oprator_id_UNIQUE` (`oprator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
