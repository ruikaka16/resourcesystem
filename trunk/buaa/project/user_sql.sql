DROP TABLE IF EXISTS `test`.`user`;
CREATE TABLE  `test`.`user` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `psw` varchar(10) NOT NULL DEFAULT '',
  `type` int(1) unsigned NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;