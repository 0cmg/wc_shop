package com.lichking.itf.dao;

import com.lichking.pojo.web.ExpressInfoPOJO;

public interface IExpressInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpressInfoPOJO record);

    int insertSelective(ExpressInfoPOJO record);

    ExpressInfoPOJO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpressInfoPOJO record);

    int updateByPrimaryKey(ExpressInfoPOJO record);
}