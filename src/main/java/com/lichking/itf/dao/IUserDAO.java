package com.lichking.itf.dao;

import com.lichking.pojo.web.UserVO;

public interface IUserDAO {
    int deleteByPrimaryKey(String username);

    int insert(UserVO record);

    int insertSelective(UserVO record);

    UserVO selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(UserVO record);

    int updateByPrimaryKey(UserVO record);
}