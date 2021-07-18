# Mybatis-Generator-Demo

本示例演示Mybatis-Generator帮助我们生成所需代码！

## Mybatis Generator能用来干啥？

+ MyBatis 代码生成器
+ 根据数据库生成相关代码
    + POJO
    + Mapper接口
    + SQL Map XML

## Mybatis Generator如何执行？

**命令行**

+ java -jar mybatis-generator-core-x.x.x.jar -configfile generatorConfig.xml

**Maven Plugin(mybatis-generator-maven-plugin)**

+ mvn mybatis-generator:generate
+ ${basedir}/src/main/resources/generatorConfig.xml

**Java程序**

## Mybatis  Generator需要配置些啥？

**generatorConfiguration**
**context**

+ jdbcConnection
+ javaModelGenerator  (Model生成器)
+ sqlMapGenerator(Mapper生成器)
+ javaClientGenerator(ANNOTATEDMAPPER /XMLMAPPER /MIXEDMAPPER) (注解/XML/混合生成器)
+ table

## Mybatis Generator有没有增强插件？

内置插件都在org.mybatis.generator.plugins包中

+ FluentBuilderMethodPlugin (POJO生成时自带Builder构造器)
+ ToStringPlugin  (POJO生成时自带ToString方法)
+ SerializablePlugin  (POJO生成时实现Serializable接口)
+ RowBoundsPlugin（分页操作）
+ ......