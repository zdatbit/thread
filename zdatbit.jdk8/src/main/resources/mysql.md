## mysql锁
  1. 行锁  
    读:select * from testDemo in share mode;  
    写:update testDemo set name = 'zhangsan' where id = 2 for update;      
  2. 表锁
    读：lock table testDemo read;  
    写：lock table testDemo write;  
  3. 间隙锁  
    读：select * from testDemo where id in(1,3,4) in share mode;  
    写：update testDemo set name = 'zhangsan' where id in(1,3,4) for update; 
  4. 页锁
    读：select * from testDemo where id id>1 and id<50 in share mode;  
    写：update testDemo set name = 'zhangsan' where id in(1,3,4) for update; 
    
## mysql事务隔离级别
   1. 读未提交  
        可能会有脏读，不可重复读和幻读
   2. 读已提交  
        可能会有不可重复读和幻读
   3. 可重复读  
        可能会有幻读
   4. 串行化  
        无风险
### 脏读、不可重复读和幻读
   1. 脏读  
        一个session可以读取到另一个session中还未提交的数据，是为脏读
   2. 不可重复读  
        一个session可以读取到另一个session中已经提交的数据，跟那个session未提交之前读到的数据不一样，是为不可重复读，侧重于数据的更新
   3. 幻读  
       一个session的读不会受到另外session的更新影响，但是可能读到多余或者删除的数据，幻读侧重于数据的增加和删除
 ## 索引  
   1. 什么是索引？  
        索引是排过序的数据，然后按一定的数据结构进行存储
   2. 为什么不使用二叉树来实现索引？  
        有些情况不实用，特殊情况下二叉树会退化为链表
   3. 为什么不使用红黑树来实现索引？  
        红黑树是一种特殊的二叉平衡树，数据过多树的深度会过深
   4. B树和B+树的区别是什么？
        主要是B树不支持范围查找，而B+树通过叶子节点可以遍历所有的数据
    B+树模型链接[!image](B+树.png)  
    B-树模型链接[!image](B+树.png)  
//todo 待完善 最左匹配等
