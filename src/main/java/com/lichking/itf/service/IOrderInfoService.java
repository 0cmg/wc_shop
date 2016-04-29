package com.lichking.itf.service;

import java.util.List;

import com.lichking.pojo.web.OrderInfoVO;

public interface IOrderInfoService {

	public int insert(OrderInfoVO record);
	
	public OrderInfoVO selectByPK(String pk);
	
	public List<OrderInfoVO> selectByWhere(OrderInfoVO record);
	
	public int updateByPKSelective(OrderInfoVO record);
	
	public int deleteByPK(String pk);
	
}
