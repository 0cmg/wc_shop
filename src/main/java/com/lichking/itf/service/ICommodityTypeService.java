package com.lichking.itf.service;

import java.util.List;

import com.lichking.pojo.web.CommodityTypePOJO;

public interface ICommodityTypeService {

	public List<CommodityTypePOJO> getAllTypes();
	
	public int insertComType(CommodityTypePOJO type);

	
}
