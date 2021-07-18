# Mybatis-Demo

本示例中演示如何使用Mybatis!

## Mybatis简单配置

```properties
#配置Mybatis映射文件位置 
mybatis.mapper-locations=classpath*:mapper/**/*.xml
#配置Mybatis类型别名的包名(常见作用于Mapper.xml文件中，替换resultType和parameterType指定POJO时替换前缀包名.)
#<select id="#" resultType="User"/> 其中User等级于cn.wsharkcoder.mybatisdemo.entity.User
mybatis.type-aliases-package=cn.wsharkcoder.mybatisdemo.entity
#设置Mybatis类型转换辅助类的包名(例如，若需要将Decimal类型转成Money类型，则需要TyperHandler来处理.）
#mybatis.type-handlers-package=
#设置Mybatis将下划线类型转成驼峰类型
#mybatis.configuration.map-underscore-to-camel-case=true

```

## Mybatis的定义与扫描

+ @MapperScan 配置扫描
+ @Mapper 定义接口
+ 映射的定义 -- XML 与注解

