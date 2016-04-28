package com.lichking.itf.service;

import com.lichking.pojo.web.OrderInfoVO;

public interface IOrderInfoService {

	public int insert(OrderInfoVO record);
	
	public OrderInfoVO selectByPK(String pk);
	
}
