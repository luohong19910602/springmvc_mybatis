/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : luohong_spring

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-08-04 20:10:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `install_info`
-- ----------------------------
DROP TABLE IF EXISTS `install_info`;
CREATE TABLE `install_info` (
  `_install` int(11) DEFAULT NULL,
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of install_info
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_article`
-- ----------------------------
DROP TABLE IF EXISTS `sys_article`;
CREATE TABLE `sys_article` (
  `_summary` varchar(1000) DEFAULT NULL,
  `_id` varchar(50) NOT NULL,
  `_title` varchar(50) DEFAULT NULL,
  `_content` longtext,
  `_url` varchar(200) DEFAULT NULL,
  `_view_count` int(11) DEFAULT NULL,
  `_reference` int(11) DEFAULT NULL,
  `_type_id` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_del_flag` int(1) DEFAULT '0',
  `_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `_type_id` (`_type_id`),
  KEY `user_fk_article` (`_user_id`),
  CONSTRAINT `sys_article_ibfk_1` FOREIGN KEY (`_type_id`) REFERENCES `sys_article_type` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_fk_article` FOREIGN KEY (`_user_id`) REFERENCES `sys_user` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_article
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_article_article_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_article_article_type`;
CREATE TABLE `sys_article_article_type` (
  `_top` int(11) DEFAULT NULL,
  `_id` varchar(50) NOT NULL,
  `_article_id` varchar(50) DEFAULT NULL,
  `_article_type_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `article_fk_article_type` (`_article_type_id`),
  KEY `article_fk_type` (`_article_id`),
  CONSTRAINT `article_fk_article_type` FOREIGN KEY (`_article_type_id`) REFERENCES `sys_article_type` (`_id`),
  CONSTRAINT `article_fk_type` FOREIGN KEY (`_article_id`) REFERENCES `sys_article` (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_article_article_type
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_article_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_article_type`;
CREATE TABLE `sys_article_type` (
  `_id` varchar(50) NOT NULL,
  `_name` varchar(50) DEFAULT NULL,
  `_desc` varchar(200) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_del_flag` int(1) DEFAULT '0',
  `_sort_flag` int(1) DEFAULT '0',
  `_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `user_fk_type` (`_user_id`),
  CONSTRAINT `user_fk_type` FOREIGN KEY (`_user_id`) REFERENCES `sys_user` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_article_type
-- ----------------------------
INSERT INTO `sys_article_type` VALUES ('0546486f_22ad_4ae3_a1cd_8cd9314a5837', '随笔', '', '2015-05-12 15:30:57', 'luohong', null, null, '1', '0', 'root');
INSERT INTO `sys_article_type` VALUES ('05468853_dbe4_4a06_be42_f1ee7cc7e087', '设计模式', '', '2015-07-09 21:27:33', 'luohong', null, null, '0', '5', 'root');
INSERT INTO `sys_article_type` VALUES ('1420706e_6f54_4c0a_95a9_31c9bf966adf', '关于我', '', '2015-07-09 21:26:50', 'luohong', null, null, '0', '10', 'root');
INSERT INTO `sys_article_type` VALUES ('298bd8f9_d1b6_490c_9420_6d2a3758c63c', '首页', '这里面包含了一些网页的基本信息，自我介绍，两点介绍等', '2015-07-09 21:26:41', 'luohong', null, null, '0', '2', 'root');
INSERT INTO `sys_article_type` VALUES ('2aa3fd7d_44d4_4920_8637_90d5b728ebd3', '齐威王确认', '阿斯顿发生的发生', '2015-07-09 21:07:44', 'luohong', null, null, '1', '1', 'root');
INSERT INTO `sys_article_type` VALUES ('54787797_5a1e_4b93_ab17_aff30612a4bb', '经典博文', '', '2015-07-09 21:27:47', 'luohong', null, null, '0', '6', 'root');
INSERT INTO `sys_article_type` VALUES ('585b2cf0_1a36_40c1_8b04_7068d611738c', '联系方式', '', '2015-07-09 21:26:56', 'luohong', null, null, '0', '11', 'root');
INSERT INTO `sys_article_type` VALUES ('8c2408a6_ed29_4384_a8b8_fe20eac5cd03', '行政', '', '2015-05-12 15:31:26', 'luohong', null, null, '1', '0', 'root');
INSERT INTO `sys_article_type` VALUES ('a433d54c_04c9_487a_89e2_95f2ab2cf757', '数据结构', '', '2015-07-09 21:30:54', 'luohong', null, null, '0', '9', 'root');
INSERT INTO `sys_article_type` VALUES ('a872d1d2_fa45_4bda_b66f_7b4cfa9afb13', '时事', '', '2015-05-12 15:31:21', 'luohong', null, null, '1', '0', 'root');
INSERT INTO `sys_article_type` VALUES ('aea1ab83_e21e_42f9_a5f4_f5182554b27e', '框架设计', '', '2015-07-09 21:28:12', 'luohong', null, null, '0', '7', 'root');
INSERT INTO `sys_article_type` VALUES ('bf5c9a23_d639_4ed6_841f_a7595678ee99', '大数据', '', '2015-07-09 21:27:20', 'luohong', null, null, '0', '4', 'root');
INSERT INTO `sys_article_type` VALUES ('cd32f1e6_29b2_4b32_94d2_ddb82658416d', '生活', '', '2015-05-12 15:31:02', 'luohong', null, null, '1', '0', 'root');
INSERT INTO `sys_article_type` VALUES ('e6759308_87eb_4d3b_ac3b_90b7041e3405', 'java', '', '2015-07-09 21:27:03', 'luohong', '2015-07-09 21:27:11', 'luohong', '0', '3', 'root');
INSERT INTO `sys_article_type` VALUES ('ebde4a36_0d5e_4f0b_8261_fc40a7e07f93', '国情', '', '2015-05-12 15:31:36', 'luohong', null, null, '1', '0', 'root');
INSERT INTO `sys_article_type` VALUES ('ef77e900_7dc0_4066_8596_8af05106a81e', '技术', '', '2015-05-12 15:30:52', 'luohong', null, null, '1', '0', 'root');
INSERT INTO `sys_article_type` VALUES ('efe5fff2_69dd_4416_9737_c123190493d8', '行业最新博文', '', '2015-07-09 21:28:51', 'luohong', null, null, '0', '8', 'root');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `_id` varchar(50) NOT NULL,
  `_parent_id` varchar(50) DEFAULT NULL,
  `_name` varchar(50) DEFAULT NULL,
  `_desc` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_del_flag` int(1) DEFAULT '0',
  `_pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('442c9a87_a0d4_4312_b73a_d660b14cceb8', '', '日志管理', '这是日志管理菜单', '2015-05-10 09:25:25', 'luohong', null, null, '0', 'http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('article', '', '文章管理', '这是文章管理菜单', '2015-05-06 10:08:01', 'luohong', null, null, '0', 'http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('article_type', '', '文章类别管理', '这是文章类别管理菜单', '2015-05-06 10:08:41', 'luohong', null, null, '1', 'http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', '', 'dfff', 'fff', '2015-07-04 13:27:01', 'luohong', null, null, '1', 'http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('root', null, '基础服务', null, null, null, null, null, '0', null);

-- ----------------------------
-- Table structure for `sys_navigation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_navigation`;
CREATE TABLE `sys_navigation` (
  `_id` varchar(50) NOT NULL,
  `_name` varchar(50) DEFAULT NULL,
  `_desc` varchar(50) DEFAULT NULL,
  `_sort_flag` varchar(50) DEFAULT NULL,
  `_article_type_list` varchar(2000) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_navigation
-- ----------------------------
INSERT INTO `sys_navigation` VALUES ('0d8c18d0_a2f7_41cd_8947_69b0cc1cabbf', '首页', '这里面包含了一些基本信息，比如是我的个人介绍，最新文档，最新动态等', '1', '298bd8f9_d1b6_490c_9420_6d2a3758c63c', null, '2015-07-09 20:56:20', 'luohong', null, '0');
INSERT INTO `sys_navigation` VALUES ('11d579b7_c74f_4cb7_9708_abbcaf0a5072', '行业最新动态', '', '6', 'e6759308_87eb_4d3b_ac3b_90b7041e3405!@!bf5c9a23_d639_4ed6_841f_a7595678ee99!@!efe5fff2_69dd_4416_9737_c123190493d8', null, '2015-07-09 20:57:01', 'luohong', null, '0');
INSERT INTO `sys_navigation` VALUES ('2ace6cca_9f07_40b4_8f4d_8ec6c6ea24a3', '大数据', '', '3', 'bf5c9a23_d639_4ed6_841f_a7595678ee99', null, '2015-07-09 20:56:41', 'luohong', null, '0');
INSERT INTO `sys_navigation` VALUES ('581cc0c4_f638_43ec_b263_24df09f5ab10', 'spring', '', '5', '', null, '2015-07-09 20:56:52', null, null, '1');
INSERT INTO `sys_navigation` VALUES ('7f0db1c8_fe00_447b_9f76_7de5c966388c', 'java', '', '2', 'e6759308_87eb_4d3b_ac3b_90b7041e3405!@!05468853_dbe4_4a06_be42_f1ee7cc7e087!@!aea1ab83_e21e_42f9_a5f4_f5182554b27e', null, '2015-07-09 20:56:36', 'luohong', null, '0');
INSERT INTO `sys_navigation` VALUES ('93ced58a_bc5a_4f0f_a36c_66dee7e28437', '数据结构', '', '4', 'a433d54c_04c9_487a_89e2_95f2ab2cf757', null, '2015-07-09 20:56:46', 'luohong', null, '0');
INSERT INTO `sys_navigation` VALUES ('bab0ac79_ac63_4e40_b580_c222c1582192', '联系信息', '', '8', '585b2cf0_1a36_40c1_8b04_7068d611738c', null, '2015-07-09 20:57:21', 'luohong', null, '0');
INSERT INTO `sys_navigation` VALUES ('c83a77a3_13a2_4074_a0e3_7a81230922c0', '关于我', '', '7', '1420706e_6f54_4c0a_95a9_31c9bf966adf', null, '2015-07-09 20:57:13', 'luohong', null, '0');

-- ----------------------------
-- Table structure for `sys_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `_id` varchar(50) NOT NULL,
  `_name` varchar(50) NOT NULL,
  `_url` varchar(200) DEFAULT NULL,
  `_desc` varchar(200) DEFAULT NULL,
  `_parent_id` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_del_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`_id`),
  KEY `_parent_id` (`_parent_id`),
  CONSTRAINT `sys_privilege_ibfk_1` FOREIGN KEY (`_parent_id`) REFERENCES `sys_privilege` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('015062d1_7970_4028_8324_2884ed6a19b9', '跳转到menu列表界面', '/menu/list.do', '无', '353bff46_c0ab_4a39_9364_430c61d72559', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('0580faf0_df67_468c_9d41_cb15f18df8d9', '跳转到添加子角色界面', '/role/add.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('074ad13f_114a_4d97_95d2_dab0abd7c845', '跳转到添加资源界面', '/resource/add.do', '无', '6f270bfe_41e9_4d16_a326_4a1419c6dedb', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('09f360ce_9cd6_4ab4_8f87_9799a472dc2d', '跳转到添加新模块权限界面', '/privilege/add.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('0afa9982_32c8_401d_91bf_c4727d4a8e84', '退出登录，跳转到登录界面', '/user/logout.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('0c0f3d0f_a7fb_4317_b9b6_a529b6984ccc', '跳转到用户菜单界面', '/user/getUserMenu.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('0e863bf7_1e2c_42fa_a965_3f8dcaa70300', '跳转到添加子模块权限界面', '/privilege/addChild.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('12630e42_d92f_40b4_ab43_52cf0209ed63', '列出menu的tree json', '/menu/listJsonWithResource.do', '无', '353bff46_c0ab_4a39_9364_430c61d72559', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('1a8606ff_4c28_456c_9df7_057cbc6e5d3d', '添加menu', '/menu/addSubmit.do', '无', '353bff46_c0ab_4a39_9364_430c61d72559', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('1d03fdd3_af51_4a6d_a7a7_ced82340c4b4', '添加用户', '/user/addSubmit.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('1db46de4_a77c_403d_8475_dad129c7cf6e', '构建用户的菜单数据，这里的数据应该直接从数据库中获取即可', '/user/getUserMenuJson.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('1efbb256_cc66_4832_9a3d_b5d684eaa982', '获取角色下面的用户的json数据', '/role/getRoleUserJson.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('1f2a41a7_c737_48a9_9200_8e8dca8a88e9', '跳转到添加角色菜单界面', '/role/addRoleMenu.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('1fd5d877_ccb4_4d1f_9303_8265b823a100', '跳转到用户角色界面', '/user/getUserRole.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('23ac9358_7f17_44e0_955e_a17f7eade701', '删除用户权限', '/user/deleteUserPrivilege.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('23ad1adc_1c00_4392_a562_fbd7534c0d27', '取出menu对应的url资源，使用json来包装数据', '/resource/openResourceJson.do', '无', '6f270bfe_41e9_4d16_a326_4a1419c6dedb', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2a6131bc_c6e8_4f41_8754_cad3bcea4ae5', '跳转到menu对应的url资源list界面', '/resource/openResource.do', '无', '6f270bfe_41e9_4d16_a326_4a1419c6dedb', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2ae7f979_3371_4c6f_b033_85ccf82b8f3a', '跳转到添加用户角色界面', '/user/addUserRole.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2cff24c3_8451_4f93_a6cc_306335a79515', '跳转到角色下面用户的界面', '/role/getRoleUser.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2d7f7cfc_3683_420b_a202_9c7c69f6fdd8', '导航管理', '/navigation/list.do', '', '69e0c812_38d1_4ab0_a614_5c97ac255846', '2015-07-09 19:57:47', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2d88aeb6_d93f_4ef8_9937_673c42902260', '跳转到获取角色menu界面', '/role/getRoleMenu.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('33ae2343_e42b_40cb_8199_98f8014bb503', '列出全部权限的json数据', '/privilege/listGridJson.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('353bff46_c0ab_4a39_9364_430c61d72559', '菜单管理', null, null, null, null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3994ba56_fd31_4f35_9419_2abe4dba4084', '添加角色菜单', '/role/addRolePrivilegeSubmit.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3fa4319e_f893_4654_a540_971086a70094', '添加用户角色', '/user/addUserRoleSubmit.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4461a380_a275_436b_85f0_1757998641aa', '列出全部权限，这里维护好层次关系', '/privilege/listJson.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4bd5bea5_58bf_45e4_9ddd_6e2df4b828b7', '跳转到角色列表界面，这里主要是添加用户时调用', '/role/listByTree.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4be53b7e_8f40_4603_adc3_2fd666b352ad', '添加新模块权限', '/privilege/addSubmit.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4bf30594_b0d6_4123_811e_cd6fa8068928', '角色管理', null, null, null, null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4f281537_7759_4bfb_8e9a_0385057d57d1', '添加用户菜单', '/user/addUserMenuSubmit.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4f959266_4d9e_4888_8a32_176886b67fac', '列出所有角色的数据', '/role/listGridJson.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('543c6b71_598f_4eee_aab4_4c0cd960a9f1', '登录', '/user/login.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('5689d84f_c83c_45d7_9267_932326c66a21', '获取用户权限的json数据', '/user/getUserPrivilegeJson.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('5c9c918f_a49e_4f31_b48e_54a34748f2bb', '跳转到添加用户界面', '/role/addUser.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('60e5f9ac_4453_4d88_bf07_ee3ded973137', '跳转到用权限界面', '/user/getUserPrivilege.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('62496d3e_fa48_4a27_8beb_13f9732d2950', '获得用户的json数据', '/user/getUserMenuJsonByUserId.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('6389e675_e31e_44a6_b9ee_27f1acd316d3', '列出menu的json', '/menu/listJson.do', '无', '353bff46_c0ab_4a39_9364_430c61d72559', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('69e0c812_38d1_4ab0_a614_5c97ac255846', '导航管理', null, '', null, '2015-07-09 19:57:03', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('6daa72b2_89dc_4022_9eca_9dec16752184', '选择用户界面', '/user/selectUser.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('6f270bfe_41e9_4d16_a326_4a1419c6dedb', '资源管理', null, null, null, null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('70db3b93_b2f1_4a78_83ca_3fbc0e2dbc32', '获取用户角色的json数据', '/user/getUserRoleJson.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('741f143f_8948_40ae_bc97_d069862c4875', '删除用户的角色', '/user/deleteUserRole.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('75a3733f_e082_4eff_bb39_dbb4a38e939b', '跳转到角色列表界面', '/role/list.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('76001ae2_4b74_4453_b5ea_c4926227e69d', '删除用户菜单', '/user/deleteUserMenu.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('76f50c00_e1d9_47c9_90cb_90ccd661f834', '列出menu的grid json', '/menu/listGridJson.do', '无', '353bff46_c0ab_4a39_9364_430c61d72559', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('78aade44_182f_4e7b_bcdf_d4660dffa570', '广告管理', '/slide/list.do', '', '925bd3ab_0c4e_42d0_aa53_1573d6a0ca90', '2015-07-09 21:32:47', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('817e4812_88c9_4ea5_8da8_df74e9841a67', '权限管理', null, null, null, null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('831566dc_9500_4e75_be29_fdd8009e2398', '打开全部的权限列表', '/privilege/listTreeJson.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('869b7e79_f203_4ba7_8052_5747ce0279d9', '修改密码', '/user/changePasswordSubmit.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('870c3174_143d_4a3d_8a11_6663bc67354e', '跳转到角色的相关信息界面', '/role/openRole.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('88669996_4d52_4e0e_bc95_024604c04215', '跳转到添加角色菜单界面', '/role/addRolePrivilege.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('8893495a_b514_4fbc_9471_2757dbe91064', '跳转到编辑用户的界面', '/user/edit.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('8ae6902e_6e6f_4669_84a5_4862552d5011', '跳转到用户信息界面', '/user/getUserInfo.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('9106bcc1_5ba4_47b4_a73a_841740b7ad11', '跳转到系统模块首页', '/privilege/list.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('925bd3ab_0c4e_42d0_aa53_1573d6a0ca90', '广告管理', null, '', null, '2015-07-09 21:32:29', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('92f97a00_51dd_4e95_8644_d4293884288a', '列出所有角色的数据', '/role/listJson.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('9ad9f23b_aa06_42ef_b916_617a16006440', '添加子角色', '/role/addSubmit.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('9e3d7302_7911_4143_80dc_88e50ab9a38a', '跳转到添加menu界面', '/menu/add.do', '无', '353bff46_c0ab_4a39_9364_430c61d72559', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a4ce0b14_2e5e_4d0b_92d8_613bb605e152', '跳转到添加用户权限界面', '/user/addUserPrivilege.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a750af17_4320_4709_80c1_1cdfdb037746', '添加用户权限', '/user/addUserPrivilegeSubmit.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a8477ac2_8e7a_451e_91be_6a2b93815c2f', '列出用户的数据，这里包含了分页以及查询功能', '/user/listJson.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('ac9a7a4a_8a4e_42e5_bd85_ad35eaf3a72e', '添加用户', '/role/addUserSubmit.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('afd973a4_d7b8_4b95_a939_495cb0baab08', '跳转到添加用户界面', '/user/add.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('b2e4326b_1947_4c13_87fd_d497c0e78b59', '获取角色权限的json数据', '/role/getRolePrivilegeJson.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('bb93fa03_a81b_406d_9ecd_b929d2473b97', '跳转到添加用户菜单界面', '/user/addUserMenu.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c1cd6e2c_c169_42e3_8c68_af4071a68a9c', '删除角色', '/role/delete.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c20fe546_464d_4671_8814_cabdc9c2808b', '返回角色对应menu的json数据', '/role/getRoleMenuJson.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c22b8ad4_73f1_4642_8cc5_836ec4803bb0', '添加子模块权限', '/privilege/addChildSubmit.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c2f9665a_717f_4617_8b7c_b1a3fd6f6bd3', '删除menu', '/menu/delete.do', '无', '353bff46_c0ab_4a39_9364_430c61d72559', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c833a2a2_1219_40d6_beb6_bd31c699ba81', '根据角色id，来获取角色的基本信息，并且跳转到角色基本信息界面', '/role/getBaseInfo.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c93af67a_f66e_485e_8cfa_bf3d2f00fce5', '跳转到修改密码界面', '/user/changePassword.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d410c55b_df9c_4a1f_b110_2ab76503e6fc', '删除用户', '/user/delete.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d700901d_e530_4f3c_b44b_eea4866fe229', '更新用户信息', '/user/editSubmit.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d71f6cd2_33e1_48e2_8253_93a9a3c24bb2', '跳转到登录用户的基本信息界面，这里会列出用户的信息，权限，菜单等', '/user/getLoginUserInfo.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('dce6815c_b075_4e55_9efb_65540b300c51', '删除角色的权限', '/role/deletePrivilege.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('e225011c_01bd_4bb4_83e7_12e157263f35', '从角色中删除用户列表', '/role/deleteRoleUser.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('e659380a_330a_47b2_9b69_f93aec415f50', '用户管理', null, null, null, null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('ea4b69c6_192a_48b5_bf20_f7828a98f068', '跳转到添加用户基本信息界面', '/user/baseInfo.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('ed300711_8bd4_4826_880e_7da580cc07cd', '添加角色菜单', '/role/deleteMenu.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f0d504ee_e345_4a5a_9f6f_4e5392865857', '添加角色菜单', '/role/addRoleMenuSubmit.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f1bc73a2_f3fb_4f93_a267_923c41d3ad7d', '跳转到用户列表界面', '/user/list.do', '无', 'e659380a_330a_47b2_9b69_f93aec415f50', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f2e064ec_bd9f_4a37_bc08_1a1c2674b77c', '跳转到角色权限界面', '/role/getRolePrivilege.do', '无', '4bf30594_b0d6_4123_811e_cd6fa8068928', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f8b47a5a_7d84_4002_bff7_6bbe8473bdd3', '删除模块', '/privilege/delete.do', '无', '817e4812_88c9_4ea5_8da8_df74e9841a67', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fb53b7b1_9bac_4cc1_a02e_2da72440de2b', '添加资源', '/resource/addSubmit.do', '无', '6f270bfe_41e9_4d16_a326_4a1419c6dedb', null, null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fca2cd50_3565_4a5b_9508_f25a70651e5b', '删除资源', '/resource/delete.do', '无', '6f270bfe_41e9_4d16_a326_4a1419c6dedb', null, null, null, null, '0');

-- ----------------------------
-- Table structure for `sys_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `_id` varchar(50) NOT NULL,
  `_name` varchar(50) NOT NULL,
  `_url` varchar(200) DEFAULT NULL,
  `_desc` varchar(50) DEFAULT NULL,
  `_menu_id` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_del_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`_id`),
  KEY `resource_menu_id` (`_menu_id`),
  CONSTRAINT `sys_resource_ibfk_1` FOREIGN KEY (`_menu_id`) REFERENCES `sys_menu` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('03a30095_5017_4f9b_8324_f3ff401a3a5b', '获得用户的json数据', 'http://localhost:80/springmvc_mybatis/user/getUserMenuJsonByUserId.do', '无', 'root', '502f2f3e_c602_4957_a6aa_0e9da7f847b7', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('080f47a6_b428_4c05_8193_98a20422bf1c', '导航管理', 'http://localhost:80/springmvc_mybatis/navigation/list.do', '', 'root', '3cd7b646_ea79_4de1_99da_e65ae12db6d8', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('092b0ea1_5d12_429f_ab89_f3ddf5a77783', '获取用户角色的json数据', 'http://localhost:80/springmvc_mybatis/user/getUserRoleJson.do', '无', 'root', 'f25a604f_1d9a_4577_b99b_0f4061646c40', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('10079ec9_faac_4955_8314_836c142286fa', '修改密码', 'http://localhost:80/springmvc_mybatis/user/changePasswordSubmit.do', '无', 'root', '6af8c57f_351e_4d50_8135_0d5d47d093f7', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('13113516_52ad_4f5e_81ba_1a8580145234', '跳转到menu列表界面', 'http://localhost:80/springmvc_mybatis/menu/list.do', '无', 'root', 'bb971ef4_f422_40f7_9cb4_c88604c6680b', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('1698c92f_c182_4a28_9568_8ec7afd1d02c', '跳转到添加用户菜单界面', 'http://localhost:80/springmvc_mybatis/user/addUserMenu.do', '无', 'root', '791f503f_5d67_4b86_922a_96b33ccb9228', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('1956d581_6e97_4880_a4aa_0d6a2c3ce011', '用户管理', 'http://localhost/springmvc_mybatis/user/list.do', '', 'root', '90d77efe_db5a_4291_9b84_644de7233934', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('1d794622_0b15_4086_aedc_d8c355b2f114', '删除用户的角色', 'http://localhost:80/springmvc_mybatis/user/deleteUserRole.do', '无', 'root', '0c2b55d4_257d_4603_b047_dcb5ddb7e955', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('1d87d0d3_e715_4ee7_8cbb_91913ad486a6', '选择用户界面', 'http://localhost:80/springmvc_mybatis/user/selectUser.do', '无', 'root', '3536d696_b3a2_4a7d_ad1e_cdfadc5768b8', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('23816af1_6c46_4d52_b14c_eb73cfbd25b2', '文章类别列表', 'http://localhost/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', 'article_type', '8d2389e7_363b_4692_a6ea_c13f8a7c7ed8', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('27a3baf0_1661_43bf_989e_61809e07d6bf', '列出用户的数据，这里包含了分页以及查询功能', 'http://localhost:80/springmvc_mybatis/user/listJson.do', '无', 'root', '2801c325_a662_4180_8cdd_198655c7a693', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('34112747_e66c_4c5d_86d1_a05d7d691dc8', '列出用户的数据，这里包含了分页以及查询功能', 'http://localhost:80/springmvc_mybatis/user/listJson.do', '无', 'root', '3f3cdfa1_c26e_4210_a061_14fb4ae98a7f', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('375875c2_f212_4757_9e15_1ca82679f40b', '列出所有角色的数据', 'http://localhost:80/springmvc_mybatis/role/listGridJson.do', '无', 'root', '4b8e53cf_63c1_430d_bf18_d50ced5407ef', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('376f75b1_a8fd_42e3_85c1_bbbc4e718780', '更新用户信息', 'http://localhost:80/springmvc_mybatis/user/editSubmit.do', '无', 'root', 'd052711d_d6c5_4c95_b546_9c450589afbb', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('3a1bbe26_7b47_4c15_b7bf_de19abb7fcf3', '列出所有角色的数据', 'http://localhost:80/springmvc_mybatis/role/listGridJson.do', '无', 'root', '58c60615_6613_4e93_a1b8_3dcdacb56b42', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('3a4dcb29_4e43_4bd2_bf9a_6af9bf88d353', '跳转到用户菜单界面', 'http://localhost:80/springmvc_mybatis/user/getUserMenu.do', '无', 'root', 'bb428080_e102_4cdd_bfad_4574e20d11b8', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('40a20d30_101d_4f18_ba16_d3dd79b74393', '跳转到添加资源界面', '/resource/add.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', 'b5690a32_9a1b_4557_9b0b_c4b42b54bef8', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('4276e984_74db_4d26_b376_b85f4ac06822', '导航管理', '/navigation/list.do', '', 'root', '169b0004_7332_4da5_bc50_e6e1da596a29', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('42c6ca5d_240e_4e93_b1ed_e55b5e0df51c', '添加用户权限', 'http://localhost:80/springmvc_mybatis/user/addUserPrivilegeSubmit.do', '无', 'root', '399a7d24_ae78_463c_b249_1e82f353994d', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('48597de8_db86_4868_8056_a69622fbbe27', '删除用户菜单', 'http://localhost:80/springmvc_mybatis/user/deleteUserMenu.do', '无', 'root', '6b656a83_2fe0_4161_b36a_180fdf7b749a', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('48e740da_ce57_45fd_b26b_bab1c3bbf04a', '菜单管理', 'http://localhost/springmvc_mybatis/menu/list.do', '', 'root', 'ea0d5cc5_f45a_409d_85f4_acda189a27fb', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('4b8b469d_9a12_4571_87f8_3e09ce23584a', '跳转到用户列表界面', 'http://localhost:80/springmvc_mybatis/user/list.do', '无', 'root', '14712a32_6891_4f6a_b9f4_67d654470c24', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('4c15e5c9_6949_4b46_8298_3a55c224a5a5', '列出全部权限的json数据', 'http://localhost:80/springmvc_mybatis/privilege/listGridJson.do', '无', 'root', '6c54692d_1c23_4990_8b43_56d81eb6b0de', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('4fdb15ba_3132_46f2_9ed9_9db743034f01', '构建用户的菜单数据，这里的数据应该直接从数据库中获取即可', 'http://localhost:80/springmvc_mybatis/user/getUserMenuJson.do', '无', 'root', 'b5b06882_5908_49d6_ad69_b75e567b137b', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('55fc2810_68ed_42d9_ac58_91d2becaa305', '跳转到添加用户权限界面', 'http://localhost:80/springmvc_mybatis/user/addUserPrivilege.do', '无', 'root', '4de92476_cf73_401f_890c_335a86192097', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('682e1227_fb67_4009_bc2c_aa404dcd72a3', '日志管理', 'http://localhost/springmvc_mybatis/article/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '493b022e_0f43_4cc9_886a_dd3ba83ce519', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('6a0fee19_edaf_4ec4_a2e8_bbc574544f07', '日志类别管理', 'http://localhost/springmvc_mybatis/articleType/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', 'b395d3a9_8d23_4c4c_8911_5779ffefee4c', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('6daa1e7f_3f72_44d4_a034_b6805bbfbb0f', '跳转到登录用户的基本信息界面，这里会列出用户的信息，权限，菜单等', 'http://localhost:80/springmvc_mybatis/user/getLoginUserInfo.do', '无', 'root', 'da357f85_bf9b_440b_aeed_18c6b54b26d4', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('706eab5c_2a55_4d60_b993_c57111be42cd', '删除用户权限', 'http://localhost:80/springmvc_mybatis/user/deleteUserPrivilege.do', '无', 'root', '4ad49bfc_f744_403e_847c_c9cfab08304a', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('73617f3e_12e9_428b_a813_87239f1d75de', '跳转到添加用户界面', 'http://localhost:80/springmvc_mybatis/user/add.do', '无', 'root', 'e83af025_a6e4_42e1_9b87_2098608ffe79', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('74140054_cc5d_4a0b_8821_51c8e1bb50b3', '文章管理', 'http://localhost/springmvc_mybatis/article/list.do', '', 'article', 'c53b9986_ece4_4362_beea_bf5bcba61a41', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('765d634f_f17b_470b_bc9b_34c7b431335e', '跳转到用户信息界面', 'http://localhost:80/springmvc_mybatis/user/getUserInfo.do', '无', 'root', '84606f57_0959_40ae_bcf2_1f6581cfde83', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('78da7b75_e2db_4fad_87d5_b70c50c42256', '文章类别列表', 'http://localhost/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', 'article', 'a56b00f3_a59a_49b0_a3a1_89c78a412227', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('794eb5f1_2244_4280_8fea_553a01ba7779', '删除资源', '/resource/delete.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', 'fdd3a689_45e8_433f_b3eb_1c7ebe9dee69', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('7d1e783c_f5e7_4128_9cd8_ade60e72c111', '添加用户', 'http://localhost:80/springmvc_mybatis/user/addSubmit.do', '无', 'root', '6f2a8e26_14d0_4736_88a4_7998b84a63b9', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('7ea70782_46a6_4f46_a43f_ebe5b8cfea53', '添加用户菜单', 'http://localhost:80/springmvc_mybatis/user/addUserMenuSubmit.do', '无', 'root', '0d1c8cba_aa52_436c_ad5f_8fb4d9cdbeff', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('85bfb649_9c03_4122_817d_811977749415', '列出用户的数据，这里包含了分页以及查询功能', 'http://localhost:80/springmvc_mybatis/user/listJson.do', '无', 'root', '8f0a6d5f_de0f_4bc9_a7bd_26b28df2deb9', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('8b95cb59_8dc0_426b_8382_f2df5c7c79cd', '添加用户角色', 'http://localhost:80/springmvc_mybatis/user/addUserRoleSubmit.do', '无', 'root', 'e1d5b5ef_7aa5_4df4_b0e8_b352f3586b3f', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('9220bf83_2031_450f_9b89_134760d6afd9', '跳转到添加用户基本信息界面', 'http://localhost:80/springmvc_mybatis/user/baseInfo.do', '无', 'root', '188a9ca6_a712_44e1_8814_fbbb14a0e33b', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('952ce4c8_9087_44ef_b137_8eb4a280e534', '删除用户', 'http://localhost:80/springmvc_mybatis/user/delete.do', '无', 'root', '0f3fbca0_b447_4dbe_81e0_0b62f4f1e3af', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('9903b0f0_478d_4e7b_a6d1_4009c39cec27', '角色管理', 'http://localhost/springmvc_mybatis/role/list.do', '', 'root', 'ef63cf50_7226_42cf_9e27_ee3318c31182', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('993cf547_1258_47ec_acfd_735d331fa0e6', '跳转到修改密码界面', 'http://localhost:80/springmvc_mybatis/user/changePassword.do', '无', 'root', 'c39f61e3_a554_4444_9b11_3c3a30d35ceb', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('a6b57a3f_3e99_4166_b81e_1c5399424090', '退出登录，跳转到登录界面', 'http://localhost:80/springmvc_mybatis/user/logout.do', '无', 'root', '9e390f53_1d6a_47b0_a636_6087d8bcd759', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('ac67ff21_16f0_4d6c_a2da_4dc349dbfb9e', '用户管理', 'http://localhost/springmvc_mybatis/user/list.do', '', 'root', '16add85d_b064_454a_af6f_38e6afec6259', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('adc3cced_f69f_4c2a_9819_5d8bd1d988f2', '跳转到用户角色界面', 'http://localhost:80/springmvc_mybatis/user/getUserRole.do', '无', 'root', '1024d490_8c51_4680_9959_f3961c486ee9', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('b3b545d6_92b0_42e9_8b1b_208899a53c54', '添加资源', '/resource/addSubmit.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', '62258535_69fe_4c35_9a07_2d5d817de28e', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('bb7ffbf9_9b5f_453b_90aa_d1a13cef99d4', '权限管理', 'http://localhost/springmvc_mybatis/privilege/list.do', '', 'root', 'e0af4343_545f_4b0d_9213_c2f0f15bb47c', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('be8ffec3_d612_4009_9b3c_8757aba69b8d', '获取用户权限的json数据', 'http://localhost:80/springmvc_mybatis/user/getUserPrivilegeJson.do', '无', 'root', 'fe66009c_b025_4cec_97ee_b242564ebf5f', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('c24ab5b3_bc10_4311_adfe_ebae41361344', '广告管理', 'http://localhost:80/springmvc_mybatis/slide/list.do', '', 'root', 'b2c35627_76d1_4844_a301_9ca3f2db2d99', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('c5f0002c_24f4_4eac_a9cc_2b5aec72c33e', '登录', 'http://localhost:80/springmvc_mybatis/user/login.do', '无', 'root', '24102d6c_bda6_496c_ba04_52f22910cfe1', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('ca99595b_cf1e_426b_8d3d_673ce34e1332', '跳转到角色列表界面', 'http://localhost:80/springmvc_mybatis/role/list.do', '无', 'root', '511ecb95_8f90_469c_8dd1_f417d7c61d72', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('dba8b76d_d82f_4b29_af63_5c071ab9ebd3', '跳转到添加用户角色界面', 'http://localhost:80/springmvc_mybatis/user/addUserRole.do', '无', 'root', 'dc2d8c75_a701_4a8c_bd80_9db8a0a3604e', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('e9c248f0_2565_43e7_980f_1c18531bcd80', '跳转到系统模块首页', 'http://localhost:80/springmvc_mybatis/privilege/list.do', '无', 'root', '92dea00b_2644_43ae_bd72_8fb82ffaabb7', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('ec79756d_33d4_483d_9953_d734ad801610', '跳转到menu对应的url资源list界面', '/resource/openResource.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', 'd31b9fa4_e038_4d5d_9d6e_828487dc0ef3', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('f06a0bd4_e563_4bba_bd31_9535f49c467f', '跳转到用权限界面', 'http://localhost:80/springmvc_mybatis/user/getUserPrivilege.do', '无', 'root', '61540833_b1e1_489b_b8d3_0a37853ce7ac', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('f5572eb1_b614_4093_b20a_8221e30c16e2', '取出menu对应的url资源，使用json来包装数据', '/resource/openResourceJson.do', 'fuck', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', '81d08048_14f5_4060_8aef_2d0b49e2b41c', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('f61a3d45_6f55_40fc_9e32_ff8fef70d550', '跳转到编辑用户的界面', 'http://localhost:80/springmvc_mybatis/user/edit.do', '无', 'root', '9d9e829d_4c80_4c00_8704_63dbfc3415d3', null, null, null, '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `_id` varchar(50) NOT NULL,
  `_name` varchar(50) NOT NULL,
  `_parent_id` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_del_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('92386e75_2b6d_4765_a58e_0104c361b39f', '文章管理角色', '', null, null, '2015-05-07 23:26:28', 'luohong', '0');
INSERT INTO `sys_role` VALUES ('root', '默认角色', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `_id` varchar(50) NOT NULL,
  `_role_id` varchar(50) DEFAULT NULL,
  `_menu_id` varchar(50) DEFAULT NULL,
  `_resource_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `role_id` (`_role_id`),
  KEY `menu_id` (`_menu_id`),
  KEY `resource_id` (`_resource_id`),
  CONSTRAINT `sys_role_menu_ibfk_1` FOREIGN KEY (`_role_id`) REFERENCES `sys_role` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`_menu_id`) REFERENCES `sys_menu` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_menu_ibfk_3` FOREIGN KEY (`_resource_id`) REFERENCES `sys_resource` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('780fa046_a88f_440b_aa7f_685f805d59bf', '92386e75_2b6d_4765_a58e_0104c361b39f', 'article_type', '23816af1_6c46_4d52_b14c_eb73cfbd25b2');
INSERT INTO `sys_role_menu` VALUES ('b2e2c9b5_6208_4d6b_b2fe_45ff7f80fdc2', 'root', 'root', 'bb7ffbf9_9b5f_453b_90aa_d1a13cef99d4');

-- ----------------------------
-- Table structure for `sys_role_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `_id` varchar(50) NOT NULL,
  `_role_id` varchar(50) DEFAULT NULL,
  `_privilege_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `role_id` (`_role_id`),
  KEY `privilege_id` (`_privilege_id`),
  CONSTRAINT `sys_role_privilege_ibfk_1` FOREIGN KEY (`_role_id`) REFERENCES `sys_role` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_privilege_ibfk_2` FOREIGN KEY (`_privilege_id`) REFERENCES `sys_privilege` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `_id` varchar(50) NOT NULL,
  `_role_id` varchar(50) DEFAULT NULL,
  `_user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `role_id` (`_role_id`),
  KEY `user_id` (`_user_id`),
  CONSTRAINT `sys_role_user_ibfk_1` FOREIGN KEY (`_role_id`) REFERENCES `sys_role` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_user_ibfk_2` FOREIGN KEY (`_user_id`) REFERENCES `sys_user` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('22c9f0d8_ad13_40fd_93f0_fa8a203bdd33', '92386e75_2b6d_4765_a58e_0104c361b39f', 'b83b1daf_f21b_477b_aa3a_05ab35f961aa');
INSERT INTO `sys_role_user` VALUES ('2db50826_213a_4664_bca6_5a8c64c8a61a', '92386e75_2b6d_4765_a58e_0104c361b39f', '10b961c8_ff44_48a1_9a00_bbe73de2bcc2');
INSERT INTO `sys_role_user` VALUES ('4b4b13bf_09d1_4f02_9555_a6cf8206a0bf', 'root', '31a0b6c6_dac0_4f19_9de1_32b52afa661f');
INSERT INTO `sys_role_user` VALUES ('5c9cb1fb_6640_4015_8e3e_f6b95f5a0559', '92386e75_2b6d_4765_a58e_0104c361b39f', 'b83b1daf_f21b_477b_aa3a_05ab35f961aa');
INSERT INTO `sys_role_user` VALUES ('5fc704a2_bae6_4ced_aa8e_fd4fd2bb66e2', '92386e75_2b6d_4765_a58e_0104c361b39f', '31a0b6c6_dac0_4f19_9de1_32b52afa661f');
INSERT INTO `sys_role_user` VALUES ('6484d22f_a7d8_409d_822e_9e6e09334ac6', '92386e75_2b6d_4765_a58e_0104c361b39f', '31a0b6c6_dac0_4f19_9de1_32b52afa661f');
INSERT INTO `sys_role_user` VALUES ('9259bf2a_4aac_4355_9bcf_4c6807b6e5c7', 'root', '10b961c8_ff44_48a1_9a00_bbe73de2bcc2');
INSERT INTO `sys_role_user` VALUES ('e4baafae_4ccd_4aa7_924d_8174526c2094', '92386e75_2b6d_4765_a58e_0104c361b39f', '31a0b6c6_dac0_4f19_9de1_32b52afa661f');
INSERT INTO `sys_role_user` VALUES ('f4766ab1_6953_4b24_b0a0_9748d7bf21fb', '92386e75_2b6d_4765_a58e_0104c361b39f', 'root');
INSERT INTO `sys_role_user` VALUES ('ff53c644_af14_4f02_a4fd_9220319e2d14', 'root', 'b83b1daf_f21b_477b_aa3a_05ab35f961aa');

-- ----------------------------
-- Table structure for `sys_slide`
-- ----------------------------
DROP TABLE IF EXISTS `sys_slide`;
CREATE TABLE `sys_slide` (
  `_title` varchar(1000) DEFAULT NULL,
  `_id` varchar(50) NOT NULL,
  `_name` varchar(50) DEFAULT NULL,
  `_desc` varchar(50) DEFAULT NULL,
  `_image_url` varchar(200) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_updated_time` varchar(50) DEFAULT NULL,
  `_del_flag` char(1) DEFAULT '0',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_slide
-- ----------------------------
INSERT INTO `sys_slide` VALUES ('你好，世界', '0fd6f9fa_bc01_488c_824a_1d6b207691e9', null, '就要搞定了，加油', '/springmvc_mybatis/attached/image/20150709/20150709213613_477.jpg', 'luohong', '2015-07-09 21:36:19', null, null, '0');
INSERT INTO `sys_slide` VALUES ('你好，世界', 'ae8a583b_49e7_46de_bd5f_c6df8b903981', null, '哈哈，快要搞定了', '/springmvc_mybatis/attached/image/20150709/20150709213600_767.jpg', 'luohong', '2015-07-09 21:36:07', null, null, '0');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `_id` varchar(50) NOT NULL,
  `_name` varchar(50) DEFAULT NULL,
  `_login_name` varchar(50) NOT NULL,
  `_password` varchar(50) NOT NULL,
  `_tel` varchar(50) DEFAULT NULL,
  `_qq` varchar(20) DEFAULT NULL,
  `_email` varchar(50) DEFAULT NULL,
  `_blog` varchar(50) DEFAULT NULL,
  `_address` varchar(200) DEFAULT NULL,
  `_current_address` varchar(200) DEFAULT NULL,
  `_birthday` varchar(20) DEFAULT NULL,
  `_login_count` int(11) DEFAULT '0',
  `_updated_time` varchar(50) DEFAULT NULL,
  `_updator` varchar(50) DEFAULT NULL,
  `_created_time` varchar(50) DEFAULT NULL,
  `_creator` varchar(50) DEFAULT NULL,
  `_del_flag` int(1) DEFAULT '0',
  `_super_user_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`_id`),
  UNIQUE KEY `user_login_name` (`_login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10b961c8_ff44_48a1_9a00_bbe73de2bcc2', '沈少钦', 'shenshaoqin', 'E10ADC3949BA59ABBE56E057F20F883E', '15013336884', '846705189', '846705189@qq.com', 'http://localhost/springmvc_mybatis/user/login.do', '潮汕', '潮汕', '1993-01-21', '0', null, null, '2015-05-12 14:20:36', 'luohong', '0', '0');
INSERT INTO `sys_user` VALUES ('31a0b6c6_dac0_4f19_9de1_32b52afa661f', 'luohong1', 'luohong1', 'B25930C902D38E98FA564302DDAD3D44', '', '', 'luohong@qq.com', '', '', '', '', '0', null, null, '2015-07-06 21:13:50', 'luohong', '0', '0');
INSERT INTO `sys_user` VALUES ('b83b1daf_f21b_477b_aa3a_05ab35f961aa', '谢梅娇', 'xiemeijiao', '3792FB33DB6FE6E2A7E2E4261498628D', '15013336884', '846705189', '846705189@qq.com', null, '广东河源龙川', '广东河源龙川', '1993-01-21', '0', null, null, '2015-05-12 14:17:51', 'luohong', '0', '0');
INSERT INTO `sys_user` VALUES ('root', 'luohong', 'admin', '21232F297A57A5A743894A0E4A801FC3', '15013336884', '846705189', '846705189@qq.com', null, null, null, '2015-02-04', '0', null, null, null, null, '0', '1');

-- ----------------------------
-- Table structure for `sys_user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `_id` varchar(50) NOT NULL,
  `_user_id` varchar(50) DEFAULT NULL,
  `_menu_id` varchar(50) DEFAULT NULL,
  `_resource_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `user_id` (`_user_id`),
  KEY `menu_id` (`_menu_id`),
  KEY `resource_id` (`_resource_id`),
  CONSTRAINT `sys_user_menu_ibfk_1` FOREIGN KEY (`_user_id`) REFERENCES `sys_user` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_menu_ibfk_2` FOREIGN KEY (`_menu_id`) REFERENCES `sys_menu` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_menu_ibfk_3` FOREIGN KEY (`_resource_id`) REFERENCES `sys_resource` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------
INSERT INTO `sys_user_menu` VALUES ('acf51207_7416_4350_b410_75650391357f', '10b961c8_ff44_48a1_9a00_bbe73de2bcc2', 'root', '48e740da_ce57_45fd_b26b_bab1c3bbf04a');

-- ----------------------------
-- Table structure for `sys_user_privilege`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_privilege`;
CREATE TABLE `sys_user_privilege` (
  `_id` varchar(50) NOT NULL,
  `_user_id` varchar(50) DEFAULT NULL,
  `_privilege_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `user_id` (`_user_id`),
  KEY `privilege_id` (`_privilege_id`),
  CONSTRAINT `sys_user_privilege_ibfk_1` FOREIGN KEY (`_user_id`) REFERENCES `sys_user` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_privilege_ibfk_2` FOREIGN KEY (`_privilege_id`) REFERENCES `sys_privilege` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_user_resource`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_resource`;
CREATE TABLE `sys_user_resource` (
  `_id` varchar(50) NOT NULL,
  `_user_id` varchar(50) NOT NULL,
  `_url` varchar(200) NOT NULL,
  PRIMARY KEY (`_id`),
  KEY `user_resource_user_id` (`_user_id`),
  CONSTRAINT `sys_user_resource_ibfk_1` FOREIGN KEY (`_user_id`) REFERENCES `sys_user` (`_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_resource
-- ----------------------------

-- ----------------------------
-- View structure for `sys_user_menu_view`
-- ----------------------------
DROP VIEW IF EXISTS `sys_user_menu_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sys_user_menu_view` AS select distinct `sys_menu`.`_id` AS `_id`,`sys_menu`.`_desc` AS `_desc`,`sys_menu`.`_name` AS `_name`,`sys_menu`.`_creator` AS `_creator`,`sys_menu`.`_created_time` AS `_created_time`,`sys_menu`.`_updated_time` AS `_updated_time`,`sys_menu`.`_updator` AS `_updator`,`sys_menu`.`_parent_id` AS `_parent_id`,`sys_menu`.`_pic` AS `_pic`,`sys_user`.`_id` AS `_user_id` from ((((`sys_user` join `sys_role_user`) join `sys_role`) join `sys_role_menu`) join `sys_menu`) where ((`sys_user`.`_id` = `sys_role_user`.`_user_id`) and (`sys_role_user`.`_role_id` = `sys_role`.`_id`) and (`sys_role`.`_id` = `sys_role_menu`.`_role_id`) and (`sys_role_menu`.`_menu_id` = `sys_menu`.`_id`)) union select distinct `sys_menu`.`_id` AS `_id`,`sys_menu`.`_desc` AS `_desc`,`sys_menu`.`_name` AS `_name`,`sys_menu`.`_creator` AS `_creator`,`sys_menu`.`_created_time` AS `_created_time`,`sys_menu`.`_updated_time` AS `_updated_time`,`sys_menu`.`_updator` AS `_updator`,`sys_menu`.`_parent_id` AS `_parent_id`,`sys_menu`.`_pic` AS `_pic`,`sys_user`.`_id` AS `_user_id` from ((`sys_user` join `sys_user_menu`) join `sys_menu`) where ((`sys_user`.`_id` = `sys_user_menu`.`_user_id`) and (`sys_user_menu`.`_menu_id` = `sys_menu`.`_id`)) ;

-- ----------------------------
-- View structure for `sys_user_privilege_view`
-- ----------------------------
DROP VIEW IF EXISTS `sys_user_privilege_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `sys_user_privilege_view` AS select distinct `sys_privilege`.`_id` AS `_id`,`sys_privilege`.`_name` AS `_name`,`sys_privilege`.`_parent_id` AS `_parent_id`,`sys_privilege`.`_desc` AS `_desc`,`sys_privilege`.`_creator` AS `_creator`,`sys_privilege`.`_created_time` AS `_created_time`,`sys_privilege`.`_updator` AS `_updator`,`sys_privilege`.`_updated_time` AS `_updated_time`,`sys_privilege`.`_del_flag` AS `_del_flag`,`sys_user`.`_id` AS `_user_id`,`sys_privilege`.`_url` AS `_url` from ((((`sys_user` join `sys_role_user`) join `sys_role`) join `sys_role_privilege`) join `sys_privilege`) where ((`sys_user`.`_id` = `sys_role_user`.`_user_id`) and (`sys_role_user`.`_role_id` = `sys_role`.`_id`) and (`sys_role`.`_id` = `sys_role_privilege`.`_role_id`) and (`sys_role_privilege`.`_privilege_id` = `sys_privilege`.`_id`) and (`sys_user`.`_del_flag` = 0) and (`sys_role`.`_del_flag` = 0) and (`sys_privilege`.`_del_flag` = 0)) union select distinct `sys_privilege`.`_id` AS `_id`,`sys_privilege`.`_name` AS `_name`,`sys_privilege`.`_parent_id` AS `_parent_id`,`sys_privilege`.`_desc` AS `_desc`,`sys_privilege`.`_creator` AS `_creator`,`sys_privilege`.`_created_time` AS `_created_time`,`sys_privilege`.`_updator` AS `_updator`,`sys_privilege`.`_updated_time` AS `_updated_time`,`sys_privilege`.`_del_flag` AS `_del_flag`,`sys_user`.`_id` AS `_user_id`,`sys_privilege`.`_url` AS `_url` from ((`sys_user` join `sys_user_privilege`) join `sys_privilege`) where ((`sys_user`.`_id` = `sys_user_privilege`.`_user_id`) and (`sys_user_privilege`.`_privilege_id` = `sys_privilege`.`_id`) and (`sys_user`.`_del_flag` = 0) and (`sys_privilege`.`_del_flag` = 0)) ;
