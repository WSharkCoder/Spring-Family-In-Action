# ErrorCode-Demo

本示例讨论Spring 统一错误码问题！

## Spring JDBC异常

无论使用何种数据访问方式，都能使用一样的异常DataAccessException.

为什么Spring能处理不同数据库的错误码呢？

统一配置所有数据库的错误码

Spring 通过SQLErrorCodeSQLExceptionTranslator解析错误码

ErrorCode的定义

+ 官方错误 org/springframework/jdbc/support/sql-error-codes.xml
+ 自定义错误码 Classpath/sql-error-codes.xml
