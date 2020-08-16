先回答问题，不要过多引申
JVM:Java virtual machine
\内存

垃圾回收机制

内存分配策略


主内存
/

高速缓存

/处理器


volatile 同步机制？

并发：
集群
处理多任务
业务场景

高并发：
mysql 主从同步复制
master-slaves
数据库集群
库表

分布式：
并行处理、同时
分布式存储系统
多节点：有的存储、有的计算、有的请求处理
负载均衡
反向代理
消息队列
NoSQL
分布式缓存
TCP/IP
作用：
1. 增大系统容量
2. 消除单点故障
3. 系统扩展性高

- 分布式应用？

1. 集合包
list
arraylist
linkedlist
set
hashset
treeset
map
hashmap
treemap
2. 并发包current
currenthashmap

算法
项目封装（英文字母大写）
基础
Spring
中间件
知识网络-思维导图

企业喜欢问什么
map的遍历，
key、values
map.entryset解决大容量的存储

maven的生命周期与命令，
clean
initialize
install

集合框架hashmap，
建立索引进行搜索
equals方法找到键值对存取put、get操作
hashmap冲突
平衡树


Linux权限666 然后面试，
读r
写w
执行x
-rw------- (600) -- 只有属主有读写权限。
-rw-r--r-- (644) -- 只有属主有读写权限；而属组用户和其他用户只有读权限。
-rwx------ (700) -- 只有属主有读、写、执行权限。
-rwxr-xr-x (755) -- 属主有读、写、执行权限；而属组用户和其他用户只有读、执行权限。
-rwx--x--x (711) -- 属主有读、写、执行权限；而属组用户和其他用户只有执行权限。
-rw-rw-rw- (666) -- 所有用户都有文件读、写权限。这种做法不可取。
-rwxrwxrwx (777) -- 所有用户都有读、写、执行权限。更不可取的做法。


- 问遍历有几种方法

1. map
key
map.entryset遍历key、value
map.values(）

2. list
iterator

3. 迭代器
for循环遍历
foreach循环遍历

hashmap数据结构图，
Linux chmod 666什么意思，

- Spring aop原理

- Spring boot和spring 区别

- 多线程，线程池

Spring mvc调用controller会新建线程吗，

对外系统接口
json格式传递数据
接口：
请求url
请求参数
应答参数
请求报文
应答报文

主动获取
被动接收

服务端调用
客户端调用

打日志
log4j
配置.properties文件
commons-logging




- 集合排序的工具类
collections的sort方法
sort（List<T> list）
comparable接口自然排序



- 内存溢出

溢出关键字
地址空间不够
启动参数设置过小
内存加载数据量太大


方法
1. 修改JVM参数，直接增加内存
2. 检查错误日志
3. 检查数据查询方式，是否一次对所有数据查询
4. list或者map对象没有清除，

outmemoryerror无法申请足够的内存
stackoverflowerror线程申请的栈深度大于虚拟机异常的深度

- 线程池

缓冲队列
自定义线程池
thread类
runable接口

executor接口(执行)
executorservice接口
threadpoolexecutor

-  创建线程的办法
thread
future
callable



linux生产问题
springMVC流程
注解
restful接口




- 多线程同步实现方式

synchronized关键字
volatile
局部变量


- 线程安全
concurrent.atom保证原子性
锁保证同一时间只有一个线程拿到锁lock

- 线程同步
sychronized同步性关键字
volatile不稳定关键字有序性

java异常error和exception的区别
系统
程序
nullpointexception


- redis的应用类型
支持key/value
也支持list、set、hash数据结构
master-slave数据备份
数据持久化
缓存更新数据
redis 有5种数据类型

- springAOP的实际应用：代码复用动态代理

交叉点进行模块化
事务管理
远程访问
权限校验
业务核心代码
AspectOrientedp
记录日志
安全
权限
缓存
错误处理
记录跟踪
性能优化监控性能
持久化
资源池


- mysql索引失效的例子

建立索引提高查询效率

使用or
联合索引
查询条件写错了没有加引号
is null is not null 导致索引失效
like通配符




- 创建索引的方式

creat index
alter table主键索引
唯一索引


- 解决生产问题
MQ
消息队列
TCP/IP
服务器和客户端
发布
订阅
代理
topic

固定、消息、可变


springboot

set
threadlocal
volatile
final修饰类属性可以修改吗不可以


- SQL优化

解决慢查询
索引
拆分表
1. 避免全表查询where 和 orfer by上建立索引
2. 避免在where子句中对null值进行判断，不要设置null ，要设置not null
3. 避免where子句中or连接条件，如果一个字段有索引，一个字段没有索引，将导致引擎放弃使用索引而全表扫描
4. 模糊查询like的使用，尽量不要加%
5. 函数操作
6. varchar代替char
7. 多表连接用jion
8. where后出现列

黑马
尚学堂

____________________________________________________________


- 什么是分布式系统？


1.分布式系统 多个节点组成的系统。

节点指的是计算机服务器，而且这些节点一般不是孤立的，而是互通的。

2.这些连通的节点上部署了我们的节点，并且相互的操作会有协同。

分布式系统对于用户而言，他们面对的就是一个服务器，提供用户需要的服务而已，

而实际上这些服务是通过背后的众多服务器组成的一个分布式系统，因此分布式系统看起来像是一个超级计算机一样。

例如淘宝，平时大家都会使用，它本身就是一个分布式系统，我们通过浏览器访问淘宝网站时，这个请求的背后就是一个庞大的分布式系统在为我们提供服务，整个系统中有的负责请求处理，有的负责存储，有的负责计算，最终他们相互协调把最后的结果返回并呈现给用户。

分布式系统主要特点：

1.增大系统容量。 需要多台机器才能应对大规模的应用场景。

所以，我们需要垂直或是水平拆分业务系统，让其变成一个分布式的架构。

2.加强系统可用。 我们的业务越来越关键，需要提高整个系统架构的可用性，这就意味着架构中不能存在单点故障。

整个系统不会因为一台机器出故障而导致整体不可用。

所以需要通过分布式架构来冗余系统以消除单点故障，从而提高系统的可用性。

3.因为模块化，所以 系统模块重用度更高

4.因为软件服务模块被拆分，开发和发布速度可以并行而变得更快

5.系统扩展性更高

6.团队协作流程也会得到改善

分布式系统的类型有三种：

1.分布式处理，但只有一个总数据库，没有局部数据库

2.分层式处理，每一层都有自己的数据库

3.充分分散的分布式网络，没有中央控制部分，各节点之间的联系方式又可以有多种，如松散的联接，紧密的联接，动态的联接，广播通知式的联接等

- 什么是 JAVA 分布式应用？

一个大型的系统往往被分为几个子系统来做，一个子系统可以部署在一台机器的多个 JVM 上，也可以部署在多台机器上。

但是每一个系统不是独立的，不是完全独立的。需要相互通信，共同实现业务功能。

一句话来说：分布式就是通过计算机网络将后端工作分布到多台主机上，多个主机一起协同完成工作。

实现分布式主要的方式

分布式应用用到的技术：

网络通信，基于消息方式的系统间通信和基于远程调用的系统间通信。

缺点： 就是会增加技术的复杂度。 基于消息的系统通信方式，主要是利用的网络协议，比如 TCP/IP 协议。 

系统间的通信还需要对数据进行处理，比如同步 IO 和异步 IO。 远程调用实现系统间的通信:通过调用本地的java接口的方法来透明的调用远程java的实现。具体的细节有框架来实现。

基于Java自身技术实现消息方式的系统间通信： 基于Java自身包实现消息方式的系统间通信的方式有： TCP/IP+BIO、 TCP/IP+NIO、 UDP/IP+BIO UDP/IP+NIO 4种方式

TCP/IP+BIO 在 Java 中可基于 Socket、ServerSocket 来实现 TCP/IP+BIO 的系统间通信。

Socket 主要用于实现建立连接及网络 IO 的操作，ServerSocket 主要用于实现服务器端端口的监听及 Socket 对象的获取。

多个客户端访问服务器端的情况下，会遇到两个问题:建立多个 socket 的，占用过多的本地资源，服务器端要承受巨大的来访量；创建过多的 socket，占用过多的资源，影响性能。

通常解决这种问题的办法是，使用 连接池，既能限制连接的数量，又能避免创建的过程，可以很大的提高性的问题。缺点就是竞争量大的时候造成激烈的竞争和等待。需要注意的是，要设置超时时间，如果不这样的话，会造成无限制的等待。

为了解决这个问题，采用一连接一线程的方式，同时也会带来副作用，内存占用过多。 TCP/IP 异步通信: JAVA NIO 通道技术实现。

JAVA 分布式知识体系介绍 附上某 JAVA 分布式学习目录，帮助了解分布式都有哪些东西

第 1 章 分布式 Java应用 

1.1 基于消息方式实现系统间的通信 

1.1.1 基于 Java自身技术实现消息方式的系统间通信 

1.1.2 基于开源框架实现消息方式的系统间通信 

1.2 基于远程调用方式实现系统间的通信 

1.2.1 基于 Java自身技术实现远程调用方式的系统间通信 

1.2.2 基于开源框架实现远程调用方式的系统间通信

第 2 章 大型分布式 Java应用与 SOA 2.1 基于 SCA实现 SOA平台 2.2 基于 ESB实现 SOA平台 2.3 基于 Tuscany实现 SOA平台 2.4 基于 Mule 实现 SOA平台

第 3 章 深入理解 JVM 3.1 Java代码的执行机制 3.1.1 Java源码编译机制 3.1.2 类加载机制 3.1.3 类执行机制 3.2 JVM内存管理 3.2.1 内存空间 3.2.2 内存分配 3.2.3 内存回收 3.2.4 JVM 内存状况查看方法和分析工具 3.3 JVM线程资源同步及交互机制 3.3.1 线程资源同步机制 3.3.2 线程交互机制 3.3.3 线程状态及分析

第 4 章 分布式应用与 SunJDK类库 4.1 集合包 4.1.1 ArrayList 4.1.2 LinkedList 4.1.3 Vector 4.1.4 Stack 4.1.5 HashSet 4.1.6 TreeSet 4.1.7 HashMap 4.1.8 TreeMap 4.1.9 性能测试 4.1.10 小结 4.2 并发包（ java.util.concurrent ） 4.2.1 ConcurrentHashMap 4.2.2 CopyOnWriteArrayList 4.2.3 CopyOnWriteArraySet 4.2.4 ArrayBlockingQueue 4.2.5 AtomicInteger 4.2.6 ThreadPoolExecutor 4.2.7 Executors 4.2.8 FutureTask 4.2.9 Semaphore 4.2.10 CountDownLatch 4.2.11 CyclicBarrier 4.2.12 ReentrantLock 4.2.13 Condition 4.2.14 ReentrantReadWriteLock 4.3 序列化 /反序列化 4.3.1 序列化 4.3.2 反序列化

第 5 章 性能调优 5.1 寻找性能瓶颈 5.1.1 CPU消耗分析 5.1.2 文件 IO 消耗分析 5.1.3 网络 IO 消耗分析 5.1.4 内存消耗分析 5.1.5 程序执行慢原因分析 5.2 调优 5.2.1 JVM 调优 5.2.2 程序调优 5.2.3 对于资源消耗不多，但程序执行慢的情况

第 6 章 构建高可用的系统 6.1 避免系统中出现单点 6.1.1 负载均衡技术 6.1.2 热备 6.2 提高应用自身的可用性 6.2.1 尽可能地避免故障 6.2.2 及时发现故障 6.2.3 及时处理故障 6.2.4 访问量及数据量不断上涨的应对策略

第 7 章 构建可伸缩的系统 7.1 垂直伸缩 7.1.1 支撑高访问量 7.1.2 支撑大数据量 7.1.3 提升计算能力 7.2 水平伸缩 7.2.1 支撑高访问量 7.2.2 支撑大数据量 7.2.3 提升计算能力 ———————————————— 版权声明：本文为CSDN博主「肖朋伟」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/qq_40147863/java/article/details/84350344


________________________________________

- 1.集合

java中的集合主要分为三种类型：

Set（集）

List（列表）

Map（映射）

数组：几乎所有集合实现的底层都有数据的身影存在，因此我们首先需要了解一下数组

2.集合与数组


数组的大小是固定不变的，并且同一个数组只能存储相同类型的数据，该数据类型可以是基本类型也可以是引用类型。

Java中集合可以存储操作不同类型和大小不固定的数据，但是Java中集合只能存储引用类型，不能存储基本类型。

Map遍历的代码示例 

一、数据准备

Map数据准备

二、迭代示例

1.第一种方式

二次取值方式

2.第二种方式

Iterator遍历

3.第三种方式

entrySet遍历

4.第四种方式

Map.values取值遍历

三、结果展示及总结

不同长度Map迭代结果

结论：

entrySet的方式遍历是效率最高的，因为hashMap内部的存储结构就是基于Entry的数组，在用这种方式进行遍历时，只需要遍历一次即可。

而使用其他方式的时间复杂度可以会提高，

例如：keySet方式，每次都需要通过key值去计算对应的hash,然后再通过hash获取对应的结果值，因此效率较低。

- 谈谈java中遍历Map的几种方法

java中的map遍历有多种方法，

从最早的Iterator，

到java5支持的foreach,

再到java8 Lambda，

先初始化一个map

public class TestMap { public static Map<Integer, Integer> map = new HashMap<Integer, Integer>(); } keySet values 如果只需要map的key或者value，用map的keySet或values方法无疑是最方便的

// KeySet 获取key public void testKeySet() { for (Integer key : map.keySet()) { System.out.println(key); } } // values 获取value public void testValues() { for (Integer value : map.values()) { System.out.println(value); } } keySet get(key) 如果需要同时获取key和value，可以先获取key,然后再通过map的get(key)获取value

需要说明的是，该方法不是最优选择，一般不推荐使用

// keySet get(key) 获取key and value public void testKeySetAndGetKey() { for (Integer key : map.keySet()) { System.out.println(key + ":" + map.get(key)); } } entrySet 通过对map entrySet的遍历，也可以同时拿到key和value，一般情况下，性能上要优于上一种,这一种也是最常用的遍历方法

// entrySet 获取key and value public void testEntry() { for (Map.Entry<Integer, Integer> entry : map.entrySet()) { System.out.println(entry.getKey() + ":" + entry.getValue()); } } Iterator 对于上面的几种foreach都可以用Iterator代替，其实foreach在java5中才被支持，foreach的写法看起来更简洁

但Iterator也有其优势：在用foreach遍历map时，如果改变其大小，会报错，但如果只是删除元素，可以使用Iterator的remove方法删除元素

// Iterator entrySet 获取key and value public void testIterator() { Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); while (it.hasNext()) { Map.Entry<Integer, Integer> entry = it.next(); System.out.println(entry.getKey() + ":" + entry.getValue()); // it.remove(); 删除元素 } } Lambda java8提供了Lambda表达式支持，语法看起来更简洁，可以同时拿到key和value，不过，经测试，性能低于entrySet,所以更推荐用entrySet的方式

// Lambda 获取key and value public void testLambda() { map.forEach((key, value) -> { System.out.println(key + ":" + value); }); } 简单性能测试 用10万条数据，做了一个简单性能测试，数据类型为Integer，map实现选取HashMap

static { for (int i = 0; i < 100000; i++) { map.put(i, 1); } } 测试结果如下：

KeySet： 392 Values： 320 keySet get(key)： 552 entrySet： 465 entrySet Iterator：508 Lambda： 536 需要说明的是，map存储的数据类型，map的大小，以及map的不同实现方式都会影响遍历的性能，所以该测试结果仅供参考

总结 如果只是获取key，或者value，推荐使用keySet或者values方式

如果同时需要key和value推荐使用entrySet

如果需要在遍历过程中删除元素推荐使用Iterator

如果需要在遍历过程中增加元素，可以新建一个临时map存放新增的元素，等遍历完毕，再把临时map放到原来的map中 

----------------------------------------------------------------------------------------------

- HDFS的底层结构
HDFS 采用Master/Slave的架构来存储数据

- 流式访问数据（数据批处理）
采用Master-Slaver模式： HDFS集群，由分布在多个机架上的大量DataNode组成，不同机架之间节点通过交换机通信 元数据：指HDFS文件系统中，文件和目录的属性信息。HDFS实现时，采用了 镜像文件（Fsimage） + 日志文件（EditLog）的备份机制。

- Hive的内部表和外部表
内部表hive 外部表HDFS

- spark相比于Hadoop的优点
离线流式数据

Strom/flink 实时数据

反射机制
Java的反射（reflection）机制是指在程序的运行状态中，可以构造任意一个类的对象，可以了解任意一个对象所属的类，可以了解任意一个类的成员变量和方法，可以调用任意一个对象的属性和方法。这种动态获取程序信息以及动态调用对象的功能称为Java语言的反射机制。反射被视为动态语言的关键。

对于一个字节码文件.class，虽然表面上我们对该字节码文件一无所知，但该文件本身却记录了许多信息。Java在将.class字节码文件载入时，JVM将产生一个java.lang.Class对象代表该.class字节码文件，从该Class对象中可以获得类的许多基本信息，这就是反射机制。所以要想完成反射操作，就必须首先认识Class类

Class类是一个比较特殊的类，它是反射机制的基础，Class类的对象表示正在运行的Java程序中的类或接口，也就是任何一个类被加载时，即将类的.class文件（字节码文件）读入内存的同时，都自动为之创建一个java.lang.Class对象。Class类没有公共构造方法，其对象是JVM在加载类时通过调用类加载器中的defineClass（）方法创建的，因此不能显式地创建一个Class对象。通过这个Class对象，才可以获得该对象的其他信

反射机制中除了上面介绍的java.lang包中的Class类之外，还需要java.lang.reflect包中的Constructor类、Method类、Field类和Parameter类。Java 8以后在java.lang.reflect包中新增了一个Executable抽象类，该类对象代表可执行的类成员。

- 线程安全和非线程安全 

线程安全：加锁 Vector HashTable

线程安全：同步synchronized

非线程安全：脏数据
ArrayList
HashMap
springboot的模板引擎
thymeleaf Freemarker

JSP

- 类加载机制

编译class文件
类加载器加载到JVM中
二进制数据读入内存
运行方法区heap、stack创建class对象

- 垃圾回收机制的算法
标记清除
复制算法
分代收集
引用计数
异步模式的
future模式
promise模式

- 线程池的实现方式有哪几种
ThreadPoolExecutor

1. concurrent包
newCacheThreadPool
newSingleThreadle
查询一个选周老师课程的学生的姓名、学号

求平均成绩代码

求成绩从高到低排序代码

JSP的

- Spring默认的日志有哪些

Springboot常用的日志

springboot的模版引擎

- Mybatis一级缓存和二级缓存

sqlSession
applicaion：并序列化
mybatis—configure.xml开启二级缓存

- flume采集数据的原理

日志收集

source

channnel

sink

- kafka与flume的区别

分布式发布订阅消息

Broker topic 选举

zookeeper partition

- git分支管理

- 为什么选择netty框架，有哪些优点，相类似框架有哪些

异步事件驱动

BIO NIO 内存池缓冲区域

Future

Callback

Event 传输快

- 为什么MQTT中间件

消息队列 发布订阅

TCP/IP publisher

Broker

Subscribe

固定头 可变头 消息体

payload

- zookeeper是做什么用的

文件系统

监听通知机制

实例IP地址不同

cfg文件

master选举

- nginx是如何配置的

HTTP 和反向代理

负载均衡 轮询

- OpenTSDB数据存储原理

底层是HBase服务器

tsdb tsdb-uid

- 如何实现flume、Kafka的数据监控

- Mybatis如何实现一级缓存和二级缓存

servlet structs

- 常用linux命令

- 上传文件的框架

bootstrap
uploadhandler？


______________________________________________

- redis中的五种数据结构

关于Redis 

redis是C语言编写的一个kv存储系统，非常快的非关系远程内存数据库。

它支持包括String、List、Set、Zset、hash五种数据结构。

通过复制、持久化和客户端分片等特性，用户可以很方便地将redis扩展成一个能够包含数百GB数据和每秒处理上百万次的请求的系统。目前支持多种语言的api，方便用户使用。

redis同时也内置了事务、LUA脚本、复制等功能，提供两种持久化选项，一种是每隔一段时间将数据导入到磁盘(快照模式)，

另一种是追加命令到日志中(AOF模式)。如果只是作为高效的内存数据库使用也可以关闭持久化功能。通过哨兵(sentinel)和自动分区(Cuuster)的方式可以提高redis服务器的高可用性。

与关系型数据库相比，redis的命令请求不需要经过查询分析器或查询优化器进行处理，也避免了更新数据时引起的随机读\写，这些慢操作。它直接读写内存中的数据，并且数据是按照一定的数据结构存储的。所以它的速度非常快。

五种数据结构 字符串(String)        

键(key)------值(value) (字符串格式),

字符串拥有一些操作命令，如：get set del 

还有一些比如自增或自减操作等等。

redis是使用C语言开发，但C中并没有字符串类型，只能使用指针或符数组的形式表示一个字符串，所以redis设计了一种简单动态字符串(SDS[Simple Dynamic String])作为底实现：

定义SDS对象，此对象中包含三个属性：

len buf中已经占有的长度(表示此字符串的实际长度) free buf中未使用的缓冲区长度 buf[] 实际保存字符串数据的地方 所以取字符串的长度的时间复杂度为O(1)，另，buf[]中依然采用了C语言的以\0结尾可以直接使用C语言的部分标准C字符串库函数。

空间分配原则：当len小于IMB（1024*1024）时增加字符串分配空间大小为原来的2倍，当len大于等于1M时每次分配 额外多分配1M的空间。

由此可以得出以下特性：

redis为字符分配空间的次数是小于等于字符串的长度N，而原C语言中的分配原则必为N。降低了分配次数提高了追加速度，代价就是多占用一些内存空间，且这些空间不会自动释放。 二进制安全的 高效的计算字符串长度(时间复杂度为O(1)) 高效的追加字符串操作。

列表(List)         

 redis对键表的结构

一个列表结构可以有序地存储多个字符串，拥有例如：lpush lpop rpush rpop等等操作命令。

列表是使用ziplist和linkedlist实现的

当列表对象同时满足以下两个条件时，列表对象使用ziplist编码：

列表对象保存的所有字符串元素的长度都小于64字节 列表对象保存的元素数量小于512个 当有任一条件 不满足时将会进行一次转码，使用linkedlist。

重新引入了一个quicklist的数据结构，列表的底层都是由quicklist实现的，它结合了ziplist和linkedlist的优点。

按照原文的解释这种数据结构是【A doubly linked list of ziplists】意思就是一个由ziplist组成的双向链表。那么这两种数据结构怎么样结合的呢？

ziplist的结构

由表头和N个entry节点和压缩列表尾部标识符zlend组成的一个连续的内存块。然后通过一系列的编码规则，提高内存的利用率，主要用于存储整数和比较短的字符串。可以看出在插入和删除元素的时候，都需要对内存进行一次扩展或缩减，还要进行部分数据的移动操作，这样会造成更新效率低下的情况。

这篇文章对ziplist的结构讲的还是比较详细的：

https://blog.csdn.net/yellowriver007/article/details/79021049

linkedlist的结构

意思为一个双向链表，和普通的链表定义相同，每个entry包含向前向后的指针，当插入或删除元素的时候，只需要对此元素前后指针操作即可。所以插入和删除效率很高。但查询的效率却是O(n)[n为元素的个数]。

了解了上面的这两种数据结构，我们再来看看上面说的“ziplist组成的双向链表”是什么意思？实际上，它整体宏观上就是一个链表结构，只不过每个节点都是以压缩列表ziplist的结构保存着数据，而每个ziplist又可以包含多个entry。也可以说一个quicklist节点保存的是一片数据，而不是一个数据。总结：

整体上quicklist就是一个双向链表结构，和普通的链表操作一样，插入删除效率很高，但查询的效率却是O(n)。不过，这样的链表访问两端的元素的时间复杂度却是O(1)。所以，对list的操作多数都是poll和push。 每个quicklist节点就是一个ziplist，具备压缩列表的特性。 在redis.conf配置文件中，有两个参数可以优化列表：

list-max-ziplist-size 表示每个quicklistNode的字节大小。默认为-2 表示8KB list-compress-depth 表示quicklistNode节点是否要压缩。默认是0 表示不压缩

哈希(hash)         redis的散列可以存储多个键 值 对之间的映射，散列存储的值既可以是字符串又可以是数字值，并且用户同样可以对散列存储的数字值执行自增操作或者自减操作。散列可以看作是一个文档或关系数据库里的一行。hash底层的数据结构实现有两种：

一种是ziplist，上面已经提到过。当存储的数据超过配置的阀值时就是转用hashtable的结构。这种转换比较消耗性能，所以应该尽量避免这种转换操作。同时满足以下两个条件时才会使用这种结构： 当键的个数小于hash-max-ziplist-entries（默认512） 当所有值都小于hash-max-ziplist-value（默认64） 另一种就是hashtable。这种结构的时间复杂度为O(1)，但是会消耗比较多的内存空间。

集合(Set)          redis的集合和列表都可以存储多个字符串，它们之间的不同在于，列表可以存储多个相同的字符串，而集合则通过使用散列表（hashtable）来保证自已存储的每个字符串都是各不相同的(这些散列表只有键，但没有与键相关联的值)，redis中的集合是无序的。还可能存在另一种集合，那就是intset，它是用于存储整数的有序集合，里面存放同一类型的整数。共有三种整数：int16_t、int32_t、int64_t。查找的时间复杂度为O(logN)，但是插入的时候，有可能会涉及到升级（比如：原来是int16_t的集合，当插入int32_t的整数的时候就会为每个元素升级为int32_t）这时候会对内存重新分配，所以此时的时间复杂度就是O(N)级别的了。注意：intset只支持升级不支持降级操作。

intset在redis.conf中也有一个配置参数set-max-intset-entries默认值为512。表示如果entry的个数小于此值，则可以编码成REDIS_ENCODING_INTSET类型存储，节约内存。否则采用dict的形式存储。

有序集合(zset)         有序集合和散列一样，都用于存储键值对：有序集合的键被称为成员（member),每个成员都是各不相同的。有序集合的值则被称为分值（score），分值必须为浮点数。有序集合是redis里面唯一一个既可以根据成员访问元素(这一点和散列一样),又可以根据分值以及分值的排列顺序访问元素的结构。它的存储方式也有两种：

是ziplist结构。           与上面的hash中的ziplist类似，member和score顺序存放并按score的顺序排列

另一种是skiplist与dict的结合。          skiplist是一种跳跃表结构，用于有序集合中快速查找，大多数情况下它的效率与平衡树差不多，但比平衡树实现简单。redis的作者对普通的跳跃表进行了修改，包括添加span\tail\backward指针、score的值可重复这些设计，从而实现排序功能和反向遍历的功能。

一般跳跃表的实现，主要包含以下几个部分：

表头（head）：指向头节点 表尾（tail）：指向尾节点 节点（node）：实际保存的元素节点，每个节点可以有多层，层数是在创建此节点的时候随机生成的一个数值，而且每一层都是一个指向后面某个节点的指针。 层（level）：目前表内节点的最大层数 长度（length）：节点的数量。 跳跃表的遍历总是从高层开始，然后随着元素值范围的缩小，慢慢降低到低层。

跳跃表的实现原理可以参考：https://blog.csdn.net/Acceptedxukai/article/details/17333673

前面也说了，有序列表是使用skiplist和dict结合实现的，skiplist用来保障有序性和访问查找性能，dict就用来存储元素信息，并且dict的访问时间复杂度为O(1)。

应用场景 redis一般应用场景 缓存会话（单点登录） 分布式锁，比如：使用setnx 各种排行榜或计数器 商品列表或用户基础数据列表等 使用list作为消息对列 秒杀，库存扣减等

五种类型的应用场景 String，redis对于KV的操作效率很高，可以直接用作计数器。例如，统计在线人数等等，另外string类型是二进制存储安全的，所以也可以使用它来存储图片，甚至是视频等。 hash，存放键值对，一般可以用来存某个对象的基本属性信息，例如，用户信息，商品信息等，另外，由于hash的大小在小于配置的大小的时候使用的是ziplist结构，比较节约内存，所以针对大量的数据存储可以考虑使用hash来分段存储来达到压缩数据量，节约内存的目的，例如，对于大批量的商品对应的图片地址名称。比如：商品编码固定是10位，可以选取前7位做为hash的key,后三位作为field，图片地址作为value。这样每个hash表都不超过999个，只要把redis.conf中的hash-max-ziplist-entries改为1024，即可。 list，列表类型，可以用于实现消息队列，也可以使用它提供的range命令，做分页查询功能。 set，集合，整数的有序列表可以直接使用set。可以用作某些去重功能，例如用户名不能重复等，另外，还可以对集合进行交集，并集操作，来查找某些元素的共同点 zset，有序集合，可以使用范围查找，排行榜功能或者topN功能。

总结        本章介绍了redis的五种数据结构和它们使用的底层存储原理，为了达到节省内存和快速访问的目的每种数据结构可能有两种存储和访问结构，在必要的时候会由一种结构转换成另一种结构，但这个转换的过程会消耗系统性能和内存空间的，所以在使用的过程中需要注意这些配置参数，开发中尽量避免达到这些峰值，使得redis能够持续的提供高效的服务。 ———————————————— 版权声明：本文为CSDN博主「至臻于勤-大道至简」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。 原文链接：https://blog.csdn.net/xpsallwell/article/details/84030285


________________________________


- IOC  全称为 Inversion of Control “控制反转” == DI（Dependency Injection）,即依赖注入。



谁控制谁 
控制什么 
为何是反转 
哪些方面反转了 

IOC ，Spring IOC 容器来负责对象的生命周期和对象之间的关系


已找女朋友为例（一般情况下我们是如何来找女朋友的呢？首先我们需要根据自己的需求（漂亮、身材好、性格好）找一个妹子，然后到处打听她的兴趣爱好、微信、电话号码，然后各种投其所好送其所要，最后追到手。如下：

/**

年轻小伙子 */
 
 public class YoungMan { 

private BeautifulGirl beautifulGirl;

YoungMan(){ 

 beautifulGirl = new BeautifulGirl(); }

public void setBeautifulGirl(BeautifulGirl beautifulGirl) 
{ this.beautifulGirl = beautifulGirl; }

public static void main(String[] args){ 
YoungMan you = new YoungMan(); 
BeautifulGirl beautifulGirl = new BeautifulGirl("你的各种条件"); 
beautifulGirl.setxxx("各种投其所好");

 you.setBeautifulGirl(beautifulGirl);
} } 

如果我们需要某个对象，一般都是采用这种直接创建的方式(new BeautifulGirl())，

这个过程复杂而又繁琐，而且我们必须要面对每个环节，同时使用完成之后我们还要负责销毁它，在这种情况下我们的对象与它所依赖的对象耦合在一起。

其实我们需要思考一个问题？我们每次用到自己依赖的对象真的需要自己去创建吗？

我们依赖对象其实并不是依赖该对象本身，而是依赖它所提供的服务，只要在我们需要它的时候，它能够及时提供服务即可，

至于它是我们主动去创建的还是别人送给我们的，其实并不是那么重要。再说了，相比于自己千辛万苦去创建它还要管理、善后而言，直接有人送过来是不是显得更加好呢？

这个给我们送东西的“人” 就是 IoC，在上面的例子中，它就相当于一个婚介公司，作为一个婚介公司它管理着很多男男女女的资料，

当我们需要一个女朋友的时候，直接跟婚介公司提出我们的需求，婚介公司则会根据我们的需求提供一个妹子给我们，我们只需要负责谈恋爱，生猴子就行了。

诚然，作为婚介公司的 IoC 帮我们省略了找女朋友的繁杂过程，将原来的主动寻找变成了现在的被动接受（符合我们的要求），更加简洁轻便。

直接有人把现成的送过来，多么美妙的事情啊。所以，简单点说，IoC 的理念就是让别人为你服务


在没有引入 IoC 的时候，被注入的对象直接依赖于被依赖的对象，

有了 IoC 后，两者及其他们的关系都是通过 Ioc Service Provider 来统一管理维护的。被注入的对象需要什么，直接跟 IoC Service Provider 打声招呼，

后者就会把相应的被依赖对象注入到被注入的对象中，从而达到 IOC Service Provider 为被注入对象服务的目的。



所以 IoC 就是这么简单！原来是需要什么东西自己去拿，现在是需要什么东西让别人（IOC Service Provider）送过来

现在在看上面那四个问题，答案就显得非常明显了:

谁控制谁：在传统的开发模式下，我们都是采用直接 new 一个对象的方式来创建对象，也就是说你依赖的对象直接由你自己控制，

但是有了 IOC 容器后，则直接由 IoC 容器来控制。所以“谁控制谁”，当然是 IoC 容器控制对象。 


控制什么：控制对象。 

为何是反转：没有 IoC 的时候我们都是在自己对象中主动去创建被依赖的对象，这是正转。

但是有了 IoC 后，所依赖的对象直接由 IoC 容器创建后注入到被注入的对象中，依赖的对象由原来的主动获取变成被动接受，所以是反转。 

哪些方面反转了：所依赖对象的获取被反转了。 妹子有了，但是如何拥有妹子呢？这也是一门学问。

可能你比较牛逼，刚刚出生的时候就指腹为婚了。 

大多数情况我们还是会考虑自己想要什么样的妹子，所以还是需要向婚介公司打招呼的。 

还有一种情况就是，你根本就不知道自己想要什么样的妹子，直接跟婚介公司说，我就要一个这样的妹子。 

所以，IOC Service Provider 为被注入对象提供被依赖对象也有如下几种方式：

构造方法注入、stter方法注入、接口注入。

构造器注入

构造器注入，是被注入的对象通过在其构造方法中声明依赖对象的参数列表，让外部知道它需要哪些依赖对象。

YoungMan(BeautifulGirl beautifulGirl){
 this.beautifulGirl = beautifulGirl; } 
 
 构造器注入方式比较直观，对象构造完毕后就可以直接使用，这就好比你出生你家里就给你指定了你媳妇。

setter 方法注入

对于 JavaBean 对象，是通过 getter 和 setter 方法来访问和设置对象的属性。

所以，当前对象只需要为其所依赖的对象提供相对应的 setter 方法，就可以通过该方法将相应的依赖对象设置到被注入对象中。如下：

public class YoungMan { 

private BeautifulGirl beautifulGirl;

public void setBeautifulGirl(BeautifulGirl beautifulGirl) {
    this.beautifulGirl = beautifulGirl;
}
} 

相比于构造器注入，setter 方式注入会显得比较宽松灵活些，它可以在任何时候进行注入（当然是在使用依赖对象之前），

这就好比你可以先把自己想要的妹子想好了，然后再跟婚介公司打招呼，你可以要林志玲款式的，赵丽颖款式的，甚至凤姐哪款的，随意性较强。

接口方式注入

接口方式注入显得比较霸道，因为它需要被依赖的对象实现不必要的接口，带有侵入性。一般都不推荐这种方式。


Resource体系

Resource，对资源的抽象，它的每一个实现类都代表了一种资源的访问策略，如ClasspathResource 、 URLResource ，FileSystemResource 等。



有了资源，就应该有资源加载，Spring 利用 ResourceLoader 来进行统一资源加载，类图如下：



BeanFactory 体系

BeanFactory 是一个非常纯粹的 bean 容器，它是 IOC 必备的数据结构，其中 BeanDefinition 是她的基本结构，它内部维护着一个 BeanDefinition map ，并可根据 BeanDefinition 的描述进行 bean 的创建和管理。



BeanFacoty 有三个直接子类 ListableBeanFactory、HierarchicalBeanFactory 和 AutowireCapableBeanFactory，DefaultListableBeanFactory 为最终默认实现，它实现了所有接口。

Beandefinition 体系

BeanDefinition 用来描述 Spring 中的 Bean 对象。



BeandefinitionReader体系

BeanDefinitionReader 的作用是读取 Spring 的配置文件的内容，并将其转换成 Ioc 容器内部的数据结构：BeanDefinition。


ApplicationContext体系

这个就是大名鼎鼎的 Spring 容器，它叫做应用上下文，与我们应用息息相关，她继承 BeanFactory，所以它是 BeanFactory 的扩展升级版，如果BeanFactory 是屌丝的话，那么 ApplicationContext 则是名副其实的高富帅。由于 ApplicationContext 的结构就决定了它与 BeanFactory 的不同，其主要区别有：

继承 MessageSource，提供国际化的标准访问策略。 继承 ApplicationEventPublisher ，提供强大的事件机制。 扩展 ResourceLoader，可以用来加载多个 Resource，可以灵活访问不同的资源。 对 Web 应用的支持。 下图来源：https://blog.csdn.net/yujin753/article/details/47043143

spring-201805101004

是 Spring IoC 中最核心的部分
