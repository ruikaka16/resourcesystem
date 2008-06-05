DROP TABLE IF EXISTS `test`.`plant`;
CREATE TABLE  `test`.`plant` (
  `id` varchar(10) NOT NULL DEFAULT '' COMMENT '国家统一编号',
  `NAME_CHN` varchar(10) NOT NULL DEFAULT '' COMMENT '中文名称',
  `NAME_FORN` varchar(20) NOT NULL DEFAULT '' COMMENT '英文名称',
  `ZHONG_NAME` varchar(20) NOT NULL DEFAULT '' COMMENT '种名',
  `LOCATION` varchar(10) NOT NULL DEFAULT '' COMMENT '产地',
  `SAVE_ID` varchar(10) NOT NULL DEFAULT '' COMMENT '保存单位编号',
  `NAME_BELONG` varchar(20) NOT NULL DEFAULT '' COMMENT '属名',
  `ID_LOCATION` varchar(10) NOT NULL DEFAULT '' COMMENT '归属地编码',
  `ORIGINAL` varchar(10) NOT NULL DEFAULT '' COMMENT '来源地',
  `COUNTRY` varchar(20) NOT NULL DEFAULT '' COMMENT '产国',
  `PROVINCE` varchar(10) NOT NULL DEFAULT '' COMMENT '来源省',
  `FEATURE` varchar(20) NOT NULL DEFAULT '' COMMENT '主要特征特性',
  `TYPE` varchar(10) NOT NULL DEFAULT '' COMMENT '资源类型',
  `SAVE_TYPE` varchar(10) NOT NULL DEFAULT '' COMMENT '保存资源类型',
  `STATUS` varchar(10) NOT NULL DEFAULT '' COMMENT '实物状态',
  `SHARE` varchar(10) NOT NULL DEFAULT '' COMMENT '共享方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;