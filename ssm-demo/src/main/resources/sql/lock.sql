#展示mysql的锁
show status like 'userdata%';
# table_locks_immediate：产生表级锁定的次数；
#table_locks_waited：出现表级锁定争用而发生等待的次数；