## 项目说明

hello项目是SpringBoot官网上入门示例！

## 项目目录结构

```
hello
├── README.md
├── pom.xml
├── .gitignore
├── /src/
│   ├──/java/
│   │  ├──/cn/wsharkcoder/hello/
│   │     └──HelloApplication
│   └──/resources/
│      └──application.properties
└── /util/
    └──/java/
       └──/cn/wsharkcoder/hello/
          └──application.properties
```

## 开发框架

SpringBoot

## 依赖

> 本文中最重要的部分便是依赖的pom.xml文档部分

通常使用Sprig Initializr插件生成的SpringBoot项目中必然包含`<parent>`标签用以指定父pom.xml文件.

父pom.xml通常的作用:

- 依赖管理
- 设置项目构建插件等

但在企业中通常都有自己定义的Pom.xml文件用以管理依赖版本等，而Maven中又仅支持单继承,那我该如何处理这个问题？

其实可以采用`<dependencyManagement>`并通过pom的方式引入需要的依赖而达到多继承的目的！

pom.xml文件如下:

```xml
<parent>
    <groupId>cn.wsharkcoder</groupId>
    <artifactId>Super-WSharkCoder</artifactId>
    <version>1.0.0.RELEASE</version>
</parent>
<dependencyManagement>
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.2</version>
        <type>pom</type>
        <scope>import</scope>
    </dependency>
</dependencies>
</dependencyManagement>
```