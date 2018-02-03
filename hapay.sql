# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.1.10-MariaDB)
# Database: hapay
# Generation Time: 2018-02-03 00:31:45 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table ha_admin
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_admin`;

CREATE TABLE `ha_admin` (
  `admin_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_name` varchar(20) NOT NULL COMMENT '管理员名称',
  `admin_password` varchar(32) NOT NULL DEFAULT '' COMMENT '管理员密码',
  `admin_login_time` int(10) NOT NULL DEFAULT '0' COMMENT '登录时间',
  `admin_login_num` int(11) NOT NULL DEFAULT '0' COMMENT '登录次数',
  `admin_is_super` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否超级管理员',
  `admin_gid` smallint(6) DEFAULT '0' COMMENT '权限组ID',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

LOCK TABLES `ha_admin` WRITE;
/*!40000 ALTER TABLE `ha_admin` DISABLE KEYS */;

INSERT INTO `ha_admin` (`admin_id`, `admin_name`, `admin_password`, `admin_login_time`, `admin_login_num`, `admin_is_super`, `admin_gid`)
VALUES
	(1,'admin','7fef6171469e80d32c0559f88b377245',1517585979,105,1,0);

/*!40000 ALTER TABLE `ha_admin` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ha_admin_log
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_admin_log`;

CREATE TABLE `ha_admin_log` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `content` varchar(50) NOT NULL COMMENT '操作内容',
  `createtime` int(10) unsigned DEFAULT NULL COMMENT '发生时间',
  `admin_name` char(20) NOT NULL COMMENT '管理员',
  `admin_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '管理员ID',
  `ip` char(15) NOT NULL COMMENT 'IP',
  `url` varchar(50) NOT NULL DEFAULT '' COMMENT 'act&op',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员操作日志';



# Dump of table ha_article
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_article`;

CREATE TABLE `ha_article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '索引id',
  `ac_id` mediumint(8) unsigned NOT NULL DEFAULT '0' COMMENT '分类id',
  `article_url` varchar(100) DEFAULT NULL COMMENT '跳转链接',
  `article_show` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否显示，0为否，1为是，默认为0',
  `article_sort` tinyint(3) unsigned NOT NULL DEFAULT '255' COMMENT '排序',
  `article_title` varchar(100) DEFAULT NULL COMMENT '标题',
  `article_content` text COMMENT '内容',
  `article_time` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '发布时间',
  PRIMARY KEY (`article_id`),
  KEY `ac_id` (`ac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章表';



# Dump of table ha_article_class
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_article_class`;

CREATE TABLE `ha_article_class` (
  `ac_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '索引ID',
  `ac_code` varchar(20) DEFAULT NULL COMMENT '分类标识码',
  `ac_name` varchar(100) NOT NULL COMMENT '分类名称',
  `ac_parent_id` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父ID',
  `ac_sort` tinyint(1) unsigned NOT NULL DEFAULT '255' COMMENT '排序',
  PRIMARY KEY (`ac_id`),
  KEY `ac_parent_id` (`ac_parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章分类表';



# Dump of table ha_cloud_config
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_cloud_config`;

CREATE TABLE `ha_cloud_config` (
  `cloud_config_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cloud_config_name` varchar(100) NOT NULL COMMENT '应用名，GLOBAL为全局',
  `cloud_config_key` varchar(100) NOT NULL COMMENT '属性名',
  `cloud_config_desc` varchar(255) NOT NULL COMMENT '参数描述',
  `cloud_config_dev_value` varchar(255) DEFAULT NULL COMMENT '开发环境值',
  `cloud_config_test_value` varchar(255) DEFAULT NULL COMMENT '测试环境值',
  `cloud_config_prod_value` varchar(255) DEFAULT NULL COMMENT '正式环境值',
  PRIMARY KEY (`cloud_config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统环境变量配置表';

LOCK TABLES `ha_cloud_config` WRITE;
/*!40000 ALTER TABLE `ha_cloud_config` DISABLE KEYS */;

INSERT INTO `ha_cloud_config` (`cloud_config_id`, `cloud_config_name`, `cloud_config_key`, `cloud_config_desc`, `cloud_config_dev_value`, `cloud_config_test_value`, `cloud_config_prod_value`)
VALUES
	(154,'PayConfig','restt','',NULL,NULL,NULL);

/*!40000 ALTER TABLE `ha_cloud_config` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ha_entpay_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_entpay_order`;

CREATE TABLE `ha_entpay_order` (
  `EntPayOrderId` varchar(100) NOT NULL DEFAULT '' COMMENT '付款订单号',
  `MchId` varchar(100) DEFAULT NULL COMMENT '商户ID',
  `ChannelId` varchar(100) DEFAULT NULL COMMENT '渠道ID',
  `ChannelName` varchar(20) DEFAULT NULL COMMENT '通道名称',
  `Amount` bigint(20) DEFAULT NULL COMMENT '转帐金额',
  `Extra` varchar(255) DEFAULT NULL COMMENT '扩展信息',
  `RemarkInfo` varchar(255) DEFAULT NULL COMMENT '转帐备注',
  `DeviceInfo` varchar(32) DEFAULT NULL COMMENT '微信支付分配的终端设备号',
  `ClientIp` varchar(100) DEFAULT NULL COMMENT '客户端IP',
  `Status` tinyint(6) DEFAULT '0' COMMENT '转帐状态,0-订单生成,1-转帐成功,2,转帐失败',
  `PaymentNo` varchar(32) DEFAULT NULL COMMENT '渠道订单ID',
  `EntPaySuccTime` bigint(20) DEFAULT NULL COMMENT '成功时间',
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
  PRIMARY KEY (`EntPayOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ha_goods_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_goods_order`;

CREATE TABLE `ha_goods_order` (
  `GoodsOrderId` varchar(30) NOT NULL COMMENT '商品订单ID',
  `GoodsId` varchar(30) NOT NULL COMMENT '商品ID',
  `GoodsName` varchar(64) NOT NULL DEFAULT '' COMMENT '商品名称',
  `Amount` bigint(20) NOT NULL COMMENT '金额,单位分',
  `UserId` varchar(30) NOT NULL COMMENT '用户ID',
  `Status` tinyint(6) NOT NULL DEFAULT '0' COMMENT '订单状态,订单生成(0),支付成功(1),处理完成(2),处理失败(-1)',
  `PayOrderId` varchar(30) DEFAULT NULL COMMENT '支付订单号',
  `ChannelId` varchar(24) DEFAULT NULL COMMENT '渠道ID',
  `ChannelUserId` varchar(64) DEFAULT NULL COMMENT '支付渠道用户ID(微信openID或支付宝账号等第三方支付账号)',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`GoodsOrderId`),
  UNIQUE KEY `IDX_PayOrderId` (`PayOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品订单表';



# Dump of table ha_iap_receipt
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_iap_receipt`;

CREATE TABLE `ha_iap_receipt` (
  `PayOrderId` varchar(30) NOT NULL COMMENT '支付订单号',
  `MchId` varchar(30) NOT NULL COMMENT '商户ID',
  `TransactionId` varchar(24) NOT NULL COMMENT 'IAP业务号',
  `ReceiptData` text NOT NULL COMMENT '渠道ID',
  `Status` tinyint(6) NOT NULL DEFAULT '0' COMMENT '处理状态:0-未处理,1-处理成功,-1-处理失败',
  `HandleCount` tinyint(6) NOT NULL DEFAULT '0' COMMENT '处理次数',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`PayOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='苹果支付凭据表';



# Dump of table ha_mch_info
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_mch_info`;

CREATE TABLE `ha_mch_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `MchId` char(32) NOT NULL COMMENT '商户ID',
  `Name` varchar(30) NOT NULL COMMENT '名称',
  `Type` varchar(24) NOT NULL COMMENT '类型',
  `ReqKey` text NOT NULL COMMENT '请求私钥',
  `ResKey` text NOT NULL COMMENT '响应私钥',
  `State` tinyint(6) NOT NULL DEFAULT '1' COMMENT '商户状态,0-停止使用,1-使用中',
  `Logo` varchar(100) DEFAULT NULL COMMENT '店铺logo',
  `Qrcode` varchar(100) DEFAULT NULL COMMENT '二维码',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`,`MchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户信息表';

LOCK TABLES `ha_mch_info` WRITE;
/*!40000 ALTER TABLE `ha_mch_info` DISABLE KEYS */;

INSERT INTO `ha_mch_info` (`id`, `MchId`, `Name`, `Type`, `ReqKey`, `ResKey`, `State`, `Logo`, `Qrcode`, `CreateTime`, `UpdateTime`)
VALUES
	(1,'20001223','矩阵测试商家','2','M86l522AV6q613Ii4W6u8K48uW8vM1N6bFgyv769220MdYe9u37N4y7rI5mQ','Hpcl522AV6q613KIi46u6g6XuW8vM1N8bFgyv769770MdYe9u37M4y7rIpl8',1,NULL,NULL,'2017-10-09 09:03:57','2017-12-20 12:41:14');

/*!40000 ALTER TABLE `ha_mch_info` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ha_mch_notify
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_mch_notify`;

CREATE TABLE `ha_mch_notify` (
  `OrderId` varchar(24) NOT NULL COMMENT '订单ID',
  `MchId` varchar(100) NOT NULL DEFAULT '' COMMENT '商户ID',
  `MchOrderNo` varchar(30) NOT NULL COMMENT '商户订单号',
  `OrderType` varchar(8) NOT NULL COMMENT '订单类型:1-支付,2-转账,3-退款',
  `NotifyUrl` varchar(2048) NOT NULL COMMENT '通知地址',
  `NotifyCount` tinyint(6) NOT NULL DEFAULT '0' COMMENT '通知次数',
  `Result` varchar(2048) DEFAULT NULL COMMENT '通知响应结果',
  `Status` tinyint(6) NOT NULL DEFAULT '1' COMMENT '通知状态,1-通知中,2-通知成功,3-通知失败',
  `LastNotifyTime` datetime DEFAULT NULL COMMENT '最后一次通知时间',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`OrderId`),
  UNIQUE KEY `IDX_MchId_OrderType_MchOrderNo` (`MchId`,`OrderType`,`MchOrderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商户通知表';



# Dump of table ha_pay_channel
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_pay_channel`;

CREATE TABLE `ha_pay_channel` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '渠道主键ID',
  `ChannelId` varchar(24) NOT NULL COMMENT '渠道ID',
  `ChannelName` varchar(30) NOT NULL COMMENT '渠道名称,如:alipay,wechat',
  `ChannelMchId` varchar(32) NOT NULL COMMENT '渠道商户ID',
  `MchId` varchar(100) NOT NULL DEFAULT '' COMMENT '商户ID',
  `State` tinyint(6) NOT NULL DEFAULT '1' COMMENT '渠道状态,0-停止使用,1-使用中',
  `Param` varchar(4096) NOT NULL COMMENT '配置参数,json字符串',
  `Remark` varchar(128) DEFAULT NULL COMMENT '备注',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_MchId_MchOrderNo` (`ChannelId`,`MchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付渠道表';

LOCK TABLES `ha_pay_channel` WRITE;
/*!40000 ALTER TABLE `ha_pay_channel` DISABLE KEYS */;

INSERT INTO `ha_pay_channel` (`id`, `ChannelId`, `ChannelName`, `ChannelMchId`, `MchId`, `State`, `Param`, `Remark`, `CreateTime`, `UpdateTime`)
VALUES
	(4,'ALIPAY_WAP','ALIPAY','wrwrewr234224','20001223',1,'{\"appid\":\"201712adsad\",\"return_url\":\"http://m.hengaikj.com/web/pay/cashier.html\",\"private_key\":\"dsfsfwef\",\"alipay_public_key\":\"sdfweff\"}','','2017-10-09 09:15:00','2018-02-03 08:30:45'),
	(5,'WX_JSAPI','WX','23422424','20001223',1,'{\"mchId\":\"149053242342432\",\"appId\":\"2342442424\",\"key\":\"324242424fefsefsf\",\"certLocalPath\":\"4232442/apiclient_cert.p12\"}','','2017-10-09 09:15:00','2018-02-03 08:31:15');

/*!40000 ALTER TABLE `ha_pay_channel` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table ha_pay_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_pay_order`;

CREATE TABLE `ha_pay_order` (
  `PayOrderId` varchar(30) NOT NULL COMMENT '支付订单号',
  `MchId` varchar(100) NOT NULL DEFAULT '' COMMENT '商户ID',
  `MchOrderNo` varchar(30) NOT NULL COMMENT '商户订单号',
  `ChannelId` varchar(24) NOT NULL COMMENT '渠道ID',
  `Amount` bigint(20) NOT NULL COMMENT '支付金额,单位分',
  `Currency` varchar(3) NOT NULL DEFAULT 'cny' COMMENT '三位货币代码,人民币:cny',
  `Status` tinyint(6) NOT NULL DEFAULT '0' COMMENT '支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成,4-已申请退款',
  `ClientIp` varchar(32) DEFAULT NULL COMMENT '客户端IP',
  `Device` varchar(64) DEFAULT NULL COMMENT '设备',
  `Subject` varchar(64) NOT NULL COMMENT '商品标题',
  `Body` varchar(256) NOT NULL COMMENT '商品描述信息',
  `Extra` varchar(512) DEFAULT NULL COMMENT '特定渠道发起时额外参数',
  `ChannelMchId` varchar(32) NOT NULL COMMENT '渠道商户ID',
  `ChannelOrderNo` varchar(64) DEFAULT NULL COMMENT '渠道订单号',
  `ErrCode` varchar(64) DEFAULT NULL COMMENT '渠道支付错误码',
  `ErrMsg` varchar(128) DEFAULT NULL COMMENT '渠道支付错误描述',
  `Param1` varchar(256) DEFAULT '' COMMENT '扩展参数1',
  `Param2` varchar(256) DEFAULT NULL COMMENT '扩展参数2',
  `NotifyUrl` varchar(128) NOT NULL COMMENT '通知地址',
  `NotifyCount` tinyint(6) NOT NULL DEFAULT '0' COMMENT '通知次数',
  `LastNotifyTime` bigint(20) DEFAULT NULL COMMENT '最后一次通知时间',
  `ExpireTime` bigint(20) DEFAULT NULL COMMENT '订单失效时间',
  `PaySuccTime` bigint(20) DEFAULT NULL COMMENT '订单支付成功时间',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`PayOrderId`),
  UNIQUE KEY `IDX_MchId_MchOrderNo` (`MchId`,`MchOrderNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付订单表';



# Dump of table ha_refund_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_refund_order`;

CREATE TABLE `ha_refund_order` (
  `RefundOrderId` varchar(30) CHARACTER SET utf8mb4 NOT NULL COMMENT '退款订单号',
  `PayOrderId` varchar(30) CHARACTER SET utf8mb4 NOT NULL COMMENT '支付订单号',
  `ChannelPayOrderNo` varchar(255) DEFAULT NULL COMMENT '渠道支付单号',
  `MchId` varchar(100) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '商户ID',
  `MchRefundNo` varchar(255) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '商户退款单号',
  `ChannelId` varchar(24) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '渠道ID',
  `ChannelName` varchar(24) DEFAULT NULL COMMENT '渠道名称',
  `PayAmount` bigint(20) DEFAULT NULL COMMENT '支付金额,单位分',
  `RefundAmount` bigint(20) DEFAULT NULL COMMENT '退款金额,单位分',
  `Currency` varchar(3) CHARACTER SET utf8mb4 DEFAULT 'cny' COMMENT '三位货币代码,人民币:cny',
  `Status` tinyint(6) DEFAULT '0' COMMENT '退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成',
  `Result` tinyint(6) DEFAULT '0' COMMENT '退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败',
  `ClientIp` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '客户端IP',
  `Device` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '设备',
  `RemarkInfo` varchar(256) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '备注',
  `ChannelUser` varchar(32) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '渠道用户标识,如微信openId,支付宝账号',
  `UserName` varchar(24) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '用户姓名',
  `ChannelMchId` varchar(32) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '渠道商户ID',
  `ChannelOrderNo` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '渠道订单号',
  `ChannelErrCode` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '渠道错误码',
  `ChannelErrMsg` varchar(128) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '渠道错误描述',
  `Extra` varchar(512) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '特定渠道发起时额外参数',
  `NotifyUrl` varchar(128) CHARACTER SET utf8mb4 DEFAULT '' COMMENT '通知地址',
  `Param1` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '扩展参数1',
  `Param2` varchar(64) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '扩展参数2',
  `ExpireTime` datetime DEFAULT NULL COMMENT '订单失效时间',
  `RefundSuccTime` datetime DEFAULT NULL COMMENT '订单退款成功时间',
  `CreateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`RefundOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退款订单表';



# Dump of table ha_trans_order
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_trans_order`;

CREATE TABLE `ha_trans_order` (
  `TransOrderId` varchar(30) NOT NULL COMMENT '转账订单号',
  `MchId` varchar(100) NOT NULL DEFAULT '' COMMENT '商户ID',
  `MchTransNo` varchar(30) NOT NULL COMMENT '商户转账单号',
  `ChannelId` varchar(24) NOT NULL COMMENT '渠道ID',
  `Amount` bigint(20) NOT NULL COMMENT '转账金额,单位分',
  `Currency` varchar(3) NOT NULL DEFAULT 'cny' COMMENT '三位货币代码,人民币:cny',
  `Status` tinyint(6) NOT NULL DEFAULT '0' COMMENT '转账状态:0-订单生成,1-转账中,2-转账成功,3-转账失败,4-业务处理完成',
  `Result` tinyint(6) NOT NULL DEFAULT '0' COMMENT '转账结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败',
  `ClientIp` varchar(32) DEFAULT NULL COMMENT '客户端IP',
  `Device` varchar(64) DEFAULT NULL COMMENT '设备',
  `RemarkInfo` varchar(256) DEFAULT NULL COMMENT '备注',
  `ChannelUser` varchar(32) DEFAULT NULL COMMENT '渠道用户标识,如微信openId,支付宝账号',
  `UserName` varchar(24) DEFAULT NULL COMMENT '用户姓名',
  `ChannelMchId` varchar(32) NOT NULL COMMENT '渠道商户ID',
  `ChannelOrderNo` varchar(32) DEFAULT NULL COMMENT '渠道订单号',
  `ChannelErrCode` varchar(128) DEFAULT NULL COMMENT '渠道错误码',
  `ChannelErrMsg` varchar(128) DEFAULT NULL COMMENT '渠道错误描述',
  `Extra` varchar(512) DEFAULT NULL COMMENT '特定渠道发起时额外参数',
  `NotifyUrl` varchar(128) NOT NULL COMMENT '通知地址',
  `Param1` varchar(64) DEFAULT NULL COMMENT '扩展参数1',
  `Param2` varchar(64) DEFAULT NULL COMMENT '扩展参数2',
  `ExpireTime` datetime DEFAULT NULL COMMENT '订单失效时间',
  `TransSuccTime` datetime DEFAULT NULL COMMENT '订单转账成功时间',
  `CreateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`TransOrderId`),
  UNIQUE KEY `IDX_MchId_MchOrderNo` (`MchId`,`MchTransNo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='转账订单表';



# Dump of table ha_wx_bill
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_wx_bill`;

CREATE TABLE `ha_wx_bill` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tradetime` varchar(100) NOT NULL DEFAULT '' COMMENT '交易时间',
  `ghid` varchar(64) NOT NULL DEFAULT '' COMMENT '公众账号ID',
  `mchid` varchar(100) NOT NULL DEFAULT '' COMMENT '商户号',
  `submch` varchar(64) NOT NULL DEFAULT '' COMMENT '子商户号',
  `deviceid` varchar(255) NOT NULL DEFAULT '' COMMENT '设备号',
  `wxorder` varchar(255) NOT NULL DEFAULT '' COMMENT '微信订单号',
  `bzorder` varchar(255) NOT NULL DEFAULT '' COMMENT '商户订单号',
  `openid` varchar(64) NOT NULL DEFAULT '' COMMENT '用户标识',
  `tradetype` varchar(10) NOT NULL DEFAULT '' COMMENT '交易类型',
  `tradestatus` varchar(10) NOT NULL DEFAULT '' COMMENT '交易状态',
  `bank` varchar(255) NOT NULL DEFAULT '' COMMENT '付款银行',
  `currency` varchar(20) NOT NULL DEFAULT '' COMMENT '货币种类',
  `totalmoney` varchar(255) NOT NULL DEFAULT '' COMMENT '总金额',
  `redpacketmoney` varchar(255) NOT NULL DEFAULT '' COMMENT '企业红包金额',
  `wxrefund` varchar(255) NOT NULL DEFAULT '' COMMENT '微信退款单号',
  `bzrefund` varchar(255) NOT NULL DEFAULT '' COMMENT '商户退款单号',
  `refundmoney` varchar(255) NOT NULL DEFAULT '' COMMENT '退款金额',
  `redpacketrefund` varchar(255) NOT NULL DEFAULT '' COMMENT '企业红包退款金额',
  `refundtype` varchar(10) NOT NULL DEFAULT '' COMMENT '退款类型',
  `refundstatus` varchar(10) NOT NULL DEFAULT '' COMMENT '退款状态',
  `productname` varchar(255) NOT NULL DEFAULT '' COMMENT '商品名称',
  `bzdatapacket` varchar(255) NOT NULL DEFAULT '' COMMENT '商户数据包',
  `fee` varchar(255) NOT NULL DEFAULT '' COMMENT '手续费',
  `rate` varchar(255) NOT NULL DEFAULT '' COMMENT '费率',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



# Dump of table ha_wx_bill_day
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ha_wx_bill_day`;

CREATE TABLE `ha_wx_bill_day` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `total_order` varchar(100) DEFAULT NULL COMMENT '总交易单数',
  `total_pay` varchar(100) DEFAULT NULL COMMENT '总交易额',
  `total_refund` varchar(100) DEFAULT NULL COMMENT '总退款金额',
  `total_company_refund` varchar(100) DEFAULT NULL COMMENT '总企业红包退款金额',
  `total_fee` varchar(100) DEFAULT NULL COMMENT '手续费总金额',
  `bill_date` varchar(10) DEFAULT NULL COMMENT '帐单日期',
  `mchId` varchar(100) DEFAULT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
