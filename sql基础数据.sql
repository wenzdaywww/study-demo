--1、插入用户信息
delete from sys_user where 1=1;
insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('www', '三万哥', 'www362412','0',sysdate,sysdate);

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', '测试', 'www362412','0',sysdate,sysdate);

insert into sys_user (USER_ID, USER_NAME, PASS_WORD,IS_DELETE,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('admin', '管理员', 'www362412','0',sysdate,sysdate);

--2、插入角色信息
delete from sys_role where 1=1;
insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'admin','管理员',sysdate,sysdate);

insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'user','用户',sysdate,sysdate);

insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'guest','游客',sysdate,sysdate);

insert into sys_role (ROLE_ID, ROLE_NAME,DESCRIPTION,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_id.nextval, 'test','测试',sysdate,sysdate);

--3、插入用户角色信息
delete from sys_user_role where 1=1;
insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('admin', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),sysdate,sysdate);

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('test', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),sysdate,sysdate);

insert into sys_user_role (USER_ID, ROLE_ID,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values ('www', (select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),sysdate,sysdate);

--4、插入菜单信息
delete from SYS_MENU where 1=1;
insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'index','首页',null,'&#xe68e;','/qadmin/main',0,'0',sysdate,sysdate);

insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'userManage','用户管理',null,'&#xe612;',null,1,'0',sysdate,sysdate);
insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'userList','用户列表',(select menu_id from SYS_MENU where menu_code='userManage'),null,'/qadmin/userList',2,'0',sysdate,sysdate);
insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'userAdd','添加用户',(select menu_id from SYS_MENU where menu_code='userManage'),null,'/qadmin/addUser',3,'0',sysdate,sysdate);

insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'articleManage','文章管理',null,'&#xe609;',null,4,'0',sysdate,sysdate);
insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'columnManage','栏目管理',(select menu_id from SYS_MENU where menu_code='articleManage'),null,null,5,'0',sysdate,sysdate);
insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'articleSet','文章管理',(select menu_id from SYS_MENU where menu_code='articleManage'),null,null,6,'0',sysdate,sysdate);

insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'sysManage','系统设置',null,'&#xe620;',null,7,'0',sysdate,sysdate);
insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'modifyPassword','修改密码',(select menu_id from SYS_MENU where menu_code='sysManage'),null,null,8,'0',sysdate,sysdate);
insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'webSet','网站设置',(select menu_id from SYS_MENU where menu_code='sysManage'),null,null,9,'0',sysdate,sysdate);

insert into SYS_MENU (menu_id, menu_code,menu_name,parent_id,menu_icon,menu_url,order_num,is_delete,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_menu_id.nextval,'/qadmin/logout','退出登录',null,'&#xe65c;','logout',10,'0',sysdate,sysdate);

--5、插入角色菜单信息
delete from sys_role_menu where 1=1;
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='index'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='userManage'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='userList'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='userAdd'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='articleManage'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='columnManage'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='articleSet'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='sysManage'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='modifyPassword'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='webSet'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='admin'),
        (select menu_id from SYS_MENU where menu_code='logout'),sysdate,sysdate);

insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='index'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='sysManage'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='modifyPassword'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='user'),
        (select menu_id from SYS_MENU where menu_code='logout'),sysdate,sysdate);

insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='index'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='sysManage'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='modifyPassword'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='webSet'),sysdate,sysdate);
insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='test'),
        (select menu_id from SYS_MENU where menu_code='logout'),sysdate,sysdate);

insert into sys_role_menu (sys_role_menu_id, role_id,menu_id,SYS_UPDATE_DATE,SYS_CREATE_DATE)
values (seq_sys_role_menu_id.nextval,(select c.ROLE_ID from sys_role c where c.ROLE_NAME='guest'),
        (select menu_id from SYS_MENU where menu_code='index'),sysdate,sysdate);






















