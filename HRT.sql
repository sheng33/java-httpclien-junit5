/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : HRT

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 15/06/2020 10:27:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for application-config.properties
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application` (
  `app_id` int NOT NULL AUTO_INCREMENT COMMENT '应用id(主键)',
  `app_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用名称',
  `app_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用code',
  `app_subtitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用副标题',
  `app_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用图片',
  `app_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用启动链接',
  `sort` int NOT NULL COMMENT '排序字段',
  `app_status` tinyint(1) NOT NULL COMMENT '状态',
  `last_operator_id` bigint NOT NULL COMMENT '最后操作人',
  `test_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`app_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='应用表';

-- ----------------------------
-- Records of application-config.properties
-- ----------------------------
BEGIN;
INSERT INTO `application` VALUES (1, 'QQ', 'qq', '即使通讯应用', 'http://www.baidu.com', 'http://www.qq.com', 1, 1, 1, '一组');
COMMIT;

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `channel_id` bigint NOT NULL AUTO_INCREMENT COMMENT '渠道id(主键)',
  `channel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道名称',
  `channel_daily_threshold` bigint NOT NULL COMMENT '日发放限额',
  `channel_daily_user_threshold` bigint NOT NULL COMMENT '单用户日充值限额',
  `channel_start_time` bigint NOT NULL COMMENT '有效期开始时间',
  `channel_end_time` bigint NOT NULL COMMENT '有效期结束时间',
  `point_id` bigint NOT NULL COMMENT '积分主键',
  `channel_status` tinyint(1) NOT NULL COMMENT '积分状态',
  `test_name` int DEFAULT NULL,
  PRIMARY KEY (`channel_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='渠道表';

-- ----------------------------
-- Records of channel
-- ----------------------------
BEGIN;
INSERT INTO `channel` VALUES (468787833876910080, '测试渠道2', 200, 2, 123123, 1231231231, 468483250516529152, 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for channel_log
-- ----------------------------
DROP TABLE IF EXISTS `channel_log`;
CREATE TABLE `channel_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` bigint NOT NULL COMMENT '时间',
  `state_change` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态变更',
  `operator_id` bigint NOT NULL COMMENT '操作人id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='渠道操作日志表';

-- ----------------------------
-- Records of channel_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for daily_statistic
-- ----------------------------
DROP TABLE IF EXISTS `daily_statistic`;
CREATE TABLE `daily_statistic` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `point_id` bigint NOT NULL COMMENT '积分id',
  `create_time` datetime NOT NULL COMMENT '统计时间',
  `issue_amount` bigint NOT NULL COMMENT '发放数量',
  `consume_amount` bigint NOT NULL COMMENT '消耗数量',
  `commision_amount` bigint NOT NULL COMMENT '抽佣数量',
  `register_num` int NOT NULL COMMENT '注册人数',
  `issue_count` int NOT NULL COMMENT '转换笔数',
  `issue_people_num` int NOT NULL COMMENT '转换人数',
  `test_name` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of daily_statistic
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for point
-- ----------------------------
DROP TABLE IF EXISTS `point`;
CREATE TABLE `point` (
  `point_id` bigint NOT NULL AUTO_INCREMENT COMMENT ' 积分表主键',
  `point_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '积分名称',
  `point_exchange_rate` int NOT NULL COMMENT '积分汇率(RMB)',
  `create_time` bigint NOT NULL COMMENT '创建时间',
  `point_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '积分code',
  `test_name` int DEFAULT NULL,
  PRIMARY KEY (`point_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='积分表';

-- ----------------------------
-- Records of point
-- ----------------------------
BEGIN;
INSERT INTO `point` VALUES (1, '咖豆', 4, 1591861576552, 'coffeeBean', NULL);
COMMIT;

-- ----------------------------
-- Table structure for testConfig
-- ----------------------------
DROP TABLE IF EXISTS `testConfig`;
CREATE TABLE `testConfig` (
  `test_id` int NOT NULL AUTO_INCREMENT COMMENT '测试组id',
  `test_name` varchar(255) DEFAULT NULL COMMENT '测试组名',
  `test_time` varchar(255) DEFAULT NULL COMMENT '测试时间',
  PRIMARY KEY (`test_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='测试组表';

-- ----------------------------
-- Records of testConfig
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for testPlan
-- ----------------------------
DROP TABLE IF EXISTS `testPlan`;
CREATE TABLE `testPlan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `application_id` int DEFAULT NULL,
  `channel_id` int DEFAULT NULL,
  `third_channel_id` int DEFAULT NULL,
  `point_id` int DEFAULT NULL,
  `test_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='测试计划表';

-- ----------------------------
-- Records of testPlan
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for third_channel
-- ----------------------------
DROP TABLE IF EXISTS `third_channel`;
CREATE TABLE `third_channel` (
  `channel_id` bigint NOT NULL AUTO_INCREMENT COMMENT '渠道id',
  `channel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道名称',
  `channel_daily_threshold` bigint NOT NULL COMMENT '日发放限额',
  `channel_daily_user_threshold` bigint NOT NULL COMMENT '用户日充值限额',
  `channel_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道key',
  `point_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '被兑换积分名称',
  `point_exchange_rate` int NOT NULL COMMENT '被兑换积分汇率(RMB)',
  `charge_ratio` int NOT NULL COMMENT '兑换服务费比例',
  `last_operator_id` bigint NOT NULL COMMENT '最后操作人id',
  `channel_status` tinyint(1) NOT NULL COMMENT '渠道状态',
  `create_time` bigint NOT NULL COMMENT '创建时间',
  `test_name` int DEFAULT NULL,
  PRIMARY KEY (`channel_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='三方渠道表';

-- ----------------------------
-- Records of third_channel
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for third_channel_log
-- ----------------------------
DROP TABLE IF EXISTS `third_channel_log`;
CREATE TABLE `third_channel_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` bigint NOT NULL COMMENT '时间',
  `state_change` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态变更',
  `operator_id` bigint NOT NULL COMMENT '操作人id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '备注',
  `test_name` int DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='三方渠道操作日志表';

-- ----------------------------
-- Records of third_channel_log
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for user_point_bill
-- ----------------------------
DROP TABLE IF EXISTS `user_point_bill`;
CREATE TABLE `user_point_bill` (
  `bill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '账单主键',
  `point_id` bigint NOT NULL COMMENT '积分主键',
  `channel_begin_points` bigint NOT NULL COMMENT '渠道变动前积分',
  `channel_changed_points` bigint NOT NULL COMMENT '渠道变动积分数',
  `channel_end_points` bigint NOT NULL COMMENT '渠道变动后积分',
  `bill_type` tinyint(1) NOT NULL COMMENT '账单类型',
  `relation_id` bigint NOT NULL COMMENT '关联id',
  `user_id` bigint NOT NULL COMMENT '用户id',
  `channel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道名称',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `app_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用名称',
  `change_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变更原因',
  `commission_ratio` int NOT NULL COMMENT '佣金比例',
  `fee_ratio` int NOT NULL COMMENT '服务费比例',
  `first_charge_mark` tinyint(1) NOT NULL COMMENT '首充标记',
  `user_begin_points` bigint NOT NULL COMMENT '用户变动前积分',
  `user_changed_points` bigint NOT NULL COMMENT '用户变动积分',
  `user_end_points` bigint NOT NULL COMMENT '用户变动后积分',
  `channel_id` bigint NOT NULL COMMENT '渠道id',
  `target_point_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '被兑积分名称',
  `test_name` int DEFAULT NULL,
  PRIMARY KEY (`bill_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='账单表';

-- ----------------------------
-- Records of user_point_bill
-- ----------------------------
BEGIN;
INSERT INTO `user_point_bill` VALUES (1, 2, 3, 4, 5, 6, 7, 8, '9', '2020-06-12 16:12:09', '0', '11', 13, 12, 13, 14, 16, 17, 18, '19', 20);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
