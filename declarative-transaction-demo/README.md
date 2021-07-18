# Declarative-transaction-demo
本示例演示SpringBoot声明式事务！

## Spring声明式事务

使用@EnableTransactionManagement注解开启SpringBoot对事务的支持:
```java 
public @interface EnableTransactionManagement {
    boolean proxyTargetClass() default false;

    AdviceMode mode() default AdviceMode.PROXY;

    int order() default 2147483647;
}
```
其中:

+ proxyTargetClass:

  指定被代理类是否有接口,若有则利用反射机制实现代理类，若无接口则使用CGlib对类进行增强.

  默认false,即默认采用CGlib方式进行增强


+ mode: 
  AOP Model的选择 
  默认AdviceModel.PROXY
    

+ order: 
  事务AOP拦截的顺序
  默认最低优先级,也就意味着自定义的AOP级别均可在事务启动后执行.
