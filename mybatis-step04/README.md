### STEP04 数据源解析与创建以及使用

#### 目的

解析 XML 关于数据源的信息的配置，建立事务管理和连接池的启动和使用，在 DefaultSqlSession 执行 SQL 语句时进行调用。



#### 设计

建立数据源连接池以及JDBC事务工厂，在 XMLConfiguration 进行数据源解析和构建，增加 Environment 对象保存环境信息，在 DefaultSqlSession 以此为基础完成对 JDBC 执行 SQL 操作。



#### 类图
