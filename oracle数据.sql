--插入角色信息
insert into sys_role (ID, ROLE_ID, ROLE_NAME,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'admin', '管理员',sysdate,sysdate);

insert into sys_role (ID, ROLE_ID, ROLE_NAME,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'user', '用户',sysdate,sysdate);

insert into sys_role (ID, ROLE_ID, ROLE_NAME,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'test', '测试',sysdate,sysdate);
--插入用户信息
insert into sys_user (USER_ID, USER_NAME, PASS_WORD,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('wenzday', '吴伟文', 'www362412',sysdate,sysdate);

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', '测试', 'www362412',sysdate,sysdate);

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('www', 'www', 'www362412',sysdate,sysdate);
--插入用户角色信息
insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('wenzday', 'admin',sysdate,sysdate);

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', 'test',sysdate,sysdate);

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('www', 'user',sysdate,sysdate);