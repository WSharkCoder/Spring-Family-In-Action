# Druid-DataSource-Pool-Demo

本示例演示SpringBoot配置阿里`Druid`连接池！

Druid是由Alibaba研发的一款具有强大的监控功能的数据库连接池！ Druid官方网站：`https://github.com/alibaba/druid`

## 依赖

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
    <exclusions>
        <!--排除SpringBoot默认的HiKariCP连接池-->
        <exclusion>
            <groupId>com.zaxxer</groupId>
            <artifactId>HiKariCP</artifactId>
        </exclusion>
    </exclusions>
</dependency>
        <!--Alibaba Druid连接池-->
<dependency>
<groupId>com.alibaba</groupId>
<artifactId>druid-spring-boot-starter</artifactId>
<version>1.1.10</version>
</dependency>
```

**注意**:排除默认HiKariCP连接池！

## `application.properties`配置数据库连接池信息

常见配置如下:

```properties
#配置数据库连接池
#初始的连接池大小
spring.datasource.druid.initial-size=5
#最大活跃连接数
spring.datasource.druid.max-active=5
#最小Idle
spring.datasource.druid.min-idle=5
#Filter配置
spring.datasource.druid.filters=conn,config,stat,slf4j
spring.datasource.druid.connection-properties=config.decrypt=true;config.decrypt.key=${public-key}
spring.datasource.druid.filter.config.enable=true
#获取连接时检查
spring.datasource.druid.test-on-borrow=true
#归还连接时检查
spring.datasource.druid.test-on-return=true
#idle时检查
spring.datasource.druid.test-while-idle=true
public-key=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALS8n
```
## SpringBoot 自动配置数据库连接池
由于SpringBoot自动配置功能可自动配置数据库连接池因此不用再手动代码配置！
## Druid Filter
TODO






