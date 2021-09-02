CREATE TABLE `euser`  (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT ,
  `username` varchar(32) NOT NULL ,
  `password` varchar(64) NOT NULL,
  `phone` int(128) NOT NULL,
  `role` int(4) NOT NULL DEFAULT '1' COMMENT 'role，1-customer，2-admin',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `food` (
  `food_id` int(64) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL DEFAULT '',
  `detail` varchar(500) CHARACTER SET utf8mb4 DEFAULT '',
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `status` int(6) NOT NULL DEFAULT '1' COMMENT 'product status：0-not showing，1-showing',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`food_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `booking` (
  `booking_id` int(64) NOT NULL AUTO_INCREMENT,
  `booking_no` varchar(128) NOT NULL DEFAULT '',
  `user_id` int(64) NOT NULL,
  `promotion_id` int(64) DEFAULT NULL,
  `customer_name` varchar(32) NOT NULL,
  `customer_mobile` varchar(32) NOT NULL,
  `number_of_people` int(64) DEFAULT NULL,
  `booking_date_time` datetime DEFAULT NULL,
  `booking_status` int(10) NOT NULL DEFAULT '10' COMMENT '订单状态: 0用户已取消，10未付款（初始状态），20已付款，30已发货，40交易完成',
  `total_price` int(64) DEFAULT NULL COMMENT '订单总价格',
  `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`booking_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `booking_food` (
  `booking_food_id` int(64) NOT NULL AUTO_INCREMENT,
  `booking_no` varchar(128) NOT NULL DEFAULT '',
  `food_id` int(64) NOT NULL,
  `food_name` varchar(100) NOT NULL DEFAULT '',
  `food_img` varchar(128) NOT NULL DEFAULT '',
  `unit_price` int(11) NOT NULL,
  `quantity` int(10) NOT NULL DEFAULT '1',
  `total_price` int(11) NOT NULL DEFAULT '0',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`booking_food_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT='订单的商品表 ';

CREATE TABLE `promotion` (
  `promotion_id` int(64) NOT NULL AUTO_INCREMENT,
  `detail` varchar(500) DEFAULT '',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`promotion_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;