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
  `e_id` int(10) NOT NULL COMMENT '员工编号',
  `c_commend` varchar(500) DEFAULT NULL COMMENT '备注事件',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`c_id`,`c_name`,`c_buy_address`,`c_address`,`c_phone`,`c_id_num`,`c_id_statu`,`c_time`,`c_want_type`,`e_id`,`c_commend`) values (1,'张三丰','河北张家口','河北邯郸','12312312','1231312341','已认证','2022-06-22 18:49:38','学区房',2,'这是备注'),(2,'赵敏','河北张家口','河北邯郸','12312','7918379','已认证','2022-06-22 18:49:46','学区房',1,'无'),(3,'张无忌','河北张家口','河北石家庄','23132132','23121321','未认证','2022-06-22 18:49:53','公寓',3,'无'),(4,'周芷若','河北张家口','河北石家庄','23123','231321231','已认证','2022-06-22 18:49:59','公寓',4,'无');

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
  `e_salary` float(10,2) DEFAULT NULL COMMENT '员工工资',
  PRIMARY KEY (`e_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`e_id`,`e_name`,`e_username`,`e_gender`,`e_age`,`e_phone`,`e_department`,`e_position`,`e_salary`) values (1,'宋江','及时雨','男',22,'1231231123132','销售部','经理',5000.00),(2,'卢俊义','玉麒麟','男',22,'123126423132','人事部','经理',4500.00),(3,'吴用','智多星','男',22,'123126423132','人事部','经理',4500.00),(4,'公孙胜  ','入云龙','男',22,'123126423132','人事部','经理',4500.00);

/*Table structure for table `finance` */

DROP TABLE IF EXISTS `finance`;

CREATE TABLE `finance` (
  `c_id` int(10) NOT NULL COMMENT '顾客ID',
  `e_id` int(10) NOT NULL COMMENT '员工ID',
  `f_price` float(10,2) DEFAULT NULL COMMENT '付款金额',
  `f_payment_way` varchar(20) DEFAULT NULL COMMENT '收款方式',
  `f_type` varchar(40) DEFAULT NULL COMMENT '财务类型',
  `f_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '财务时间',
  `f_payment_amount` float(10,2) DEFAULT NULL COMMENT '付款金额',
  `f_loan_amount` float(10,2) DEFAULT NULL COMMENT '贷款金额',
  `f_bank_name` varchar(40) DEFAULT NULL COMMENT '银行名称',
  PRIMARY KEY (`c_id`,`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `finance` */

insert  into `finance`(`c_id`,`e_id`,`f_price`,`f_payment_way`,`f_type`,`f_time`,`f_payment_amount`,`f_loan_amount`,`f_bank_name`) values (1,1,1000.00,'微信','首付','2022-06-22 16:11:13',50000.00,40000.00,'浦发银行'),(2,1,1000.00,'支付宝','贷款','2022-06-22 20:11:28',90000.00,20000.00,'中国银行'),(2,2,10001.00,'支付宝','贷款','2022-06-22 20:36:32',15000.00,13000.00,'中国建设银行'),(3,3,12000.00,'刷卡','定金','2022-06-22 20:12:22',13000.00,12000.00,'中国天地银行');

/*Table structure for table `house` */

DROP TABLE IF EXISTS `house`;

CREATE TABLE `house` (
  `h_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '房源ID',
  `h_name` varchar(40) DEFAULT NULL COMMENT '房源名称',
  `h_number` varchar(40) DEFAULT NULL COMMENT '房间号码',
  `h_type` varchar(40) DEFAULT NULL COMMENT '房间类型',
  `h_price` float(10,2) DEFAULT NULL COMMENT '房间价格',
  `h_erea` int(5) DEFAULT NULL COMMENT '房间面积',
  `e_id` int(10) NOT NULL COMMENT '员工ID（统计人员）',
  `h_time` datetime DEFAULT NULL COMMENT '登记时间',
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `house` */

insert  into `house`(`h_id`,`h_name`,`h_number`,`h_type`,`h_price`,`h_erea`,`e_id`,`h_time`) values (1,'A栋','1234','教学区',12.00,100,1,'2022-10-10 00:00:00'),(3,'A005','100','商品房',100.00,100,1,'2022-06-20 00:00:00'),(4,'A003','100','商品房',100.00,100,1,'2022-06-20 00:00:00');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
