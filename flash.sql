/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : flash

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 19/02/2020 16:55:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员id',
  `log_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账户',
  `log_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin-4', 'admin1', '123456', '管理员1号');
INSERT INTO `admin` VALUES ('admin-6', 'admin2', '123456', '管理员2号');

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `aut_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创作者id',
  `log_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `log_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `id_card` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  PRIMARY KEY (`aut_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('aut-1', 'aut1', '123456', '创作者测试1号', '2019-12-21 00:00:00', '12345476552345', 'qwsdcv@net.com1', '13242451', '广东珠海1');
INSERT INTO `author` VALUES ('aut-2', 'aut2', '123456', '创作者测试1号', '2020-01-01 20:37:57', '12343545', 'DQWDZ@qq.com', '123245356', '广东深圳2');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `c_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '顾客id',
  `log_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `log_pwd` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `phone` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `re_address1` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址1',
  `re_address2` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址2',
  `re_address3` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址3',
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('cus-1', 'cus1', '123456', '顾客测试1号', '1234', '广东珠海', '光电子', '', '');
INSERT INTO `customer` VALUES ('cus-2', 'cus2', '123456', '顾客测试2号', '123424s5', '广东茂名', '彩琪坊', '', NULL);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `o_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单id',
  `time` datetime(0) NOT NULL COMMENT '时间',
  `cus_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '顾客id',
  `aut_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创作者id',
  `re_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `payment` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否已付款',
  `camilo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡密',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('ord-0fe', '2020-02-05 11:28:39', 'cus-1', 'aut-2', '光电子', 58.00, '否', NULL, NULL);
INSERT INTO `orders` VALUES ('ord-1', '2019-12-03 00:00:00', 'cus-1', 'aut-1', '广东珠海', 133.00, '是', '1243546ythgrfesdcfg', '无');
INSERT INTO `orders` VALUES ('ord-2', '2019-12-20 15:27:41', 'cus-2', 'aut-2', '广东深圳', 122.00, '是', '13456356rgafdv', '无');
INSERT INTO `orders` VALUES ('ord-2d7', '2020-02-04 05:36:12', 'cus-1', 'aut-2', '光电子', 58.00, '否', NULL, NULL);
INSERT INTO `orders` VALUES ('ord-3', '2019-12-22 17:13:28', 'cus-1', 'aut-1', '广东深圳', 111.00, '是', '12342qweqgrfsdcr', '无');
INSERT INTO `orders` VALUES ('ord-4', '2020-01-03 08:48:36', 'cus-2', 'aut-2', '广东茂名', 423.00, '是', '12345356tsdcsd', '无');
INSERT INTO `orders` VALUES ('ord-801', '2020-02-04 05:40:26', 'cus-1', 'aut-2', '光电子', 10.00, '否', NULL, NULL);

-- ----------------------------
-- Table structure for re_up_shelf
-- ----------------------------
DROP TABLE IF EXISTS `re_up_shelf`;
CREATE TABLE `re_up_shelf`  (
  `r_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上架记录id',
  `aut_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创作者id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创作者名称',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `work_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作品名称',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '介绍',
  `upload_time` datetime(0) NOT NULL COMMENT '上传时间',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关联文件',
  `work_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作品类型',
  `continue _up` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否有后续更新',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`r_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of re_up_shelf
-- ----------------------------
INSERT INTO `re_up_shelf` VALUES ('shelf-1', 'aut-1', '创作者测试1号', '', '水彩艺术', '', '2019-12-09 16:31:01', '123436.jpg', '图片', '是', '无');

-- ----------------------------
-- Table structure for re_upload
-- ----------------------------
DROP TABLE IF EXISTS `re_upload`;
CREATE TABLE `re_upload`  (
  `upload_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '上传id',
  `aut_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创作者id',
  `time` datetime(0) NOT NULL COMMENT '时间',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `work_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作品名称',
  `introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '介绍',
  `work_type` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联文件',
  `img_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '封面图片',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`upload_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of re_upload
-- ----------------------------
INSERT INTO `re_upload` VALUES ('upload-0fe', 'aut-1', '2020-01-01 07:28:55', 'k310无刻印齿轮一套6个装', 'k310无刻印齿轮', '原厂出售', '实际商品', 33.00, '69023ec07e764b8d9f6f0e302665ee91', '27a385c6b234435c9c4c6c9406f190ac.jpg', '库存充足');
INSERT INTO `re_upload` VALUES ('upload-1c2', 'aut-2', '2020-01-03 03:51:42', '动漫壁纸', '二次元动漫壁纸福贴', '新的一年里蒸蒸日上，更加明朗。要更加的开心哦', '实际商品', 10.00, '889cc190561042cb956d652a03c6924d', '11c2c7b7ffd14787b300200e2dee7de7.png', '库存充足');
INSERT INTO `re_upload` VALUES ('upload-5fe', 'aut-2', '2020-01-03 03:46:37', '动漫抱枕', '爱鲨抱枕', '爱鲨，爱的拥抱送给❤心仪的他(她)吧', '实际商品', 58.00, 'fa55ff06c9064a60b9be0a596bca9271', 'f6109c1d73ce4cff988b4cd25a89b61d.png', '库存充足');
INSERT INTO `re_upload` VALUES ('upload-973', 'aut-1', '2019-12-25 02:40:05', '特价优惠蛋黄酥26元一箱/30个装', '蛋黄酥', '美味酥爽', '实际商品', 25.00, '253953fd64db4254add384af38f9edb9', '9331f5cdca9a4241ab4ac573e6414f85.jpg', '库存充足');
INSERT INTO `re_upload` VALUES ('upload-dda', 'aut-2', '2020-01-03 04:02:29', '思维启蒙书', '你学的数学可能是假的 : 超简单有趣的数学思维启蒙书 ', '你学的数学可能是假的 : 超简单有趣的数学思维启蒙书 ', '实际商品', 59.00, 'e2626b7e184241cbbe069a094482a25e', '875574866be445d19c98e4641ecac6bf.png', '库存充足');
INSERT INTO `re_upload` VALUES ('upload-e9e', 'aut-1', '2020-01-01 07:28:12', '一起来驯养可爱小龙吧', '虚拟宠物', '萌娘兽耳虚拟宠物', '虚拟商品', 233.00, '6507dee153ac4b0d9aabab4365ca5475', '2db958be48de466cb84aa020ee1d330e.jpg', '库存充足');
INSERT INTO `re_upload` VALUES ('upload-eda', 'aut-1', '2019-12-25 02:58:03', '小微动漫风格图片制作', '代画四格漫画', '代做设计', '虚拟商品', 10.00, '77817252607348a29ddc3e766be8ac8f', '8e6c6d4444e944308b44546f8060b8c9.png', '库存充足');
INSERT INTO `re_upload` VALUES ('upload-f22', 'aut-2', '2020-01-03 03:58:42', '科技书物', 'Python编程从零基础到项目实战（微课视频版）', 'Python配套习题实验答案及分析手册（100页电子书）：该学习手册不但提供了习题与实验的参考答案，重点在实验里提供了超出书本知识的内容和代码，并提供了学习重点、学习方法、学习拓展方向的分析。', '实际商品', 68.00, '78d920a95e70462486377f4a28834d61', '7aaaa2143e14419fade17450993e881b.png', '库存充足');

-- ----------------------------
-- Table structure for re_work_update
-- ----------------------------
DROP TABLE IF EXISTS `re_work_update`;
CREATE TABLE `re_work_update`  (
  `update_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新id',
  `aut_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创作者id',
  `time` datetime(0) NOT NULL COMMENT '时间',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关联文件',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`update_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of re_work_update
-- ----------------------------
INSERT INTO `re_work_update` VALUES ('update-1', 'aut-1', '2019-12-09 16:31:44', '123234.jpg', '无');

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction`  (
  `t_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易id',
  `c_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '顾客id',
  `aut_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创作者id',
  `re_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  `price` decimal(10, 2) NOT NULL COMMENT '价格',
  `payment` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否已付款',
  `camilo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卡密',
  `remarks` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transaction
-- ----------------------------
INSERT INTO `transaction` VALUES ('tran-1', 'cus-1', 'aut-1', '广东珠海阳光集团(有限)公司', 288.00, '是', '1243546ythgrfesdcfg', '无');
INSERT INTO `transaction` VALUES ('tran-2', 'cus-2', 'aut-2', '广东珠海海洋集团(有限)公司', 399.00, '是', NULL, '无');
INSERT INTO `transaction` VALUES ('tran-3', 'cus-1', 'aut-1', '广东珠海六个六集团', 111.00, '是', '1234246asdd', '无');

SET FOREIGN_KEY_CHECKS = 1;
