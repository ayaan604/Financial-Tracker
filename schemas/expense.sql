CREATE TABLE `expense` (
  `expense_id` bigint NOT NULL AUTO_INCREMENT,
  `amount` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `timestamp` date DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`expense_id`),
  KEY `FKr376ysaygq5hasrysgj5ax04y` (`user_id`),
  CONSTRAINT `FKr376ysaygq5hasrysgj5ax04y` FOREIGN KEY (`user_id`) REFERENCES `f_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci