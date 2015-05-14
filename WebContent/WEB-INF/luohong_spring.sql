/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : luohong_spring

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-05-13 11:12:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for install_info
-- ----------------------------
DROP TABLE IF EXISTS `install_info`;
CREATE TABLE `install_info` (
  `install` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_article
-- ----------------------------
DROP TABLE IF EXISTS `sys_article`;
CREATE TABLE `sys_article` (
  `id` varchar(50) NOT NULL,
  `article_title` varchar(50) DEFAULT NULL,
  `article_content` longtext,
  `article_url` varchar(200) DEFAULT NULL,
  `article_view_count` int(11) DEFAULT NULL,
  `article_reference` int(11) DEFAULT NULL,
  `article_type_id` varchar(50) DEFAULT NULL,
  `article_created_time` varchar(50) DEFAULT NULL,
  `article_creator` varchar(50) DEFAULT NULL,
  `article_updated_time` varchar(50) DEFAULT NULL,
  `article_updator` varchar(50) DEFAULT NULL,
  `article_del_flag` int(1) DEFAULT '0',
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `article_type_id` (`article_type_id`),
  KEY `user_fk_article` (`user_id`),
  CONSTRAINT `sys_article_ibfk_1` FOREIGN KEY (`article_type_id`) REFERENCES `sys_article_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_fk_article` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_article
-- ----------------------------

-- ----------------------------
-- Table structure for sys_article_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_article_type`;
CREATE TABLE `sys_article_type` (
  `id` varchar(50) NOT NULL,
  `article_type_name` varchar(50) DEFAULT NULL,
  `article_type_desc` varchar(200) DEFAULT NULL,
  `article_type_created_time` varchar(50) DEFAULT NULL,
  `article_type_creator` varchar(50) DEFAULT NULL,
  `article_type_updated_time` varchar(50) DEFAULT NULL,
  `article_type_updator` varchar(50) DEFAULT NULL,
  `article_type_del_flag` int(1) DEFAULT '0',
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_fk_type` (`user_id`),
  CONSTRAINT `user_fk_type` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_article_type
-- ----------------------------
INSERT INTO `sys_article_type` VALUES ('0546486f_22ad_4ae3_a1cd_8cd9314a5837', '随笔', '', '2015-05-12 15:30:57', 'luohong', null, null, '0', 'root');
INSERT INTO `sys_article_type` VALUES ('8c2408a6_ed29_4384_a8b8_fe20eac5cd03', '行政', '', '2015-05-12 15:31:26', 'luohong', null, null, '0', 'root');
INSERT INTO `sys_article_type` VALUES ('a872d1d2_fa45_4bda_b66f_7b4cfa9afb13', '时事', '', '2015-05-12 15:31:21', 'luohong', null, null, '0', 'root');
INSERT INTO `sys_article_type` VALUES ('cd32f1e6_29b2_4b32_94d2_ddb82658416d', '生活', '', '2015-05-12 15:31:02', 'luohong', null, null, '0', 'root');
INSERT INTO `sys_article_type` VALUES ('ebde4a36_0d5e_4f0b_8261_fc40a7e07f93', '国情', '', '2015-05-12 15:31:36', 'luohong', null, null, '0', 'root');
INSERT INTO `sys_article_type` VALUES ('ef77e900_7dc0_4066_8596_8af05106a81e', '技术', '', '2015-05-12 15:30:52', 'luohong', null, null, '0', 'root');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL,
  `menu_parent_id` varchar(50) DEFAULT NULL,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_desc` varchar(50) DEFAULT NULL,
  `menu_created_time` varchar(50) DEFAULT NULL,
  `menu_creator` varchar(50) DEFAULT NULL,
  `menu_updated_time` varchar(50) DEFAULT NULL,
  `menu_updator` varchar(50) DEFAULT NULL,
  `menu_del_flag` int(1) DEFAULT '0',
  `menu_pic` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('442c9a87_a0d4_4312_b73a_d660b14cceb8', '', '日志管理', '这是日志管理菜单', '2015-05-10 09:25:25', 'luohong', null, null, '0', 'http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('article', '', '文章管理', '这是文章管理菜单', '2015-05-06 10:08:01', 'luohong', null, null, '0', 'http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('article_type', '', '文章类别管理', '这是文章类别管理菜单', '2015-05-06 10:08:41', 'luohong', null, null, '1', 'http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('root', null, '基础服务', null, null, null, null, null, '0', null);

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_privilege`;
CREATE TABLE `sys_privilege` (
  `id` varchar(50) NOT NULL,
  `privilege_name` varchar(50) NOT NULL,
  `privilege_url` varchar(200) DEFAULT NULL,
  `privilege_desc` varchar(200) DEFAULT NULL,
  `privilege_parent_id` varchar(50) DEFAULT NULL,
  `privilege_created_time` varchar(50) DEFAULT NULL,
  `privilege_creator` varchar(50) DEFAULT NULL,
  `privilege_updated_time` varchar(50) DEFAULT NULL,
  `privilege_updator` varchar(50) DEFAULT NULL,
  `privilege_del_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `privilege_parent_id` (`privilege_parent_id`),
  CONSTRAINT `sys_privilege_ibfk_1` FOREIGN KEY (`privilege_parent_id`) REFERENCES `sys_privilege` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO `sys_privilege` VALUES ('12cb569c_a755_48d7_a0c8_e04340df774b', '删除角色', 'http://localhost/springmvc_mybatis/role/delete.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:29:19', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('17f28255_225d_4572_a42e_f93f8f39388f', '修改密码', 'http://localhost/springmvc_mybatis/user/changePasswordSubmit.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-12 15:11:13', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('191f05b9_08ce_40a3_bcf9_9a32f2b8680f', '获取角色用户json数据', 'http://localhost/springmvc_mybatis/role/getRoleUserJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:37:13', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('25bb0511_00b3_42ce_bb26_e569211c2d44', '添加角色权限', 'http://localhost/springmvc_mybatis/role/addRolePrivilegeSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:34:19', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2b12fa86_34f9_462e_95ad_b42d246c5c2e', '更新文章', 'http://localhost/springmvc_mybatis/article/update.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 10:11:57', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2f6869b7_0bcd_481f_ae4d_9acef32ab850', '用户管理', 'http://localhost/springmvc_mybatis/user/list.do', '', '769b2417_0f6e_4190_b456_e84e838f0fd6', '2015-04-29 11:14:59', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3a5ff5b3_0175_4189_8ed8_55d250497eef', '获取角色的tree json', 'http://localhost/springmvc_mybatis/role/listByTree.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:47:57', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3f2bc4f3_1002_4aa6_88b2_a2ee313c8393', '获取角色基本西悉尼', 'http://localhost/springmvc_mybatis/role/getBaseInfo.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:47:03', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3f347364_9dad_4e56_ad95_781e0c69867f', '添加角色', 'http://localhost/springmvc_mybatis/role/addSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:29:06', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3f42fdd2_094b_4c46_b695_f6b90cf1fae7', '文章类别列表', 'http://localhost/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-04-25 10:24:30', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4447e64e_aae2_4990_8364_e37f94673ef3', '系统默认权限', null, '', null, '2015-05-06 10:22:08', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('44fa0a23_48f6_457a_bb6e_26c999a090e7', '退出', 'http://localhost/springmvc_mybatis/user/logout.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:22:30', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('459a4434_abab_404c_b48b_e4eebec0da98', '跳转到添加角色菜单界面', 'http://localhost/springmvc_mybatis/role/addRoleMenu.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:30:08', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('476ab3e5_1953_4800_ac85_796d1a7303d5', '获取角色grid json数据', 'http://localhost/springmvc_mybatis/role/listGridJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:47:29', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4934717f_b99b_4ca1_a5ba_b461550c17cc', '文章管理', 'http://localhost/springmvc_mybatis/article/list.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-04-29 11:17:04', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('56e0f5a8_48a2_408a_89a8_5d1610654951', '文章列表json', 'http://localhost/springmvc_mybatis/articleType/listJson.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 11:14:29', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('593f0641_9cbe_47f7_b4f5_0712cdf33e42', '获取角色菜单的json', 'http://localhost/springmvc_mybatis/role/getRoleMenuJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:31:42', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('5a8311da_cfee_4bfc_b7ed_60a88d1db1dc', '删除文章类别', 'http://localhost/springmvc_mybatis/articleType/delete.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 10:12:23', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('6a397f82_98e9_4324_80bd_5d31b370f27f', '跳转到添加角色权限界面', 'http://localhost/springmvc_mybatis/role/addRolePrivilege.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:33:50', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('769b2417_0f6e_4190_b456_e84e838f0fd6', '用户管理', null, '这是用户管理类别', null, '2015-04-29 11:14:39', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('776f0e28_2758_4916_89b8_6534463e1bd4', '获取角色列表数据界面', 'http://localhost/springmvc_mybatis/role/listJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:45:50', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('7a8ad945_9e46_4dc4_9f7e_7d583c459cc8', '更新文章类别', 'http://localhost/springmvc_mybatis/articleType/update.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 10:12:47', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('7af9049e_2b36_4d1b_bf59_a5ec252792f2', '文章类别管理', null, '这是文章类别管理，用于添加文章类别，删除文章类别，已经更新文章类别', null, '2015-04-25 10:23:14', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('7c0e3bf4_1cae_4c64_967c_b9475cb771ed', '日志管理', 'http://localhost/springmvc_mybatis/article/listByAndroid.do', '', 'd44e43b5_acc1_4891_acde_ad906bb880e4', '2015-05-10 09:24:20', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('81ff227d_7d19_4c1a_b2b3_4ff00500be73', '跳转到角色菜单界面', 'http://localhost/springmvc_mybatis/role/getRoleMenu.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:50:50', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('8b805a71_12aa_4500_859c_c34878f38d2e', '跳转到添加文章', 'http://localhost/springmvc_mybatis/article/add.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 10:11:14', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('8bb6c538_5fb8_4c33_93c1_3539afb02db4', '跳转到添加角色用户界面', 'http://localhost/springmvc_mybatis/role/addUser.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:34:58', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('915bf26c_901a_420d_8936_f4bc0ef87976', '菜单管理', null, '菜单管理的类别', null, '2015-04-29 11:13:41', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('98725feb_429a_4f33_b058_ea026281258e', '菜单管理', 'http://localhost/springmvc_mybatis/menu/list.do', '', '915bf26c_901a_420d_8936_f4bc0ef87976', '2015-04-29 11:14:12', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a0d4d476_e68b_4655_a032_63bc5b5f5612', '权限管理', null, '这是权限管理类别', null, '2015-04-29 11:14:27', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a1b5f7da_7ce3_48e0_9e45_9138d30d05dd', '角色管理', 'http://localhost/springmvc_mybatis/role/list.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-06 10:25:37', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a42a90fc_a423_44d4_9b8c_409db86117a2', '用户管理', 'http://localhost/springmvc_mybatis/user/list.do', '', 'c480f6bd_56da_4cd0_ac9e_c1c0e86b1b97', '2015-04-29 11:17:19', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a80264d0_e77e_4254_93a6_6553c183f698', '添加角色用户', 'http://localhost/springmvc_mybatis/role/addUserSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:35:44', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('af3367e1_7218_41b6_81b5_a0aa2577521e', '删除角色权限', 'http://localhost/springmvc_mybatis/role/deletePrivilege.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:32:09', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('b02d3a37_f7b9_47fc_ba38_34633a82095e', '获取角色权限json数据', 'http://localhost/springmvc_mybatis/role/getRolePrivilegeJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:33:18', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('bb4b7442_eec8_4cab_a8bf_4588febbbb0e', '删除用户角色', 'http://localhost/springmvc_mybatis/role/deleteRoleUser.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:36:11', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c352d13c_7adb_4b99_9f6d_31d6129b7dc9', '删除角色菜单', 'http://localhost/springmvc_mybatis/role/deleteMenu.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:31:12', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c480f6bd_56da_4cd0_ac9e_c1c0e86b1b97', '用户管理', null, '这是用户管理类别', null, '2015-04-29 11:15:37', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c69cd67d_7dcb_433b_a623_f3934c366095', '获取文章列表的json', 'http://localhost/springmvc_mybatis/article/listJson.do', '列出全部文章json数据', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 11:13:15', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c969f565_3bb5_4439_be06_90c8ecc3ef0d', '添加文章列表', 'http://localhost/springmvc_mybatis/articleType/add.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 10:13:16', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('ca9a2e09_a61a_4773_b24d_e0fca8a48465', '跳转到添加角色用户界面', 'http://localhost/springmvc_mybatis/role/getRoleUser.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:36:46', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('cb705a9a_3a74_43f9_a666_2592f77edea6', '跳转到添加角色界面', 'http://localhost/springmvc_mybatis/role/add.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:28:40', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d44e43b5_acc1_4891_acde_ad906bb880e4', '日志管理', null, '这是日志管理的类别', null, '2015-05-10 09:23:45', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d6d3bba3_46a9_442e_86d7_30e100d6b777', '日志类别管理', 'http://localhost/springmvc_mybatis/articleType/listByAndroid.do', '', 'd44e43b5_acc1_4891_acde_ad906bb880e4', '2015-05-10 09:25:06', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d6fbb4af_6542_4c87_88f5_ee7efc2aa91b', '获取登录用户菜单', 'http://localhost/springmvc_mybatis/user/getUserMenuJson.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:23:24', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('df9e50d0_33a4_43c7_a782_fc26650e3bde', '角色管理', null, '', null, '2015-05-06 10:25:20', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('e739f785_1db0_403a_9386_875536439971', '权限管理', 'http://localhost/springmvc_mybatis/privilege/list.do', '', 'a0d4d476_e68b_4655_a032_63bc5b5f5612', '2015-04-29 11:15:19', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('eb159e8d_2963_42cc_adf5_31643dd9e881', '获取登录用户的权限', 'http://localhost/springmvc_mybatis/user/getUserPrivilege.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:24:06', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f1db846a_6c9e_4090_95f3_d3ce982a841e', '添加文章', 'http://localhost/springmvc_mybatis/article/addSubmit.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 11:07:35', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f4124bec_2b08_479f_a9b4_79b4bbe764f7', '文章管理', null, '这是文章管理类别', null, '2015-04-29 11:16:56', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f83895c2_5c9c_488d_afea_60f85c727a83', '登录', 'http://localhost/springmvc_mybatis/user/login.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:22:21', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f8fe4f3d_f65a_4919_a3a6_5587e4ec9641', '跳转到修改密码界面', 'http://localhost/springmvc_mybatis/user/changePassword.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-12 15:10:47', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fbaf16cd_08b1_4e48_b4d7_7c4c3b510b9b', '获取角色信息信息', 'http://localhost/springmvc_mybatis/role/openRole.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:46:35', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fdec56ac_1dee_41e0_a0ae_a84d67187c89', '删除文章', 'http://localhost/springmvc_mybatis/article/delete.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 10:11:30', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fe82c2e8_c1ba_439e_bf91_3c268257c228', '添加角色菜单', 'http://localhost/springmvc_mybatis/role/addRoleMenuSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:30:37', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fef73cdd_bd40_465c_b751_173e822735ed', '跳转到角色权限界面', 'http://localhost/springmvc_mybatis/role/getRolePrivilege.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:32:43', 'luohong', null, null, '0');

-- ----------------------------
-- Table structure for sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_resource`;
CREATE TABLE `sys_resource` (
  `id` varchar(50) NOT NULL,
  `resource_name` varchar(50) NOT NULL,
  `resource_url` varchar(200) DEFAULT NULL,
  `resource_desc` varchar(50) DEFAULT NULL,
  `resource_menu_id` varchar(50) DEFAULT NULL,
  `resource_created_time` varchar(50) DEFAULT NULL,
  `resource_creator` varchar(50) DEFAULT NULL,
  `resource_updated_time` varchar(50) DEFAULT NULL,
  `resource_updator` varchar(50) DEFAULT NULL,
  `resource_del_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `resource_menu_id` (`resource_menu_id`),
  CONSTRAINT `sys_resource_ibfk_1` FOREIGN KEY (`resource_menu_id`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_resource
-- ----------------------------
INSERT INTO `sys_resource` VALUES ('1956d581_6e97_4880_a4aa_0d6a2c3ce011', '用户管理', 'http://localhost/springmvc_mybatis/user/list.do', '', 'root', '90d77efe_db5a_4291_9b84_644de7233934', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('23816af1_6c46_4d52_b14c_eb73cfbd25b2', '文章类别列表', 'http://localhost/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', 'article_type', '8d2389e7_363b_4692_a6ea_c13f8a7c7ed8', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('48e740da_ce57_45fd_b26b_bab1c3bbf04a', '菜单管理', 'http://localhost/springmvc_mybatis/menu/list.do', '', 'root', 'ea0d5cc5_f45a_409d_85f4_acda189a27fb', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('682e1227_fb67_4009_bc2c_aa404dcd72a3', '日志管理', 'http://localhost/springmvc_mybatis/article/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '493b022e_0f43_4cc9_886a_dd3ba83ce519', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('6a0fee19_edaf_4ec4_a2e8_bbc574544f07', '日志类别管理', 'http://localhost/springmvc_mybatis/articleType/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', 'b395d3a9_8d23_4c4c_8911_5779ffefee4c', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('74140054_cc5d_4a0b_8821_51c8e1bb50b3', '文章管理', 'http://localhost/springmvc_mybatis/article/list.do', '', 'article', 'c53b9986_ece4_4362_beea_bf5bcba61a41', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('78da7b75_e2db_4fad_87d5_b70c50c42256', '文章类别列表', 'http://localhost/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', 'article', 'a56b00f3_a59a_49b0_a3a1_89c78a412227', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('9903b0f0_478d_4e7b_a6d1_4009c39cec27', '角色管理', 'http://localhost/springmvc_mybatis/role/list.do', '', 'root', 'ef63cf50_7226_42cf_9e27_ee3318c31182', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('ac67ff21_16f0_4d6c_a2da_4dc349dbfb9e', '用户管理', 'http://localhost/springmvc_mybatis/user/list.do', '', 'root', '16add85d_b064_454a_af6f_38e6afec6259', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('bb7ffbf9_9b5f_453b_90aa_d1a13cef99d4', '权限管理', 'http://localhost/springmvc_mybatis/privilege/list.do', '', 'root', 'e0af4343_545f_4b0d_9213_c2f0f15bb47c', 'luohong', null, null, '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(50) NOT NULL,
  `role_name` varchar(50) NOT NULL,
  `role_parent_id` varchar(50) DEFAULT NULL,
  `role_updated_time` varchar(50) DEFAULT NULL,
  `role_updator` varchar(50) DEFAULT NULL,
  `role_created_time` varchar(50) DEFAULT NULL,
  `role_creator` varchar(50) DEFAULT NULL,
  `role_del_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('92386e75_2b6d_4765_a58e_0104c361b39f', '文章管理角色', '', null, null, '2015-05-07 23:26:28', 'luohong', '0');
INSERT INTO `sys_role` VALUES ('root', '默认角色', null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `menu_id` varchar(50) DEFAULT NULL,
  `resource_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `menu_id` (`menu_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `sys_role_menu_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_menu_ibfk_3` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('57a3aaf1_0bf4_4911_8c1a_2e62fd872cb0', '92386e75_2b6d_4765_a58e_0104c361b39f', 'article', '78da7b75_e2db_4fad_87d5_b70c50c42256');
INSERT INTO `sys_role_menu` VALUES ('780fa046_a88f_440b_aa7f_685f805d59bf', '92386e75_2b6d_4765_a58e_0104c361b39f', 'article_type', '23816af1_6c46_4d52_b14c_eb73cfbd25b2');
INSERT INTO `sys_role_menu` VALUES ('941daa39_26da_497d_b003_694ef2ff7f48', '92386e75_2b6d_4765_a58e_0104c361b39f', 'article', '74140054_cc5d_4a0b_8821_51c8e1bb50b3');

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_privilege`;
CREATE TABLE `sys_role_privilege` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `privilege_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `privilege_id` (`privilege_id`),
  CONSTRAINT `sys_role_privilege_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_privilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `sys_privilege` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO `sys_role_privilege` VALUES ('028bf185_3cbe_411e_b381_358bac1d79a6', 'root', '44fa0a23_48f6_457a_bb6e_26c999a090e7');
INSERT INTO `sys_role_privilege` VALUES ('04f9b480_c355_45c6_ab3a_ce866ccf5314', '92386e75_2b6d_4765_a58e_0104c361b39f', '5a8311da_cfee_4bfc_b7ed_60a88d1db1dc');
INSERT INTO `sys_role_privilege` VALUES ('25c1df02_b423_4728_8d5e_a5ad665d9eff', 'root', '17f28255_225d_4572_a42e_f93f8f39388f');
INSERT INTO `sys_role_privilege` VALUES ('3f5f18bf_c8d4_4094_ab67_42bee0d79707', '92386e75_2b6d_4765_a58e_0104c361b39f', '3f42fdd2_094b_4c46_b695_f6b90cf1fae7');
INSERT INTO `sys_role_privilege` VALUES ('40043198_a1ba_4673_b033_a7681adf76d9', 'root', 'f83895c2_5c9c_488d_afea_60f85c727a83');
INSERT INTO `sys_role_privilege` VALUES ('534c11f4_5080_42f9_83ac_331a9c8f9ce5', '92386e75_2b6d_4765_a58e_0104c361b39f', '8b805a71_12aa_4500_859c_c34878f38d2e');
INSERT INTO `sys_role_privilege` VALUES ('56dc9120_4437_4417_b0d2_ba7edd374c3e', '92386e75_2b6d_4765_a58e_0104c361b39f', '56e0f5a8_48a2_408a_89a8_5d1610654951');
INSERT INTO `sys_role_privilege` VALUES ('6ad4b98a_2c91_4a66_9b16_ded45058ca31', 'root', 'd6fbb4af_6542_4c87_88f5_ee7efc2aa91b');
INSERT INTO `sys_role_privilege` VALUES ('8a55ada0_24c7_419c_be9d_6c08d1a47112', '92386e75_2b6d_4765_a58e_0104c361b39f', 'c69cd67d_7dcb_433b_a623_f3934c366095');
INSERT INTO `sys_role_privilege` VALUES ('916afe82_31cc_463b_a5b5_de0db18d5e81', '92386e75_2b6d_4765_a58e_0104c361b39f', 'f1db846a_6c9e_4090_95f3_d3ce982a841e');
INSERT INTO `sys_role_privilege` VALUES ('983a21a4_c6f8_4ea1_97f6_0dbf10c38f77', '92386e75_2b6d_4765_a58e_0104c361b39f', 'c969f565_3bb5_4439_be06_90c8ecc3ef0d');
INSERT INTO `sys_role_privilege` VALUES ('9f7037c5_88c0_4b52_b814_0637c217a9a9', '92386e75_2b6d_4765_a58e_0104c361b39f', '4934717f_b99b_4ca1_a5ba_b461550c17cc');
INSERT INTO `sys_role_privilege` VALUES ('c043865d_1dc7_49cb_96ce_9297a8a88e9a', '92386e75_2b6d_4765_a58e_0104c361b39f', '7a8ad945_9e46_4dc4_9f7e_7d583c459cc8');
INSERT INTO `sys_role_privilege` VALUES ('dc22243a_6c18_4235_a4a4_631a7e42d90d', 'root', 'f8fe4f3d_f65a_4919_a3a6_5587e4ec9641');
INSERT INTO `sys_role_privilege` VALUES ('dcb4c5b3_bdcf_48d0_b23d_fdd767f9ad80', 'root', 'eb159e8d_2963_42cc_adf5_31643dd9e881');
INSERT INTO `sys_role_privilege` VALUES ('f4494c17_ab93_4512_a668_706836e320e9', '92386e75_2b6d_4765_a58e_0104c361b39f', 'fdec56ac_1dee_41e0_a0ae_a84d67187c89');
INSERT INTO `sys_role_privilege` VALUES ('f5154465_e901_4bdc_abe9_4608dc8850a8', '92386e75_2b6d_4765_a58e_0104c361b39f', '2b12fa86_34f9_462e_95ad_b42d246c5c2e');

-- ----------------------------
-- Table structure for sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` varchar(50) NOT NULL,
  `role_id` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sys_role_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_user_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('22c9f0d8_ad13_40fd_93f0_fa8a203bdd33', '92386e75_2b6d_4765_a58e_0104c361b39f', 'b83b1daf_f21b_477b_aa3a_05ab35f961aa');
INSERT INTO `sys_role_user` VALUES ('4bc79957_aef0_4fa1_836f_f93bc0fbaefd', 'root', '10b961c8_ff44_48a1_9a00_bbe73de2bcc2');
INSERT INTO `sys_role_user` VALUES ('85c9c001_a40c_4119_98cb_a8ea0bdcc140', '92386e75_2b6d_4765_a58e_0104c361b39f', '10b961c8_ff44_48a1_9a00_bbe73de2bcc2');
INSERT INTO `sys_role_user` VALUES ('ff53c644_af14_4f02_a4fd_9220319e2d14', 'root', 'b83b1daf_f21b_477b_aa3a_05ab35f961aa');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_login_name` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  `user_qq` varchar(20) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_blog` varchar(50) DEFAULT NULL,
  `user_address` varchar(200) DEFAULT NULL,
  `user_current_address` varchar(200) DEFAULT NULL,
  `user_birthday` varchar(20) DEFAULT NULL,
  `user_login_count` int(11) DEFAULT '0',
  `user_updated_time` varchar(50) DEFAULT NULL,
  `user_updator` varchar(50) DEFAULT NULL,
  `user_created_time` varchar(50) DEFAULT NULL,
  `user_creator` varchar(50) DEFAULT NULL,
  `user_del_flag` int(1) DEFAULT '0',
  `user_super_user_flag` int(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_login_name` (`user_login_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('10b961c8_ff44_48a1_9a00_bbe73de2bcc2', '沈少钦', 'shenshaoqin', 'F59BD65F7EDAFB087A81D4DCA06C4910', '15013336884', '846705189', '846705189@qq.com', 'http://localhost/springmvc_mybatis/user/login.do', '潮汕', '潮汕', '1993-01-21', '0', null, null, '2015-05-12 14:20:36', 'luohong', '0', '0');
INSERT INTO `sys_user` VALUES ('b83b1daf_f21b_477b_aa3a_05ab35f961aa', '谢梅娇', 'xiemeijiao', '3792FB33DB6FE6E2A7E2E4261498628D', '15013336884', '846705189', '846705189@qq.com', null, '广东河源龙川', '广东河源龙川', '1993-01-21', '0', null, null, '2015-05-12 14:17:51', 'luohong', '0', '0');
INSERT INTO `sys_user` VALUES ('root', 'luohong', 'admin', '21232F297A57A5A743894A0E4A801FC3', '15013336884', '846705189', '846705189@qq.com', null, null, null, '2015-02-04', '0', null, null, null, null, '0', '1');

-- ----------------------------
-- Table structure for sys_user_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `menu_id` varchar(50) DEFAULT NULL,
  `resource_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `menu_id` (`menu_id`),
  KEY `resource_id` (`resource_id`),
  CONSTRAINT `sys_user_menu_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_menu_ibfk_2` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_menu_ibfk_3` FOREIGN KEY (`resource_id`) REFERENCES `sys_resource` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_privilege
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_privilege`;
CREATE TABLE `sys_user_privilege` (
  `id` varchar(50) NOT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `privilege_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `privilege_id` (`privilege_id`),
  CONSTRAINT `sys_user_privilege_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_user_privilege_ibfk_2` FOREIGN KEY (`privilege_id`) REFERENCES `sys_privilege` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_privilege
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_resource
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_resource`;
CREATE TABLE `sys_user_resource` (
  `id` varchar(50) NOT NULL,
  `user_resource_user_id` varchar(50) NOT NULL,
  `user_resource_url` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_resource_user_id` (`user_resource_user_id`),
  CONSTRAINT `sys_user_resource_ibfk_1` FOREIGN KEY (`user_resource_user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_resource
-- ----------------------------
