# Hello

Hello项目是SpringBoot官网入门示例！

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

+ SpringBoot

## POM

直奔主题，通常通过 `Sprig Initializr`构建的项目中都以`spring-boot-starter-parent`作为`Parent POM`的：

```xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.2</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
```

`Parent POM`文件的作用：

+ 引入`Child POM`的公共依赖.
+ 管理依赖版本,避免依赖冲突.

但由于Maven中仅支持单继承, 当企业内部具有自定义`POM`需要继承时，我又该如何引入`SpringBoot`的依赖/依赖管理呢？

Maven官方其实找已经帮我们处理好了这个问题,通过<dependencyManagement>标签以POM方式引入即可：

```xml
<!--企业内部POM-->
<parent>
    <groupId>cn.wsharkcoder</groupId>
    <artifactId>Super-WSharkCoder</artifactId>
    <version>1.0.0.RELEASE</version>
</parent>
<dependencyManagement>
	<dependencies>
    	<dependency>
            <!--外部依赖-->
        	<groupId>org.springframework.boot</groupId>
       		<artifactId>spring-boot-starter-parent</artifactId>
        	<version>2.5.2</version>
        	<type>pom</type>
        	<scope>import</scope>
   		</dependency>
	</dependencies>
</dependencyManagement>
```



## 参考资料

[学Maven，这篇万余字的教程，真的够用了！](https://blog.csdn.net/u012702547/article/details/103558093)

