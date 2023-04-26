### STEP03

Mapper XML 的解析和注册使用



#### 目的

实现对 Mapper 配置文件的读取，自动处理配置文件生成代理类，并配置解析存储 Sql 信息。

#### 实现



#### 流程



通过 SqlSessionFactoryBuilder 建造类，提供构造方法，使用 XmlConfigBuidler 来解析 Xml 配置文件，解析出 Configuration 类信息Configuration 类对 MapperRegistry 进行了包装，同时 聚合 MappedStatement 对象来存储 Mapper 类对应 Sql 与 方法关系，每解析完成一个 namespcae 信息后（即对于一个接口类），这个接口就会进行注册为 MapperProxyFactory。



SqlFactory 会提供 SqlSession 对象，它提供了方法来获取对应 MappedStatement 对象来在方法中进行调用。



我们在 MapperRegistry 注册完成的 Mapper，我们可以通过 Configuration 进行获取，它会通过聚合的 MapperRegistry 对象根据 类信息 获取 MapperProxyFactory 进行实例化，实例化对象过程中建立了 MethodProxy 对象，它实现了 InvocationHandler 接口，指定了 invoke 调用逻辑（根据方法类名等信息判断是否通过 聚合 SqlSession 对象来调用 SqlSession 提供的方法），最终通过 JDKProxy 实例化对象。





