# Multi-DataSource-Demo

本示例主要用来演示双数据源的配置！

## 多数据源配置基本步骤

### `application.properties`配置多数据源信息

```properties
#foo数据库配置
foo.datasource.url=jdbc:h2:mem:foo
foo.datasource.username=sa
foo.datasource.password=
#bar数据库配置
bar.datasource.url=jdbc:h2:mem:bar
bar.datasource.username=sa
bar.datasource.password=
```

### 排除数据源的自动配置类

```java
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        JdbcTemplateAutoConfiguration.class
})
```

### 手动配置数据源与事务Bean

```java

@Bean
@ConfigurationProperties("foo.datasource")
public DataSourceProperties fooDataSourceProperties(){
        return new DataSourceProperties();
        }

@Bean
public DataSource fooDataSource(){
        DataSourceProperties dataSourceProperties=fooDataSourceProperties();
        //打印本数据库URL
        log.info("====");
        log.info("foo datasource: {}",dataSourceProperties.getUrl());
        log.info("====");
        //数据源配置->数据源建造者->构建数据源
        return dataSourceProperties.initializeDataSourceBuilder().build();
        }

@Bean
@Resource
public PlatformTransactionManager fooTxManager(DataSource fooDataSource){
        return new DataSourceTransactionManager(fooDataSource);
        }
```