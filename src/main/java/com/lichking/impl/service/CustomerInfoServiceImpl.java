package com.lichking.impl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lichking.itf.dao.ICustomerInfoDAO;
import com.lichking.itf.service.ICustomerInfoService;
import com.lichking.pojo.web.CustomerInfoVO;

@Service("CustomerInfoService")
public class CustomerInfoServiceImpl implements ICustomerInfoService {

	@Resource
	private ICustomerInfoDAO customerInfoDAO;
	
	@Override
	public List<CustomerInfoVO> selectByWhere(CustomerInfoVO civo) {
		return this.customerInfoDAO.selectByWhere(civo);
	}

	@Override
	public int insertSelective(CustomerInfoVO civo) {
		return this.customerInfoDAO.insertSelective(civo);
	}

	@Override
	public int updateByPKSelective(CustomerInfoVO civo) {
		return this.customerInfoDAO.updateByPrimaryKeySelective(civo);
	}

}
