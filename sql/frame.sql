DROP TABLE IF EXISTS `SysUser`;
CREATE TABLE `SysUser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `deptId` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `userName` varchar(64) NOT NULL COMMENT '用户名称',
  `userAccount` varchar(64) NOT NULL COMMENT '用户账号',
  `mobile` varchar(32) DEFAULT NULL COMMENT '手机号码',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `status` tinyint(2) DEFAULT 1 COMMENT '帐号状态（1:正常 0:停用）',
  `delFlag` tinyint(2) DEFAULT 0 COMMENT '删除标志（0:代表存在 1:代表删除）',
  `createBy` varchar(64) DEFAULT NULL COMMENT '创建者',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateBy` varchar(64) DEFAULT NULL COMMENT '更新者',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `deptId_userName_key` (`deptId`, `userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

DROP TABLE IF EXISTS `SysRole`;
CREATE TABLE `SysRole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `roleName` varchar(64) NOT NULL COMMENT '角色名称',
  `roleKey` varchar(64) NOT NULL COMMENT '角色权限key',
  `userAccount` varchar(32) NOT NULL COMMENT '用户账号',
  `sort` tinyint(2) DEFAULT NULL COMMENT '排序',
  `dataScope` tinyint(2) DEFAULT NUll COMMENT '数据范围',
  `status` tinyint(2) DEFAULT 1 COMMENT '角色状态（1:正常 0:停用）',
  `delFlag` tinyint(2) DEFAULT 0 COMMENT '删除标志（0:代表存在 1:代表删除）',
  `createBy` varchar(64) DEFAULT NUll COMMENT '创建者',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateBy` varchar(64) DEFAULT NUll COMMENT '更新者',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';

DROP TABLE IF EXISTS `SysDept`;
CREATE TABLE `SysDept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `parentId` bigint(20) NOT NULL COMMENT '父类ID',
  `deptName` varchar(64) NOT NULL COMMENT '部门名称',
  `sort` tinyint(2) DEFAULT NULL COMMENT '排序',
  `status` tinyint(2) DEFAULT 1 COMMENT '部门状态（1:正常 0:停用）',
  `delFlag` tinyint(2) DEFAULT 0 COMMENT '删除标志（0:代表存在 1:代表删除）',
  `createBy` varchar(64) DEFAULT NUll COMMENT '创建者',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateBy` varchar(64) DEFAULT NUll COMMENT '更新者',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门信息表';


