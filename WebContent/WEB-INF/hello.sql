/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50610
Source Host           : localhost:3306
Source Database       : hello

Target Server Type    : MYSQL
Target Server Version : 50610
File Encoding         : 65001

Date: 2015-05-11 19:39:24
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `sys_article` VALUES ('072aeada_241a_4c9b_800a_d7a83dc5447b', 'ddd', 'ggggg', null, null, null, 'ce2b08b8_ba4e_45b1_b4a3_c4af4b0f09ec', '2015-05-11 00:29:00', null, null, null, '1', null);
INSERT INTO `sys_article` VALUES ('0898f4ce_3357_4d8d_8ced_ee018ad00751', 'xxxx', 'vvvv', null, null, null, '7692b720_c74f_4675_9277_462968db73ee', '2015-05-09 11:14:33', null, null, null, '1', null);
INSERT INTO `sys_article` VALUES ('0ed51b0a_62ae_4f71_af0e_c29200c6f058', 'ggggggg', 'vvvggjjjhfffdddd', null, null, null, '93aa82a6_e65f_45fe_bff8_18ad29bdc9cf', '2015-05-10 08:46:24', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('115eb543_5f88_40a5_8f4e_51974f06d2d1', 'fffffrrrr', 'ffffffyy', null, null, null, '3d105040_0d6e_4e98_9737_f1647083ed9b', '2015-05-10 23:51:37', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('136f6c73_8d5a_413f_83e8_b1d0f55657d1', 'ddd', 'ddd', null, null, null, '93aa82a6_e65f_45fe_bff8_18ad29bdc9cf', '2015-05-10 23:42:14', null, null, null, '1', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06');
INSERT INTO `sys_article` VALUES ('17cb21fa_b7f7_49be_8a2b_51403e77c140', 'yyyy', 'hhhh', null, null, null, '403a47cd_26fb_40b7_b80c_fdcc304c1d2d', '2015-05-10 08:49:51', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('2b6a729c_8379_4b64_b66e_ac3671d81dd5', 'dsfasdsdfsasdfsadfdf', '<p>\r\n	sdafasdfas\r\n</p>\r\n<p>\r\n	sdfasdfasdffds&nbsp;<br />\r\ndfghsgh\r\n</p>\r\n<p>\r\n	对方沟通好地方搞活动覆盖\r\n</p>\r\n<p>\r\n	<strong>奋斗过水电费干坏事的<em></em></strong>\r\n</p>\r\n<p>\r\n	<b><i>谁知道股份的高<u></u></i></b>\r\n</p>\r\n<p>\r\n	<b><i><u>水电费人和事都符合</u></i></b>\r\n</p>\r\n<p>\r\n	<b><i><u>、<img src=\"/springmvc_mybatis/attached/image/20150511/20150511003340_135.jpg\" alt=\"\" /></u></i></b>\r\n</p>', null, null, null, '6af3acd9_4756_4fc3_9ba6_a352d40835f6', '2015-05-11 00:33:44', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article` VALUES ('2f1cc12b_e6ad_4813_a5b7_75c00e8f0b44', 'ddd', 'fff', null, null, null, 'd8e1f46f_f067_4b48_abab_154091d01f6c', '2015-05-11 00:49:17', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('320159c5_4883_4304_a5f0_836c755add3a', 'sssssss', 'ffffffff', null, null, null, '72740c38_4a1c_4693_b261_9437cbbee568', '2015-05-09 16:43:07', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('3ad7bab4_400f_4540_890b_63558b225944', 'dddd', 'bbhhhhhhhyytttrrd', null, null, null, 'c2d5ff82_2a9a_4bbf_a1af_d259154dfd6d', '2015-05-09 17:11:43', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('499e5795_88d5_42ab_a0fe_e8dd4931ff50', 'tttt', 'ggggg', null, null, null, '403a47cd_26fb_40b7_b80c_fdcc304c1d2d', '2015-05-10 08:53:45', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('4df8f45a_7a11_4a7d_a4b3_3be48ababd39', null, null, null, null, null, null, '2015-05-07 09:06:33', 'luohong', null, null, '0', null);
INSERT INTO `sys_article` VALUES ('51a9d0ee_b30f_42a2_a588_85f8d161a869', 'wwwggg', 'www', null, null, null, 'ce2b08b8_ba4e_45b1_b4a3_c4af4b0f09ec', '2015-05-11 00:26:15', null, null, null, '1', null);
INSERT INTO `sys_article` VALUES ('5ac17bfc_cfae_48bf_8659_00d4f1394d18', 'fff', 'vggjj', null, null, null, 'cf5d4868_8a95_4791_ac8f_3cae26b8c982', '2015-05-11 00:49:29', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('680e9ddf_e10e_4ab7_868c_ffdc4106cac7', 'sdfadsfasdf', 'asdfasdf', null, null, null, 'bfe38baf_7507_4e75_9bfa_d9e18586e3c0', '2015-05-11 00:32:38', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article` VALUES ('75a3e6c4_7047_4666_a177_04081ccbf2d8', 'eee', 'cccccc', null, null, null, '403a47cd_26fb_40b7_b80c_fdcc304c1d2d', '2015-05-10 08:48:20', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('7774ffa3_d99f_4d3b_b968_d81e04a31250', 'dfvasdfvasdfg', 'asdgffasdga', null, null, null, '6af3acd9_4756_4fc3_9ba6_a352d40835f6', '2015-05-11 00:32:19', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article` VALUES ('777f4683_2363_45bd_b623_34e8495fd94b', 'dsgfsfdg', 'asgfasgsg', null, null, null, '36589e57_b03d_45e1_a57d_319184cb92b9', '2015-05-10 23:49:53', null, null, null, '1', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06');
INSERT INTO `sys_article` VALUES ('7e686317_1393_4d22_abbd_71783c0c0ffc', 'bbhh', 'vvfhhk', null, null, null, 'c8e7e09b_817c_46f5_8df3_673c6d275a02', '2015-05-10 09:38:04', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('86a30b74_30b5_4824_8dc4_0c6e834d2391', 'ggg', 'hhhh', null, null, null, '59d7aaab_b496_4352_a736_0f51de2babf5', '2015-05-10 23:52:03', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('879b159f_e958_4706_82b5_55723aacfe2d', 'asdfsdf', 'asdfasdf', null, null, null, '23b33493_130d_4e22_8ff1_eda32f1274c3', '2015-05-10 23:50:41', null, null, null, '0', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06');
INSERT INTO `sys_article` VALUES ('9dcb66ec_ce2d_49d5_b92b_53ea44b07f5e', 'ttt', 'tttttt\n', null, null, null, '1948aec7_0fe7_4304_946f_2611131b0cbb', '2015-05-09 15:42:07', null, null, null, '1', null);
INSERT INTO `sys_article` VALUES ('a3589d63_d82e_4ce3_a3d9_7c5aeaffe184', 'ddd', 'ffffff', null, null, null, '93aa82a6_e65f_45fe_bff8_18ad29bdc9cf', '2015-05-10 08:47:10', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('aa6f6d6b_6691_45ab_a975_751255c28a45', 'safasdfasd', 'fasdfasdf', null, null, null, 'a2078a64_db6c_4a05_aa39_189b6ac6af59', '2015-05-06 11:08:20', 'hello', null, null, '0', null);
INSERT INTO `sys_article` VALUES ('b6d4d220_4688_4b39_a424_659654b6e9c0', '我是谢梅娇', '<p>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n	<p>\r\n		我是谢梅娇\r\n	</p>\r\n	<div>\r\n		<br />\r\n	</div>\r\n我是谢梅娇\r\n</p>\r\n<p>\r\n	<br />\r\n</p>', null, null, null, 'bad2ce16_cf1d_4d20_b375_4ff8f6a0286c', '2015-05-07 23:29:30', '谢梅娇', null, null, '0', null);
INSERT INTO `sys_article` VALUES ('c0a14ca0_24e3_4cdd_a278_dda2ddd705f5', 'rrr', 'rrrr', null, null, null, 'c8e7e09b_817c_46f5_8df3_673c6d275a02', '2015-05-10 23:51:54', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('c5727410_136d_446c_9eec_c3098f569a1f', 'qqq', 'wwwww', null, null, null, '3d105040_0d6e_4e98_9737_f1647083ed9b', '2015-05-10 23:51:24', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('c7f0858f_52d7_4621_8939_4fead444889b', 'tttt', 'ggggg', null, null, null, '403a47cd_26fb_40b7_b80c_fdcc304c1d2d', '2015-05-10 08:51:48', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('ccdc893c_443f_4286_8472_6d684255235b', '世界，你好', '<p>\r\n	世界你好\r\n</p>\r\n<h1>\r\n	世界你好\r\n</h1>\r\n<h2>\r\n	世界你好\r\n</h2>\r\n<h2>\r\n	<strong>世界你好</strong>\r\n</h2>\r\n<h2>\r\n	<em>世界你好</em>\r\n</h2>\r\n<h2>\r\n	<u>世界你好<s></s></u>\r\n</h2>\r\n<h2>\r\n	<u><strike>世界你好</strike></u>\r\n</h2>\r\n<p>\r\n	<u><strike>顶顶顶</strike></u>\r\n</p>\r\n<p>\r\n	<ul>\r\n		<li>\r\n			<u><strike>dddd</strike></u>\r\n		</li>\r\n		<li>\r\n			<u><strike>dddd</strike></u>\r\n		</li>\r\n		<li>\r\n			<u><strike>ddd</strike></u>\r\n		</li>\r\n		<li>\r\n			<u><strike>ddddd</strike></u>\r\n		</li>\r\n		<li>\r\n			<u><strike>d</strike></u>\r\n		</li>\r\n		<li>\r\n			<u><strike>点点滴滴</strike></u>\r\n		</li>\r\n		<li>\r\n			<u><strike>顶顶顶顶顶顶顶顶顶顶</strike></u>\r\n		</li>\r\n		<ul>\r\n			<li>\r\n				<u><strike>顶顶顶顶顶顶顶顶顶顶顶顶顶</strike></u>\r\n			</li>\r\n		</ul>\r\n	</ul>\r\n</p>\r\n<h2>\r\n	<img src=\"/springmvc_mybatis/attached/image/20150507/20150507232253_23.jpg\" alt=\"\" />\r\n</h2>', null, null, null, 'bad2ce16_cf1d_4d20_b375_4ff8f6a0286c', '2015-05-07 23:23:51', 'luohong', null, null, '0', null);
INSERT INTO `sys_article` VALUES ('dff823e4_dd8f_4ce5_a881_4eb716131311', 'dddd', 'fffff', null, null, null, '7692b720_c74f_4675_9277_462968db73ee', '2015-05-09 11:03:20', null, null, null, '1', null);
INSERT INTO `sys_article` VALUES ('e43e4b66_3708_40d9_8298_4f587a5c8680', 'dddd', 'fffff', null, null, null, 'c8e7e09b_817c_46f5_8df3_673c6d275a02', '2015-05-10 09:37:16', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('e4f4dd23_731d_443a_b1d5_b5d99b69fb02', 'hhhbb', 'njjjk', null, null, null, 'ce2b08b8_ba4e_45b1_b4a3_c4af4b0f09ec', '2015-05-11 00:26:55', null, null, null, '1', null);
INSERT INTO `sys_article` VALUES ('e7a4fc98_3772_4696_8471_7f31a6ffb1e2', 'ddd', 'xxxx', null, null, null, 'd8e1f46f_f067_4b48_abab_154091d01f6c', '2015-05-11 00:48:33', null, null, null, '0', null);
INSERT INTO `sys_article` VALUES ('ed47767d_bc12_43a3_b2ee_2da30da82f3f', '世界，你好', '<p>\r\n	世界，你好！！！\r\n</p>\r\n<p>\r\n	<img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost/springmvc_mybatis/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" />\r\n</p>\r\n<p>\r\n	<img src=\"/springmvc_mybatis/attached/image/20150507/20150507230540_856.jpg\" alt=\"\" />\r\n</p>\r\n<h1>\r\n	滴答滴答地方\r\n</h1>\r\n<h2>\r\n	地对地导弹\r\n</h2>\r\n<h2>\r\n	<u>鹅鹅鹅鹅鹅鹅饿鹅鹅鹅鹅鹅鹅饿</u>\r\n</h2>\r\n<h2>\r\n	<em>额鹅鹅鹅鹅鹅鹅饿鹅鹅鹅鹅鹅鹅饿</em>\r\n</h2>\r\n<h2>\r\n	<hr style=\"page-break-after:always;\" class=\"ke-pagebreak\" />\r\n</h2>', null, null, null, 'a2078a64_db6c_4a05_aa39_189b6ac6af59', '2015-05-07 23:06:17', 'luohong', null, null, '0', null);
INSERT INTO `sys_article` VALUES ('efd4e1dc_cfea_4532_923b_ecb155e03922', 'safasdfasd', 'fasdfasdf', null, null, null, 'a2078a64_db6c_4a05_aa39_189b6ac6af59', '2015-05-06 11:08:47', 'hello', null, null, '0', null);
INSERT INTO `sys_article` VALUES ('f191d3f2_72bb_4574_a79d_f161f59cbf5b', 'dddd', 'fffff', null, null, null, 'c2d5ff82_2a9a_4bbf_a1af_d259154dfd6d', '2015-05-09 17:11:27', null, null, null, '0', null);

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
  CONSTRAINT `user_fk_type` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_article_type
-- ----------------------------
INSERT INTO `sys_article_type` VALUES ('076e38b8_a27a_4e2f_bd96_942921c95073', 'qqq', null, '2015-05-11 00:46:27', null, null, null, '0', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article_type` VALUES ('082777f6_d871_492c_99b7_8bb0e42d8c36', 'tttt', null, '2015-05-09 15:15:58', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('0f291a4b_3332_4471_a73a_9f6b1721610e', 'rrrr', null, '2015-05-09 17:20:58', null, null, null, '0', '58e4040b_9b2e_4618_b4dc_4f47211d6f2f');
INSERT INTO `sys_article_type` VALUES ('0f990d20_0275_4a1b_91f3_1a339bb7da25', 'yyy', null, '2015-05-08 17:38:36', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('1948aec7_0fe7_4304_946f_2611131b0cbb', 'tttt', null, '2015-05-09 15:29:03', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('23b33493_130d_4e22_8ff1_eda32f1274c3', 'sdfasdf', 'fasfasf', '2015-05-10 23:50:32', null, null, null, '0', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06');
INSERT INTO `sys_article_type` VALUES ('2a270824_6a47_4f84_af07_1315e78340ac', 'ttt', null, '2015-05-11 00:48:17', null, null, null, '0', '93efc4b8_3e1b_4b21_b5af_87778037f479');
INSERT INTO `sys_article_type` VALUES ('2b17e58a_29bc_4315_96a2_c3a7068c3db3', 'tttt', null, '2015-05-09 10:35:02', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('2e562eb8_9547_4ae5_a762_ae0420fe6514', 'yyy', null, '2015-05-08 17:38:28', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('30b27902_be87_4f84_9e36_af77d0d9fd46', 'yyyy', null, '2015-05-08 17:34:39', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('36589e57_b03d_45e1_a57d_319184cb92b9', 'asfsdf', 'asfasfd', '2015-05-10 23:42:02', null, '2015-05-10 23:50:17', null, '1', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06');
INSERT INTO `sys_article_type` VALUES ('3d105040_0d6e_4e98_9737_f1647083ed9b', 'kkkmnb', null, '2015-05-10 09:37:34', null, null, null, '0', 'ea5ff9ca_72c9_4d90_9903_f3594a301743');
INSERT INTO `sys_article_type` VALUES ('3d4348d8_73c0_421a_947f_54f9f3432767', 'gggg', null, '2015-05-08 17:30:41', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('3ed2f664_3fd8_4ece_afa0_383720cd8132', 'rrrr', null, '2015-05-11 00:29:38', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article_type` VALUES ('403a47cd_26fb_40b7_b80c_fdcc304c1d2d', 'wwwwww', null, '2015-05-10 08:45:50', null, null, null, '0', 'ba099286_83ad_42d6_97d7_bc1e9f9f3a9a');
INSERT INTO `sys_article_type` VALUES ('4684cce8_ca09_47ea_8d77_da15f63bb57c', 'gggg', null, '2015-05-08 17:30:41', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('4e5dd620_249b_4fb1_bef5_66456f908c30', 'rrttuuiop', null, '2015-05-08 16:38:01', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('59d7aaab_b496_4352_a736_0f51de2babf5', 'ffgghhj', null, '2015-05-10 09:37:27', null, null, null, '0', 'ea5ff9ca_72c9_4d90_9903_f3594a301743');
INSERT INTO `sys_article_type` VALUES ('60334f9a_7609_4f55_8268_e6b62a6d5d7b', 'yyy', null, '2015-05-08 17:38:35', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('6779dfb9_19d3_4164_b688_e4fcd52338c9', 'kki', null, '2015-05-11 00:49:07', null, null, null, '0', '93efc4b8_3e1b_4b21_b5af_87778037f479');
INSERT INTO `sys_article_type` VALUES ('68be4fb9_919c_4570_a4b0_8efd0c0a0e5f', 'gggg', null, '2015-05-08 17:30:41', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('6af3acd9_4756_4fc3_9ba6_a352d40835f6', 'ddddffh', null, '2015-05-11 00:29:25', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article_type` VALUES ('6b535a92_d154_4669_802f_e1292d184b1e', 'gggg', null, '2015-05-08 17:30:17', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('6b6ca99a_08fa_425f_97c0_ea1f01df282b', 'yyy', null, '2015-05-08 17:38:35', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('6d72424a_0024_4213_8348_b8b92da8e7e1', '你好', '你好', '2015-05-07 23:34:20', null, '2015-05-07 23:35:12', '谢梅娇', '1', null);
INSERT INTO `sys_article_type` VALUES ('6d7e7f22_1036_4e41_be5b_a8388e87e768', 'yyyy', null, '2015-05-08 17:34:57', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('6fc51c8e_8a13_437e_acad_fa1a6bf2f96a', 'ddddd', null, '2015-05-10 08:37:55', null, null, null, '0', 'ba099286_83ad_42d6_97d7_bc1e9f9f3a9a');
INSERT INTO `sys_article_type` VALUES ('72740c38_4a1c_4693_b261_9437cbbee568', 'abc', null, '2015-05-09 15:44:34', null, null, null, '0', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('750ec70a_e31d_440a_adf1_76b10cfd16f7', 'tttt', null, '2015-05-09 15:28:52', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('7692b720_c74f_4675_9277_462968db73ee', 'dddddd', null, '2015-05-09 10:53:19', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('7700d2ce_a0ce_468b_8ff7_63c585f383b9', 'gggg', null, '2015-05-08 17:30:40', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('77e73d56_f405_49b1_8881_636a11c5d2fe', 'fff', null, '2015-05-09 15:30:37', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('7d4266cf_e468_47da_b2c6_c7776c3b551c', 'rrr', null, '2015-05-08 16:24:14', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('7ed4b01b_8b0c_4a20_98c8_e2dc00af1b5d', 'fff', null, '2015-05-09 10:46:31', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('8170bbaa_0e1a_4068_b31b_62a123aa7ca5', 'gggg', null, '2015-05-08 17:30:41', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('81957414_321d_40e1_bc6a_48d7a9b7a796', 'zzsa', null, '2015-05-10 09:37:41', null, null, null, '0', 'ea5ff9ca_72c9_4d90_9903_f3594a301743');
INSERT INTO `sys_article_type` VALUES ('8516709c_a9d1_4992_86ac_eb1d7e20ba13', 'ddd', null, '2015-05-09 17:30:31', null, null, null, '0', 'ba099286_83ad_42d6_97d7_bc1e9f9f3a9a');
INSERT INTO `sys_article_type` VALUES ('8b963c7f_a705_42b9_97b0_c8c2a754615f', 'rrrrrr', null, '2015-05-09 10:24:35', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('90f000cd_8b9a_4aa3_9c37_1495383f1e2a', 'ttkkkk', null, '2015-05-09 15:30:29', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('9252cf97_d955_42a5_82d5_315982e151ec', 'gggg', null, '2015-05-08 17:30:40', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('93aa82a6_e65f_45fe_bff8_18ad29bdc9cf', 'fffff', null, '2015-05-10 08:38:15', null, null, null, '0', 'ba099286_83ad_42d6_97d7_bc1e9f9f3a9a');
INSERT INTO `sys_article_type` VALUES ('9b543c2e_3a87_4c68_ba13_b08979086d08', '行政', '', '2015-05-07 23:21:36', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('9cc0d47e_3ace_4c64_adeb_bf842cc3c14e', '骆宏', '', '2015-05-08 15:54:41', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('a09d6e3d_267b_404b_a2e1_8a044495faae', 'gggg', null, '2015-05-08 17:30:41', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('a2078a64_db6c_4a05_aa39_189b6ac6af59', 'sdafasdfa', 'fsadfasdf', '2015-05-06 10:40:53', 'hello', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('a51940d0_bc69_4f36_8476_8dd1d10c5515', 'gggg', null, '2015-05-08 17:30:39', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('a5c99797_89fb_4f6d_9a35_8bf4b8ba2083', 'rrrffff', null, '2015-05-08 16:24:37', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('aa1ac1e6_74b2_40f5_aa1a_47e8f09c1ec1', 'tttt', null, '2015-05-08 17:43:22', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('b26bfbbd_ce05_4970_9c3c_6669360e137f', 'yyy', null, '2015-05-08 17:38:35', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('b54d6ce9_19ab_42b5_898d_58e37ee63ce3', 'rrrewwsfgk', null, '2015-05-10 08:46:04', null, null, null, '0', 'ba099286_83ad_42d6_97d7_bc1e9f9f3a9a');
INSERT INTO `sys_article_type` VALUES ('b9da190b_20c1_4fdd_a69e_e625f2e2dd73', 'trewq', null, '2015-05-09 16:25:42', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('bad2ce16_cf1d_4d20_b375_4ff8f6a0286c', '爱情', '', '2015-05-07 23:21:45', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('bfe38baf_7507_4e75_9bfa_d9e18586e3c0', 'rrrr', null, '2015-05-11 00:29:32', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article_type` VALUES ('c2d5ff82_2a9a_4bbf_a1af_d259154dfd6d', 'www', null, '2015-05-09 17:10:46', null, null, null, '0', '71464df1_7f82_4782_8aee_087d1a4cb5d5');
INSERT INTO `sys_article_type` VALUES ('c399f3a0_4e90_4d99_8e19_9a8a84f3ddcb', 'fffgghjklied', null, '2015-05-08 16:27:51', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('c87d7892_0d8d_4218_b2cc_651442828018', 'tttt', null, '2015-05-09 15:29:28', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('c8e7e09b_817c_46f5_8df3_673c6d275a02', 'tttttt', null, '2015-05-10 09:36:22', null, null, null, '0', 'ea5ff9ca_72c9_4d90_9903_f3594a301743');
INSERT INTO `sys_article_type` VALUES ('c9198213_0e43_4b6d_ab03_79a76414d331', '爱情', '', '2015-05-08 15:54:49', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('ca89f792_2ba0_434c_8113_aeffdad9b197', '公关', '', '2015-05-07 23:21:42', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('cb436794_d778_4388_9e8e_f601fca4808e', '一起努力吧', '', '2015-05-08 15:54:55', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('ce2b08b8_ba4e_45b1_b4a3_c4af4b0f09ec', 'wer', null, '2015-05-11 00:26:01', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article_type` VALUES ('cf5d4868_8a95_4791_ac8f_3cae26b8c982', 'dddd', null, '2015-05-11 00:49:01', null, null, null, '0', '93efc4b8_3e1b_4b21_b5af_87778037f479');
INSERT INTO `sys_article_type` VALUES ('d536fa97_6a14_47b9_8c26_b8e4f883c595', 'gggg', null, '2015-05-08 17:30:40', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('d60e7c1a_4f30_4f90_b16b_3dbd0c675f16', 'gggg', null, '2015-05-08 17:30:41', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('d85244b2_f7c3_47ec_b354_d692a5c6a3e7', 'tttt', null, '2015-05-09 15:29:43', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('d8934b0a_a69e_4c9c_a677_9d19493b5825', 'hhh', null, '2015-05-11 00:29:49', null, null, null, '1', '8a6ab98d_84b2_4cad_badf_04c18f0a099a');
INSERT INTO `sys_article_type` VALUES ('d8e1f46f_f067_4b48_abab_154091d01f6c', 'ttt', null, '2015-05-11 00:48:17', null, null, null, '0', '93efc4b8_3e1b_4b21_b5af_87778037f479');
INSERT INTO `sys_article_type` VALUES ('d9f4f7e6_d9fa_4555_98bb_83618f91b352', 'ttkkkk', null, '2015-05-09 15:29:49', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('db1c3f33_6e78_4626_a677_01557a31d674', 'asdfsdfs', 'sadfasdfasdf', '2015-05-07 15:38:37', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('db2ab13f_a670_4d1c_9e31_edfa2d907688', 'ddd', 'ddd', '2015-05-10 23:41:31', null, null, null, '1', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06');
INSERT INTO `sys_article_type` VALUES ('de386577_4fcd_414b_a8e3_721f1cff0fbc', '世界', '', '2015-05-08 15:54:45', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('de61e1ed_37e4_4eeb_a1ed_13cfd368003b', 'yyy', null, '2015-05-08 17:38:34', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('e33c5f36_b3fc_4cdc_bf90_2bbeaa95fee5', 'tttt', null, '2015-05-09 15:29:24', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('e883c766_d086_402e_b6b7_168c9e4eefc7', 'yyy', null, '2015-05-08 17:38:35', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('f0846e30_bec8_448f_b0b1_edb6b8f6a863', 'dddd', 'dddd', '2015-05-07 15:38:41', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('f705a701_437d_4a13_850d_ea37792eee61', '招聘', '', '2015-05-07 23:21:51', 'luohong', null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('fa87ee4b_06ae_47c5_9c64_3d2f136436d5', 'ffff', null, '2015-05-09 15:44:08', null, null, null, '1', 'b71dc5de_c210_4bda_a585_4b9c0758f3c1');
INSERT INTO `sys_article_type` VALUES ('ff45d4cd_817d_495d_b57d_f23d6f89789e', 'yyy', null, '2015-05-08 17:38:36', null, null, null, '1', null);
INSERT INTO `sys_article_type` VALUES ('ffab3b93_3630_4614_bef5_96bab91bb91f', 'rrrr', null, '2015-05-09 17:21:17', null, null, null, '0', '58e4040b_9b2e_4618_b4dc_4f47211d6f2f');

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
INSERT INTO `sys_menu` VALUES ('442c9a87_a0d4_4312_b73a_d660b14cceb8', '', '日志管理', '这是日志管理菜单', '2015-05-10 09:25:25', 'luohong', null, null, '0', 'http://210.38.139.40/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('article', '', '文章管理', '这是文章管理菜单', '2015-05-06 10:08:01', 'luohong', null, null, '0', 'http://210.38.139.40/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
INSERT INTO `sys_menu` VALUES ('article_type', '', '文章类别管理', '这是文章类别管理菜单', '2015-05-06 10:08:41', 'luohong', null, null, '0', 'http://210.38.139.40/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif');
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
INSERT INTO `sys_privilege` VALUES ('12cb569c_a755_48d7_a0c8_e04340df774b', '删除角色', 'http://210.38.139.40/springmvc_mybatis/role/delete.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:29:19', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('191f05b9_08ce_40a3_bcf9_9a32f2b8680f', '获取角色用户json数据', 'http://210.38.139.40/springmvc_mybatis/role/getRoleUserJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:37:13', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('25bb0511_00b3_42ce_bb26_e569211c2d44', '添加角色权限', 'http://210.38.139.40/springmvc_mybatis/role/addRolePrivilegeSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:34:19', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2b12fa86_34f9_462e_95ad_b42d246c5c2e', '更新文章', 'http://210.38.139.40/springmvc_mybatis/article/update.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 10:11:57', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('2f6869b7_0bcd_481f_ae4d_9acef32ab850', '用户管理', 'http://210.38.139.40/springmvc_mybatis/user/list.do', '', '769b2417_0f6e_4190_b456_e84e838f0fd6', '2015-04-29 11:14:59', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3a5ff5b3_0175_4189_8ed8_55d250497eef', '获取角色的tree json', 'http://210.38.139.40/springmvc_mybatis/role/listByTree.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:47:57', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3f2bc4f3_1002_4aa6_88b2_a2ee313c8393', '获取角色基本西悉尼', 'http://210.38.139.40/springmvc_mybatis/role/getBaseInfo.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:47:03', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3f347364_9dad_4e56_ad95_781e0c69867f', '添加角色', 'http://210.38.139.40/springmvc_mybatis/role/addSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:29:06', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('3f42fdd2_094b_4c46_b695_f6b90cf1fae7', '文章类别列表', 'http://210.38.139.40/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-04-25 10:24:30', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4447e64e_aae2_4990_8364_e37f94673ef3', '系统默认权限', null, '', null, '2015-05-06 10:22:08', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('44fa0a23_48f6_457a_bb6e_26c999a090e7', '退出', 'http://210.38.139.40/210.38.139.40/user/logout.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:22:30', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('459a4434_abab_404c_b48b_e4eebec0da98', '跳转到添加角色菜单界面', 'http://210.38.139.40/springmvc_mybatis/role/addRoleMenu.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:30:08', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('476ab3e5_1953_4800_ac85_796d1a7303d5', '获取角色grid json数据', 'http://210.38.139.40/springmvc_mybatis/role/listGridJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:47:29', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('4934717f_b99b_4ca1_a5ba_b461550c17cc', '文章管理', 'http://210.38.139.40/springmvc_mybatis/article/list.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-04-29 11:17:04', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('56e0f5a8_48a2_408a_89a8_5d1610654951', '文章列表json', 'http://210.38.139.40/springmvc_mybatis/articleType/listJson.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 11:14:29', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('593f0641_9cbe_47f7_b4f5_0712cdf33e42', '获取角色菜单的json', 'http://210.38.139.40/springmvc_mybatis/role/getRoleMenuJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:31:42', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('5a8311da_cfee_4bfc_b7ed_60a88d1db1dc', '删除文章类别', 'http://210.38.139.40/springmvc_mybatis/articleType/delete.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 10:12:23', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('6a397f82_98e9_4324_80bd_5d31b370f27f', '跳转到添加角色权限界面', 'http://210.38.139.40/springmvc_mybatis/role/addRolePrivilege.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:33:50', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('769b2417_0f6e_4190_b456_e84e838f0fd6', '用户管理', null, '这是用户管理类别', null, '2015-04-29 11:14:39', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('776f0e28_2758_4916_89b8_6534463e1bd4', '获取角色列表数据界面', 'http://210.38.139.40/springmvc_mybatis/role/listJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:45:50', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('7a8ad945_9e46_4dc4_9f7e_7d583c459cc8', '更新文章类别', 'http://210.38.139.40/springmvc_mybatis/articleType/update.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 10:12:47', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('7af9049e_2b36_4d1b_bf59_a5ec252792f2', '文章类别管理', null, '这是文章类别管理，用于添加文章类别，删除文章类别，已经更新文章类别', null, '2015-04-25 10:23:14', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('7c0e3bf4_1cae_4c64_967c_b9475cb771ed', '日志管理', 'http://210.38.139.40/springmvc_mybatis/article/listByAndroid.do', '', 'd44e43b5_acc1_4891_acde_ad906bb880e4', '2015-05-10 09:24:20', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('81ff227d_7d19_4c1a_b2b3_4ff00500be73', '跳转到角色菜单界面', 'http://210.38.139.40/springmvc_mybatis/role/getRoleMenu.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:50:50', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('8b805a71_12aa_4500_859c_c34878f38d2e', '跳转到添加文章', 'http://210.38.139.40/springmvc_mybatis/article/add.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 10:11:14', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('8bb6c538_5fb8_4c33_93c1_3539afb02db4', '跳转到添加角色用户界面', 'http://210.38.139.40/springmvc_mybatis/role/addUser.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:34:58', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('915bf26c_901a_420d_8936_f4bc0ef87976', '菜单管理', null, '菜单管理的类别', null, '2015-04-29 11:13:41', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('98725feb_429a_4f33_b058_ea026281258e', '菜单管理', 'http://210.38.139.40/springmvc_mybatis/menu/list.do', '', '915bf26c_901a_420d_8936_f4bc0ef87976', '2015-04-29 11:14:12', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a0d4d476_e68b_4655_a032_63bc5b5f5612', '权限管理', null, '这是权限管理类别', null, '2015-04-29 11:14:27', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a1b5f7da_7ce3_48e0_9e45_9138d30d05dd', '角色管理', 'http://210.38.139.40/springmvc_mybatis/role/list.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-06 10:25:37', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a42a90fc_a423_44d4_9b8c_409db86117a2', '用户管理', 'http://210.38.139.40/springmvc_mybatis/user/list.do', '', 'c480f6bd_56da_4cd0_ac9e_c1c0e86b1b97', '2015-04-29 11:17:19', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('a80264d0_e77e_4254_93a6_6553c183f698', '添加角色用户', 'http://210.38.139.40/springmvc_mybatis/role/addUserSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:35:44', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('af3367e1_7218_41b6_81b5_a0aa2577521e', '删除角色权限', 'http://210.38.139.40/springmvc_mybatis/role/deletePrivilege.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:32:09', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('b02d3a37_f7b9_47fc_ba38_34633a82095e', '获取角色权限json数据', 'http://210.38.139.40/springmvc_mybatis/role/getRolePrivilegeJson.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:33:18', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('bb4b7442_eec8_4cab_a8bf_4588febbbb0e', '删除用户角色', 'http://210.38.139.40/springmvc_mybatis/role/deleteRoleUser.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:36:11', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c352d13c_7adb_4b99_9f6d_31d6129b7dc9', '删除角色菜单', 'http://210.38.139.40/springmvc_mybatis/role/deleteMenu.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:31:12', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c480f6bd_56da_4cd0_ac9e_c1c0e86b1b97', '用户管理', null, '这是用户管理类别', null, '2015-04-29 11:15:37', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c69cd67d_7dcb_433b_a623_f3934c366095', '获取文章列表的json', 'http://210.38.139.40/springmvc_mybatis/article/listJson.do', '列出全部文章json数据', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 11:13:15', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('c969f565_3bb5_4439_be06_90c8ecc3ef0d', '添加文章列表', 'http://210.38.139.40/springmvc_mybatis/articleType/add.do', '', '7af9049e_2b36_4d1b_bf59_a5ec252792f2', '2015-05-06 10:13:16', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('ca9a2e09_a61a_4773_b24d_e0fca8a48465', '跳转到添加角色用户界面', 'http://210.38.139.40/springmvc_mybatis/role/getRoleUser.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:36:46', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('cb705a9a_3a74_43f9_a666_2592f77edea6', '跳转到添加角色界面', 'http://210.38.139.40/springmvc_mybatis/role/add.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:28:40', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d44e43b5_acc1_4891_acde_ad906bb880e4', '日志管理', null, '这是日志管理的类别', null, '2015-05-10 09:23:45', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d6d3bba3_46a9_442e_86d7_30e100d6b777', '日志类别管理', 'http://210.38.139.40/springmvc_mybatis/articleType/listByAndroid.do', '', 'd44e43b5_acc1_4891_acde_ad906bb880e4', '2015-05-10 09:25:06', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('d6fbb4af_6542_4c87_88f5_ee7efc2aa91b', '获取登录用户菜单', 'http://210.38.139.40/springmvc_mybatis/user/getUserMenuJson.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:23:24', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('df9e50d0_33a4_43c7_a782_fc26650e3bde', '角色管理', null, '', null, '2015-05-06 10:25:20', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('e739f785_1db0_403a_9386_875536439971', '权限管理', 'http://210.38.139.40/210.38.139.40/privilege/list.do', '', 'a0d4d476_e68b_4655_a032_63bc5b5f5612', '2015-04-29 11:15:19', '', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('eb159e8d_2963_42cc_adf5_31643dd9e881', '获取登录用户的权限', 'http://210.38.139.40/springmvc_mybatis/user/getUserPrivilege.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:24:06', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f1db846a_6c9e_4090_95f3_d3ce982a841e', '添加文章', 'http://210.38.139.40/springmvc_mybatis/article/addSubmit.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 11:07:35', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f4124bec_2b08_479f_a9b4_79b4bbe764f7', '文章管理', null, '这是文章管理类别', null, '2015-04-29 11:16:56', null, null, null, '0');
INSERT INTO `sys_privilege` VALUES ('f83895c2_5c9c_488d_afea_60f85c727a83', '登录', 'http://210.38.139.40/springmvc_mybatis/user/login.do', '', '4447e64e_aae2_4990_8364_e37f94673ef3', '2015-05-06 10:22:21', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fbaf16cd_08b1_4e48_b4d7_7c4c3b510b9b', '获取角色信息信息', 'http://210.38.139.40/springmvc_mybatis/role/openRole.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:46:35', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fdec56ac_1dee_41e0_a0ae_a84d67187c89', '删除文章', 'http://210.38.139.40/springmvc_mybatis/article/delete.do', '', 'f4124bec_2b08_479f_a9b4_79b4bbe764f7', '2015-05-06 10:11:30', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fe82c2e8_c1ba_439e_bf91_3c268257c228', '添加角色菜单', 'http://210.38.139.40/springmvc_mybatis/role/addRoleMenuSubmit.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:30:37', 'luohong', null, null, '0');
INSERT INTO `sys_privilege` VALUES ('fef73cdd_bd40_465c_b751_173e822735ed', '跳转到角色权限界面', 'http://210.38.139.40/springmvc_mybatis/role/getRolePrivilege.do', '', 'df9e50d0_33a4_43c7_a782_fc26650e3bde', '2015-05-07 09:32:43', 'luohong', null, null, '0');

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
INSERT INTO `sys_resource` VALUES ('1956d581_6e97_4880_a4aa_0d6a2c3ce011', '用户管理', 'http://210.38.139.40/springmvc_mybatis/user/list.do', '', 'root', '90d77efe_db5a_4291_9b84_644de7233934', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('23816af1_6c46_4d52_b14c_eb73cfbd25b2', '文章类别列表', 'http://210.38.139.40/springmvc_mybatis/articleType/list.do', '列出全部的文章类别列表', 'article_type', '8d2389e7_363b_4692_a6ea_c13f8a7c7ed8', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('48e740da_ce57_45fd_b26b_bab1c3bbf04a', '菜单管理', 'http://210.38.139.40/springmvc_mybatis/menu/list.do', '', 'root', 'ea0d5cc5_f45a_409d_85f4_acda189a27fb', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('682e1227_fb67_4009_bc2c_aa404dcd72a3', '日志管理', 'http://210.38.139.40/springmvc_mybatis/article/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '493b022e_0f43_4cc9_886a_dd3ba83ce519', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('6a0fee19_edaf_4ec4_a2e8_bbc574544f07', '日志类别管理', 'http://210.38.139.40/springmvc_mybatis/articleType/listByAndroid.do', '', '442c9a87_a0d4_4312_b73a_d660b14cceb8', 'b395d3a9_8d23_4c4c_8911_5779ffefee4c', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('74140054_cc5d_4a0b_8821_51c8e1bb50b3', '文章管理', 'http://210.38.139.40/springmvc_mybatis/article/list.do', '', 'article', 'c53b9986_ece4_4362_beea_bf5bcba61a41', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('9903b0f0_478d_4e7b_a6d1_4009c39cec27', '角色管理', 'http://210.38.139.40/springmvc_mybatis/role/list.do', '', 'root', 'ef63cf50_7226_42cf_9e27_ee3318c31182', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('ac67ff21_16f0_4d6c_a2da_4dc349dbfb9e', '用户管理', 'http://210.38.139.40/springmvc_mybatis/user/list.do', '', 'root', '16add85d_b064_454a_af6f_38e6afec6259', 'luohong', null, null, '0');
INSERT INTO `sys_resource` VALUES ('bb7ffbf9_9b5f_453b_90aa_d1a13cef99d4', '权限管理', 'http://210.38.139.40/springmvc_mybatis/privilege/list.do', '', 'root', 'e0af4343_545f_4b0d_9213_c2f0f15bb47c', 'luohong', null, null, '0');

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
INSERT INTO `sys_role_privilege` VALUES ('04f9b480_c355_45c6_ab3a_ce866ccf5314', '92386e75_2b6d_4765_a58e_0104c361b39f', '5a8311da_cfee_4bfc_b7ed_60a88d1db1dc');
INSERT INTO `sys_role_privilege` VALUES ('3f5f18bf_c8d4_4094_ab67_42bee0d79707', '92386e75_2b6d_4765_a58e_0104c361b39f', '3f42fdd2_094b_4c46_b695_f6b90cf1fae7');
INSERT INTO `sys_role_privilege` VALUES ('534c11f4_5080_42f9_83ac_331a9c8f9ce5', '92386e75_2b6d_4765_a58e_0104c361b39f', '8b805a71_12aa_4500_859c_c34878f38d2e');
INSERT INTO `sys_role_privilege` VALUES ('56dc9120_4437_4417_b0d2_ba7edd374c3e', '92386e75_2b6d_4765_a58e_0104c361b39f', '56e0f5a8_48a2_408a_89a8_5d1610654951');
INSERT INTO `sys_role_privilege` VALUES ('72aeed8a_38c8_4a49_810a_bd2df978fc81', 'root', 'f83895c2_5c9c_488d_afea_60f85c727a83');
INSERT INTO `sys_role_privilege` VALUES ('8a55ada0_24c7_419c_be9d_6c08d1a47112', '92386e75_2b6d_4765_a58e_0104c361b39f', 'c69cd67d_7dcb_433b_a623_f3934c366095');
INSERT INTO `sys_role_privilege` VALUES ('916afe82_31cc_463b_a5b5_de0db18d5e81', '92386e75_2b6d_4765_a58e_0104c361b39f', 'f1db846a_6c9e_4090_95f3_d3ce982a841e');
INSERT INTO `sys_role_privilege` VALUES ('983a21a4_c6f8_4ea1_97f6_0dbf10c38f77', '92386e75_2b6d_4765_a58e_0104c361b39f', 'c969f565_3bb5_4439_be06_90c8ecc3ef0d');
INSERT INTO `sys_role_privilege` VALUES ('9f7037c5_88c0_4b52_b814_0637c217a9a9', '92386e75_2b6d_4765_a58e_0104c361b39f', '4934717f_b99b_4ca1_a5ba_b461550c17cc');
INSERT INTO `sys_role_privilege` VALUES ('acaa398a_ce71_4814_b72b_9d8dbc4d2ef4', 'root', '44fa0a23_48f6_457a_bb6e_26c999a090e7');
INSERT INTO `sys_role_privilege` VALUES ('c043865d_1dc7_49cb_96ce_9297a8a88e9a', '92386e75_2b6d_4765_a58e_0104c361b39f', '7a8ad945_9e46_4dc4_9f7e_7d583c459cc8');
INSERT INTO `sys_role_privilege` VALUES ('f1745854_5150_4354_bbe0_01898d6f906f', 'root', 'eb159e8d_2963_42cc_adf5_31643dd9e881');
INSERT INTO `sys_role_privilege` VALUES ('f3c42a30_24fa_4f39_b018_1c81106f96fe', 'root', 'd6fbb4af_6542_4c87_88f5_ee7efc2aa91b');
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
INSERT INTO `sys_user` VALUES ('10f3bf2a_df23_417d_894f_e0562bfc0439', null, 'ooo', '7F94DD413148FF9AC9E9E4B6FF2B6CA9', null, null, null, null, null, null, null, '0', null, null, '2015-05-10 09:28:06', null, '0', '0');
INSERT INTO `sys_user` VALUES ('58e4040b_9b2e_4618_b4dc_4f47211d6f2f', null, 'ddd', '77963B7A931377AD4AB5AD6A9CD718AA', null, null, null, null, null, null, null, '0', null, null, '2015-05-09 17:12:11', null, '0', '0');
INSERT INTO `sys_user` VALUES ('5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06', null, 'iii', '36347412C7D30AE6FDE3742BBC4F21B9', null, null, null, null, null, null, null, '0', null, null, '2015-05-10 09:26:54', null, '0', '0');
INSERT INTO `sys_user` VALUES ('71464df1_7f82_4782_8aee_087d1a4cb5d5', null, 'www', '4EAE35F1B35977A00EBD8086C259D4C9', null, null, null, null, null, null, null, '0', null, null, '2015-05-08 16:00:47', null, '0', '0');
INSERT INTO `sys_user` VALUES ('75fc749f_c5a2_4c52_b40e_8e3486504bcc', null, 'qqqqqq', '343B1C4A3EA721B2D640FC8700DB0F36', null, null, null, null, null, null, null, '0', null, null, '2015-05-10 09:04:09', null, '0', '0');
INSERT INTO `sys_user` VALUES ('8a6ab98d_84b2_4cad_badf_04c18f0a099a', null, 'ggg', 'BA248C985ACE94863880921D8900C53F', null, null, null, null, null, null, null, '0', null, null, '2015-05-11 00:25:44', null, '0', '0');
INSERT INTO `sys_user` VALUES ('93efc4b8_3e1b_4b21_b5af_87778037f479', null, 'rrr', '44F437CED647EC3F40FA0841041871CD', null, null, null, null, null, null, null, '0', null, null, '2015-05-10 09:05:44', null, '0', '0');
INSERT INTO `sys_user` VALUES ('b71dc5de_c210_4bda_a585_4b9c0758f3c1', null, 'eee', 'D2F2297D6E829CD3493AA7DE4416A18F', null, null, null, null, null, null, null, '0', null, null, '2015-05-08 16:18:07', null, '0', '0');
INSERT INTO `sys_user` VALUES ('b78e9e26_0a23_449e_ba9c_1cd1ce8a145a', null, 'sas', 'A8A64CEF262A04DE4872B68B63AB7CD8', null, null, null, null, null, null, null, '0', null, null, '2015-05-11 00:31:03', null, '0', '0');
INSERT INTO `sys_user` VALUES ('ba099286_83ad_42d6_97d7_bc1e9f9f3a9a', null, 'eeeeeeeee', 'CD87CD5EF753A06EE79FC75DC7CFE66C', null, null, null, null, null, null, null, '0', null, null, '2015-05-09 17:30:11', null, '0', '0');
INSERT INTO `sys_user` VALUES ('c474258e_0a9a_4056_b395_7a94c13ccaa0', null, 'qqq', 'B2CA678B4C936F905FB82F2733F5297F', null, null, null, null, null, null, null, '0', null, null, '2015-05-10 09:02:07', null, '0', '0');
INSERT INTO `sys_user` VALUES ('ea5ff9ca_72c9_4d90_9903_f3594a301743', null, 'tttttt', 'BCC720F2981D1A68DBD66FFD67560C37', null, null, null, null, null, null, null, '0', null, null, '2015-05-10 09:36:12', null, '0', '0');
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
INSERT INTO `sys_user_menu` VALUES ('02f19b01_784e_49d3_aaf8_a7c7eb503114', 'ea5ff9ca_72c9_4d90_9903_f3594a301743', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '682e1227_fb67_4009_bc2c_aa404dcd72a3');
INSERT INTO `sys_user_menu` VALUES ('148387bf_70a3_48c1_87e7_478544f69ea2', '10f3bf2a_df23_417d_894f_e0562bfc0439', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '682e1227_fb67_4009_bc2c_aa404dcd72a3');
INSERT INTO `sys_user_menu` VALUES ('24a75dc7_a623_4bd0_82dd_c1f26c12256a', '93efc4b8_3e1b_4b21_b5af_87778037f479', 'article', '74140054_cc5d_4a0b_8821_51c8e1bb50b3');
INSERT INTO `sys_user_menu` VALUES ('2f77941d_89a6_4fea_982d_919446cf2a71', 'b78e9e26_0a23_449e_ba9c_1cd1ce8a145a', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '6a0fee19_edaf_4ec4_a2e8_bbc574544f07');
INSERT INTO `sys_user_menu` VALUES ('37d168b6_7d67_4d32_b296_817ce1fd5d8d', 'ea5ff9ca_72c9_4d90_9903_f3594a301743', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '6a0fee19_edaf_4ec4_a2e8_bbc574544f07');
INSERT INTO `sys_user_menu` VALUES ('460b4ecb_5473_4e28_bcd9_0157fdd6308b', '8a6ab98d_84b2_4cad_badf_04c18f0a099a', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '6a0fee19_edaf_4ec4_a2e8_bbc574544f07');
INSERT INTO `sys_user_menu` VALUES ('7776de7c_cadb_449f_9b22_dece24cf3fc4', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '6a0fee19_edaf_4ec4_a2e8_bbc574544f07');
INSERT INTO `sys_user_menu` VALUES ('8c22a08c_387e_4138_b803_ebd5368f754d', 'b78e9e26_0a23_449e_ba9c_1cd1ce8a145a', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '682e1227_fb67_4009_bc2c_aa404dcd72a3');
INSERT INTO `sys_user_menu` VALUES ('9c18d22c_a547_4408_ab63_3e981d915eee', '10f3bf2a_df23_417d_894f_e0562bfc0439', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '6a0fee19_edaf_4ec4_a2e8_bbc574544f07');
INSERT INTO `sys_user_menu` VALUES ('d3bcd336_4a8e_4c95_aee7_2456877271a3', '75fc749f_c5a2_4c52_b40e_8e3486504bcc', 'root', '48e740da_ce57_45fd_b26b_bab1c3bbf04a');
INSERT INTO `sys_user_menu` VALUES ('e5c88844_921c_4ce7_891f_9a3d42afc7d0', '75fc749f_c5a2_4c52_b40e_8e3486504bcc', 'article_type', '23816af1_6c46_4d52_b14c_eb73cfbd25b2');
INSERT INTO `sys_user_menu` VALUES ('ed2903df_fd56_45c7_84c9_792db1a9cf1a', '8a6ab98d_84b2_4cad_badf_04c18f0a099a', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '682e1227_fb67_4009_bc2c_aa404dcd72a3');
INSERT INTO `sys_user_menu` VALUES ('f3affedc_e865_4a0f_b460_21c3d1cb93a7', '93efc4b8_3e1b_4b21_b5af_87778037f479', 'article_type', '23816af1_6c46_4d52_b14c_eb73cfbd25b2');
INSERT INTO `sys_user_menu` VALUES ('fb1a5ba9_a1fa_48af_b807_e1da142db312', '5e2f0121_8d5b_42e1_90c5_4d6e21c3ae06', '442c9a87_a0d4_4312_b73a_d660b14cceb8', '682e1227_fb67_4009_bc2c_aa404dcd72a3');

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
