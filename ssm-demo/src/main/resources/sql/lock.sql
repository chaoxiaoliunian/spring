#展示mysql的锁,不要使用图形化工具。
show status like 'userdata%';
# table_locks_immediate：产生表级锁定的次数；
#table_locks_waited：出现表级锁定争用而发生等待的次数；

lock table userdata read;
show open tables;
unlock tables;

#开两个窗口，视为两个事务
#读锁演示
set autocommit=0;
select * from userdata wehre id=1 lock in share mode;
#当没出现死锁的时候，会因超时而失败。当出现死锁的时候会杀死后一个事务，前面一个事务的更新正常执行。
update userdata set age=200 where id=1;
#commit 为释放锁。
#commit;

#写锁演示
#加入行排他锁
select * from userdata where id=1 for update;

#查看行级锁的争用状态
 show status like 'innodb_row_lock%';
 #Innodb_row_lock_current_waits：当前正在等待锁定的数量；
#Innodb_row_lock_time：从系统启动到现在锁定总时间长度；
# Innodb_row_lock_time_avg：每次等待所花平均时间；
# Innodb_row_lock_time_max：从系统启动到现在等待最常的一次所花的时间；
# Innodb_row_lock_waits：系统启动后到现在总共等待的次数；

#对于这5个状态变量，比较重要的主要是：
#Innodb_row_lock_time_avg（等待平均时长）
# Innodb_row_lock_waits（等待总次数）
# Innodb_row_lock_time（等待总时长）这三项。

