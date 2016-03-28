package com.lichking.itf.service;

import java.util.List;

import com.lichking.pojo.web.CommodityInfoPOJO;

public interface ICommodityInfoService {

	public int insertComWithNull(CommodityInfoPOJO com);
	
	public List<CommodityInfoPOJO> selectByWhere(CommodityInfoPOJO com);
	
	public CommodityInfoPOJO selectByPK(Integer comid);
	
	public int updateComByPKSelective(CommodityInfoPOJO com);
	
	public int deleteComByPK(Integer comid);
	
}
