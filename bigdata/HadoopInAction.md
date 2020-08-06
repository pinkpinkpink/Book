# 第一章分布式编程框架

遍历TB/PB级别数据

MapReduce 大规模分布式数据处理

Hadoop集群是同一地点用网络互联的一组通用机器。

HDFS分布式文件系统

比较SQL和Hadoop
1 用键值对（基本的数据单元）代替关系表
2 函数式声明MapReduce代替声明式查询SQl


152 相同程序在MapReduce中的扩展
mapping——获取输入数据将数据单元装入mapper——过滤转换
reducing——处理来自mapper的所有输出——聚合——包含<k,v>巨大列表中

# 第二章 Hadoop

21 hadoop构造模块

NameNode 名字节点 50070

Master/Slave

DataNode 数据节点

Secondary NameNode 次名字节点

监测HDFS集群状态的辅助守护进程

JobTracker 作业跟踪节点

TaskTracker 任务跟踪节点


22 Hadoop集群安装SSH

全分布模式

master
backup
hadoop1



bin/hadoop
bin/hadoop jar



# 第三章 Hadoop组件


31 HDFS文件

HDFS文件系统 可以大数据集100TB在HDFS存储为单个文件

311 基本文件命令

hadoop fs -cmd<args>
hadoop fs -ls 文件列表

添加文件和目录

hadoop fs -put exanple.txt .

检索文件

hadoop fs -cat example.txt 
hadoop fs -tail example.txt

删除文件

hadoop fs -rm example.txt

hadoop fs -help ls

312 编程读写HDFS

322 mapper

Patitioner:重定向Mapper输出




第四章 MapReduce基础程序

Streaming 处理键值对

数据集的汇聚统计Aggregate


第五章 高阶Mapreduce

数据连结的通用框架

DATAJOIN来连结

DistributedCache


半连结 map侧过滤后在reduce侧连结

BLoom filter



第六章 编程

生产集群上的监视和调试

计数器

63 性能调优

631 combiner 减少网络流量提高总体吞吐量

634 JVM重用





第七章 pig编程

数据库输入输出

dump

第八章 管理Hadoop

实际应用设定参数值


从HDFS集群中删减DataNode

感知网络布局和机架设计

多用户作业调度

JObTracker

第九章 云上运行Hadoop

第十章 Pig编程

Pig Latin

filter

union

group

join


Pig可以操作

relational

nested

semistructured

unstructured



Pig面向应用程序设计

处理日志数据

自然语言处理

分析网络图

运行pig
pig -x local

pig -x mapreduce

用户定义函数

Pig 实战 计算相似专利的例子

第十一章 Hive及Hadoop集群


软件仓库

查询

汇总

数据分析

HiveQL

表的结构

TINYINT

SMALLINT

INT

BIGINT

DOUBLE

STRING



1121 Hbase 数据存储系统

十亿行 百万列

使用HDFS作为底层文件系统，完全分布式和高可用

zookeeper 协作服务

katta 索引系统

StumbleUpon 推荐最佳网站

ES2爬虫

HDFS文件命令

hadoop fs -cmd<args>



Hive
