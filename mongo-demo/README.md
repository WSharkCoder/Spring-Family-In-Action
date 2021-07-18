## NOSQL概要

NOSql数据库主要分为四大类：K-V型（Redis、Memcache） 文档型（MongoDB、Couchbase） 列存储 （HBase 、Cassandra）图数据库（ Neo4j)

## MongoDB

### 官网

`https://www.mongodb.com/`

### Spring对MongoDB的支持

+ Spring Data MongoDB
+ MongoTemplate
+ Repository支持

### Spring Data MongoDB 的基本使用

##### 注解

+ @Document
+ @Id

##### MongoTemplate

+ save / remove
+ Criteria / Query / Update

#### 初始化MongoDB 的库及权限

##### 创建库

```shell
> use springbucks;
switched to db springbucks

```

##### 创建用户

```shell
> db.createUser(
	{
		user:"springbucks",
		pwd:"springbucks",
		roles:[
			{role:"readWrite",db:"springbucks"}
		]
	}
)
> show users;
{
        "_id" : "springbucks.springbucks",
        "userId" : UUID("10091347-bd96-4e3b-babe-46f50c08da51"),
        "user" : "springbucks",
        "db" : "springbucks",
        "roles" : [
                {
                        "role" : "readWrite",
                        "db" : "springbucks"
                }
        ],
        "mechanisms" : [
                "SCRAM-SHA-1",
                "SCRAM-SHA-256"
        ]
}
```

##### 常见操作

```properties
#查看数据集
> show collections;
coffee
#查看数据
> db.coffee.find();
{ "_id" : ObjectId("60edb38395cbcf2fec2de09d"), "name" : "espresso", "price" : { "money" : { "currency" : { "code" : "CNY", "numericCode" : 156, "decimalPlaces" : 2 }, "amount" : "20.00" } }, "createTime" : ISODate("2021-07-13T15:38:41.985Z"), "updateTime" : ISODate("2021-07-13T15:38:42.420Z"), "_class" : "cn.wsharkcoder.mongodemo.model.Coffee" }

```

