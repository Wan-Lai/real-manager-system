/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.37 : Database - db_realmanagersystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_realmanagersystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_realmanagersystem`;

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `c_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '顾客ID',
  `c_name` varchar(40) DEFAULT NULL COMMENT '顾客姓名',
  `c_buy_address` varchar(40) DEFAULT NULL COMMENT '顾客购买地址',
  `c_address` varchar(40) DEFAULT NULL COMMENT '顾客地址',
  `c_phone` varchar(20) DEFAULT NULL COMMENT '顾客电话',
  `c_id_num` varchar(20) DEFAULT NULL COMMENT '身份证号',
  `c_id_statu` varchar(5) DEFAULT NULL COMMENT '身份证状态',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '登记时间',
  `c_want_type` varchar(40) DEFAULT NULL COMMENT '期望户型',
  `c_commend` varchar(500) DEFAULT NULL COMMENT '备注事件',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `e_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `e_name` varchar(40) DEFAULT NULL COMMENT '员工姓名',
  `e_username` varchar(40) DEFAULT NULL COMMENT '员工昵称',
  `e_gender` char(1) DEFAULT NULL COMMENT '员工性别',
  `e_age` int(20) DEFAULT NULL COMMENT '员工年龄',
  `e_phone` varchar(11) DEFAULT NULL COMMENT '员工电话',
  `e_department` varchar(30) DEFAULT NULL COMMENT '员工部门',
  `e_position` varchar(30) DEFAULT NULL COMMENT '员工职位',
  `e_salary` float DEFAULT NULL COMMENT '员工工资',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

/*Table structure for table `finance` */

DROP TABLE IF EXISTS `finance`;

CREATE TABLE `finance` (
  `c_id` int(10) NOT NULL COMMENT '顾客ID',
  `e_id` int(10) DEFAULT NULL COMMENT '员工ID',
  `c_price` int(11) DEFAULT NULL COMMENT '付款金额',
  `c_payment_way` varchar(20) DEFAULT NULL COMMENT '收款方式',
  `c_type` varchar(40) DEFAULT NULL COMMENT '财务类型',
  `c_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '财务时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `finance` */

/*Table structure for table `house` */

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
  `h_id` int(10) NOT NULL COMMENT '房源ID',
  `h_name` varchar(40) DEFAULT NULL COMMENT '房源名称',
  `h_number` varchar(40) DEFAULT NULL COMMENT '房间号码',
  `h_type` varchar(40) DEFAULT NULL COMMENT '房间类型',
  `h_price` float(4,2) DEFAULT NULL COMMENT '房间价格',
  `h_erea` int(5) DEFAULT NULL COMMENT '房间面积',
  `e_id` int(10) NOT NULL COMMENT '员工ID（统计人员）',
  `h_time` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`h_id`,`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `house` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
