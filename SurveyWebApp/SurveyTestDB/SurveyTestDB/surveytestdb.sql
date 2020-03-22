CREATE TABLE `SurveyTestDB`.`surveytestdb` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `timestamp` varchar(150) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `college` varchar(150) DEFAULT NULL,
  `degree` varchar(150) DEFAULT NULL,
  `role` varchar(150) DEFAULT NULL,
  `project` varchar(150) DEFAULT NULL,
  `client` varchar(150) DEFAULT NULL,
  `fact1` varchar(150) DEFAULT NULL,
  `fact2` varchar(150) DEFAULT NULL,
  `piclink` varchar(150) DEFAULT 'Piclink.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;