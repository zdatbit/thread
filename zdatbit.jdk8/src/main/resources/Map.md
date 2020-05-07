## HashMap
### HashMap 1.7
  1. hashMap使用数组加链表的实现方式
  2. 链表的插入使用头插法
  3. hashMap扩展时，会遍历所有的数据重新rehash
  4. map的长度是2的幂次方，因为hashcode会跟(map.length-1)进行与运算
  5. 如果有相同的key,hashcode肯定也是相同的，会从第一个节点进行遍历，然后替换value
  6. map的扩展条件是数据的总数，而不是数组占用数

### HashMap 1.8
  1. hashMap使用数组加链表加红黑树的实现方式
  2. 链表的插入使用尾插法
  3. hashMap扩展时，会遍历所有的数据重新rehash,跟1.7有点不一样的是，合使用高位的数字来直接决定hash的位置
  4. map的长度是2的幂次方，因为hashcode会跟(map.length-1)进行与运算
  5. 如果有相同的key,hashcode肯定也是相同的，会从第一个节点进行遍历，然后替换value
  7. map的扩展条件是数据的总数，而不是数组占用数
  8. 如果链表长度超过8，会树化
  9. 如果树的节点小于6，会链化
  
## concurrentHashMap
  1. map由segment数组实现,初始化的时候只初始化segment0
  2. segment由nodeo数组来实现数据存储，node数组的数量至少是2
  3. put的时候，由会segment0来赋值初始化
  4. 数据hashCode会由高位来决定哪个segment
  5. 数据低位来决定哪个node来存储数据
  6. put的时候会加锁,如果没有获取到锁，会遍历节点数据，初始化一个node等操作