DROP TABLE IF EXISTS `m_menu`;
DROP TABLE IF EXISTS `m_permission`;
DROP TABLE IF EXISTS `m_permission_group`;
DROP TABLE IF EXISTS `m_group_operation_rel`;
DROP TABLE IF EXISTS `m_user`;
DROP TABLE IF EXISTS `m_user_permission_rel`;
DROP TABLE IF EXISTS `m_user_group_rel`;



CREATE TABLE `m_menu` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级菜单ID',
  `url` varchar(64) DEFAULT NULL COMMENT '链接地址',
  `menu_name` varchar(64) NOT NULL COMMENT '菜单名称',
  `idx` bigint(20) DEFAULT NULL COMMENT '排序',
  `icon` varchar(64) DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='菜单表';



CREATE TABLE `m_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `portal_id` int(11) DEFAULT NULL COMMENT '系统ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `url` varchar(64) NOT NULL COMMENT 'RequestMapping value',
  `method` varchar(8) NULL COMMENT 'RequestMapping method',
  `permission_name` varchar(64) NOT NULL COMMENT '权限名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='权限（操作）表';



CREATE TABLE `m_permission_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_name` varchar(32) NOT NULL COMMENT '权限组名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='权限组表';


CREATE TABLE `m_group_permission_rel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` bigint(20) NOT NULL COMMENT '权限组ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='组权限映射表';

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
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='用户权限映射表（非必须）';

CREATE TABLE `m_user_group_rel` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `group_id` bigint(20) NOT NULL COMMENT '权限组ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8 COMMENT='组用户映射表';


INSERT INTO `m_menu` (`id`, `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ('1', NULL, NULL, '系统管理', NULL, NULL);
INSERT INTO `m_menu` (`id`, `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ('2', '1', '/auth/permission/group/list', '权限管理', NULL, NULL);
INSERT INTO `m_menu` (`id`, `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ('3', '1', '/auth/permission/user/list', '用户管理', NULL, NULL);
INSERT INTO `m_menu` (`id`, `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ('4', '1', '/auth/permission/menu/list', '菜单管理', NULL, NULL);

INSERT INTO `m_user` (`id`, `username`, `password`, `nickname`, `enabled`) VALUES ('10001', 'admin', 'admin', 'admin', '1');
























INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理1', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理2', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理3', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理4', NULL, NULL);

INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理5', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理6', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理7', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理8', NULL, NULL);

INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理9', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理10', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理11', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理12', NULL, NULL);

INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理13', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理14', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理15', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理16', NULL, NULL);

INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理17', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理18', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理19', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理20', NULL, NULL);

INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理21', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理22', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理23', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理24', NULL, NULL);

INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理25', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理26', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理27', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理28', NULL, NULL);

INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( NULL, NULL, '系统管理29', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/group/list', '权限管理30', NULL, NULL);
INSERT INTO `m_menu` (  `parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES (  '1', '/auth/permission/user/list', '用户管理31', NULL, NULL);
INSERT INTO `m_menu` (`parent_id`, `url`, `menu_name`, `idx`, `icon`) VALUES ( '1', '/auth/permission/menu/list', '菜单管理32', NULL, NULL);
