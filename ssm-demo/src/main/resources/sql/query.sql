#分页查询
 #代表从第5条记录开始（包含第5条）向后查10条。初始值为0。
select * from userdata limit 5,10;
#sql查询顺序
select a.id,count(b.oid) as total
from userdata as a left join orgdata as b on a.id=b.uid
where a.username like '欧阳娜娜%' group by b.uid
having count(b.uid)<2
order by total desc limit 1;
#1.先进行from 后面：userdata和orgdata的笛卡尔积产生虚表vt1；
#2.然后进行on 过滤产生虚表vt2；
#3.然后将外连接保留表中未匹配的行加入产生vt3;
#4.如果还有其他外连接，则持续进行2,3步。
#5.然后使用where过滤产生vt4；
#6.根据group by 对vt4的数据进行分组，产生vt5；
#7.然后根据having进行过滤产生vt6;
#8.然后根据select 中的distinct 去重，生成vt然后根据order by 进行排序生成vt7
#9.然后进行limit;


