# java 学习的一些demo,个人学习的笔记

## 1. java-spi-study01 
java-spi-study01是关于java spi机制学习的demo；  
spi-service 提供Search接口和加载实现Search接口的静态类SearchManager；  
db-search 是b厂商实现的Search功能,依赖spi-service；  
file-seach 是a厂商实现的Seach功能,依赖spi-service；  
spi-invoker 是服务调用方。  
  
### 1.1 SPI简单介绍
SPI(Service Provider Interface)，在java.util.ServiceLoader的文档里有比较详细的介绍。   
简单的总结下java spi机制的思想：我们系统里抽象的各个模块，往往有很多不同的实现方案，比如日志模块的方案，xml解析模块、jdbc模块的方案等。
面向的对象的设计里，我们一般推荐模块之间基于接口编程，模块之间不对实现类进行硬编码。一旦代码里涉及具体的实现类，就违反了可拔插的原则，
如果需要替换一种实现，就需要修改代码。为了实现在模块装配的时候能不在程序里动态指明，这就需要一种服务发现机制。
java spi就是提供这样的一个机制：为某个接口寻找服务实现的机制。
   
### 1.2 SPI具体约定  
当服务的提供者，提供了服务接口的一种实现之后，在jar包的META-INF/services/目录里同时创建一个以服务接口命名的文件。
该文件里就是实现该服务接口的具体实现类。而当外部程序装配这个模块的时候，就能通过该jar包META-INF/services/里的配置文件找到具体的实现类名，
并装载实例化，完成模块的注入。基于这样一个约定就能很好的找到服务接口的实现类，而不需要再代码里制定。
jdk提供服务实现查找的一个工具类：java.util.ServiceLoader。
    
### 1.3 场景  
* common-logging apache最早提供的日志的门面接口。只有接口，没有实现。具体方案由各提供商实现，
发现日志提供商是通过扫描 META-INF/services/org.apache.commons.logging.LogFactory配置文件，
通过读取该文件的内容找到日志提工商实现类。只要我们的日志实现里包含了这个文件，并在文件里制定 LogFactory工厂接口的实现类即可。
  
* jdbc  jdbc4.0以前， 开发人员还需要基于Class.forName("xxx")的方式来装载驱动，jdbc4也基于spi的机制来发现驱动提供商了，
可以通过META-INF/services/java.sql.Driver文件里指定实现类的方式来暴露驱动提供者。


  
## 2. java-websocket-study01
该模块是websocket的一个demo,tomcat版本建议为8.x或以上版本  
只是一个非常简单的demo,仅供学习之用  
js里面判断websocket状态用readyState属性: 
 
| 序号 | 状态值 | 含义说明 |  
| ------ | ------ | ------ |  
| 1 | 0 | 对应常量CONNECTING (numeric value 0) 正在建立连接连接，还没有完成 |  
| 2 | 1 | 对应常量OPEN (numeric value 1) 连接成功建立，可以进行通信 |
| 3 | 2 | 对应常量CLOSING (numeric value 2) 连接正在进行关闭握手，即将关闭 |  
| 4 | 3 | 对应常量CLOSED (numeric value 3) 连接已经关闭或者根本没有建立 |
