### STEP01

创建简单的映射器代理工厂



#### 目的

通过实现简单映射器工厂，创建映射器对象，通过代理对象调用处理SQL语句。



#### 实现

- MapperProxyFactory：Mapper代理工厂，返回代理对象工厂类
- MapperProxy：Mapper代理，代理接口对象，包装内部调用实现SQL语句逻辑。



只是简单实现，代理使用 JDK 代理类，不再补充说明。

注：Mapper 内部存储了 Map对象 sqlSession，存储了 方法与具体调用内容的关联信息。