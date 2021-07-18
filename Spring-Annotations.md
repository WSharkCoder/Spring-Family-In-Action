# Spring 注解

[TOC]

##  Java Config相关注解

`@Configuration`

 标记被注解类为配置类.

`@ImportResource`

注入配置以外(application.properties)的一些xml配置文件的一些信息.

`@ComponentScan`

指定扫描哪些Package下的Bean.

`@Bean`

被注解方法的返回值将置入Spring容器当中.

`@ConfigurationProperties`  

绑定配置文件中的配置信息方便使用.

## Bean 定义相关注解

`@Component` /`@Service`/ `@Repository`

标识组件/服务/数据访问等Bean并注入至 Spring容器中.

`@Controller`/ `@RestController`

 控制器Bean/Restful风格的控制器Bean并自动注入至Spring容器中.

`@RequestMapping`

 映射方法与URL 

## Bean注入相关注解

`@Autowired`/`@Qualifier` / `@Resource`

Spring上下文中按照类型/名字/ 类型和名字等方式查找Bean并注入.

`@Value` 

注入常量