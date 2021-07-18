# PageHelper-Demo

本示例演示如何使用Mybatis-PageHelper分页插件.

#### 官网

`https://pagehelper.github.io/`

#### 常用配置

```properties
#配置RowBounds类中offset属性作为页码
pagehelper.offset-as-page-num=true
#页码小于0时提示相应信息
pagehelper.reasonable=true
#页码等于0时查询所有数据
pagehelper.page-size-zero=true
#方法参数支持
pagehelper.support-methods-arguments=true
```