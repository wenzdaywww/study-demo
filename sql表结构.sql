/**用户表*/
create table SYSUSER
(
  userid   VARCHAR2(50) not null,
  username VARCHAR2(50),
  passwd   VARCHAR2(50)
);
comment on table SYSUSER
  is '用户信息表';
comment on column SYSUSER.userid
  is '用户ID';
comment on column SYSUSER.username
  is '用户名';
comment on column SYSUSER.passwd
  is '密码';
alter table SYSUSER
  add primary key (USERID)
  using index 
  tablespace USERS
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
create table SYSROLES
(
  id       NUMBER not null,
  roleid   VARCHAR2(20),
  rolename VARCHAR2(50)
)
-- Add comments to the columns 
comment on column SYSROLES.id
  is 'ID';
comment on column SYSROLES.roleid
  is '角色ID';
comment on column SYSROLES.rolename
  is '角色名称';
-- Create/Recreate primary, unique and foreign key constraints 
alter table SYSROLES
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255;