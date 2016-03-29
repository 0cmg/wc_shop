package com.lichking.itf.service;

import java.util.List;

import com.lichking.pojo.web.CommodityTypeVO;

public interface ICommodityTypeService {

	public List<CommodityTypeVO> getAllTypes();
	
	public int insertComType(CommodityTypeVO type);

	
}
