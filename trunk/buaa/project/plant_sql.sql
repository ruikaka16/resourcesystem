DROP TABLE IF EXISTS `test`.`plant`;
CREATE TABLE  `test`.`plant` (
  `id` varchar(10) NOT NULL DEFAULT '' COMMENT '����ͳһ���',
  `NAME_CHN` varchar(10) NOT NULL DEFAULT '' COMMENT '��������',
  `NAME_FORN` varchar(20) NOT NULL DEFAULT '' COMMENT 'Ӣ������',
  `ZHONG_NAME` varchar(20) NOT NULL DEFAULT '' COMMENT '����',
  `LOCATION` varchar(10) NOT NULL DEFAULT '' COMMENT '����',
  `SAVE_ID` varchar(10) NOT NULL DEFAULT '' COMMENT '���浥λ���',
  `NAME_BELONG` varchar(20) NOT NULL DEFAULT '' COMMENT '����',
  `ID_LOCATION` varchar(10) NOT NULL DEFAULT '' COMMENT '�����ر���',
  `ORIGINAL` varchar(10) NOT NULL DEFAULT '' COMMENT '��Դ��',
  `COUNTRY` varchar(20) NOT NULL DEFAULT '' COMMENT '����',
  `PROVINCE` varchar(10) NOT NULL DEFAULT '' COMMENT '��Դʡ',
  `FEATURE` varchar(20) NOT NULL DEFAULT '' COMMENT '��Ҫ��������',
  `TYPE` varchar(10) NOT NULL DEFAULT '' COMMENT '��Դ����',
  `SAVE_TYPE` varchar(10) NOT NULL DEFAULT '' COMMENT '������Դ����',
  `STATUS` varchar(10) NOT NULL DEFAULT '' COMMENT 'ʵ��״̬',
  `SHARE` varchar(10) NOT NULL DEFAULT '' COMMENT '����ʽ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;