package com.lichking.itf.dao;

import com.lichking.pojo.web.CustomerInfoVO;

public interface ICustomerInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerInfoVO record);

    int insertSelective(CustomerInfoVO record);

    CustomerInfoVO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerInfoVO record);

    int updateByPrimaryKey(CustomerInfoVO record);
}