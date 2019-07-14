insert into sysroles (ID, ROLEID, ROLENAME)
values (seq_sysroles_id.nextval, 'admin', '管理员');

insert into sysroles (ID, ROLEID, ROLENAME)
values (seq_sysroles_id.nextval, 'user', '用户');

insert into sysroles (ID, ROLEID, ROLENAME)
values (seq_sysroles_id.nextval, 'test', '测试');

insert into sysuser (USERID, USERNAME, PASSWD)
values ('wenzday', '吴伟文', 'www362412');

insert into sysuser (USERID, USERNAME, PASSWD)
values ('www1', '测试', 'www362412');

insert into sysuser (USERID, USERNAME, PASSWD)
values ('www', 'www', 'www362412');
