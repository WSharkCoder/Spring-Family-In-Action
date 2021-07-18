# SpringBucks

本项目是极客时间玩转Spring课程中的项目！本项目的很多内容也来源于本课程中:

`https://gitee.com/geektime-geekbang/geektime-spring-family`

## 项目需求说明

项目功能如下：

![随课项目drawio](https://gitee.com/wsharkcoder/img/raw/master/img/%E9%9A%8F%E8%AF%BE%E9%A1%B9%E7%9B%AEdrawio.png)

技术流程:

![随课项目-技术需求](https://gitee.com/wsharkcoder/img/raw/master/img/%E9%9A%8F%E8%AF%BE%E9%A1%B9%E7%9B%AE-%E6%8A%80%E6%9C%AF%E9%9C%80%E6%B1%82.png)

项目实体:

+ 咖啡、订单、顾客、 服务员，咖啡师

订单状态:

![订单状态](https://gitee.com/wsharkcoder/img/raw/master/img/%E8%AE%A2%E5%8D%95%E7%8A%B6%E6%80%81.png)

## 项目答疑

#### 关于支付部分

Float/Double类型表示Money是不准确的，而采用金融领域的Joda-Money中的对象来定义Money：

```xml
        <!--金融Money包-->
<dependency>
    <groupId>org.joda</groupId>
    <artifactId>joda-money</artifactId>
    <version>1.0.1</version>
</dependency>
        <!--类型映射包-->
<dependency>
<groupId>org.jadira.usertype</groupId>
<artifactId>usertype.core</artifactId>
<version>6.0.1.GA</version>
</dependency>
```

## 企业中项目结构

### 多数据源、分库分表、读写分离的关系

#### 几种常见情况

+ 系统需要访问几个完全不同的数据库
+ 系统需要访问同一个库的主库和备库
+ 系统需要访问一组做了分库分表的数据库

![](https://gitee.com/wsharkcoder/img/raw/master/img/%E5%A4%9A%E6%95%B0%E6%8D%AE%E6%BA%90.png)

![](https://gitee.com/wsharkcoder/img/raw/master/img/%E4%B8%BB%E5%89%AF%E5%BA%93.png)

数据库中间件的使用情况

+ 中间件连接主副库

![数据库中间件](https://gitee.com/wsharkcoder/img/raw/master/img/%E6%95%B0%E6%8D%AE%E5%BA%93%E4%B8%AD%E9%97%B4%E4%BB%B6.png)

+ 分库分表

![分库分表](https://gitee.com/wsharkcoder/img/raw/master/img/%E5%88%86%E5%BA%93%E5%88%86%E8%A1%A8.png)

#####   

## TODO List

+ Spring事务的传播特性 REQUIRES_NEW & NESTED 两种事务传播特性的区别
+ Druid监控的配置/慢SQL配置/生产环境避免打开监控的Servlet?/不要开启removeAbandoned?/ testXXX的使用影响性能?
