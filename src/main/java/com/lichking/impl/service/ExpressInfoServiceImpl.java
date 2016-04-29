package com.lichking.impl.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lichking.itf.dao.IExpressInfoDAO;
import com.lichking.itf.service.IExpressInfoService;
import com.lichking.pojo.web.ExpressInfoVO;

@Service("ExpressInfoService")
public class ExpressInfoServiceImpl implements IExpressInfoService {

	@Resource
	private IExpressInfoDAO expressInfoDAO;
	
	@Override
	public int insertSelective(ExpressInfoVO eivo) {
		return this.expressInfoDAO.insertSelective(eivo);
	}

}
