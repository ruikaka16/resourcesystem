DROP TABLE IF EXISTS `test`.`faren`;
CREATE TABLE  `test`.`faren` (
  `name` varchar(45) NOT NULL DEFAULT '',
  `zhuguan` varchar(45) NOT NULL DEFAULT '',
  `address` varchar(45) NOT NULL DEFAULT '',
  `suozaiaddress` varchar(45) NOT NULL DEFAULT '',
  `xingzhi` varchar(45) NOT NULL DEFAULT '',
  `id` varchar(45) NOT NULL DEFAULT '',
  `id_1` varchar(45) NOT NULL DEFAULT '',
  `jigouid` varchar(45) NOT NULL DEFAULT '',
  `xzzgbm` varchar(45) NOT NULL DEFAULT '',
  `zipcode` varchar(45) NOT NULL DEFAULT '',
  `dwwz` varchar(45) NOT NULL DEFAULT '',
  `dwsx` varchar(45) NOT NULL DEFAULT '',
  `hymc` varchar(45) NOT NULL DEFAULT '',
  `xkmc` varchar(45) NOT NULL DEFAULT '',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;