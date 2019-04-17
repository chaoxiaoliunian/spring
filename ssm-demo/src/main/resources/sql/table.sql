#建库建表
select '创建mydata库';
drop database  if exists mydata;
create database mydata;
select '创建用户表:mydata，机构表';
use mydata;
drop table if EXISTS userdata;
create table userdata(
id int(32)NOT NULL  auto_increment,
username varchar(60),
age int(3),
sex varchar(10),
addr varchar(200),
primary key (id)
 )ENGINE=INNODB DEFAULT CHARSET=UTF8;

drop table if EXISTS orgdata;
create table orgdata(
oid int(32)NOT NULL  auto_increment,
orgname varchar(60),
uid int(32),
primary key (oid)
 )ENGINE=INNODB DEFAULT CHARSET=UTF8;

