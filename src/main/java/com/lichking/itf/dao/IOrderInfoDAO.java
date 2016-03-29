package com.lichking.itf.dao;

import com.lichking.pojo.web.OrderInfoVO;

public interface IOrderInfoDAO {
    int deleteByPrimaryKey(String orderno);

    int insert(OrderInfoVO record);

    int insertSelective(OrderInfoVO record);

    OrderInfoVO selectByPrimaryKey(String orderno);

    int updateByPrimaryKeySelective(OrderInfoVO record);

    int updateByPrimaryKey(OrderInfoVO record);
}