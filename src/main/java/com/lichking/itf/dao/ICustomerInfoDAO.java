package com.lichking.itf.dao;

import com.lichking.pojo.web.CustomerInfoPOJO;

public interface ICustomerInfoDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(CustomerInfoPOJO record);

    int insertSelective(CustomerInfoPOJO record);

    CustomerInfoPOJO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CustomerInfoPOJO record);

    int updateByPrimaryKey(CustomerInfoPOJO record);
}