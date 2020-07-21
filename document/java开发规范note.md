编程规约
1. 命名不能以_和$开始结束
2. 类名使用UpperCamelCase风格，遵从驼峰形式
3. 方法名、参数名、成员变量、局部变量都统一使用lowerCamelCase风格，遵从驼峰形式
    
    localValue
    getHttpMessage()
    
4. 常量名全部大写，单词间下划线隔开 MAX_COUNT
5. 抽象类名使用Abstract或Base开头，异常类Exception结尾，测试类Test结尾
6. 中括号是数组的一部分，数组定义String[] args
7. POJO类中布尔类型的变量，不加is
    
    isDelete
8. 包名小写，点分隔符仅一个单词
9. 模块、接口、类、方法使用了设计模式，命名体现具体模式 
    public class OrderFactory
10. 接口类方法和属性不要加任何修饰符（public也不要加），加上javadoc注释，不要在接口里定义变量，
    接口方法签名 void f();
    接口基础常量：String COMMANY = "gsww"；
11. 接口和实现类命名：
    （1）Service和DAO类，基于SOA，暴露出来的服务一定是接口，内部实现类用Impl后缀与接口区别
        CacheServiceImpl实现CacheService接口
    （2）形容能力的接口，对应形容词做接口名（-able）
        AbstractTranslator实现Translatable
12. 枚举类名Enum后缀，枚举成员名称全部大写，单词间下划线
    枚举是特殊的常量类，构造方法强制私有
    ProcessStatusEnum：SUCCESS/UNKOWN_REASON
13. 各层命名：
    （1）Service/DAO
     1）获取单个对象方法名用get前缀
     2）获取多个对象方法用list做前缀
     3）获取统计值方法用count前缀
     4）插入方法用save/insert前缀
     5）删除方法remove/delete前缀
     6）修改方法update前缀
     （2）领域模型
     1）数据对象：xxxDO，xxx数据表名
     2）数据传输对象：xxxDTO，xxx为业务领域相关名称
     3）展示对象：xxxVO，xxx网页名称
     4）POJO是DO/DTO/BO/VO统称
14. 常量
    (1) 不允许任何魔法值（未经定义的常量）直接出现在代码中
    String key= "Id#gsww"+tradeld；
    cache.put(key,value);         
     
     (2)long或Long初始赋值使用Long不能用long
     
     （3）不要使用一个常量类维护所有常量
     
     （4）常量复用层次：
     
     1） 跨应用共享常量
     
     2）子工程内共享常量：当前工程constant目录下
     
     3）包内共享常量：包下单独constant目录下
     
     4）类内共享常量：private static final
     
     5）应用内共享常量
     
 
 
 
 1.3 代码格式
 
 
 （1）大括号使用约定
 
        大括号为空，使用{},不需换行
        非空代码块：
        1）左大括号前不换行
        2）左大括号后换行
        3）右大括号前换行
        4）右大括号后else不换行，终止的右大括号后换行
 （2）左小括号和字符之间不出现空格，
        右小括号和字符之间无空格
        
 （3）if/for/while/switch/do保留字与括号之间加空格
 （4）任何二目、三目运算符的左右两边都加空格
        =
        &&
 （5） 强制4个空格缩进，禁止tab
 （6）注释双斜线和注释内容之间只有一个空格
    // 注释
 （7） 单行不要超过120个字符，超出换行：
    
        1）第二行对第一行缩进4个空格，第三行不缩进
        2）运算符和下文一起换行
        3）方法调用的点和下文换行
        4）方法调用，多个参数，换行时，在逗号后进行
        5）括号前不要换行
 （8）方法参数在定义和转入时，多个参数后面加空格
    method("a", "b")                        
  (9)  IDE text file encoding 设置utf-8，文件换行用Unix格式，不用windows格式
 
 
 
 
1.4 oop规约



（1）避免一个类的对象引用访问此类的静态变量或静态方法，直接访问类名
 
（2） 所有覆写方法，必须加@Override注解

（3）相同参数类型，相同业务含义，使用Java的可变参数，避免使用Object

（4）外部正在调用或者二方依赖库的接口，不允许修改方法签名，避免影响接口，接口过时加@Deprecated注解

（5）不使用过时类和方法
    decode(String encodeStr)过时
    使用decode(String source,String encode)
 
 (6)Object的equals方法容易抛空指针异常，使用常量或确定有值的对象调用equals
 
    test.equals(object)
 
 （7）所有相同类型的包装类对象之间比较，全部用equals方法比较
 
 （8）基本数据类型和包装数据类型
    
        
        1） 所有POJO类属性包装数据类型
        
        2）RPC方法返回值和参数使用包装数据类型
        
        3）所有局部变量使用基本数据类型
        
        4）POJO类属性没有初值自己显式赋值
        
        5）数据库类型可能是null，自动拆箱，基本数据类型接收NPE风险
        
 （9）DO/DTO/VO等POJO类，不要设定任何默认属性值
 
 （10）序列化类新增属性时，不修改serialVersionUID字段，避免序列化失败，
 如果完全不兼容升级，避免序列化混乱，修改serialVersionUID值
 
 （11）    构造方法禁止加入业务逻辑，初始化逻辑init方法
 
 （12）   POJO类必须toString 方法
 
 （13） 索引访问String spilt方法得到的数组，需要做一个分隔符有无内容的检查，否则抛
        indexOutOfBoundsException
        
 （14） 类内方法定义顺序：
    
    
        公有方法或保护方法 > 私有方法 > getter/setter方法  
        
        
 （15）setter方法中，参数名称与类成员变量名称一致，this.成员名 = 参数名
 
 
 （16）循环体，字符串连接方式，使用StringBuilder的append方法扩展
 
 
 （17） final声明类、成员变量、方法以及本地变量，使用final的情况：
            
            
            
            1） 不允许继承的类String类
            2） 不允许修改引用的域对象，POJO域对象
            3） 不允许重写的方法 POJO的setter方法
            4） 不允许运行过程中重新赋值的局部变量
            5）避免上下文重复使用一个变量，final描述可以强制重新定义一个变量       


（18）类成员和方法访问控制
    
        1） 不允许外部直接new创建对象，构造方法private
        2） 工具类不允许public或default构造方法
        3） 类非static成员变量仅在本类使用，private
        4）类static成员变量仅在本类使用，private
        5）static成员变量，是否为final
        6）类成员方法只供类内部调用，private
        
        
        private想删除就删除
 
 
 
1.5 集合处理


（1）hashcode 和equals 处理
        
        
        1）重写equals，重写hashcode
        2）set存储不重复对象，hashcode和equals判断，set存储对象重写        
        3）自定义对象为Map的键，那么必须重写hashcode和equals
        4）String 重写了hashcode和equals方法，String对象可以作为key来使用
 （2）ArrayList的subList的结果不可强转为ArrayList，否则ClassCastException异常
    subList返回的是ArrayList的 
    
 （3）使用工具类ArrayList()把数组转换成集合时，不能修改集合相关的方法，add/remove/clear方法
 （4）泛型通配符<? extends T> 来接收返回的数据，不能用add，<? super T>不能用get
 
 （5）不要在foreach循环里进行remove/add操作，remove使用Iterator，对Iterator加锁
 （6）Iterator<String> iterator = list iterator();
        while(iterator.hasNext()){
        String item = iterator.next();
        if(){
        iterator.remove()}}        
 (7)Comparator满足条件：否则Array.sort，Collection.sort报IllegalArgumentException
 
    1）x\y比较结果与y/x结果相反
    2）x>y,y>z,则x>z
    3) x=y 比较结果相同
    
 （8）集合初始化，指定初始值大小
        hashmap使用HashMap(int initialCapcity)初始化
 （9） entry遍历map类集合KV，而不是keySet方式进行遍历
        keySet 一次是转为Iterator对象
        一次是hashmap取出key所对应的value
        而entrySet只是遍历一次就把key、value放在entry中，效率更高   
        Map.foreach
        
        values返回值v值集合，list集合对象
        keySet()返回K值集合，是一个Set集合对象
        entry返回K-V组合集合 、
        
        有序是遍历结果按某种依次排列
        稳定集合遍历次序一定
        ArrayList order/unsort
        Hashmap是unorder/unsort
        TreeSort是order/sort
        
        
 （10）Set唯一，去重操作，List的contains方法进行遍历
 
 
 1.6 并发处理
 
 （1）单例对象保证线程安全
 （2）创建线程或线程池请指定有意义的线程名称
 （3）线程资源通过线程池提供，不允许在应用中自行创建显式创建线程
    
        线程池减少创建和销毁线程所花时间以及系统的资源开销，解决资源不足
        不使用线程池，可能造成系统创建大量同类线程而导致消耗完内存或过度切换
        
 （4）线程池不允许使用Excutors去创建，通过ThreadPoolExcutor方式，规避资源耗尽
        
        
        CachedThreadPool和ScheduledThreadPool允许创建线程数量Integer.MAX_VALUE       
        
 (5) SimpleDateFoemat 线程不安全类，不定义static变量，定义static必须加锁，使用DateUtils
 
 线程安全，使用DateUtils工具类
 
 （6） 高并发锁的性能损耗
        
        能用无锁数据结构，就不用锁
        能用区块锁，就不要锁整个方法体
        能用对象锁，不要用类锁
        
  （7）多个资源、数据库表、对象同时加锁，需要保证加锁顺序，否则死锁
     
  （8）并发修改同一记录，避免更新丢失，需要加锁，应用层加锁，缓存加锁
        数据库层乐观锁，version更新依据
        
 （9）多线程处理定时任务，Timer运行多个TimeTask，只要其中之一没有捕获异常，任务终止                 
   
   （10）CountDownlatch进行异步转同步，每个线程调用countDown方法，线程执行代码注意catch异常         
   
 （11）并发 double-checked locking 实现延迟初始化优化问题，目标属性volatile
 
  （12）volatile解决多线程内存不可见 count++
        LongAdder
  （13）Hashmap 容量 resize高并发 死链 加锁规避
  
  （14）ThreadLocal 无法共享对象 static 修饰 静态变量 
  
 1.7 控制语句
 
 
    - 控制语句 switch case default 终止
   
   - 不参数校验
        
注释

- javadoc /**
/

- 


- 后台输送页面变量 $!(var)     

- Math.random() double Random nextInt nextLong

- System.currentTimeMillis

- 初始化 指定大小



异常日志

- RuntimeException 预先检查

- finally try catch

- runtimeException/ exception/throwable 避免

- 不直接用 Log4j Logback 用SLF4J API

- 15天

- trace/debug/info



单元测试


- AIR
 Automatic 自动化
 Independent 独立性
 Repeatable 可重复
 
- assert

- Mock

- DAO manager Service

- Border 边界 循环边界 特殊取值 

- 自动回滚数据库 脏数据




安全规约



- SQL METAADATA字段值限定 防止SQL注入 禁止字符串拼接访问数据库


- page size 过大 内存溢出

- order by 数据库慢查询

- 任意定向

- SQL注入

- 反序列化注入

工程结构

-  Service

- manager

- DAO

- DO Data Object

- DTO Data Transfer Object

- BO Business Object
- AO

二方库依赖

- GroupID com.{公司/BU}.业务线[子业务线] 最多4级

- ArtifactID 产品线名-模块名

- 不依赖SNAPSHOT

- 禁止子项目pom同GroupId 同ArtifactId 不同version

- pom 依赖<dependencies> 版本仲裁 <dependencymanagement>
          
服务器


- JVM XX: +HeapDumpOutOfMenoryError

- JVM  Xms Xmx 设置一样大小内存


POJO Plain Orinary Java Object



