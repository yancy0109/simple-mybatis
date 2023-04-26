package com.yancy.mybatis.test.dao;

import com.yancy.mybatis.test.po.User;

/**
 * 测试接口
 * @author yancy0109
 */
public interface IUserDao {

    String queryUserInfoById(String uId);
}
