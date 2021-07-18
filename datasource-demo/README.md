# DataSource-Demo

本示例主要用来演示SpringBoot自动配置数据源的特性！

## 开发框架

+ SpringBoot
+ H2数据库

## 数据源初始化与数据初始化

SpringBoot启动时将使用`schema.sql`进行数据库初始化，使用`data.sql`进行数据初始化.

此外也可通过`application.properties`配置初始化文件位置,且配置方式`SpringBoot`各个版本各不相同,先查文档再配置.
