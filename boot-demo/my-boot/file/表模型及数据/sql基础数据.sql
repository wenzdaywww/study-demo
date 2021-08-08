/**1、插入用户信息 **/
DELETE FROM SYS_USER WHERE 1=1;
insert into sys_user (user_id, user_name, pass_word,is_delete,sys_update_date,sys_create_date)
VALUES ('www', '三万哥', 'www362412','0',now(),now());

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', '测试', 'www362412','0',now(),now());

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('admin', '管理员', 'www362412','0',now(),now());

/**2、插入角色信息 **/
delete from sys_role where 1=1;
insert into sys_role (ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('admin','管理员',now(),now());

insert into sys_role (ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('user','用户',now(),now());

insert into sys_role (ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('guest','游客',now(),now());

insert into sys_role ( ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test','测试',now(),now());

/**3、插入用户角色信息 **/
delete from sys_user_role where 1=1;
insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('admin', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),now(),now());

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),now(),now());

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('www', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),now(),now());

/**4、插入菜单信息 **/
delete from SYS_MENU where 1=1;
insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('index','首页',null,'&#xe68e;','/qadmin/main',0,'0',now(),now());

insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('userManage','用户管理',null,'&#xe612;',null,1,'0',now(),now());
insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('userList','用户列表',(select a.parent_id from (select m.menu_id parent_id from SYS_MENU m where m.menu_code='userManage') a),null,'/qadmin/userList?page=1',2,'0',now(),now());
insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('userAdd','添加用户',(select a.parent_id from (select m.menu_id parent_id  from SYS_MENU m where menu_code='userManage') a),null,'/qadmin/addUser',3,'0',now(),now());

insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('articleManage','文章管理',null,'&#xe609;',null,4,'0',now(),now());
insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('columnManage','栏目管理',(select a.parent_id from (select m.menu_id parent_id  from SYS_MENU m where menu_code='articleManage') a),null,null,5,'0',now(),now());
insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('articleSet','文章管理',(select a.parent_id from (select m.menu_id parent_id  from SYS_MENU m where menu_code='articleManage') a),null,null,6,'0',now(),now());

insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('sysManage','系统设置',null,'&#xe620;',null,7,'0',now(),now());
insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('modifyPassword','修改密码',(select a.parent_id from (select m.menu_id parent_id  from SYS_MENU m where menu_code='sysManage') a),null,null,8,'0',now(),now());
insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('webSet','网站设置',(select a.parent_id from (select m.menu_id parent_id  from SYS_MENU m where menu_code='sysManage') a),null,null,9,'0',now(),now());

insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('logout','退出登录',null,'&#xe65c;','/qadmin/logout',10,'0',now(),now());

insert into SYS_MENU (menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('contact','联系我们',null,'&#xe63a;','/ws/login',11,'0',now(),now());
/**5、插入角色菜单信息 **/
delete from sys_role_menu where 1=1;
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='index'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='userManage'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='userList'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='userAdd'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='articleManage'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='columnManage'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='articleSet'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='sysManage'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='modifyPassword'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='webSet'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='logout'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='contact'),now(),now());

insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='index'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='sysManage'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='modifyPassword'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='logout'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='contact'),now(),now());

insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='index'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='sysManage'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='modifyPassword'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='webSet'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='logout'),now(),now());
insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='contact'),now(),now());

insert into sys_role_menu (role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ((select c.ROLE_ID from sys_role c where c.ROLE_NAME='guest'),
        (select menu_id from SYS_MENU where menu_code='index'),now(),now());


