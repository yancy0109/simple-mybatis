package com.yancy.mybatis.test.dao;

import com.yancy.mybatis.test.po.User;

/**
 * @author yancy0109
 */
public interface IUserDao {

    User queryUserInfoById(Long uId);

}
