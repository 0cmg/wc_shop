package com.lichking.impl.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lichking.itf.dao.ICommodityTypeDAO;
import com.lichking.itf.service.ICommodityTypeService;
import com.lichking.pojo.web.CommodityTypePOJO;

@Service("CommodityTypeService")
public class CommodityTypeServiceImpl implements ICommodityTypeService {

	@Resource
	private ICommodityTypeDAO commodityTypeDAO;
	
	@Override
	public List<CommodityTypePOJO> getAllTypes() {
		return this.commodityTypeDAO.selectAll();
	}

	@Override
	public int insertComType(CommodityTypePOJO type) {
		return this.commodityTypeDAO.insert(type);
	}
	
	

}
