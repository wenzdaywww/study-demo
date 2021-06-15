--插入角色信息
delete from sys_role where 1=1;
insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'admin','管理员',sysdate,sysdate);

insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'user','用户',sysdate,sysdate);

insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'guest','游客',sysdate,sysdate);

insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'test','测试',sysdate,sysdate);
--插入用户信息
delete from sys_user where 1=1;
insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('www', '三万哥', 'www362412','0',sysdate,sysdate);

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', '测试', 'www362412','0',sysdate,sysdate);

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('admin', '管理员', 'www362412','0',sysdate,sysdate);

--插入用户角色信息
delete from sys_user_role where 1=1;
insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('admin', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),sysdate,sysdate);

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),sysdate,sysdate);

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('www', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),sysdate,sysdate);