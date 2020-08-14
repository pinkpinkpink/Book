# IOC

Inversion of controller

将设计好的对象交给容器

applocationContext.xml中配置Bean

@Controller/service/Respository/Component注解

IOC容器初始化

1. 将所有Bean 实力华为对象（new对象）
2. 将Bean的属性值注入进去（属性赋值）
3. java初始化IOC容器：ApplicationContext context = ClassPathXmlApplicationContext在main()

javaweb初始化IOC容器

expression = execution（）

object target

1. 通知类
2. 业务方法增删改
3. 配置
   1. 定义切入点
   2. 定义通知类advice
   3. pointcut-ref连接 
4. 编写
   1. 业务类、通知纳入容器
   2. 通过注解将对象增加到需要添加扫描器
   3. 签名里面写方法
   4. 声明参数返回值
   5. 注解形式形成AOP

illegalargument

配置类通知

Scheme实现接口

1. public class logAfter
2. 实现类
3. 通知类纳入IOC容器
   
@service

@controller

@compent

@response

# AOP

Aspect Oriented Programming

面向切面

对既有程序定义一个切入点，在前后切入不同执行内容

打开/关闭数据库连接

打开/关闭事务

记录日志

@Aspect

注解将Java定义为切面类

@Point


- 类注解为@Configure

- Schedule定时任务

# 



# NOSQL

## NOSQL-redis

- 添加pom.xml

<dependency>  
          <groupId>org.springframework.boot</groupId>  
          <artifactId>spring-boot-starter-redis</artifactId>  
      </dependency>


## NOSQL-mongddb

## NOSQL-RabbitMQ

## druid数据源

## Mybatis

@Mapper

## Nutz



# 第一章 微服务

微服务

HTTP

功能可拆装

微服务文档

Microservices

分布式部署运维



Spring boot Helloword

浏览器请求

服务器处理请求

RestAPI



1. maven
2. 导入依赖：Springboot官网 statrt
3. main启动
4. controller
5. 打包 java-jar maven-plugin



依赖

1. 功能抽象成starters



注解

1. @springbootConfiguration
2. @Configuaration标注配置类=配置文件=组件容器
3. @EnableAutoConfiguation：META/INF/spring.factories
4. @AutoConfiguation
5. @Import
6. 将自动配置类导入容器中，
7. @Bean

问题：

target文件无法操作


# 第二章 

# 第三章 
日志框架
1. System.out.println("")，将关键数据打印在控制台，写在一个文件
2. 框架记录系统运行信息，日志框架
3. 新增功能：
   1. 异步模式
   2. 自动归档
4. 将以前框架替换为新框架，重新修改之前的相关API
5. JDBC数据库驱动
   1. 统一的接口层：日志抽象abstract层
   2. 给项目中导入具体的日志实现
   3. 日志框架实现抽象层



2⃣️市面常见的日志框架

日志抽象层：（日志门面）

1. Jboss-logging排除
2. log4j
3. SLF4j

日志实现：

1. log4j
2. JUL（java.util.logging)排除
3. Logback

选择：

日志抽象层：SLF4j

日志实现：Logback

Spring：CL

Springboot：SLF4j和Logback


3⃣️SLF4j使用

开发：日志记录方法的调用，不是直接来自调用日志实现类，而是调用日志抽象层的方法

slf4j日志框架的配置文件，配置文件是日志实现类的配置文件

a：（slf4j+logback）、Spring（commmons-logging）、Hibernate（jboss-logging）

详情查看slf4j官网

4⃣️其他日志框架转换为slf4j

如何让系统中所有的日志框架统一到slf4j

1. 将系统中其他框架排除
2. 用中间包替换原有日志框架
3. 使用slf4j其他的实现

日志配置

5⃣️springboot日志关系

依赖之间的关系


右键-Digrams

Springboot使用

1. springboot底层也是slf4j+logback方式进行日志记录
2. springboot其他日志替换成slf4j
3. 中间件replcae包
4. 引入其他框架，把默认的日志框架移除
5. Springboot能自动适配所有日志，底层使用slf4j+logback，引入其他框架，只需要把其他框架

2. 指定配置

logback.spring.xml

切换日志框架

ELK

# 第四章 SpringWeb开发

使用SpringBoot
1. 选中模块
2. 自动配置原理？
   1. @autoconfiguration自动配置组件
   2. @properties配置类的文件信息
3. 业务代码

bootstrap

webjars：以Jar包的方式引入资源


静态资源的映射规则需要再看

访问当前项目下


3. 模版引擎需要在看

页面模版

组装数据

Thymeleaf 官方文档


语法：

1. Th :text 改变当前属性的值

31. SpringMVC自动配置原理

EnableWebMVC全面接管

Configuration扩展配置

拦截器做登陆检

注册Servlet三大组件：

1. servlet
2. Filter
3. Listener

Jetty（长连接）

嵌入式Servlet容器的自动配置原理

tomcat

容器配置修改

EnableServletContainerCustomizerBeanProcessor

添加容器工厂

调用定制器的定制方法

servlet容器启动原理

springboot运行run方法

刷新refreshContext（context）:SpringBoot刷新容器

onfresh

41. Servlet和JSP支持

定制器Serverperporties

Servlet的创建工厂

Tomcat

Jetty

外置Servlet容器

外部安装Tomcat

应用war包


42 Servlet容器

注册组件

1. filter
2. servlet
3. listener

Register

Jetty长连接：聊天

Undertow不支持JSP，并发

Tomcat默认使用

切换：

pom.xml直接引入dependency

Servlet.class Tomcat.class

spring-boot-start-jetty

IOC容器

tomcat

war包

50 Servlet的启动原理


# 第五章 docker

概念

1⃣️容器

1. 镜像启动后的实例//运行镜像产生容器（软件）
2. 镜像是创建容器的模版
3. 搜索镜像 docker search tomcat
4. 拉取 docker pull tomcat
5. 根据镜像启动容器 
6. 操作容器
   1. 运行 docker run --name mytomcat -d tomcat //-d后台运行
   2. 查看运行容器  docker ps -a //-a所有
   3. 停止 docker stop container id/name 
   4. 删除 docker rm container -id //删除处于停止状态
   5. 启动 docker start contianer -id
   6. 端口映射 -p 8888:8080//（虚拟机）即主机端口映射到容器端口 
      1. docker run -d -p 8888:8080
   7. 关闭防火墙 service firewalld status/stop
   8. 容器日志 docker logs container -id
   9. 一个镜像启动多个容器

2⃣️镜像images

1. 仓库用来打包各种镜像
2. 搜索 docker search mysql //docker.hub
3. 拉取 docker pull mysql
4. 列表 docker images
5. 删除 docker rmi image-id

使用docker步骤

1. 查看内核版本centos3.10
   uname -r
2. 启动docker
   systemctl start docker
   systemctl enable docker 开机自启动
3. 停止docker
   stop docker
   
4. yum install docker
5. docker仓库找到镜像
6. docker运行镜像，生成容器
7. docker容器启动停止

网络

service network restart

环境搭建

1. mysql
   1. docker search mysql //docker.hub
   2. docker pull mysql
   3. docker images
   4. docker run -p 3306:3306  --name mysql01 -e MYSQL_ROOT_PASSWORD=password -d mysql
   5. -v /my/custom：/etc/mysql/conf.d文件夹挂载到容器的文件，mysql文件
   6. Character-utf8
   7. Docker ps -a
   8. Docker logs container -id
   9. 
   10. 
2. redis
3. rabbitmq
4. elasticsearch


# 第六章 数据连接

数据访问

JDBC

MyBatis？

Spring Data JPA？

JDBC

Build

run

监听器

schema*sql

jdbcTemplate

druid

1. maven
2. DruidConfig
3. webFilter

MyBatis

1. maven
2. druid
3. javaBean
4. 注解增删改查Mapper（）
5. @Mapper
6. @MapperScan批量

配置

github-mybatis

整合JPA （hibernate）Spring Data

Spring Data

repository

cured操作 create、

# 第七章 启动原理

springApplication

run()

# 第八章 

cache

Spring缓存抽象

1. jcache1.0
2. CacheManager 组件
3. Cache 缓存接口，RedisCache
4. @Cacheable 方法配置，方法的请求参数
5. @CacheEvict 清空
6. @CachePut 调用

环境

1. 连接mysql，导入数据库文件,创建表
2. javabean封装数据
3. 整合mybatis
   1. 配置数据源mysql application.properties
   2. 注解版mybatis
      1. @MappperScan("")
      2. @Cacheable
      3. Cache <key,value>
      4. @Caching

Redis

数据库、缓存、中间件

docker中国

redis.cn

数据结构（5个）：String、list、set、zset、hash

append

# 第九章 消息

Jms

Rabbit

Template

Listener

RabbitMQ

1⃣️概念

AMQP（advanced Message Queue Protocol）

Message

Publisher生产者

Exchange交换器：

1. direct：单播
2. fanout：广播
3. topic：模式匹配
4. headers

Queue容器

Binding绑定Exchange和Queue

Connection Tcp连接

Channel 信道

Consumer取得消息

Broker 消息队列服务器实体

2⃣️RabbitMQ运行机制



3⃣️RabbitMQ整合

1. docker 5672
2. Admin:guest/password:guest
3. 

4⃣️RabbitTemplate发送接收消息&序列化机制


# 第十章 ElasticSearch



ElasticSearch 

Restful

ElasticSearchTemplate

github-jest


SpringDataElasticSearch

# 第十一章 分布式Dubbo

分布式：zookeeper+Dubbo

Springboot+SpringCloud

orm

mvc

rpc

soa

注册中心：zookeeper

分布式服务调用框架：Dubbo

Dubbo

provider

consumer

远程调用

Zookeeper

zkclinet

SpringCloud

分布式

1. 服务发现 Netfix Eureka
2. 负载均衡Ribbon @LoadBalanced
3. 断路器 Hystrix
4. 服务网关 Zuul
5. 分布式配置 Spring Cloud Config
   
注册中心Eureka

服务提供者

消费者

发现服务

# 第十二章 热部署

不重启，自动部署

Spring Loaded

JRebel插件

Spring boot Devtools （推荐）

ctrl+f9

# 第十三章 监控管理

dump

autoconfig

beans

health

trace

mappings

——————————————————————————————————————————————————————————————————

expression = execution（）

object target

1. 通知类
2. 业务方法增删改
3. 配置
   1. 定义切入点
   2. 定义通知类advice
   3. pointcut-ref连接 
4. 编写
   1. 业务类、通知纳入容器
   2. 通过注解将对象增加到需要添加扫描器
   3. 签名里面写方法
   4. 声明参数返回值
   5. 注解形式形成AOP
   
illegalargument

配置类通知

Scheme实现接口

1. public class logAfter
2. 实现类
3. 通知类纳入IOC容器

@service

@controller

@compent

@response





















