SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- 创建数据库
CREATE DATABASE IF NOT EXISTS springcloud01 CHARACTER SET utf8 ;
USE springcloud01 ;
-- 创建表
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `deptno` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `dname` VARCHAR(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `db_source` VARCHAR(60) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`deptno`) USING BTREE
) ENGINE = MYISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '开发部', DATABASE());
INSERT INTO `dept` VALUES (2, '人事部', DATABASE());
INSERT INTO `dept` VALUES (3, '财务部', DATABASE());
INSERT INTO `dept` VALUES (4, '市场部', DATABASE());
INSERT INTO `dept` VALUES (5, '运维部', DATABASE());

SET FOREIGN_KEY_CHECKS = 1;

SELECT * FROM dept ;