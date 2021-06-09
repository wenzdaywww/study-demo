--创建表空间
create tablespace boot
    logging
    datafile '/u01/app/oracle/oradata/XE/boot.dbf'
    size 50m
    autoextend on
    next 50m maxsize 20480m
    extent management local;
/**用户表*/
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

/**角色表*/
create table SYS_ROLE
(
  id       NUMBER primary key,
  role_id   VARCHAR2(20),
  role_name VARCHAR2(50),
  sys_update_date date,
  sys_create_date date
);
-- Add comments to the columns 
comment on column SYS_ROLE.id
  is 'ID';
comment on column SYS_ROLE.role_id
  is '角色ID';
comment on column SYS_ROLE.role_name
  is '角色名称';
comment on column SYS_ROLE.sys_update_date
    is '更新时间';
comment on column SYS_ROLE.sys_create_date
    is '创建时间';
-- Create/Recreate primary, unique and foreign key constraints
create sequence seq_sys_role_id increment by 1 start with 1 maxvalue 999999999; 
/**用户角色表*/
create table SYS_USER_ROLE
(
  user_id   VARCHAR2(50),
  role_id   VARCHAR2(20),
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