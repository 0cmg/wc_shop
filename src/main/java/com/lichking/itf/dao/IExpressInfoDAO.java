package com.lichking.itf.dao;

import com.lichking.pojo.web.ExpressInfoVO;

public interface IExpressInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(ExpressInfoVO record);

    int insertSelective(ExpressInfoVO record);

    ExpressInfoVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ExpressInfoVO record);

    int updateByPrimaryKey(ExpressInfoVO record);
}