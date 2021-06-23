--创建表空间
/**create tablespace boot
    logging
    datafile '/u01/app/oracle/oradata/XE/boot.dbf'
    size 50m
    autoextend on
    next 50m maxsize 20480m
    extent management local;**/
/**1、用户表*/
drop table SYS_USER;
create table SYS_USER(
    user_id   VARCHAR2(50) primary key,
    user_name VARCHAR2(50),
    pass_word   VARCHAR2(50),
    is_delete   char(1),
    sys_update_date date,
    sys_create_date date
);
comment on table SYS_USER
  is '用户信息表';
comment on column SYS_USER.user_id
  is '用户ID';
comment on column SYS_USER.user_name
  is '用户名';
comment on column SYS_USER.pass_word
  is '密码';
comment on column SYS_USER.is_delete
    is '删除';
comment on column SYS_USER.sys_update_date
    is '更新时间';
comment on column SYS_USER.sys_create_date
    is '创建时间';

/**2、角色表*/
drop table SYS_ROLE;
create table SYS_ROLE(
  role_id   NUMBER primary key,
  role_name VARCHAR2(50),
  description VARCHAR2(50),
  sys_update_date date,
  sys_create_date date
);
-- Add comments to the columns
comment on column SYS_ROLE.role_id
  is '角色ID';
comment on column SYS_ROLE.role_name
  is '角色名称';
comment on column SYS_ROLE.description
    is '角色描述';
comment on column SYS_ROLE.sys_update_date
    is '更新时间';
comment on column SYS_ROLE.sys_create_date
    is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints
drop sequence seq_sys_role_id;
create sequence seq_sys_role_id increment by 1 start with 1 maxvalue 999999999; 

/**3、用户角色表*/
drop table SYS_USER_ROLE;
create table SYS_USER_ROLE(
  user_id   VARCHAR2(50),
  role_id   NUMBER,
  sys_update_date date,
  sys_create_date date
);
-- Add comments to the columns 
comment on column SYS_USER_ROLE.user_id
  is '用户ID';
comment on column SYS_USER_ROLE.role_id
  is '角色ID';
comment on column SYS_USER_ROLE.sys_update_date
    is '更新时间';
comment on column SYS_USER_ROLE.sys_create_date
    is '创建时间';

/**4、菜单表*/
drop table SYS_MENU;
create table SYS_MENU(
    menu_id   NUMBER primary key,
    menu_code VARCHAR2(200),
    menu_name VARCHAR2(200),
    parent_id NUMBER,
    menu_icon VARCHAR2(200),
    menu_url  VARCHAR2(200),
    order_num NUMBER,
    is_delete char(1),
    sys_update_date date,
    sys_create_date date
);
-- Add comments to the columns
comment on column SYS_MENU.menu_id
    is '菜单ID';
comment on column SYS_MENU.menu_code
    is '菜单编码';
comment on column SYS_MENU.menu_name
    is '菜单名称';
comment on column SYS_MENU.parent_id
    is '父级菜单ID';
comment on column SYS_MENU.menu_icon
    is '菜单图标';
comment on column SYS_MENU.menu_url
    is '菜单路径';
comment on column SYS_MENU.order_num
    is '菜单序号';
comment on column SYS_MENU.is_delete
    is '是否删除';
comment on column SYS_MENU.sys_update_date
    is '更新时间';
comment on column SYS_MENU.sys_create_date
    is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints
drop sequence seq_sys_menu_id;
create sequence seq_sys_menu_id increment by 1 start with 1 maxvalue 999999999;

/**5、角色菜单表*/
drop table sys_role_menu;
create table sys_role_menu(
    sys_role_menu_id   NUMBER primary key,
    role_id   NUMBER,
    menu_id   NUMBER,
    sys_update_date date,
    sys_create_date date
);
-- Add comments to the columns
comment on column sys_role_menu.sys_role_menu_id
    is '菜单ID';
comment on column sys_role_menu.role_id
    is '菜单名称';
comment on column sys_role_menu.menu_id
    is '父级菜单ID';
comment on column sys_role_menu.sys_update_date
    is '更新时间';
comment on column sys_role_menu.sys_create_date
    is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints
drop sequence seq_sys_role_menu_id;
create sequence seq_sys_role_menu_id increment by 1 start with 1 maxvalue 999999999;