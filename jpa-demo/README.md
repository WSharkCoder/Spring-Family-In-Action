# JPA-DEMO

本示例主要演示如何使用Spring Data JPA!

## JPA注解

### 实体注解

`@Entity`

标注实体

`@MappedSuperClass`

标注某类实体的父类

`@Table(name)`

标注实体对应的表

### 主键

`@Id`

标注主键

`@GeneratedValue(strategy,generator)`

标注自增主键以及自增主键生成策略以及生成器

`@SequenceGenerator(name,sequenceName)`

标注序列

### 映射相关注解

`@Column(name,nullable, length,insertable,updatable)`

标注字段(名字，是否为空，长度)

`@JoinTable(name)` / `@JoinColumn(name)`

标注表间关联

### 关系

`@OneToOne`/`@OneToMany` /`@ManyToOne`/`@ManyToMany`

标注表间关系

`@OrderBy`

标注查询顺序

## JPA Repository方法名(JAP通过方法名判断执行操作)

Repository<T,ID>接口

`CrudRepository <T,ID>`

`PagingAndSortingRepository<T,ID>`

`JpaRepository<T,ID>`

根据方法名查询

`find..By..`/ `read...By..`/  `query...By...`/`get...By...`

`count...By...`

`...OrderBy...[Asc/Desc]`

`And/Or/IgnoreCase`

`Top/First/Distinct`

分页查询

`PagingAndSortingRepository<T,ID>`

`Pageable/Sort`

`Slice<T>/Page<T>`

## Repository是如何从接口变成Bean的？Repository Bean是如何创建的？

#### JpaRepositoriesRegistrar

+ 激活了@EnableJpaRepositories
+ 返回了JpaRepositoryConfigExtension

#### RepositoryBeanDefinitionRegistrarSupport.registerBeanDefinitions

+ 注册 Repository Bean(类型是JpaRepositoryFactoryBean)

#### RepositoryConfigurationExtensionSupport.getRepositoryConfigurations

+ 取得Repository配置

#### JpaRepositoryFactory.getTargetRepository

+ 创建Repository

### 接口方法是如何被实现的

#### RepositoryFactorySupport.getRepository添加Advice

+ DefaultMethodInvokingMethodInterceptor
+ QueryExecutorMethodInterceptor

#### AbstractJpaQuery.execute 执行具体的查询

#### 语法解析在Part中