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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`c_id`,`c_name`,`c_buy_address`,`c_address`,`c_phone`,`c_id_num`,`c_id_statu`,`c_time`,`c_want_type`,`c_commend`) values (1,'张三','河北张家口','河北邯郸','1231231231312','12313123412313213','已认证','2022-12-10 00:00:00','学区房','这是备注'),(2,'张宇3','河北张家口','河北邯郸','12312313121','791837981372813','已认证','2022-06-20 20:36:28','学区房','无');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `e_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `e_name` varchar(40) DEFAULT NULL COMMENT '员工姓名',
  `e_username` varchar(40) DEFAULT NULL COMMENT '员工昵称',
  `e_gender` varchar(40) DEFAULT NULL COMMENT '员工性别',
  `e_age` int(20) DEFAULT NULL COMMENT '员工年龄',
  `e_phone` varchar(40) DEFAULT NULL COMMENT '员工电话',
  `e_department` varchar(40) DEFAULT NULL COMMENT '员工部门',
  `e_position` varchar(40) DEFAULT NULL COMMENT '员工职位',
  `e_salary` float(6,2) DEFAULT NULL COMMENT '员工工资',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_id`,`e_name`,`e_username`,`e_gender`,`e_age`,`e_phone`,`e_department`,`e_position`,`e_salary`) values (1,'王五','wagnwu','man',22,'1231231123132','销售部','经理',5000.00),(4,'王六','wagnliu','女',22,'123126423132','人事部','经理',4500.00),(5,'陈启','wagnliu','女',22,'123126423132','人事部','经理',4500.00),(6,'赵八','wagnliu','女',22,'123126423132','人事部','经理',4500.00),(7,'称九','wagnliu','女',22,'123126423132','人事部','经理',4500.00),(9,'面团0','wagnliuw','man',22,'123126423132','认识部','经理',4500.00);

/*Table structure for table `finance` */

DROP TABLE IF EXISTS `finance`;

CREATE TABLE `finance` (
  `c_id` int(10) NOT NULL COMMENT '顾客ID',
  `e_id` int(10) NOT NULL COMMENT '员工ID',
  `f_price` float(7,2) DEFAULT NULL COMMENT '付款金额',
  `f_payment_way` varchar(20) DEFAULT NULL COMMENT '收款方式',
  `f_type` varchar(40) DEFAULT NULL COMMENT '财务类型',
  `f_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '财务时间',
  PRIMARY KEY (`c_id`,`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `finance` */

insert  into `finance`(`c_id`,`e_id`,`f_price`,`f_payment_way`,`f_type`,`f_time`) values (1,1,1000.00,'微信','首付','2022-06-22 08:18:16'),(2,1,1000.00,'支付宝','贷款','2022-06-22 08:18:25'),(2,2,1000.00,'支付宝','贷款','2022-06-22 08:18:34');

/*Table structure for table `house` */

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
  `h_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '房源ID',
  `h_name` varchar(40) DEFAULT NULL COMMENT '房源名称',
  `h_number` varchar(40) DEFAULT NULL COMMENT '房间号码',
  `h_type` varchar(40) DEFAULT NULL COMMENT '房间类型',
  `h_price` double(10,2) DEFAULT NULL COMMENT '房间价格',
  `h_erea` int(5) DEFAULT NULL COMMENT '房间面积',
  `e_id` int(10) NOT NULL COMMENT '员工ID（统计人员）',
  `h_time` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `house` */

insert  into `house`(`h_id`,`h_name`,`h_number`,`h_type`,`h_price`,`h_erea`,`e_id`,`h_time`) values (1,'A栋','1234','教学区',12.00,100,1,'2022-10-10 00:00:00'),(3,'A005','100','商品房',100.00,100,1,'2022-06-20 00:00:00'),(4,'A003','100','商品房',100.00,100,1,'2022-06-20 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
