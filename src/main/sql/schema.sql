--数据库舒适化脚本

--创建数据库

create database miaosha;
use miaosha;
CREATE TABLE miaosha(
`miaosha_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` varchar(120) NOT NULL COMMENT '商品名称',
`number` int NOT  NULL COMMENT '库存数量',
`start_time` timestamp not NULL DEFAULT 0 COMMENT '秒杀开启时间',
`end_time` timestamp not NULL   DEFAULT 0 COMMENT '秒杀结束时间',
`create_time` timestamp  NOT NULL  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY PK_miaosha_ID(miaosha_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'
;
--初始化数据
insert into miaosha (name,number,start_time,end_time) values
('1599元强手机华为nave3',122,'2018-09-02 00:00:00','2018-09-03 00:00:00'),
('1799元强手机华为nave4',44,'2019-09-02 00:00:00','2019-09-03 00:00:00'),
('1999元强手机华为nave5',33,'2019-05-02 00:00:00','2019-05-03 00:00:00');

--秒杀项目成功表
--用户登陆成功认证表
create table success_miaosha(
miaosha_id bigint NOT NULL  COMMENT '商品库存id',
phone varchar(11) NOT NULL COMMENT '用户电话',
state tinyint NOT NULL DEFAULT  0 COMMENT '状态标识：-1：无效 0：成功 1：已付款 2：已发货',
create_time TIMESTAMP  NOT NULL COMMENT '创建时间',
PRIMARY KEY (miaosha_id , phone) , /*联合主键*/
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细'


--连接数据库
mysql  -uroot -p