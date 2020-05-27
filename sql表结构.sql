--创建表空间
create tablespace boot  
logging  
datafile '/u01/app/oracle/oradata/XE/boot.dbf' 
size 50m  
autoextend on  
next 50m maxsize 20480m  
extent management local;  
/**用户表*/
create table SYS_USER
(
  user_id   VARCHAR2(50) not null,
  user_name VARCHAR2(50),
  pass_word   VARCHAR2(50)
);
comment on table SYS_USER
  is '用户信息表';
comment on column SYS_USER.user_id
  is '用户ID';
comment on column SYS_USER.user_name
  is '用户名';
comment on column SYS_USER.pass_word
  is '密码';
alter table SYS_USER
  add primary key (USER_ID)
  using index 
  tablespace boot
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  ); 
/**角色表*/
create table SYS_ROLE
(
  id       NUMBER not null,
  role_id   VARCHAR2(20),
  role_name VARCHAR2(50)
);
-- Add comments to the columns 
comment on column SYS_ROLE.id
  is 'ID';
comment on column SYS_ROLE.role_id
  is '角色ID';
comment on column SYS_ROLE.role_name
  is '角色名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYS_ROLE
  add primary key (ID)
  using index 
  tablespace boot
  pctfree 10
  initrans 2
  maxtrans 255;
create sequence seq_sys_role_id increment by 1 start with 1 maxvalue 999999999; 
/**用户角色表*/
create table SYS_USER_ROLE
(
  user_id   VARCHAR2(50),
  role_id   VARCHAR2(20)
);
-- Add comments to the columns 
comment on column SYS_USER_ROLE.user_id
  is '用户ID';
comment on column SYS_USER_ROLE.role_id
  is '角色ID';