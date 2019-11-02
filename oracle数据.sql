insert into sys_role (ID, ROLE_ID, ROLE_NAME)
values (seq_sys_role_id.nextval, 'admin', '管理员');

insert into sys_role (ID, ROLE_ID, ROLE_NAME)
values (seq_sys_role_id.nextval, 'user', '用户');

insert into sys_role (ID, ROLE_ID, ROLE_NAME)
values (seq_sys_role_id.nextval, 'test', '测试');

insert into sys_user (USER_ID, USER_NAME, PASS_WORD)
values ('wenzday', '吴伟文', 'www362412');

insert into sys_user (USER_ID, USER_NAME, PASS_WORD)
values ('test', '测试', 'www362412');

insert into sys_user (USER_ID, USER_NAME, PASS_WORD)
values ('www', 'www', 'www362412');

insert into sys_user_role (USER_ID, ROLE_ID)
values ('wenzday', 'admin');

insert into sys_user_role (USER_ID, ROLE_ID)
values ('test', 'test');

insert into sys_user_role (USER_ID, ROLE_ID)
values ('www', 'user');