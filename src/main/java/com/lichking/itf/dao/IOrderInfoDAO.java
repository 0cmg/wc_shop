package com.lichking.itf.dao;

import com.lichking.pojo.web.OrderInfoPOJO;

public interface IOrderInfoDAO {
    int deleteByPrimaryKey(String orderno);

    int insert(OrderInfoPOJO record);

    int insertSelective(OrderInfoPOJO record);

    OrderInfoPOJO selectByPrimaryKey(String orderno);

    int updateByPrimaryKeySelective(OrderInfoPOJO record);

    int updateByPrimaryKey(OrderInfoPOJO record);
}