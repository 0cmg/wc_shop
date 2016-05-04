package com.lichking.impl.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

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

	@Override
	public List<OrderInfoVO> selectByWhere(OrderInfoVO record) {
		return this.orderInfoDAO.selectByWhere(record);
	}

	@Override
	public int updateByPKSelective(OrderInfoVO record) {
		return this.orderInfoDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPK(String pk) {
		return this.orderInfoDAO.deleteByPrimaryKey(pk);
	}

	@Override
	public List<OrderInfoVO> selectByDate(HashMap<String, Date> map) {
		return this.orderInfoDAO.selectByDate(map);
	}

}
