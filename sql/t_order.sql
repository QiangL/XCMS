CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_driver_id` varchar(13) NOT NULL,
  `order_date` date NOT NULL,
  `order_quantity` int(11) DEFAULT NULL,
  `order_transaction_amount` double DEFAULT NULL,
  `order_charging_time` double DEFAULT NULL,
  `order_bad_review` double DEFAULT NULL,
  `order_driver_score` double DEFAULT NULL,
  `order_driver_grade` varchar(2) DEFAULT NULL,
  `order_reward` double DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=179 DEFAULT CHARSET=utf8;
