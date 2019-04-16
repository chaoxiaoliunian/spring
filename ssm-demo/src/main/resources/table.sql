#使用user库
select '创建userdata库';
drop database  if exists userdata;
create database userdata;
select '创建用户表:userdata';
use userdata;
drop table if EXISTS userdata;
create table userdata(
id int(32) not null primary key auto_increment,
username varchar(60),
age int(3),
sex varchar(10),
addr varchar(200)
 );