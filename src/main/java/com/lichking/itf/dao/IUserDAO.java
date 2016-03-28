package com.lichking.itf.dao;

import com.lichking.pojo.web.UserPOJO;

public interface IUserDAO {
    int deleteByPrimaryKey(String username);

    int insert(UserPOJO record);

    int insertSelective(UserPOJO record);

    UserPOJO selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(UserPOJO record);

    int updateByPrimaryKey(UserPOJO record);
}