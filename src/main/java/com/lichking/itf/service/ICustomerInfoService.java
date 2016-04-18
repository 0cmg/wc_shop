package com.lichking.itf.service;

import java.util.List;

import com.lichking.pojo.web.CustomerInfoVO;

public interface ICustomerInfoService {

	public List<CustomerInfoVO> selectByWhere(CustomerInfoVO civo);
	
	public int insertSelective(CustomerInfoVO civo);
	
	public int updateByPKSelective(CustomerInfoVO civo);
	
}
