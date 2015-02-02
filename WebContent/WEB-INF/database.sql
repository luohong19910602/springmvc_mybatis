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

create table sys_resource(
	id varchar(50) primary key, 
	resource_name varchar(50) not null,
	resource_url varchar(50),
	resource_desc varchar(50),
	resource_menu_id varchar(50), 
	resource_created_time varchar(50),
	resource_creator varchar(50),
	resource_updated_time varchar(50),
	resource_updator varchar(50),
	resource_del_flag int(1) default 0,
	foreign key (resource_menu_id) references sys_menu(id) 
	on delete cascade on update cascade
);
		
create table sys_user(
    id varchar(50) primary key,
    user_name varchar(50),
    user_login_name varchar(50) not null unique,
    user_password varchar(50) not null,
    user_tel varchar(50),
    user_qq varchar(20),
    user_email varchar(50),
    user_blog varchar(50),
    user_address varchar(200),
    user_current_address varchar(200),
    user_birthday varchar(20),
    user_login_count int(11) default 0,
    user_updated_time varchar(50),
    user_updator varchar(50),
    user_created_time varchar(50),
    user_creator varchar(50),
    user_del_flag int(1) default 0,
    user_super_user_flag int(1) default 0
);

--用户可以访问的url
create table sys_user_resource(
    id varchar(50) primary key,
    user_resource_user_id varchar(50) not null,
    user_resource_url varchar(200) not null,
    foreign key (user_resource_user_id) references sys_user(id) 
	on delete cascade on update cascade
);

--角色
create table sys_role(
    id varchar(50) primary key,
    role_name varchar(50) not null,
    role_parent_id varchar(50),
    role_updated_time varchar(50),
    role_updator varchar(50),
    role_created_time varchar(50),
    role_creator varchar(50),
    role_del_flag int(1) default 0
);

create table sys_role_menu(
    id varchar(50) primary key,
    role_id varchar(50),
    menu_id varchar(50),
    resource_id varchar(50),
    foreign key (role_id) references sys_role(id) 
	on delete cascade on update cascade,
	foreign key (menu_id) references sys_menu(id) 
	on delete cascade on update cascade,
	foreign key (resource_id) references sys_resource(id) 
	on delete cascade on update cascade
);

drop table sys_privilege;
create table sys_privilege(
	id varchar(50) primary key, 
	privilege_name varchar(50) not null,
	privilege_url varchar(200),
	privilege_desc varchar(200),
	privilege_parent_id varchar(50), 
	privilege_created_time varchar(50),
	privilege_creator varchar(50),
	privilege_updated_time varchar(50),
	privilege_updator varchar(50),
	privilege_del_flag int(1) default 0,
	foreign key (privilege_parent_id) references sys_privilege(id) 
	on delete cascade on update cascade
);

create table sys_role_privilege(
    id varchar(50) primary key,
    role_id varchar(50),
    privilege_id varchar(50),
    foreign key (role_id) references sys_role(id) 
	on delete cascade on update cascade,
	foreign key (privilege_id) references sys_privilege(id) 
	on delete cascade on update cascade
);

create table sys_role_user(
    id varchar(50) primary key,
    role_id varchar(50),
    user_id varchar(50),
    foreign key (role_id) references sys_role(id) 
	on delete cascade on update cascade,
	foreign key (user_id) references sys_user(id) 
	on delete cascade on update cascade
);

create table sys_user_privilege(
    id varchar(50) primary key,
    user_id varchar(50),
    privilege_id varchar(50),
    foreign key (user_id) references sys_user(id) 
	on delete cascade on update cascade,
	foreign key (privilege_id) references sys_privilege(id) 
	on delete cascade on update cascade
);

create table sys_user_menu(
    id varchar(50) primary key,
    user_id varchar(50),
    menu_id varchar(50),
    resource_id varchar(50),
    foreign key (user_id) references sys_user(id) 
	on delete cascade on update cascade,
	foreign key (menu_id) references sys_menu(id) 
	on delete cascade on update cascade,
	foreign key (resource_id) references sys_resource(id) 
	on delete cascade on update cascade
);

create table sys_article_type(
    id varchar(50) primary key,
    article_type_name varchar(50),
    article_type_desc varchar(200),
    article_type_created_time varchar(50),
	article_type_creator varchar(50),
	article_type_updated_time varchar(50),
	article_type_updator varchar(50),
	article_type_del_flag int(1) default 0
);

create table sys_article(
    id varchar(50) primary key,
    article_title varchar(50),
    article_content varchar(500),
    article_url varchar(100),
    article_view_count int,
    article_reference int,
    article_type_id varchar(50),
    article_created_time varchar(50),
	article_creator varchar(50),
	article_updated_time varchar(50),
	article_updator varchar(50),
	article_del_flag int(1) default 0,
    foreign key (article_type_id) references sys_article_type(id) 
	on delete cascade on update cascade
);

--初始化菜单数据
insert into sys_menu(id, menu_name) values('root', '基础服务');

insert into sys_privilege(id,privilege_name,privilege_url,privilege_desc) values('1', '菜单管理', 'http://localhost/springmvc_mybatis/menu/list.do','这里是菜单管理的链接，列出全部菜单');
insert into sys_privilege(id,privilege_name,privilege_url,privilege_desc) values('2', '权限管理', 'http://localhost/springmvc_mybatis/privilege/list.do','这里是权限管理的链接，列出全部权限');
insert into sys_privilege(id,privilege_name,privilege_url,privilege_desc) values('3', '角色管理', 'http://localhost/springmvc_mybatis/role/list.do','这里是角色管理的链接，列出全部角色');
insert into sys_privilege(id,privilege_name,privilege_url,privilege_desc) values('4', '用户管理', 'http://localhost/springmvc_mybatis/user/list.do','这里是员工管理的链接，列出全部用户');

insert into sys_resource(id, resource_name, resource_url, resource_desc, resource_menu_id) values('1', '菜单管理', 'http://localhost/springmvc_mybatis/menu/list.do','这里是菜单管理的链接，列出全部菜单', 'root');
insert into sys_resource(id, resource_name, resource_url, resource_desc, resource_menu_id) values('2', '权限管理', 'http://localhost/springmvc_mybatis/privilege/list.do','这里是权限管理的链接，列出全部权限', 'root');
insert into sys_resource(id, resource_name, resource_url, resource_desc, resource_menu_id) values('3', '角色管理', 'http://localhost/springmvc_mybatis/role/list.do','这里是角色管理的链接，列出全部角色', 'root');
insert into sys_resource(id, resource_name, resource_url, resource_desc, resource_menu_id) values('4', '员工管理', 'http://localhost/springmvc_mybatis/user/list.do','这里是员工管理的链接，列出全部用户', 'root');


