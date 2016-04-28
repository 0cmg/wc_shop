package com.lichking.impl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lichking.itf.dao.IOrderInfoDAO;
import com.lichking.itf.service.IOrderInfoService;
import com.lichking.pojo.web.OrderInfoVO;


@Service("OrderInfoService")
public class OrderInfoServiceImpl implements IOrderInfoService {

	@Resource
	private IOrderInfoDAO orderInfoDAO;
	
	@Override
	public int insert(OrderInfoVO record) {
		return this.orderInfoDAO.insert(record);
	}

	@Override
	public OrderInfoVO selectByPK(String pk) {
		return this.orderInfoDAO.selectByPrimaryKey(pk);
	}

}
