# Programmatic-Transaction-Demo

本示例主要关于Spring编程式事务！

## Spring编程式事务

PlatformTransactionManager 事务统一接口中包括:

+ DataSourceTransactionManager
+ HibernateTransactionManager
+ JtaTransactionManager

```java 
public interface PlatformTransactionManager extends TransactionManager {
    TransactionStatus getTransaction(@Nullable TransactionDefinition var1) throws TransactionException;

    void commit(TransactionStatus var1) throws TransactionException;

    void rollback(TransactionStatus var1) throws TransactionException;
}
```

TransactionDefinition 可以定事务的特性包括:

+ Propagation 转播特性
+ Isolation 隔离性
+ Timeout 事务超时
+ Read-only status只读状态

TODO

+ Spring中含有7中转播特性？
+ Spring事务隔离特性？

Spring编程式事务主要通过TransactionTemplate,TransactionCallback以及TransactionCallbackWithoutResult类。



