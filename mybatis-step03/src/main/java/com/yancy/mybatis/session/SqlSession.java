package com.yancy.mybatis.session;

public interface SqlSession {

    /**
     * 根据指定 SqlId 获取一条记录的封装对象
     * @param statement
     * @return
     * @param <T>
     */
    <T> T selectOne(String statement);

    /**
     * 根据 SqlID 获取一条记录的封装对象，此方法允许附带 Sql 参数
     * 实际使用传递参数为 Pojo， Map， ImmutableMap
     * @param statement
     * @param parameter
     * @return
     * @param <T>
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 返回泛型类指定代理映射器对象
     * @param type
     * @return
     * @param <T>
     */
    <T> T getMapper(Class<T> type);
}
