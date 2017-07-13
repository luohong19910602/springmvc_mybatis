/*
Navicat MySQL Data Transfer

Source Server         : loclhost
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : luohong_spring

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-07-13 10:17:59
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `sys_resource` VALUES ('03a30095_5017_4f9b_8324_f3ff401a3a5b', '获得用户的json数据', 'http://localhost:8080/springmvc_mybatis/user/getUserMenuJsonByUserId.do', '无', 'root', '502f2f3e_c602_4957_a6aa_0e9da7f847b7', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('080f47a6_b428_4c05_8193_98a20422bf1c', '导航管理', 'http://localhost:8080/springmvc_mybatis/navigation/list.do', '', 'root', '3cd7b646_ea79_4de1_99da_e65ae12db6d8', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('092b0ea1_5d12_429f_ab89_f3ddf5a77783', '获取用户角色的json数据', 'http://localhost:8080/springmvc_mybatis/user/getUserRoleJson.do', '无', 'root', 'f25a604f_1d9a_4577_b99b_0f4061646c40', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('10079ec9_faac_4955_8314_836c142286fa', '修改密码', 'http://localhost:8080/springmvc_mybatis/user/changePasswordSubmit.do', '无', 'root', '6af8c57f_351e_4d50_8135_0d5d47d093f7', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('13113516_52ad_4f5e_81ba_1a8580145234', '跳转到menu列表界面', 'http://localhost:8080/springmvc_mybatis/menu/list.do', '无', 'root', 'bb971ef4_f422_40f7_9cb4_c88604c6680b', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('1698c92f_c182_4a28_9568_8ec7afd1d02c', '跳转到添加用户菜单界面', 'http://localhost:8080/springmvc_mybatis/user/addUserMenu.do', '无', 'root', '791f503f_5d67_4b86_922a_96b33ccb9228', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('1956d581_6e97_4880_a4aa_0d6a2c3ce011', '用户管理', 'http://localhost:8080/springmvc_mybatis/user/list.do', '', 'root', '90d77efe_db5a_4291_9b84_644de7233934', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('1d794622_0b15_4086_aedc_d8c355b2f114', '删除用户的角色', 'http://localhost:8080/springmvc_mybatis/user/deleteUserRole.do', '无', 'root', '0c2b55d4_257d_4603_b047_dcb5ddb7e955', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('1d87d0d3_e715_4ee7_8cbb_91913ad486a6', '选择用户界面', 'http://localhost:8080/springmvc_mybatis/user/selectUser.do', '无', 'root', '3536d696_b3a2_4a7d_ad1e_cdfadc5768b8', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('23816af1_6c46_4d52_b14c_eb73cfbd25b2', '文章类别列表', 'http://localhost:8080/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', 'article_type', '8d2389e7_363b_4692_a6ea_c13f8a7c7ed8', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('27a3baf0_1661_43bf_989e_61809e07d6bf', '列出用户的数据，这里包含了分页以及查询功能', 'http://localhost:8080/springmvc_mybatis/user/listJson.do', '无', 'root', '2801c325_a662_4180_8cdd_198655c7a693', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('34112747_e66c_4c5d_86d1_a05d7d691dc8', '列出用户的数据，这里包含了分页以及查询功能', 'http://localhost:8080/springmvc_mybatis/user/listJson.do', '无', 'root', '3f3cdfa1_c26e_4210_a061_14fb4ae98a7f', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('375875c2_f212_4757_9e15_1ca82679f40b', '列出所有角色的数据', 'http://localhost:8080/springmvc_mybatis/role/listGridJson.do', '无', 'root', '4b8e53cf_63c1_430d_bf18_d50ced5407ef', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('376f75b1_a8fd_42e3_85c1_bbbc4e718780', '更新用户信息', 'http://localhost:8080/springmvc_mybatis/user/editSubmit.do', '无', 'root', 'd052711d_d6c5_4c95_b546_9c450589afbb', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('3a1bbe26_7b47_4c15_b7bf_de19abb7fcf3', '列出所有角色的数据', 'http://localhost:8080/springmvc_mybatis/role/listGridJson.do', '无', 'root', '58c60615_6613_4e93_a1b8_3dcdacb56b42', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('3a4dcb29_4e43_4bd2_bf9a_6af9bf88d353', '跳转到用户菜单界面', 'http://localhost:8080/springmvc_mybatis/user/getUserMenu.do', '无', 'root', 'bb428080_e102_4cdd_bfad_4574e20d11b8', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('40a20d30_101d_4f18_ba16_d3dd79b74393', '跳转到添加资源界面', '/resource/add.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', 'b5690a32_9a1b_4557_9b0b_c4b42b54bef8', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('4276e984_74db_4d26_b376_b85f4ac06822', '导航管理', '/navigation/list.do', '', 'root', '169b0004_7332_4da5_bc50_e6e1da596a29', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('42c6ca5d_240e_4e93_b1ed_e55b5e0df51c', '添加用户权限', 'http://localhost:8080/springmvc_mybatis/user/addUserPrivilegeSubmit.do', '无', 'root', '399a7d24_ae78_463c_b249_1e82f353994d', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('48597de8_db86_4868_8056_a69622fbbe27', '删除用户菜单', 'http://localhost:8080/springmvc_mybatis/user/deleteUserMenu.do', '无', 'root', '6b656a83_2fe0_4161_b36a_180fdf7b749a', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('48e740da_ce57_45fd_b26b_bab1c3bbf04a', '菜单管理', 'http://localhost/springmvc_mybatis/menu/list.do', '', 'root', 'ea0d5cc5_f45a_409d_85f4_acda189a27fb', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('4b8b469d_9a12_4571_87f8_3e09ce23584a', '跳转到用户列表界面', 'http://localhost:8080/springmvc_mybatis/user/list.do', '无', 'root', '14712a32_6891_4f6a_b9f4_67d654470c24', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('4c15e5c9_6949_4b46_8298_3a55c224a5a5', '列出全部权限的json数据', 'http://localhost:8080/springmvc_mybatis/privilege/listGridJson.do', '无', 'root', '6c54692d_1c23_4990_8b43_56d81eb6b0de', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('4fdb15ba_3132_46f2_9ed9_9db743034f01', '构建用户的菜单数据，这里的数据应该直接从数据库中获取即可', 'http://localhost:8080/springmvc_mybatis/user/getUserMenuJson.do', '无', 'root', 'b5b06882_5908_49d6_ad69_b75e567b137b', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('55fc2810_68ed_42d9_ac58_91d2becaa305', '跳转到添加用户权限界面', 'http://localhost:8080/springmvc_mybatis/user/addUserPrivilege.do', '无', 'root', '4de92476_cf73_401f_890c_335a86192097', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('682e1227_fb67_4009_bc2c_aa404dcd72a3', '日志管理', 'http://localhost:8080/springmvc_mybatis/article/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '493b022e_0f43_4cc9_886a_dd3ba83ce519', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('6a0fee19_edaf_4ec4_a2e8_bbc574544f07', '日志类别管理', 'http://localhost:8080/springmvc_mybatis/articleType/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', 'b395d3a9_8d23_4c4c_8911_5779ffefee4c', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('6daa1e7f_3f72_44d4_a034_b6805bbfbb0f', '跳转到登录用户的基本信息界面，这里会列出用户的信息，权限，菜单等', 'http://localhost:8080/springmvc_mybatis/user/getLoginUserInfo.do', '无', 'root', 'da357f85_bf9b_440b_aeed_18c6b54b26d4', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('706eab5c_2a55_4d60_b993_c57111be42cd', '删除用户权限', 'http://localhost:8080/springmvc_mybatis/user/deleteUserPrivilege.do', '无', 'root', '4ad49bfc_f744_403e_847c_c9cfab08304a', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('73617f3e_12e9_428b_a813_87239f1d75de', '跳转到添加用户界面', 'http://localhost:8080/springmvc_mybatis/user/add.do', '无', 'root', 'e83af025_a6e4_42e1_9b87_2098608ffe79', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('74140054_cc5d_4a0b_8821_51c8e1bb50b3', '文章管理', 'http://localhost:8080/springmvc_mybatis/article/list.do', '', 'article', 'c53b9986_ece4_4362_beea_bf5bcba61a41', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('765d634f_f17b_470b_bc9b_34c7b431335e', '跳转到用户信息界面', 'http://localhost:8080/springmvc_mybatis/user/getUserInfo.do', '无', 'root', '84606f57_0959_40ae_bcf2_1f6581cfde83', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('78da7b75_e2db_4fad_87d5_b70c50c42256', '文章类别列表', 'http://localhost:8080/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', 'article', 'a56b00f3_a59a_49b0_a3a1_89c78a412227', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('794eb5f1_2244_4280_8fea_553a01ba7779', '删除资源', '/resource/delete.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', 'fdd3a689_45e8_433f_b3eb_1c7ebe9dee69', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('7d1e783c_f5e7_4128_9cd8_ade60e72c111', '添加用户', 'http://localhost:8080/springmvc_mybatis/user/addSubmit.do', '无', 'root', '6f2a8e26_14d0_4736_88a4_7998b84a63b9', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('7ea70782_46a6_4f46_a43f_ebe5b8cfea53', '添加用户菜单', 'http://localhost:8080/springmvc_mybatis/user/addUserMenuSubmit.do', '无', 'root', '0d1c8cba_aa52_436c_ad5f_8fb4d9cdbeff', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('85bfb649_9c03_4122_817d_811977749415', '列出用户的数据，这里包含了分页以及查询功能', 'http://localhost:8080/springmvc_mybatis/user/listJson.do', '无', 'root', '8f0a6d5f_de0f_4bc9_a7bd_26b28df2deb9', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('8b95cb59_8dc0_426b_8382_f2df5c7c79cd', '添加用户角色', 'http://localhost:8080/springmvc_mybatis/user/addUserRoleSubmit.do', '无', 'root', 'e1d5b5ef_7aa5_4df4_b0e8_b352f3586b3f', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('9220bf83_2031_450f_9b89_134760d6afd9', '跳转到添加用户基本信息界面', 'http://localhost:8080/springmvc_mybatis/user/baseInfo.do', '无', 'root', '188a9ca6_a712_44e1_8814_fbbb14a0e33b', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('952ce4c8_9087_44ef_b137_8eb4a280e534', '删除用户', 'http://localhost:8080/springmvc_mybatis/user/delete.do', '无', 'root', '0f3fbca0_b447_4dbe_81e0_0b62f4f1e3af', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('9903b0f0_478d_4e7b_a6d1_4009c39cec27', '角色管理', 'http://localhost:8080/springmvc_mybatis/role/list.do', '', 'root', 'ef63cf50_7226_42cf_9e27_ee3318c31182', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('993cf547_1258_47ec_acfd_735d331fa0e6', '跳转到修改密码界面', 'http://localhost:8080/springmvc_mybatis/user/changePassword.do', '无', 'root', 'c39f61e3_a554_4444_9b11_3c3a30d35ceb', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('a6b57a3f_3e99_4166_b81e_1c5399424090', '退出登录，跳转到登录界面', 'http://localhost:8080/springmvc_mybatis/user/logout.do', '无', 'root', '9e390f53_1d6a_47b0_a636_6087d8bcd759', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('ac67ff21_16f0_4d6c_a2da_4dc349dbfb9e', '用户管理', 'http://localhost:8080/springmvc_mybatis/user/list.do', '', 'root', '16add85d_b064_454a_af6f_38e6afec6259', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('adc3cced_f69f_4c2a_9819_5d8bd1d988f2', '跳转到用户角色界面', 'http://localhost:8080/springmvc_mybatis/user/getUserRole.do', '无', 'root', '1024d490_8c51_4680_9959_f3961c486ee9', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('b3b545d6_92b0_42e9_8b1b_208899a53c54', '添加资源', '/resource/addSubmit.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', '62258535_69fe_4c35_9a07_2d5d817de28e', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('bb7ffbf9_9b5f_453b_90aa_d1a13cef99d4', '权限管理', 'http://localhost:8080/springmvc_mybatis/privilege/list.do', '', 'root', 'e0af4343_545f_4b0d_9213_c2f0f15bb47c', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('be8ffec3_d612_4009_9b3c_8757aba69b8d', '获取用户权限的json数据', 'http://localhost:8080/springmvc_mybatis/user/getUserPrivilegeJson.do', '无', 'root', 'fe66009c_b025_4cec_97ee_b242564ebf5f', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('c24ab5b3_bc10_4311_adfe_ebae41361344', '广告管理', 'http://localhost:8080/springmvc_mybatis/slide/list.do', '', 'root', 'b2c35627_76d1_4844_a301_9ca3f2db2d99', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('c5f0002c_24f4_4eac_a9cc_2b5aec72c33e', '登录', 'http://localhost:8080/springmvc_mybatis/user/login.do', '无', 'root', '24102d6c_bda6_496c_ba04_52f22910cfe1', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('ca99595b_cf1e_426b_8d3d_673ce34e1332', '跳转到角色列表界面', 'http://localhost:8080/springmvc_mybatis/role/list.do', '无', 'root', '511ecb95_8f90_469c_8dd1_f417d7c61d72', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('dba8b76d_d82f_4b29_af63_5c071ab9ebd3', '跳转到添加用户角色界面', 'http://localhost:8080/springmvc_mybatis/user/addUserRole.do', '无', 'root', 'dc2d8c75_a701_4a8c_bd80_9db8a0a3604e', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('e9c248f0_2565_43e7_980f_1c18531bcd80', '跳转到系统模块首页', 'http://localhost:8080/springmvc_mybatis/privilege/list.do', '无', 'root', '92dea00b_2644_43ae_bd72_8fb82ffaabb7', null, null, null, '0');
INSERT INTO `sys_resource` VALUES ('ec79756d_33d4_483d_9953_d734ad801610', '跳转到menu对应的url资源list界面', '/resource/openResource.do', '无', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', 'd31b9fa4_e038_4d5d_9d6e_828487dc0ef3', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('f06a0bd4_e563_4bba_bd31_9535f49c467f', '跳转到用权限界面', 'http://localhost:8080/springmvc_mybatis/user/getUserPrivilege.do', '无', 'root', '61540833_b1e1_489b_b8d3_0a37853ce7ac', null, null, null, '1');
INSERT INTO `sys_resource` VALUES ('f5572eb1_b614_4093_b20a_8221e30c16e2', '取出menu对应的url资源，使用json来包装数据', '/resource/openResourceJson.do', 'fuck', 'c61cc532_8d2e_4b80_bd3d_0ee86cc0a15b', '81d08048_14f5_4060_8aef_2d0b49e2b41c', 'luohong', null, null, '1');
INSERT INTO `sys_resource` VALUES ('f61a3d45_6f55_40fc_9e32_ff8fef70d550', '跳转到编辑用户的界面', 'http://localhost:8080/springmvc_mybatis/user/edit.do', '无', 'root', '9d9e829d_4c80_4c00_8704_63dbfc3415d3', null, null, null, '1');
