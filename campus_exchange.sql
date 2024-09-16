/*
 Navicat Premium Data Transfer

 Source Server         : lucky
 Source Server Type    : MySQL
 Source Server Version : 80035 (8.0.35)
 Source Host           : localhost:3306
 Source Schema         : campus_exchange

 Target Server Type    : MySQL
 Target Server Version : 80035 (8.0.35)
 File Encoding         : 65001

 Date: 16/09/2024 22:29:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` bigint NOT NULL AUTO_INCREMENT,
  `post_posting_time` datetime NOT NULL COMMENT '发帖时间',
  `post_text_content` text CHARACTER SET gb18030 COLLATE gb18030_chinese_ci NOT NULL COMMENT '文字内容',
  `post_visitor_user_id` bigint NOT NULL COMMENT '发帖用户编号',
  `post_title` varchar(255) CHARACTER SET gb18030 COLLATE gb18030_chinese_ci NOT NULL,
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 149 CHARACTER SET = gb18030 COLLATE = gb18030_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (131, '2024-09-14 16:40:32', '内容1', 182, '标题1');
INSERT INTO `post` VALUES (133, '2024-09-15 10:47:22', '测试内容测试内容测试内容测试内容测试内容测试内容', 182, '测试标题');
INSERT INTO `post` VALUES (134, '2024-09-15 14:12:21', '监听，窥屏，你Wi-Fi同网络下所有设备号，等等这些不是摆在明面上的窃取隐私吗？但凡硬件厂商能做底层的，这个权限不是随便开。所以前几年国家才严打了一波窃取隐私问题。这点真不是吹苹果，开与不开麦的app，你试试说几句话明显能看出来开麦权限的在窃听，马上app电商广告就来了。', 182, '小伙纪念科比在马路运球跑被撞飞');
INSERT INTO `post` VALUES (135, '2024-09-15 14:17:05', '当前情况一下，这个还是苹果15 16啊', 182, 'Mate 60还值得买吗');
INSERT INTO `post` VALUES (136, '2024-09-15 14:22:03', '不用跟进啊，以前就有安卓机有单独的拍照键了，要说跟进也是苹果跟进的\r\n我按下音量键不就能拍了吗', 182, '我敢预言！苹果16的拍照按键，安卓厂商都会跟进的！');
INSERT INTO `post` VALUES (137, '2024-09-15 17:07:19', '函数式组件是一种定义自身没有任何状态的组件的方式。它们很像纯函数：接收 props，返回 vnodes。函数式组件在渲染过程中不会创建组件实例 (也就是说，没有 this)，也不会触发常规的组件生命周期钩子。\r\n\r\n我们用一个普通的函数而不是一个选项对象来创建函数式组件。该函数实际上就是该组件的渲染函数。\r\n\r\n函数式组件的签名与 setup() 钩子相同：函数式组件是一种定义自身没有任何状态的组件的方式。它们很像纯函数：接收 props，返回 vnodes。函数式组件在渲染过程中不会创建组件实例 (也就是说，没有 this)，也不会触发常规的组件生命周期钩子。\r\n\r\n我们用一个普通的函数而不是一个选项对象来创建函数式组件。该函数实际上就是该组件的渲染函数。\r\n\r\n函数式组件的签名与 setup() 钩子相同：函数式组件是一种定义自身没有任何状态的组件的方式。它们很像纯函数：接收 props，返回 vnodes。函数式组件在渲染过程中不会创建组件实例 (也就是说，没有 this)，也不会触发常规的组件生命周期钩子。\r\n\r\n我们用一个普通的函数而不是一个选项对象来创建函数式组件。该函数实际上就是该组件的渲染函数。\r\n\r\n函数式组件的签名与 setup() 钩子相同：函数式组件是一种定义自身没有任何状态的组件的方式。它们很像纯函数：接收 props，返回 vnodes。函数式组件在渲染过程中不会创建组件实例 (也就是说，没有 this)，也不会触发常规的组件生命周期钩子。\r\n\r\n我们用一个普通的函数而不是一个选项对象来创建函数式组件。该函数实际上就是该组件的渲染函数。\r\n\r\n函数式组件的签名与 setup() 钩子相同：函数式组件是一种定义自身没有任何状态的组件的方式。它们很像纯函数：接收 props，返回 vnodes。函数式组件在渲染过程中不会创建组件实例 (也就是说，没有 this)，也不会触发常规的组件生命周期钩子。\r\n\r\n我们用一个普通的函数而不是一个选项对象来创建函数式组件。该函数实际上就是该组件的渲染函数。\r\n\r\n函数式组件的签名与 setup() 钩子相同：', 183, 'lucky的文章标题1');
INSERT INTO `post` VALUES (138, '2024-09-15 22:24:23', '我和同事每天上班前，都会在工作地点对面的一家夫妻店买早餐吃。\r\n\r\n有时候是包子，有时候是小笼包，有时候是蒸饺，有时候是炸酱面，总之每个都好吃！\r\n\r\n但我们俩最爱的还是牛肉包，可惜由于人实在太多了，不是每一次都能买到，可能5次里只有1次能买到，买到可能也只有一个。\r\n\r\n如果只有一个，我和同事还要理智分配，比如这次我吃，下次她吃。\r\n\r\n大多数情况下，我们俩都会先问有没有牛肉包，没有的话就吃别的，有的话就吃牛肉包。\r\n\r\n直到今天！我们一进去，老板就认出了我们，她说：我老公昨天说有两个女生很喜欢吃牛肉包，但每次都买不到，今天我特意给你们多蒸了一笼，正好四个！', 183, '“特意为你们俩多蒸了一笼牛肉包”');
INSERT INTO `post` VALUES (139, '2024-09-15 22:26:10', '小笼包真好吃，小笼包真好吃，小笼包真好吃', 183, '小笼包');
INSERT INTO `post` VALUES (140, '2024-09-15 22:26:37', '发布jpg图片发布jpg图片发布jpg图片发布jpg图片发布jpg图片', 183, '发布jpg图片');
INSERT INTO `post` VALUES (141, '2024-09-16 10:25:06', '当前情况一下，这个还是苹果15 16啊', 182, 'Mate 60还值得买吗');
INSERT INTO `post` VALUES (142, '2024-09-16 10:28:06', '内容内容内容内容内容内容', 183, '测试 10.27');
INSERT INTO `post` VALUES (143, '2024-09-16 10:32:24', '内容内容内容内容内容内容内容内容内容', 183, '测试10.32');
INSERT INTO `post` VALUES (144, '2024-09-16 10:36:24', '内容内容内容内容内容内容内容', 183, '测试10.36');
INSERT INTO `post` VALUES (145, '2024-09-16 10:38:34', '内容那日容内容那日容内容那日容内容那日容内容那日容', 183, '测试10.38');
INSERT INTO `post` VALUES (146, '2024-09-16 10:41:31', 'test 10.41test 10.41test 10.41test 10.41test 10.41', 183, 'test 10.41');
INSERT INTO `post` VALUES (147, '2024-09-16 11:14:18', 'test 11.13test 11.13test 11.13test 11.13test 11.13test 11.13', 183, 'test 11.13');
INSERT INTO `post` VALUES (148, '2024-09-16 11:17:31', 'test 11.17test 11.17test 11.17test 11.17', 183, 'test 11.17');

-- ----------------------------
-- Table structure for post_pic
-- ----------------------------
DROP TABLE IF EXISTS `post_pic`;
CREATE TABLE `post_pic`  (
  `post_pic_id` bigint NOT NULL AUTO_INCREMENT,
  `post_id` bigint NOT NULL,
  `path` varchar(255) CHARACTER SET gb18030 COLLATE gb18030_chinese_ci NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`post_pic_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = gb18030 COLLATE = gb18030_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post_pic
-- ----------------------------
INSERT INTO `post_pic` VALUES (17, 131, '17263032323390.jpg', '2024-09-14 16:40:33');
INSERT INTO `post_pic` VALUES (18, 131, '17263032323391.jpg', '2024-09-14 16:40:33');
INSERT INTO `post_pic` VALUES (19, 133, '17263684420520.png', '2024-09-15 10:47:22');
INSERT INTO `post_pic` VALUES (20, 133, '17263684420521.png', '2024-09-15 10:47:22');
INSERT INTO `post_pic` VALUES (21, 133, '17263684420522.png', '2024-09-15 10:47:22');
INSERT INTO `post_pic` VALUES (22, 134, '17263807406690.png', '2024-09-15 14:12:21');
INSERT INTO `post_pic` VALUES (23, 135, '17263810254200.png', '2024-09-15 14:17:05');
INSERT INTO `post_pic` VALUES (24, 136, '17263813230680.png', '2024-09-15 14:22:03');
INSERT INTO `post_pic` VALUES (25, 141, '17264535056420.png', '2024-09-16 10:25:06');
INSERT INTO `post_pic` VALUES (26, 146, '17264544906350.png', '2024-09-16 10:41:31');
INSERT INTO `post_pic` VALUES (27, 146, '17264544906351.png', '2024-09-16 10:41:31');
INSERT INTO `post_pic` VALUES (28, 146, '17264544906352.png', '2024-09-16 10:41:31');
INSERT INTO `post_pic` VALUES (29, 147, '17264564583090.png', '2024-09-16 11:14:19');
INSERT INTO `post_pic` VALUES (30, 147, '17264564583091.png', '2024-09-16 11:14:19');
INSERT INTO `post_pic` VALUES (31, 147, '17264564583092.png', '2024-09-16 11:14:19');
INSERT INTO `post_pic` VALUES (32, 147, '17264564583093.png', '2024-09-16 11:14:19');
INSERT INTO `post_pic` VALUES (33, 147, '17264564583094.png', '2024-09-16 11:14:19');

-- ----------------------------
-- Table structure for visitor_user
-- ----------------------------
DROP TABLE IF EXISTS `visitor_user`;
CREATE TABLE `visitor_user`  (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET gb18030 COLLATE gb18030_chinese_ci NOT NULL,
  `user_password` varchar(255) CHARACTER SET gb18030 COLLATE gb18030_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 184 CHARACTER SET = gb18030 COLLATE = gb18030_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visitor_user
-- ----------------------------
INSERT INTO `visitor_user` VALUES (182, 'zgh', '88888888');
INSERT INTO `visitor_user` VALUES (183, 'lucky', '88888888');

-- ----------------------------
-- Table structure for visitor_user_collect
-- ----------------------------
DROP TABLE IF EXISTS `visitor_user_collect`;
CREATE TABLE `visitor_user_collect`  (
  `visitor_user_collect_id` bigint NOT NULL AUTO_INCREMENT,
  `collect_time` datetime NOT NULL,
  `user_id` bigint NOT NULL,
  `post_id` bigint NOT NULL,
  PRIMARY KEY (`visitor_user_collect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = gb18030 COLLATE = gb18030_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visitor_user_collect
-- ----------------------------
INSERT INTO `visitor_user_collect` VALUES (1, '2024-09-04 22:23:13', 2, 1);
INSERT INTO `visitor_user_collect` VALUES (2, '2024-09-13 22:23:35', 2, 3);

SET FOREIGN_KEY_CHECKS = 1;
