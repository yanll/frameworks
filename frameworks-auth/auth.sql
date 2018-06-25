create database if not exists auth_center character set utf8;

use auth_center;

drop table if exists `m_menu`;
drop table if exists `m_permission`;
drop table if exists `m_role`;
drop table if exists `m_role_permission_rel`;
drop table if exists `m_user`;
drop table if exists `m_system`;
drop table if exists `m_user_role_rel`;
--drop table if exists `m_organization`;
--drop table if exists `m_department`;
--drop table if exists `m_user_permission_rel`;



create table `m_system` (
  `id` bigint(20) unsigned not null auto_increment comment '主键ID',
  `system_code` varchar(64) not null comment '系统代码',
  `system_name` varchar(128) not null comment '系统名称',
  `owner_id` bigint(20) null comment 'OWNER_ID',
  `owner_name` varchar(64) null comment 'OWNER_NAME',
  `enabled` int(11) not null default '1' comment '是否启用 1：是 0：否',
  `editable` int(11) not null default '1' comment '是否可编辑 1：是 0：否',
  primary key (`id`)
) engine=innodb auto_increment=10001 default charset=utf8 comment='菜单表';


create table `m_menu` (
  `id` bigint(20) unsigned not null auto_increment comment '主键ID',
  `system_code` varchar(64) not null comment '系统代码',
  `parent_id` bigint(20) default null comment '父级菜单ID',
  `url` varchar(64) default null comment '链接地址',
  `menu_code` varchar(64) null comment '菜单代码',
  `menu_name` varchar(64) not null comment '菜单名称',
  `menu_params` varchar(256) default null comment '菜单参数',
  `icon` varchar(64) default null comment '菜单图标',
  `display_order` bigint(20) default null comment '排序',
  `enabled` int(11) not null default '1' comment '是否启用 1：是 0：否',
  `editable` int(11) not null default '1' comment '是否可编辑 1：是 0：否',
  primary key (`id`)
) engine=innodb auto_increment=10001 default charset=utf8 comment='菜单表';



create table `m_permission` (
  `id` bigint(20) unsigned not null auto_increment comment '主键id',
  `system_code` varchar(64) not null comment '系统代码',
  `menu_id` bigint(20) default null comment '菜单ID',
  `url` varchar(64) not null comment 'REQUESTMAPPING VALUE',
  `permission_name` varchar(64) not null comment '权限名称',
  `enabled` int(11) not null default '1' comment '是否启用 1：是 0：否',
  `editable` int(11) not null default '1' comment '是否可编辑 1：是 0：否',
  primary key (`id`)
) engine=innodb auto_increment=10001 default charset=utf8 comment='权限（操作）表';



create table `m_role` (
  `id` bigint(20) unsigned not null auto_increment comment '主键ID',
  `system_code` varchar(64) not null comment '系统代码',
  `role_name` varchar(32) not null comment '角色名',
  `enabled` int(11) not null default '1' comment '是否启用 1：是 0：否',
  `editable` int(11) not null default '1' comment '是否可编辑 1：是 0：否',
  primary key (`id`)
) engine=innodb auto_increment=10001 default charset=utf8 comment='角色表';


create table `m_role_permission_rel` (
  `id` bigint(20) unsigned not null auto_increment comment '主键ID',
  `role_id` bigint(20) not null comment '角色ID',
  `permission_id` bigint(20) not null comment '权限ID',
  primary key (`id`)
) engine=innodb auto_increment=10001 default charset=utf8 comment='角色权限映射表';

create table `m_user` (
  `id` bigint(20) unsigned not null auto_increment comment '主键ID',
  `username` varchar(32) not null comment '用户名',
  `password` varchar(64) not null comment '密码',
  `nickname` varchar(16) not null,
  `enabled` int(11) not null default '1' comment '是否启用 1：是 0：否',
  `editable` int(11) not null default '1' comment '是否可编辑 1：是 0：否',
  primary key (`id`)
) engine=innodb auto_increment=10001 default charset=utf8 comment='用户表';


create table `m_user_role_rel` (
  `id` bigint(20) unsigned not null auto_increment comment '主键ID',
  `role_id` bigint(20) not null comment '角色ID',
  `user_id` bigint(20) not null comment '用户ID',
  primary key (`id`)
) engine=innodb auto_increment=10001 default charset=utf8 comment='用户角色映射表';

insert into `m_system` (`system_code`, `system_name`) values ('auth_console', '授权控制台系统');
insert into `m_system` (`system_code`, `system_name`) values ('monitor_console', '监控控制台系统');


insert into `m_menu` (`id`, `parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) values ('10001', null, 'auth_console', null, 'home', '主页', '1');
insert into `m_menu` (`id`, `parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) values ('10002', null, 'auth_console', null, 'system_manage', '系统管理', '1');
insert into `m_menu` (`id`, `parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) values ('10003', null, 'auth_console', null, 'log_manage', '日志管理', '1');
insert into `m_menu` (`id`, `parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) values ('10004', null, 'auth_console', null, 'demo_manage', '演示管理', '1');

insert into `m_menu` (`parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) select `id`, 'auth_console', null, 'role_manage', '角色管理', '1' from `m_menu` where `menu_code` = 'system_manage';
insert into `m_menu` (`parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) select `id`, 'auth_console', null, 'permission_manage', '权限管理', '1' from `m_menu` where `menu_code` = 'system_manage';
insert into `m_menu` (`parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) select `id`, 'auth_console', null, 'menu_manage', '菜单管理', '1' from `m_menu` where `menu_code` = 'system_manage';
insert into `m_menu` (`parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) select `id`, 'auth_console', null, 'user_manage', '用户管理', '1' from `m_menu` where `menu_code` = 'system_manage';

insert into `m_menu` (`parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) select `id`, 'auth_console', null, 'system_log_manage', '系统日志管理', '1' from `m_menu` where `menu_code` = 'log_manage';
insert into `m_menu` (`parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) select `id`, 'auth_console', null, 'operate_log_manage', '操作日志管理', '1' from `m_menu` where `menu_code` = 'log_manage';

insert into `m_menu` (`parent_id`, `system_code`, `url`, `menu_code`, `menu_name`, `enabled`) select `id`, 'auth_console', null, 'demo_breadcrumb', '面包屑', '1' from `m_menu` where `menu_code` = 'demo_manage';







insert into `m_user` (`id`, `username`, `password`, `nickname`, `enabled`) values ('10001', 'admin', 'admin', 'admin', '1');
insert into `m_user` (`id`, `username`, `password`, `nickname`, `enabled`) values ('10002', 'user', 'user', 'user', '1');
insert into `m_user` (`username`, `password`, `nickname`, `enabled`) values ('guest', 'guest', 'guest', '1');


insert into `m_role` (`id`, `system_code`, `role_name`, `enabled`) values ('10001', 'auth_console', 'su（超级管理员）', '1');
insert into `m_role` (`id`, `system_code`, `role_name`, `enabled`) values ('10002', 'auth_console', 'guest（访客）', '1');

insert into m_permission (system_code,menu_id,url,permission_name,enabled) select 'auth_console',id,'list','查询列表',1 from m_menu where parent_id is not null;
insert into m_permission (system_code,menu_id,url,permission_name,enabled) select 'auth_console',id,'add','增加',1 from m_menu where parent_id is not null;
insert into m_permission (system_code,menu_id,url,permission_name,enabled) select 'auth_console',id,'edit','修改',1 from m_menu where parent_id is not null;
insert into m_permission (system_code,menu_id,url,permission_name,enabled) select 'auth_console',id,'delete','删除',1 from m_menu where parent_id is not null;
insert into m_permission (system_code,menu_id,url,permission_name,enabled) select 'auth_console',id,'detail','查看详情',1 from m_menu where parent_id is not null;

insert into m_role_permission_rel(role_id,permission_id) select 10001,id from m_permission;
insert into m_role_permission_rel(role_id,permission_id) select 10002,id from m_permission;

insert into m_user_role_rel(role_id, user_id) values(10001, 10001);
insert into m_user_role_rel(role_id, user_id) values(10002, 10002);

select * from m_permission where id in (
  select permission_id from m_role_permission_rel where role_id in (
    select id from m_role where id in (
      select role_id from m_user_role_rel where user_id = 10001
    )
  )
)