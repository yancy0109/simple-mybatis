### STEP02

实现映射器的注册与使用



#### 目的

实现自动注册 Mapper 工厂，用于获取对应的映射器，通过 工厂 获取对应的代理对象，代理对象 内部调用是通过 SqlSession 来处理需要 方法逻辑。

SqlSession 也是提供外部获取 映射器对象的接口，我们实现此方法，获取对应的代理对象。

#### 实现

- SqlSession：提供映射器通用接口，以及获取映射器接口
- DefaultSqlSession：聚合 MapperRegistry 对象，通过获取容器内部 MapperProxyFactory 来获取映射器代理对象，SqlSession 其他接口实现类，来定义了查询方法的通用实现，我们在代理类中调用方法，也是通过 MapperProxy 包装 SqlSession 来调用了此处逻辑。
- SqlSessionFactory：提供开启 SqlSession 方法
- DefaultSqlSessionFactory：提供 DefaultSqlSession 类对象，聚合 MapperRegistry 对象。
- MapperRegistry：提供扫描方法，通过扫描在内部容器注册 MapperProxyFactory 对象



#### 流程

1. MapperRegistry：扫描包路径，缓存 MapperProxyFacotry 对象。

2. 创建聚合 MapperRegistry 对象的 SqlSessionFacotry 对象

3. 开启 SqlSession，获取聚合 MapperRegistry 的 SqlSession 对象

4. 通过 SqlSession 接口获取 映射器代理对象（通过 MapperRegistry 获取 MapperProxyFactory 来获取代理对象）

5. 代理对象获取是通过 JDK Proxy 获取动态代理对象，它的 InvocationHandler 实现类 MapperProxy，聚合了 SqlSession 对象，

   SqlSession 内含了对数据库操作的统一逻辑，通过 MapperProxy 实现对 SqlSession 内部逻辑的处理与调用。

