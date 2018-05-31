CREATE DATABASE IF NOT EXISTS AUTH_CENTER CHARACTER SET UTF8;

use AUTH_CENTER;

DROP TABLE IF EXISTS `m_menu`;
DROP TABLE IF EXISTS `m_permission`;
DROP TABLE IF EXISTS `m_permission_group`;
DROP TABLE IF EXISTS `m_permission_group_rel`;
DROP TABLE IF EXISTS `m_user`;
DROP TABLE IF EXISTS `m_user_permission_rel`;
DROP TABLE IF EXISTS `m_user_group_rel`;



CREATE TABLE `m_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `portal_id` int(11) DEFAULT NULL COMMENT '系统ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级菜单ID',
  `url` varchar(64) DEFAULT NULL COMMENT '链接地址',
  `menu_code` varchar(64) NOT NULL COMMENT '菜单代码',
  `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `menu_params` varchar(256) DEFAULT NULL COMMENT '菜单参数',
  `icon` varchar(64) DEFAULT NULL COMMENT '菜单图标',
  `idx` bigint(20) DEFAULT NULL COMMENT '排序',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用 1：是 0：否',
  `editable` int(11) NOT NULL DEFAULT '0' COMMENT '是否可编辑 1：是 0：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='菜单表';



CREATE TABLE `m_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `portal_id` int(11) DEFAULT NULL COMMENT '系统ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `url` varchar(64) NOT NULL COMMENT 'RequestMapping value',
  `method` varchar(8) NULL COMMENT 'RequestMapping method',
  `permission_name` varchar(64) NOT NULL COMMENT '权限名称',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用 1：是 0：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='权限（操作）表';



CREATE TABLE `m_permission_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `portal_id` int(11) DEFAULT NULL COMMENT '系统ID',
  `group_name` varchar(32) NOT NULL COMMENT '权限组名',
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用 1：是 0：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='权限组表';


CREATE TABLE `m_permission_group_rel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` bigint(20) NOT NULL COMMENT '权限组ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='组权限映射表';

CREATE TABLE `m_user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(16) NOT NULL,
  `enabled` int(11) NOT NULL DEFAULT '0' COMMENT '是否启用 1：是 0：否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `m_user_permission_rel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='用户权限映射表（非必须）';

CREATE TABLE `m_user_group_rel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` bigint(20) NOT NULL COMMENT '权限组ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10001 DEFAULT CHARSET=utf8 COMMENT='组用户映射表';



INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('101', NULL, '1', NULL, 'home', '主页', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('102', NULL, '1', NULL, 'system_manage', '系统管理', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('103', NULL, '1', NULL, 'log_manage', '日志管理', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('998', NULL, '1', NULL, 'demo_manage', '演示管理', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('999', NULL, '1', NULL, 'unknow_batch', '未知批次', '1');

INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('1001', 102, '1', NULL, 'permission_group', '权限分组', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('1002', 102, '1', NULL, 'menu_manage', '菜单管理', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('1003', 102, '1', NULL, 'user_manage', '用户管理', '1');

INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('1004', 103, '1', NULL, 'system_log', '系统日志', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('1005', 103, '1', NULL, 'operate_log', '操作日志', '1');

INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('1006', 999, '1', NULL, 'remit_center', '打款中心', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('1007', 999, '1', NULL, 'bank_channel', '银行通道', '1');


INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('10001', 1007, '1', NULL, 'BJBANK', '北京银行', '1');
INSERT INTO `m_menu` (`id`, `parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES ('10002', 1007, '1', NULL, 'HFBANK', '恒丰银行', '1');

INSERT INTO `m_menu` (`parent_id`, `portal_id`, `url`, `menu_code`, `menu_name`, `enabled`) VALUES (998, '1', NULL, '', '面包屑', '1');





INSERT INTO `m_user` (`id`, `username`, `password`, `nickname`, `enabled`) VALUES ('10001', 'admin', 'admin', 'admin', '1');
INSERT INTO `m_user` (`id`, `username`, `password`, `nickname`, `enabled`) VALUES ('10002', 'user', 'user', 'user', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');
INSERT INTO `m_user` (`username`, `password`, `nickname`, `enabled`) VALUES ('1', '1', '1', '1');


INSERT INTO `m_permission_group` (`id`, `portal_id`, `group_name`, `enabled`) VALUES ('10001', '1', 'SU（超级管理员）', '1');
INSERT INTO `m_permission_group` (`id`, `portal_id`, `group_name`, `enabled`) VALUES ('10002', '1', 'GUEST（访客）', '1');

insert into m_permission (portal_id,menu_id,url,method,permission_name,enabled)
    select 1,id,'index','','def',1 from m_menu;

insert into m_user_permission_rel(user_id,permission_id)
select 10001,id from m_permission;

select * from m_permission where id in (
  select permission_id from m_permission_group_rel where group_id in (
    select id from m_permission_group where id in (
      select group_id from m_user_group_rel where user_id = 10001
    )
  )
)
union all
select * from m_permission where id in(
  select permission_id from m_user_permission_rel where user_id = 10001
)