DROP TABLE IF EXISTS `test`.`largedevice`;
CREATE TABLE  `test`.`largedevice` (
  `name` varchar(45) NOT NULL DEFAULT '',
  `id` varchar(45) NOT NULL DEFAULT '',
  `time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;